package university.jala.chess;

import java.util.Map;
import university.jala.chess.console.chess.DefaultConsoleChess;
import university.jala.chess.engine.base.Chess;
import university.jala.chess.engine.base.ChessConfiguration;
import university.jala.chess.engine.filters.ChessArgumentsParseFilter;
import university.jala.chess.engine.filters.ChessParametersValidationFilter;

/**
 * Main class to start the chess game in the console.
 *
 * @author Juan José Monsalve Orozco (LeMonsalve)
 * @version 1.0
 * @since 2024-09-01
 */
public class ChessConsoleGame {

  public static void main(String[] args) {
    final Map<String, String> parameters = ChessArgumentsParseFilter.parse(args);
    final ChessConfiguration configuration = ChessParametersValidationFilter.validate(parameters);
    final Chess chess = new DefaultConsoleChess(configuration);
    chess.setup();
    chess.logState();
    chess.start();
  }

}