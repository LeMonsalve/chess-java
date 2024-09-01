package university.jala.chess.engine.steps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import university.jala.chess.engine.tokens.Token;
import university.jala.chess.engine.tokens.TokenConverter;
import university.jala.chess.engine.tokens.Tokens;

public class StepsCenter {

  private final Map<Integer, Step> steps;
  private int stepId = 0;

  public StepsCenter(final @NotNull Map<Integer, Step> steps) {
    this.steps = new LinkedHashMap<>(steps);
  }

  public StepsCenter() {
    this.steps = new LinkedHashMap<>();
  }

  public @NotNull @Unmodifiable Map<Integer, Step> findAll() {
    return steps;
  }

  public void createStepFromTokens(final List<Token> tokens) {
    Step step = new Step(tokens);

    if (isStepDuplicated(step)) {
      return;
    }

    final int id = stepId++;
    steps.put(id, step);
  }

  public void createFromCodes(final List<Integer> codes) {
    List<Token> tokens = TokenConverter.fromInts(codes, Tokens::fromCode);
    createStepFromTokens(tokens);
  }

  public void createFromOrderLevels(final List<Integer> ordersLevels) {
    List<Token> tokens = TokenConverter.fromInts(ordersLevels, Tokens::fromOrderLevel);
    createStepFromTokens(tokens);
  }

  private boolean isStepDuplicated(final Step stepToCheck) {
    for (Step step : steps.values()) {
      if (step.equals(stepToCheck)) {
        return true;
      }
    }

    return false;
  }
}
