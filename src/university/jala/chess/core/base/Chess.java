package university.jala.chess.core.base;

import com.lemonsalve.tools.generation.Generator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import university.jala.chess.core.formater.Formater;
import university.jala.chess.core.sorter.Sorter;
import university.jala.chess.core.steps.StepsCenter;
import university.jala.chess.core.tokens.Token;

public abstract class Chess {

  private final ChessState state;
  private final Formater<ChessState> stateFormater;
  private final Sorter<List<Token>> sorter;
  private final Generator<Token> generator;
  private final Logger logger;

  protected Chess(
    final ChessConfiguration configuration,
    final Formater<ChessState> stateFormater,
    final Sorter<List<Token>> sorter,
    final Generator<Token> generator
  ) {
    this.state = new ChessState(configuration, new ArrayList<>(), new ArrayList<>());
    this.stateFormater = stateFormater;
    this.sorter = sorter;
    this.generator = generator;
    this.logger = Logger.getLogger(Chess.class.getName());
  }

  public abstract void start();

  protected void initialize() {
    final int initialTokensAmount = state.configuration().range();
    final List<Token> generatedTokens = generator.generateMany(initialTokensAmount);

    state.initialTokens().addAll(generatedTokens);
    StepsCenter.instance().createStepFrom(generatedTokens);
  }

  public void logState() {
    final String formattedState = stateFormater.format(state);
    logger.info(formattedState);
  }

  public ChessState getState() {
    return state;
  }

  public Sorter<List<Token>> getSorter() {
    return sorter;
  }
}
