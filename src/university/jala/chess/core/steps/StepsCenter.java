package university.jala.chess.core.steps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import university.jala.chess.core.tokens.Token;
import university.jala.chess.core.tokens.TokenNotFoundException;

public class StepsCenter {

  private static StepsCenter instance;

  private final Map<Integer, Step> steps;
  private int stepId = 0;

  private StepsCenter() {
    this.steps = new LinkedHashMap<>();
  }

  public static synchronized StepsCenter instance() {
    if (instance == null) {
      instance = new StepsCenter();
    }

    return instance;
  }

  public @NotNull @Unmodifiable Map<Integer, Step> getSteps() {
    return steps;
  }

  public void createStepFrom(final List<Token> tokens) {
    final int id = stepId++;
    Step step = new Step(tokens);
    steps.put(id, step);
  }

  public synchronized void createStep(final List<Integer> codes) {
    List<Token> tokens = codesToTokens(codes);
    createStepFrom(tokens);
  }

  private @NotNull List<Token> codesToTokens(final @NotNull List<Integer> codes) {
    List<Token> tokens = new ArrayList<>();

    for (int code : codes) {
      Token token = Token.fromOrderLevel(code);
      if (token == null) {
        throw new TokenNotFoundException("Token with order level: " + code + " not found");
      }

      tokens.add(token);
    }

    return tokens;
  }
}
