package university.jala.chess.engine.algorithms;

@FunctionalInterface
public interface AlgorithmExecutor<T> {

  T execute(T value);
}
