package university.jala.chess.engine.observers;

@FunctionalInterface
public interface ChangeEmitter<T> {

  void emitChange(T change);
}
