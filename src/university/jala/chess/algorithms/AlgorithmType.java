package university.jala.chess.algorithms;

public enum AlgorithmType {
    NONE("", "None"),
    INSERTION_SORT("i", "Insertion Sort"),
    BUBBLE_SORT("b", "Bubble Sort"),
    QUICK_SORT("q", "Quick Sort"),;

    private final String identifier;
    private final String value;

    AlgorithmType(final String identifier, final String value) {
        this.identifier = identifier;
        this.value = value;
    }

    public String getIdentifier() {return identifier; }
    public String getValue() {
        return value;
    }

    public static AlgorithmType fromIdentifier(final String identifier) {
        for (AlgorithmType algorithmType : AlgorithmType.values()) {
            if (algorithmType.getIdentifier().equals(identifier)) {
                return algorithmType;
            }
        }

        return AlgorithmType.NONE;
    }
}
