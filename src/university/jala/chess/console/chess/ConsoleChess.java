package university.jala.chess.console.chess;

import com.lemonsalve.tools.generation.Generator;
import java.util.List;
import java.util.Map;
import university.jala.chess.engine.base.Chess;
import university.jala.chess.engine.base.ChessConfiguration;
import university.jala.chess.engine.base.ChessState;
import university.jala.chess.engine.board.Board;
import university.jala.chess.engine.formater.Formater;
import university.jala.chess.engine.observers.Observer;
import university.jala.chess.engine.sorter.Sorter;
import university.jala.chess.engine.steps.Step;
import university.jala.chess.engine.steps.StepConverter;
import university.jala.chess.engine.steps.StepsCenter;
import university.jala.chess.engine.tokens.Token;

public class ConsoleChess extends Chess {

  public ConsoleChess(
    final ChessConfiguration configuration,
    final Observer<List<Integer>> tokenIntObserver,
    final Formater<ChessState> formater,
    final Sorter<List<Token>> sorter,
    final Generator<Token> generator,
    final StepsCenter stepsCenter,
    final Board board
  ) {
    super(configuration, tokenIntObserver, formater, sorter, generator, stepsCenter, board);
  }

  @Override
  public void setup() {
    initialize();
    sortTokens();
    setupBoard();
  }

  @Override
  public void start() {
    final Board board = getBoard();
    board.start();
  }

  private void sortTokens() {
    final Sorter<List<Token>> sorter = getTokensSorter();
    final ChessState state = getState();
    final List<Token> orderedTokens = state.orderedTokens();
    final List<Token> initialTokens = getState().initialTokens();
    final List<Token> sortedTokens = sorter.sort(initialTokens);
    orderedTokens.addAll(sortedTokens);
  }

  private void setupBoard() {
    final ChessState state = getState();
    final Map<Integer, Step> steps = state.stepsCenter().findAll();
    final Board board = getBoard();
    board.setup(StepConverter.mapToQueue(steps));
  }
}
