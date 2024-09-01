package university.jala.chess.console.board;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.engine.base.ChessConfiguration;
import university.jala.chess.engine.board.Board;
import university.jala.chess.engine.steps.Step;
import university.jala.chess.engine.tokens.Token;

public class ConsoleBoard extends Board {

  private static final Logger logger = Logger.getLogger(ConsoleBoard.class.getName());

  public ConsoleBoard(final ChessConfiguration configuration) {
    super(configuration);
  }

  @Override
  public void setup(final Queue<Step> steps) {
    super.setup(new LinkedList<>(steps));
  }

  @Override
  public void start() {
    Queue<Step> steps = getSteps();
    ChessConfiguration configuration = getConfiguration();

    logHeader(steps, configuration);

    String[][] board = createEmptyBoard();

    for (Step step : steps) {
      executeStep(step, board, configuration);
    }
  }

  private void executeStep(
    final @NotNull Step step,
    final String[][] board,
    final @NotNull ChessConfiguration configuration
  ) {
    try {
      Thread.sleep(configuration.pauseMilliseconds());
      fillBoardWithTokens(board, step.tokens());
      logBoard(board);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  @Contract(value = " -> new", pure = true)
  private String @NotNull [][] createEmptyBoard() {
    return new String[8][8];
  }

  private void fillBoardWithTokens(final String[][] board, final @NotNull List<Token> tokens) {
    int index = 0;
    int tokensPerRow = Math.min(tokens.size(), 8);
    int startCol = (8 - tokensPerRow) / 2;

    for (int row = 0; row < 2; row++) {
      fillRowWithTokens(board, tokens, row, startCol, tokensPerRow, index);
      index = Math.min(index + 8, tokens.size());
    }

    fillEmptyBoard(board);
  }

  private void fillRowWithTokens(
    final String[][] board,
    final List<Token> tokens,
    final int row,
    final int startCol,
    final int tokensPerRow,
    int index
  ) {
    for (int col = 0; col < 8; col++) {
      if (index < tokens.size() && col >= startCol && col < startCol + tokensPerRow) {
        board[row][col] = tokens.get(index++).getIcon();
      } else {
        board[row][col] = getSquareColor(row, col);
      }
    }
  }

  private void fillEmptyBoard(final String[][] board) {
    for (int row = 2; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        board[row][col] = getSquareColor(row, col);
      }
    }
  }

  @Contract(pure = true)
  private @NotNull String getSquareColor(final int row, final int col) {
    return (row + col) % 2 == 0 ? "⬛" : "⬜";
  }

  private void logBoard(final String @NotNull [][] board) {
    StringBuilder builder = new StringBuilder("\n");
    for (String[] row : board) {
      for (String cell : row) {
        builder.append(cell).append(" ");
      }
      builder.append("\n");
    }
    final String boardString = builder.toString();
    logger.info(boardString);
  }

  private void logHeader(
    final @NotNull Queue<Step> steps,
    final @NotNull ChessConfiguration configuration
  ) {
    int totalStepsTime = configuration.pauseMilliseconds() * steps.size();
    String header = String.format("""
      WELCOME TO CHESS!
      Tokens were ordered in %d steps
      All steps took %d ms
      
      """, steps.size(), totalStepsTime);
    logger.info(header);
  }
}
