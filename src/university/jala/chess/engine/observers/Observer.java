package university.jala.chess.engine.observers;

@FunctionalInterface
public interface Observer<T> {

  void onChange(T value);
}
