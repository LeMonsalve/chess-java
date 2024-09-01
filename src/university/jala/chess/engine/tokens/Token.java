package university.jala.chess.engine.tokens;

public enum Token {
  KING(1, "a", "KN", 4, "🤴"),
  QUEEN(2, "b", "QN", 5, "👸"),
  TOWER_ONE(3, "c", "TN", 1, "🏢"),
  TOWER_TWO(4, "d", "TN", 8, "🏢"),
  BISHOP_ONE(5, "e", "BN", 3, "🗼"),
  BISHOP_TWO(6, "f", "BN", 6, "🗼"),
  HORSE_ONE(7, "g", "HN", 2, "🐴"),
  HORSE_TWO(8, "h", "HN", 7, "🐴"),
  PAWN_ONE(9, "i", "PN", 9, "♟️"),
  PAWN_TWO(10, "j", "PN", 10, "♟️"),
  PAWN_THREE(11, "k", "PN", 11, "♟️"),
  PAWN_FOUR(12, "l", "PN", 12, "♟️"),
  PAWN_FIVE(13, "m", "PN", 13, "♟️"),
  PAWN_SIX(14, "n", "PN", 14, "♟️"),
  PAWN_SEVEN(15, "o", "PN", 15, "♟️"),
  PAWN_EIGHT(16, "p", "PN", 16, "♟️");

  private final int code;
  private final String identifier;
  private final String name;
  private final int orderLevel;
  private final String icon;

  Token(
    final int code,
    final String identifier,
    final String name,
    final int orderLevel,
    final String icon
  ) {
    this.code = code;
    this.identifier = identifier;
    this.name = name;
    this.orderLevel = orderLevel;
    this.icon = icon;
  }

  public int getCode() {
    return code;
  }

  public String getIdentifier() {
    return identifier;
  }

  public String getName() {
    return name;
  }

  public int getOrderLevel() {
    return orderLevel;
  }

  public String getIcon() {
    return icon;
  }
}
