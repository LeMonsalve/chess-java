package university.jala.chess.engine.sorter;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.algorithms.AlgorithmExecutor;
import university.jala.chess.engine.tokens.Token;
import university.jala.chess.engine.tokens.TokenConverter;

public class ChessSorter implements Sorter<List<Token>> {

  private final AlgorithmExecutor<List<Integer>> algorithmExecutor;
  private final ToIntFunction<Token> tokenToIntFunction;
  private final Function<Integer, Token> intToTokenFunction;

  public ChessSorter(
    final AlgorithmExecutor<List<Integer>> algorithmExecutor,
    final ToIntFunction<Token> tokenToIntFunction,
    final Function<Integer, Token> intToTokenFunction
  ) {
    this.algorithmExecutor = algorithmExecutor;
    this.tokenToIntFunction = tokenToIntFunction;
    this.intToTokenFunction = intToTokenFunction;
  }

  @Override
  public List<Token> sort(final @NotNull List<Token> items) {
    List<Token> sortedItems;
    List<Integer> integerItems = items.stream().map(tokenToIntFunction::applyAsInt).toList();

    integerItems = algorithmExecutor.execute(integerItems);
    sortedItems = TokenConverter.fromInts(integerItems, intToTokenFunction);

    return sortedItems;
  }
}
