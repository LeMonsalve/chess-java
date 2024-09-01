package university.jala.chess.engine.algorithms;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.algorithms.defaults.BubbleSortAlgorithm;
import university.jala.chess.engine.algorithms.defaults.InsertSortAlgorithm;
import university.jala.chess.engine.algorithms.defaults.QuickSortAlgorithm;
import university.jala.chess.engine.algorithms.exceptions.AlgorithmTypeNotFoundException;

public class ChessAlgorithmFactory {

  private ChessAlgorithmFactory() {
  }

  public static @NotNull Builder from(
    final @NotNull AlgorithmType algorithmType
  ) {
    return new Builder(algorithmType);
  }

  public static class Builder {

    private final AlgorithmType algorithmType;

    private Builder(final @NotNull AlgorithmType algorithmType) {
      this.algorithmType = algorithmType;
    }

    public @NotNull AlgorithmExecutor<List<Integer>> build() {
      return switch (algorithmType) {
        case QUICK_SORT -> new QuickSortAlgorithm<>();
        case BUBBLE_SORT -> new BubbleSortAlgorithm<>();
        case INSERTION_SORT -> new InsertSortAlgorithm<>();
        default ->
          throw new AlgorithmTypeNotFoundException("Algorithm type not found: " + algorithmType);
      };
    }
  }
}
