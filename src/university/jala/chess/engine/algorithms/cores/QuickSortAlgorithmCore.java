package university.jala.chess.engine.algorithms.cores;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public final class QuickSortAlgorithmCore {

  private QuickSortAlgorithmCore() {
  }

  public static <T extends Comparable<T>> T[] quickSort(
    final T @NotNull [] values,
    final int low,
    final int high,
    final Consumer<T[]> consumer
  ) {
    final T[] sortedValues = values.clone();

    recursiveQuickSort(sortedValues, low, high, consumer);

    return sortedValues;
  }

  public static <T extends Comparable<T>> T[] quickSort(
    final T @NotNull [] values,
    final int low,
    final int high
  ) {
    T[] sortedValues = values.clone();

    sortedValues = quickSort(sortedValues, low, high, _ -> {
    });

    return sortedValues;
  }

  private static <T extends Comparable<T>> void recursiveQuickSort(
    final T @NotNull [] sortedValues,
    final int low,
    final int high,
    final Consumer<T[]> consumer
  ) {
    if (low < high) {
      final int pi = partition(sortedValues, low, high, consumer);

      consumer.accept(sortedValues);

      recursiveQuickSort(sortedValues, low, pi - 1, consumer);
      recursiveQuickSort(sortedValues, pi + 1, high, consumer);
    }
  }

  private static <T extends Comparable<T>> int partition(
    final T @NotNull [] values,
    final int low,
    final int high,
    final Consumer<T[]> consumer
  ) {
    final T pivot = values[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (values[j].compareTo(pivot) <= 0) {
        i++;
        swap(values, i, j, consumer);
      }
    }
    swap(values, i + 1, high, consumer);
    return i + 1;
  }

  private static <T extends Comparable<T>> void swap(
    final T @NotNull [] values,
    final int i,
    final int j,
    final @NotNull Consumer<T[]> consumer
  ) {
    final T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
    consumer.accept(values);
  }

}
