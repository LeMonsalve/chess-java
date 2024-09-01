package university.jala.chess.engine.algorithms.observables;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.algorithms.cores.QuickSortAlgorithmCore;
import university.jala.chess.engine.observers.Observer;

public class ObservableQuickSortAlgorithm<T extends Comparable<T>>
  extends AbstractObservableSortingAlgorithm<T> {

  public ObservableQuickSortAlgorithm(final Observer<List<T>> observer) {
    super(observer);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<T> execute(final @NotNull List<T> value) {
    T[] values = value.toArray((T[]) new Comparable[value.size()]);
    return List.of(sort(values));
  }

  public T[] sort(final T[] values) {
    return QuickSortAlgorithmCore.quickSort(values, 0, values.length - 1, updatedValues -> {
      final List<T> newValues = new ArrayList<>(List.of(updatedValues));
      emitChange(newValues);
    });
  }
}
