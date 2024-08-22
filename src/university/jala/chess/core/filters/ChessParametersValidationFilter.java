package university.jala.chess.core.filters;

import com.lemonsalve.tools.notifications.Notifier;
import com.lemonsalve.tools.notifications.SimpleNotifier;
import com.lemonsalve.tools.validators.IntValidator;
import com.lemonsalve.tools.validators.StringValidator;
import com.lemonsalve.tools.validators.ValidationResult;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.core.algorithms.AlgorithmType;
import university.jala.chess.core.base.ChessConfiguration;
import university.jala.chess.core.base.ChessState;
import university.jala.chess.core.colors.ColorType;
import university.jala.chess.core.formater.ChessFormater;
import university.jala.chess.core.tokens.TokenConfiguration;
import university.jala.chess.core.tokens.TokenType;
import university.jala.chess.core.tokens.Tokens;

public final class ChessParametersValidationFilter {

  private static final Logger logger = Logger.getLogger(
    ChessParametersValidationFilter.class.getName()
  );

  private ChessParametersValidationFilter() {
  }

  public static @NotNull ChessConfiguration validate(
    final @NotNull Map<String, String> parameters) {
    final IntValidator intListValidator = new IntValidator().inList(List.of(1, 2, 4, 6, 8, 16));
    final IntValidator pauseMillisecondsValidator = new IntValidator().minValue(100).maxValue(1000);
    final StringValidator oneCharacterValidator = new StringValidator()
      .notNull()
      .minLength(1)
      .maxLength(1)
      .lettersOnly()
      .lowerCase();

    final ValidationResult<Integer> pauseMillisecondsValidationResult = pauseMillisecondsValidator.validate(
      assignZeroToNull(parameters.get("s")));
    final ValidationResult<Integer> rangeValidationResult = intListValidator.validate(
      assignZeroToNull(parameters.get("r")));
    final ValidationResult<String> algorithmTypeValidationResult = oneCharacterValidator.validate(
      parameters.get("a"));
    final ValidationResult<String> tokenTypeValidationResult = oneCharacterValidator.validate(
      parameters.get("t"));
    final ValidationResult<String> colorTypeValidationResult = oneCharacterValidator.validate(
      parameters.get("c"));

    final int pauseMilliseconds =
      pauseMillisecondsValidationResult.value() != null ? pauseMillisecondsValidationResult.value()
        : 0;
    final int range = rangeValidationResult.value() != null ? rangeValidationResult.value() : 0;
    final AlgorithmType algorithmType =
      algorithmTypeValidationResult.value() != null ? AlgorithmType.fromIdentifier(
        algorithmTypeValidationResult.value()) : AlgorithmType.NONE;
    final TokenType tokenType =
      tokenTypeValidationResult.value() != null ? TokenType.fromIdentifier(
        tokenTypeValidationResult.value()) : TokenType.NONE;
    final ColorType colorType =
      colorTypeValidationResult.value() != null ? ColorType.fromIdentifier(
        colorTypeValidationResult.value()) : ColorType.NONE;

    final TokenConfiguration tokenConfiguration = new TokenConfiguration(Tokens.getDefaultSetup());
    final ChessConfiguration configuration = new ChessConfiguration(
      algorithmType,
      tokenType,
      colorType,
      range,
      pauseMilliseconds,
      tokenConfiguration
    );

    final boolean hasInvalidParameters = checkForNoneOrZero(configuration);

    if (hasInvalidParameters) {
      onInvalidParameter(configuration);
    }

    return configuration;
  }

  private static boolean checkForNoneOrZero(final @NotNull ChessConfiguration configuration) {
    if (configuration.algorithmType() == AlgorithmType.NONE) {
      return true;
    }

    if (configuration.tokenType() == TokenType.NONE) {
      return true;
    }

    if (configuration.colorType() == ColorType.NONE) {
      return true;
    }

    return configuration.range() == 0 || configuration.pauseMilliseconds() == 0;
  }

  private static void onInvalidParameter(final ChessConfiguration configuration) {
    final ChessState state = new ChessState(configuration);
    final ChessFormater formater = new ChessFormater();

    final String formattedState = formater.formatInvalid(state);

    Notifier notifier = new SimpleNotifier();
    notifier.send("Invalid Parameters", formattedState);

    logger.info(formattedState);

    System.exit(1);
  }

  private static int assignZeroToNull(final String value) {
    int result;

    try {
      result = Integer.parseInt(value);
    } catch (NumberFormatException e) {
      result = 0;
    }

    return result;
  }
}
