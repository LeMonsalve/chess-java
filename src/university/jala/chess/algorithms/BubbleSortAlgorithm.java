package university.jala.chess.algorithms;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.steps.StepsCenter;

public class BubbleSortAlgorithm<T extends Comparable<T>> implements AlgorithmExecutor<List<T>> {

  @Override
  @SuppressWarnings("unchecked")
  public List<T> execute(final @NotNull List<T> value) {
    T[] values = value.toArray((T[]) new Comparable[value.size()]);
    return List.of(sort(values));
  }

  public T[] sort(final T[] values) {
    bubbleSort(values);
    return values;
  }

  @SuppressWarnings("unchecked")
  private void bubbleSort(final T @NotNull [] values) {
    final int n = values.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (values[j].compareTo(values[j + 1]) > 0) {
          T temp = values[j];
          values[j] = values[j + 1];
          values[j + 1] = temp;

          StepsCenter.instance().createStep((List<Integer>) List.of(values));
        }
      }
    }
  }
}