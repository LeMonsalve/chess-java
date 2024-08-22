package university.jala.chess.core.colors;

public enum ColorType {
  NONE("", "None"),
  WHITE("w", "White"),
  BLACK("b", "Black");

  private final String identifier;
  private final String value;

  ColorType(final String identifier, final String value) {
    this.identifier = identifier;
    this.value = value;
  }

  public static ColorType fromIdentifier(final String identifier) {
    for (ColorType colorType : ColorType.values()) {
      if (colorType.getIdentifier().equals(identifier)) {
        return colorType;
      }
    }

    return ColorType.NONE;
  }

  public String getIdentifier() {
    return identifier;
  }

  public String getValue() {
    return value;
  }
}
