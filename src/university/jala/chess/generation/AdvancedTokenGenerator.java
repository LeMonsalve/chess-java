package university.jala.chess.generation;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.base.ChessConfiguration;
import university.jala.chess.tokens.Token;

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
      .orElseThrow(() -> new IllegalStateException(
        "Token range is not included in token configuration setup"
      ));
  }
}
