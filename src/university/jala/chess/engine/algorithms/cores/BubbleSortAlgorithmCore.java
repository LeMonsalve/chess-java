package university.jala.chess.engine.algorithms.cores;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public final class BubbleSortAlgorithmCore {

  private BubbleSortAlgorithmCore() {
  }

  public static <T extends Comparable<T>> T @NotNull [] bubbleSort(
    final T @NotNull [] values,
    final Consumer<T[]> consumer
  ) {
    T[] sortedValues = values.clone();

    final int n = sortedValues.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (sortedValues[j].compareTo(sortedValues[j + 1]) > 0) {
          T temp = sortedValues[j];
          sortedValues[j] = sortedValues[j + 1];
          sortedValues[j + 1] = temp;

          consumer.accept(sortedValues);
        }
      }
    }

    return sortedValues;
  }

  public static <T extends Comparable<T>> T @NotNull [] bubbleSort(
    final T @NotNull [] values
  ) {
    return bubbleSort(values, _ -> {
    });
  }

}
