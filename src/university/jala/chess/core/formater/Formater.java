package university.jala.chess.core.formater;

@FunctionalInterface
public interface Formater<T> {

  String format(T value);
}
