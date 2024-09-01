package university.jala.chess.engine.tokens;

import java.util.List;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

public final class TokenConverter {

  private TokenConverter() {
  }

  public static List<Token> fromInts(
    final @NotNull List<Integer> integerItems,
    final Function<Integer, Token> intToTokenFunction
  ) {
    return integerItems.stream().map(intToTokenFunction).toList();
  }
}
