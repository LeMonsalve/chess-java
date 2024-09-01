package university.jala.chess.engine.steps;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;

public final class StepConverter {

  private StepConverter() {
  }

  public static <T> @NotNull Queue<Step> mapToQueue(final @NotNull Map<T, Step> steps) {
    final Queue<Step> queue = new LinkedList<>();

    for (Map.Entry<T, Step> entry : steps.entrySet()) {
      queue.add(entry.getValue());
    }

    return queue;
  }
}
