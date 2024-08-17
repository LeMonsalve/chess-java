package university.jala.chess.sorter;

import java.util.ArrayList;
import java.util.List;
import university.jala.chess.algorithms.AlgorithmExecutor;
import university.jala.chess.tokens.Token;

public class ChessSorter implements Sorter<List<Token>> {

  private final AlgorithmExecutor<List<Integer>> algorithmExecutor;

  public ChessSorter(final AlgorithmExecutor<List<Integer>> algorithmExecutor) {
    this.algorithmExecutor = algorithmExecutor;
  }

  @Override
  public List<Token> sort(final List<Token> items) {
    List<Token> sortedItems;
    List<Integer> integerItems = items.stream().map(Token::getOrderLevel).toList();

    integerItems = algorithmExecutor.execute(integerItems);
    sortedItems = convertIntegersToTokens(integerItems);

    return sortedItems;
  }

  public List<Token> convertIntegersToTokens(List<Integer> integerItems) {
    List<Token> tokens = new ArrayList<>();

    for (Integer item : integerItems) {
      Token token = Token.fromOrderLevel(item);
      tokens.add(token);
    }

    return tokens;
  }
}
