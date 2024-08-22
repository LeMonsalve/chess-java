package university.jala.chess.core.algorithms;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class ChessAlgorithmSelector {

  private ChessAlgorithmSelector() {
  }

  public static @NotNull AlgorithmExecutor<List<Integer>> from(
    final @NotNull AlgorithmType algorithmType
  ) {
    return switch (algorithmType) {
      case QUICK_SORT -> new QuickSortAlgorithm<>();
      case BUBBLE_SORT -> new BubbleSortAlgorithm<>();
      case INSERTION_SORT -> new InsertSortAlgorithm<>();
      default -> throw new AlgorithmNotFoundException("Unexpected value: " + algorithmType);
    };
  }
}
