package university.jala.chess.console;

import com.lemonsalve.tools.generation.Generator;
import java.util.List;
import university.jala.chess.core.base.Chess;
import university.jala.chess.core.base.ChessConfiguration;
import university.jala.chess.core.base.ChessState;
import university.jala.chess.core.formater.Formater;
import university.jala.chess.core.sorter.Sorter;
import university.jala.chess.core.tokens.Token;

public class ConsoleChess extends Chess {

  public ConsoleChess(
    final ChessConfiguration configuration,
    final Formater<ChessState> formater,
    final Sorter<List<Token>> sorter,
    final Generator<Token> generator
  ) {
    super(configuration, formater, sorter, generator);
  }

  @Override
  public void start() {
    initialize();
    sortTokens();
  }

  private void sortTokens() {
    final Sorter<List<Token>> sorter = getSorter();
    final List<Token> tokens = getState().initialTokens();
    final List<Token> sortedTokens = sorter.sort(tokens);
    getState().tokens().addAll(sortedTokens);
  }
}
