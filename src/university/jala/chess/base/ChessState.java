package university.jala.chess.base;

import java.util.ArrayList;
import java.util.List;
import university.jala.chess.tokens.Token;

public record ChessState(
  ChessConfiguration configuration,
  List<Token> initialTokens,
  List<Token> tokens
) {

  public ChessState(ChessConfiguration configuration) {
    this(configuration, new ArrayList<>(), new ArrayList<>());
  }
}
