package university.jala.chess.formater;

@FunctionalInterface
public interface Formattable<T> {

  T format();
}
