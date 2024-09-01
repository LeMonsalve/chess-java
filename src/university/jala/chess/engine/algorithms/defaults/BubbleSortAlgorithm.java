package university.jala.chess.engine.algorithms.defaults;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.algorithms.AlgorithmExecutor;
import university.jala.chess.engine.algorithms.cores.BubbleSortAlgorithmCore;

public class BubbleSortAlgorithm<T extends Comparable<T>> implements AlgorithmExecutor<List<T>> {

  @Override
  @SuppressWarnings("unchecked")
  public List<T> execute(final @NotNull List<T> value) {
    T[] values = value.toArray((T[]) new Comparable[value.size()]);
    return List.of(sort(values));
  }

  public T[] sort(final T[] values) {
    return BubbleSortAlgorithmCore.bubbleSort(values);
  }
}