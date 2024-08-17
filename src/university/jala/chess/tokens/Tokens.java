package university.jala.chess.tokens;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public final class Tokens {

  private Tokens() {
  }

  @Contract(" -> new")
  public static @NotNull @Unmodifiable Map<Integer, List<Token>> getDefaultSetup() {
    return Map.of(
      1, List.of(Token.KING),
      2, List.of(Token.KING, Token.QUEEN),
      4, List.of(Token.KING, Token.QUEEN, Token.BISHOP_ONE, Token.BISHOP_TWO),
      6, List.of(Token.KING, Token.QUEEN, Token.BISHOP_ONE, Token.BISHOP_TWO, Token.HORSE_ONE,
        Token.HORSE_TWO),
      8, List.of(Token.KING, Token.QUEEN, Token.BISHOP_ONE, Token.BISHOP_TWO, Token.HORSE_ONE,
        Token.HORSE_TWO, Token.TOWER_ONE, Token.TOWER_TWO),
      10, List.of(Token.KING, Token.QUEEN, Token.BISHOP_ONE, Token.BISHOP_TWO, Token.HORSE_ONE,
        Token.HORSE_TWO, Token.TOWER_ONE, Token.TOWER_TWO, Token.PAWN_ONE, Token.PAWN_TWO),
      16, List.of(Token.KING, Token.QUEEN, Token.BISHOP_ONE, Token.BISHOP_TWO, Token.HORSE_ONE,
        Token.HORSE_TWO, Token.TOWER_ONE, Token.TOWER_TWO, Token.PAWN_ONE, Token.PAWN_TWO,
        Token.PAWN_THREE, Token.PAWN_FOUR, Token.PAWN_FIVE, Token.PAWN_SIX, Token.PAWN_SEVEN,
        Token.PAWN_EIGHT)
    );
  }
}
