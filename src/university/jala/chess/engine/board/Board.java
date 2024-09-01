package university.jala.chess.engine.board;

import java.util.Queue;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.base.ChessConfiguration;
import university.jala.chess.engine.steps.Step;

public abstract class Board {

  private final ChessConfiguration configuration;
  private Queue<Step> steps;

  protected Board(final @NotNull ChessConfiguration configuration) {
    this.configuration = configuration;
  }

  public void setup(final Queue<Step> steps) {
    this.steps = steps;
  }

  public abstract void start();

  public ChessConfiguration getConfiguration() {
    return configuration;
  }

  public Queue<Step> getSteps() {
    return steps;
  }
}
