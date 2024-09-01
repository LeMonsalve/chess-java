package university.jala.chess.engine.algorithms;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.algorithms.exceptions.AlgorithmTypeNotFoundException;
import university.jala.chess.engine.algorithms.observables.ObservableBubbleSortAlgorithm;
import university.jala.chess.engine.algorithms.observables.ObservableInsertSortAlgorithm;
import university.jala.chess.engine.algorithms.observables.ObservableQuickSortAlgorithm;
import university.jala.chess.engine.observers.Observer;
import university.jala.chess.engine.observers.exceptions.ObserverRequiredException;

public final class ChessObservableAlgorithmFactory {

  private ChessObservableAlgorithmFactory() {
  }

  public static @NotNull Builder from(final @NotNull AlgorithmType algorithmType) {
    return new Builder(algorithmType);
  }

  public static class Builder {

    private final AlgorithmType algorithmType;
    private Observer<List<Integer>> observer;

    private Builder(final @NotNull AlgorithmType algorithmType) {
      this.algorithmType = algorithmType;
    }

    public Builder withObserver(final @NotNull Observer<List<Integer>> observer) {
      this.observer = observer;
      return this;
    }

    public @NotNull AlgorithmExecutor<List<Integer>> build() {
      if (observer == null) {
        throw new ObserverRequiredException("Observer is required, value: " + null);
      }

      return switch (algorithmType) {
        case QUICK_SORT -> new ObservableQuickSortAlgorithm<>(observer);
        case BUBBLE_SORT -> new ObservableBubbleSortAlgorithm<>(observer);
        case INSERTION_SORT -> new ObservableInsertSortAlgorithm<>(observer);
        default ->
          throw new AlgorithmTypeNotFoundException("Algorithm type not found: " + algorithmType);
      };
    }
  }
}