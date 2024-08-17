package university.jala.chess.console;

import university.jala.chess.algorithms.ChessAlgorithmSelector;
import university.jala.chess.base.ChessConfiguration;
import university.jala.chess.formater.ChessFormater;
import university.jala.chess.generation.AdvancedTokenGenerator;
import university.jala.chess.sorter.ChessSorter;

public class DefaultConsoleChess extends ConsoleChess {

  public DefaultConsoleChess(final ChessConfiguration configuration) {
    super(
      configuration,
      new ChessFormater(),
      new ChessSorter(ChessAlgorithmSelector.from(configuration.algorithmType())),
      new AdvancedTokenGenerator(configuration)
    );
  }
}
