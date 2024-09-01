package university.jala.chess.engine.formater;

@FunctionalInterface
public interface Formater<T> {

  String format(T value);
}
