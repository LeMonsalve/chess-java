package university.jala.chess.engine.generation;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.base.ChessConfiguration;
import university.jala.chess.engine.tokens.Token;
import university.jala.chess.engine.tokens.exceptions.InvalidTokenRangeException;

public class AdvancedTokenGenerator extends AbstractTokenGenerator {

  public AdvancedTokenGenerator(final ChessConfiguration configuration) {
    super(getAvailableTokensByConfiguration(configuration), new Random());
  }

  private static List<Token> getAvailableTokensByConfiguration(
    final @NotNull ChessConfiguration configuration
  ) {
    final int range = configuration.range();
    final Map<Integer, List<Token>> tokenSetup = configuration.tokenConfiguration().setup();

    return tokenSetup.entrySet().stream()
      .filter(entry -> entry.getKey() == range)
      .findFirst()
      .map(Entry::getValue)
      .orElseThrow(() -> new InvalidTokenRangeException(
        "Token range is not included in token configuration setup"
      ));
  }
}
