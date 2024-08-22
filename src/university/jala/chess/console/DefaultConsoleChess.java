package university.jala.chess.console;

import university.jala.chess.core.algorithms.ChessAlgorithmSelector;
import university.jala.chess.core.base.ChessConfiguration;
import university.jala.chess.core.formater.ChessFormater;
import university.jala.chess.core.generation.AdvancedTokenGenerator;
import university.jala.chess.core.sorter.ChessSorter;

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
