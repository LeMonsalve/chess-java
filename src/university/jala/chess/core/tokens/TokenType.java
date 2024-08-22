package university.jala.chess.core.tokens;

public enum TokenType {
  NONE("", "None"),
  NUMERIC("n", "Numeric"),
  CHARACTERISTIC("c", "Characteristic");

  private final String identifier;
  private final String value;

  TokenType(final String identifier, final String value) {
    this.identifier = identifier;
    this.value = value;
  }

  public static TokenType fromIdentifier(final String identifier) {
    for (TokenType tokenType : TokenType.values()) {
      if (tokenType.getIdentifier().equals(identifier)) {
        return tokenType;
      }
    }

    return TokenType.NONE;
  }

  public String getIdentifier() {
    return identifier;
  }

  public String getValue() {
    return value;
  }
}
