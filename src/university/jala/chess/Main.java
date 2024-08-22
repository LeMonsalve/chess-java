package university.jala.chess;

import java.util.Map;
import university.jala.chess.console.DefaultConsoleChess;
import university.jala.chess.core.base.Chess;
import university.jala.chess.core.base.ChessConfiguration;
import university.jala.chess.core.filters.ChessArgumentsParseFilter;
import university.jala.chess.core.filters.ChessParametersValidationFilter;

/**
 * Main class to start the chess game
 *
 * @author lemonsalve
 */
public class Main {

  public static void main(String[] args) {
    final Map<String, String> parameters = ChessArgumentsParseFilter.parse(args);
    final ChessConfiguration configuration = ChessParametersValidationFilter.validate(parameters);
    final Chess chess = new DefaultConsoleChess(configuration);
    chess.start();
    chess.logState();
  }

}