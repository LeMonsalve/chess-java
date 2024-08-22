package university.jala.chess.core.algorithms;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public class InsertSortAlgorithm<T extends Comparable<T>> implements AlgorithmExecutor<List<T>> {

  @Override
  @SuppressWarnings("unchecked")
  public List<T> execute(final @NotNull List<T> value) {
    T[] values = value.toArray((T[]) new Comparable[value.size()]);
    return List.of(sort(values));
  }

  public T[] sort(final T[] values) {
    insertionSort(values);
    return values;
  }

  private void insertionSort(final T @NotNull [] values) {
    for (int i = 1; i < values.length; i++) {
      final T key = values[i];
      int j = i - 1;
      while (j >= 0 && values[j].compareTo(key) > 0) {
        values[j + 1] = values[j];
        j = j - 1;
      }
      values[j + 1] = key;
    }
  }
}