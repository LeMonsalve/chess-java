package university.jala.chess.engine.generation;

import com.lemonsalve.tools.generation.Generator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import university.jala.chess.engine.tokens.Token;

public abstract class AbstractTokenGenerator implements Generator<Token> {

  protected final List<Token> availableTokens;
  protected final Random random;

  protected AbstractTokenGenerator(final List<Token> availableTokens, final Random random) {
    this.availableTokens = new ArrayList<>(availableTokens);
    this.random = random;
  }

  @Override
  public Token generate() {
    return getAvailableToken().orElse(null);
  }

  @Override
  public List<Token> generateMany(final int amount) {
    final List<Token> tokens = new ArrayList<>();
    for (int index = 0; index < amount; index++) {
      tokens.add(generate());
    }
    return tokens;
  }

  protected Optional<Token> getAvailableToken() {
    if (availableTokens.isEmpty()) {
      return Optional.empty();
    }

    final Token token = getRandomAvailableToken();
    availableTokens.remove(token);
    return Optional.of(token);
  }

  protected Token getRandomAvailableToken() {
    final int randomIndex = random.nextInt(availableTokens.size());
    return availableTokens.get(randomIndex);
  }
}
