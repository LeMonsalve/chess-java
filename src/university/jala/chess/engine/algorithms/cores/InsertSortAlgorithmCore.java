package university.jala.chess.engine.algorithms.cores;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public final class InsertSortAlgorithmCore {

  private InsertSortAlgorithmCore() {
  }

  public static <T extends Comparable<T>> T[] insertionSort(
    final T @NotNull [] values,
    final Consumer<T[]> consumer
  ) {
    T[] sortedValues = values.clone();

    for (int i = 1; i < sortedValues.length; i++) {
      final T key = sortedValues[i];
      int j = i - 1;
      while (j >= 0 && sortedValues[j].compareTo(key) > 0) {
        sortedValues[j + 1] = sortedValues[j];
        j = j - 1;
      }
      sortedValues[j + 1] = key;

      consumer.accept(sortedValues);
    }

    return sortedValues;
  }

  public static <T extends Comparable<T>> T[] insertionSort(final T @NotNull [] values) {
    return insertionSort(values, _ -> {
    });
  }

}
