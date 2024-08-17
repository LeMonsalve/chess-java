package university.jala.chess.algorithms;

@FunctionalInterface
public interface AlgorithmExecutor<T> {

  T execute(T value);
}
