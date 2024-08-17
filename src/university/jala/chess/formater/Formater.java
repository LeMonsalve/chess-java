package university.jala.chess.formater;

@FunctionalInterface
public interface Formater<T> {

  String format(T value);
}
