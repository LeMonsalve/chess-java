package university.jala.chess.engine.algorithms.observables;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.algorithms.AlgorithmExecutor;
import university.jala.chess.engine.observers.ChangeEmitter;
import university.jala.chess.engine.observers.Observer;

public abstract class AbstractObservableSortingAlgorithm<T extends Comparable<T>>
  implements AlgorithmExecutor<List<T>>, ChangeEmitter<List<T>> {

  private final Observer<List<T>> observer;

  protected AbstractObservableSortingAlgorithm(
    final @NotNull Observer<List<T>> observer
  ) {
    this.observer = observer;
  }

  @Override
  public void emitChange(final List<T> change) {
    observer.onChange(change);
  }
}