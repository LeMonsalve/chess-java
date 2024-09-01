package university.jala.chess.engine.generation;

import java.util.List;
import java.util.Random;
import university.jala.chess.engine.tokens.Token;

public class TokenGenerator extends AbstractTokenGenerator {

  public TokenGenerator() {
    super(List.of(Token.values()), new Random());
  }
}
