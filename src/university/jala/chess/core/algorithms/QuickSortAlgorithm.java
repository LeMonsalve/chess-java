package university.jala.chess.core.algorithms;


import java.util.List;
import org.jetbrains.annotations.NotNull;

public class QuickSortAlgorithm<T extends Comparable<T>> implements AlgorithmExecutor<List<T>> {

  @Override
  @SuppressWarnings("unchecked")
  public List<T> execute(final @NotNull List<T> value) {
    T[] values = value.toArray((T[]) new Comparable[value.size()]);
    sort(values);
    return List.of(values);
  }

  public void sort(final T[] values) {
    quickSort(values, 0, values.length - 1);
  }

  private void quickSort(final T[] values, final int low, final int high) {
    if (low < high) {
      final int pi = partition(values, low, high);
      quickSort(values, low, pi - 1);
      quickSort(values, pi + 1, high);
    }
  }

  private int partition(final T @NotNull [] values, final int low, final int high) {
    final T pivot = values[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (values[j].compareTo(pivot) <= 0) {
        i++;
        swap(values, i, j);
      }
    }
    swap(values, i + 1, high);
    return i + 1;
  }

  private void swap(final T @NotNull [] values, final int i, final int j) {
    final T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  }
}