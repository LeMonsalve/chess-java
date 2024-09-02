package university.jala.chess.engine.base;

import com.lemonsalve.tools.generation.Generator;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.logging.Logger;
import university.jala.chess.engine.board.Board;
import university.jala.chess.engine.formater.Formater;
import university.jala.chess.engine.observers.Observer;
import university.jala.chess.engine.sorter.Sorter;
import university.jala.chess.engine.steps.StepsCenter;
import university.jala.chess.engine.tokens.Token;
import university.jala.chess.engine.tokens.Tokens;

public abstract class Chess {

  private static final Logger logger = Logger.getLogger(Chess.class.getName());
  private final ChessState state;
  private final Formater<ChessState> stateFormater;
  private final Sorter<List<Token>> tokensSorter;
  private final Generator<Token> tokenGenerator;
  private final Board board;
  private final Instant startInstant;
  private Instant endInstant;

  protected Chess(
    final ChessConfiguration configuration,
    final Observer<List<Integer>> tokenIntObserver,
    final Formater<ChessState> stateFormater,
    final Sorter<List<Token>> tokensSorter,
    final Generator<Token> tokenGenerator,
    final StepsCenter stepsCenter,
    final Board board
  ) {
    this.state = new ChessState(configuration, tokenIntObserver, stepsCenter);
    this.stateFormater = stateFormater;
    this.tokensSorter = tokensSorter;
    this.tokenGenerator = tokenGenerator;
    this.board = board;
    this.startInstant = Instant.now();
  }

  public abstract void setup();

  public abstract void start();

  protected void initialize() {
    final int initialTokensAmount = state.configuration().range();
    final List<Token> generatedTokens = tokenGenerator.generateMany(initialTokensAmount);

    state.initialTokens().addAll(generatedTokens);

    final List<Integer> generatedTokensOrderLevels = Tokens.toIntegers(
      generatedTokens,
      Token::getOrderLevel
    );

    state.tokenIntObserver().onChange(generatedTokensOrderLevels);
  }

  public void logState() {
    final String formattedState = stateFormater.format(state);
    logger.info(formattedState);
  }

  public ChessState getState() {
    return state;
  }

  public Sorter<List<Token>> getTokensSorter() {
    return tokensSorter;
  }

  protected Board getBoard() {
    return board;
  }

  protected void setEndInstant(final Instant endInstant) {
    this.endInstant = endInstant;
  }

  public void logGameDuration() {
    final long millis = Duration.between(startInstant, endInstant).toMillis();
    final String message = "Chess game took " + millis + " milliseconds.";
    logger.info(message);
  }
}
