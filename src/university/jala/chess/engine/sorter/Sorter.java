package university.jala.chess.engine.sorter;

@FunctionalInterface
public interface Sorter<T> {

  T sort(T items);
}
