package university.jala.chess.engine.algorithms;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.observers.Observer;
import university.jala.chess.engine.steps.StepsCenter;

public record ChessAlgorithmChangeObserver(StepsCenter stepsCenter)
  implements Observer<List<Integer>> {

  public ChessAlgorithmChangeObserver() {
    this(new StepsCenter());
  }

  @Override
  public void onChange(final @NotNull List<Integer> value) {
    stepsCenter.createFromOrderLevels(value);
  }
}
