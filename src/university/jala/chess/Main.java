package university.jala.chess;

import java.util.Map;
import university.jala.chess.base.Chess;
import university.jala.chess.base.ChessConfiguration;
import university.jala.chess.console.DefaultConsoleChess;
import university.jala.chess.filters.ChessArgumentsParseFilter;
import university.jala.chess.filters.ChessParametersValidationFilter;
import university.jala.chess.steps.Step;
import university.jala.chess.steps.StepsCenter;

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

    final StepsCenter center = StepsCenter.instance();
    final Map<Integer, Step> steps = center.getSteps();

    System.out.println(steps);
  }

}