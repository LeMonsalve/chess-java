package university.jala.chess.core.sorter;

@FunctionalInterface
public interface Sorter<T> {

  T sort(T items);
}
