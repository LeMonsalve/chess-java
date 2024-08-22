package university.jala.chess.core.algorithms;

@FunctionalInterface
public interface AlgorithmExecutor<T> {

  T execute(T value);
}
