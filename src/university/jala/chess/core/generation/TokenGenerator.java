package university.jala.chess.core.generation;

import java.util.List;
import java.util.Random;
import university.jala.chess.core.tokens.Token;

public class TokenGenerator extends AbstractTokenGenerator {

  public TokenGenerator() {
    super(List.of(Token.values()), new Random());
  }
}
