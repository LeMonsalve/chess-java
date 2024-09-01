package university.jala.chess.engine.formater;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.algorithms.AlgorithmType;
import university.jala.chess.engine.base.ChessState;
import university.jala.chess.engine.colors.ColorType;
import university.jala.chess.engine.sorter.Sorter;
import university.jala.chess.engine.tokens.Token;
import university.jala.chess.engine.tokens.TokenType;
import university.jala.chess.engine.tokens.exceptions.TokenTypeNotFoundException;

public class ChessStateFormater implements Formater<ChessState> {

  private static final String INVALID = "Invalid";
  private final Sorter<List<Token>> initialTokensSorter;

  public ChessStateFormater(Sorter<List<Token>> initialTokensSorter) {
    this.initialTokensSorter = initialTokensSorter;
  }

  public static @NotNull String formatInvalid(final @NotNull ChessState state) {
    final AlgorithmType algorithmType = state.configuration().algorithmType();
    final TokenType tokenType = state.configuration().tokenType();
    final ColorType colorType = state.configuration().colorType();
    final int pauseMilliseconds = state.configuration().pauseMilliseconds();

    return String.format("""
        
        Algorithm: %s
        Type: %s
        Color: %s
        Values: %s
        Order: %s
        Pause Milliseconds: %s
        """,
      algorithmType == AlgorithmType.NONE ? INVALID : algorithmType.getValue(),
      tokenType == TokenType.NONE ? INVALID : tokenType.getValue(),
      colorType == ColorType.NONE ? INVALID : colorType.getValue(),
      "[]",
      INVALID,
      pauseMilliseconds == -1 ? INVALID : pauseMilliseconds
    );
  }

  @Override
  public String format(final @NotNull ChessState state) {
    return switch (state.configuration().tokenType()) {
      case NUMERIC -> formatTokenWithInt(state, Token::getCode);
      case CHARACTERISTIC -> formatTokenWithString(state, Token::getIdentifier);
      default -> throw new TokenTypeNotFoundException(
        "Token type: " + state.configuration().tokenType() + " not found"
      );
    };
  }

  private @NotNull String formatTokenWithString(
    final @NotNull ChessState state,
    final Function<Token, String> tokenFunction
  ) {
    final List<String> initialTokens = state.initialTokens().stream().map(tokenFunction).toList();

    final List<String> orderedTokens = initialTokensSorter.sort(state.initialTokens()).stream()
      .map(tokenFunction).toList();

    return baseFormat(state, initialTokens, orderedTokens);
  }

  private @NotNull String formatTokenWithInt(
    final @NotNull ChessState state,
    final ToIntFunction<Token> tokenFunction
  ) {
    List<String> initialTokens = state.initialTokens().stream()
      .map(token -> String.valueOf(tokenFunction.applyAsInt(token))).toList();

    List<String> orderedTokens = initialTokensSorter.sort(state.initialTokens()).stream()
      .map(token -> String.valueOf(tokenFunction.applyAsInt(token))).toList();

    return baseFormat(state, initialTokens, orderedTokens);
  }

  private @NotNull String baseFormat(
    final @NotNull ChessState state,
    final List<String> initialTokens,
    final List<String> orderedTokens
  ) {
    final AlgorithmType algorithmType = state.configuration().algorithmType();
    final TokenType tokenType = state.configuration().tokenType();
    final ColorType colorType = state.configuration().colorType();
    final int pauseMilliseconds = state.configuration().pauseMilliseconds();

    return String.format("""
        
        Algorithm: [%s]
        Type: [%s]
        Color: [%s]
        Values: %s
        Order: %s
        Pause Milliseconds: [%dms]
        """,
      algorithmType.getValue(),
      tokenType.getValue(),
      colorType.getValue(),
      initialTokens,
      orderedTokens,
      pauseMilliseconds
    );
  }
}
