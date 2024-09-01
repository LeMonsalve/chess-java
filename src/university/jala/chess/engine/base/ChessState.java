package university.jala.chess.engine.base;

import java.util.ArrayList;
import java.util.List;
import university.jala.chess.engine.observers.Observer;
import university.jala.chess.engine.steps.StepsCenter;
import university.jala.chess.engine.tokens.Token;

public record ChessState(
  ChessConfiguration configuration,
  Observer<List<Integer>> tokenIntObserver,
  List<Token> initialTokens,
  List<Token> orderedTokens,
  StepsCenter stepsCenter
) {

  public ChessState(
    final ChessConfiguration configuration,
    final Observer<List<Integer>> tokenIntObserver,
    final StepsCenter stepsCenter
  ) {
    this(configuration, tokenIntObserver, new ArrayList<>(), new ArrayList<>(), stepsCenter);
  }
}
