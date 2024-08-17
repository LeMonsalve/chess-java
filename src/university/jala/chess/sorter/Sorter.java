package university.jala.chess.sorter;

@FunctionalInterface
public interface Sorter<T> {

  T sort(T items);
}
