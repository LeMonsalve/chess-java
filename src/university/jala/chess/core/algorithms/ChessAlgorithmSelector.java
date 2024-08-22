package university.jala.chess.core.algorithms;

import java.util.List;

public final class ChessAlgorithmSelector {

  private ChessAlgorithmSelector() {
  }

  public static AlgorithmExecutor<List<Integer>> from(final AlgorithmType algorithmType) {
    return switch (algorithmType) {
      case QUICK_SORT -> new QuickSortAlgorithm<>();
      case BUBBLE_SORT -> new BubbleSortAlgorithm<>();
      case INSERTION_SORT -> new InsertSortAlgorithm<>();
      default -> throw new IllegalStateException("Unexpected value: " + algorithmType);
    };
  }
}
