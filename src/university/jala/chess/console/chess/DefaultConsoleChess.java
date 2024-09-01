package university.jala.chess.console.chess;

import com.lemonsalve.tools.generation.Generator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import university.jala.chess.console.board.ConsoleBoard;
import university.jala.chess.engine.algorithms.AlgorithmExecutor;
import university.jala.chess.engine.algorithms.ChessAlgorithmChangeObserver;
import university.jala.chess.engine.algorithms.ChessAlgorithmFactory;
import university.jala.chess.engine.algorithms.ChessObservableAlgorithmFactory;
import university.jala.chess.engine.base.ChessConfiguration;
import university.jala.chess.engine.base.ChessState;
import university.jala.chess.engine.board.Board;
import university.jala.chess.engine.formater.ChessStateFormater;
import university.jala.chess.engine.formater.Formater;
import university.jala.chess.engine.generation.AdvancedTokenGenerator;
import university.jala.chess.engine.observers.Observer;
import university.jala.chess.engine.sorter.ChessSorter;
import university.jala.chess.engine.sorter.Sorter;
import university.jala.chess.engine.steps.StepsCenter;
import university.jala.chess.engine.tokens.Token;
import university.jala.chess.engine.tokens.Tokens;

public class DefaultConsoleChess extends ConsoleChess {

  private static final StepsCenter stepsCenter = new StepsCenter();
  private static final Observer<List<Integer>> tokenIntObserver = new ChessAlgorithmChangeObserver(
    stepsCenter
  );

  public DefaultConsoleChess(final ChessConfiguration configuration) {
    super(
      configuration,
      tokenIntObserver,
      createFormater(configuration),
      createObservableSorter(configuration, Token::getOrderLevel, Tokens::fromOrderLevel),
      createGenerator(configuration),
      stepsCenter,
      createBoard(configuration)
    );
  }

  public static @NotNull Formater<ChessState> createFormater(
    final @NotNull ChessConfiguration configuration
  ) {
    final Sorter<List<Token>> sorter = createSorter(
      configuration,
      Token::getCode,
      Tokens::fromCode
    );

    return new ChessStateFormater(sorter);
  }

  public static @NotNull Sorter<List<Token>> createSorter(
    final @NotNull ChessConfiguration configuration,
    final ToIntFunction<Token> tokenToIntFunction,
    final Function<Integer, Token> intToTokenFunction
  ) {
    final AlgorithmExecutor<List<Integer>> algorithmExecutor = createAlgorithmExecutor(
      configuration
    );

    return new ChessSorter(algorithmExecutor, tokenToIntFunction, intToTokenFunction);
  }

  public static @NotNull Sorter<List<Token>> createObservableSorter(
    final @NotNull ChessConfiguration configuration,
    final ToIntFunction<Token> tokenToIntFunction,
    final Function<Integer, Token> intToTokenFunction
  ) {
    final AlgorithmExecutor<List<Integer>> algorithmExecutor = createObservableAlgorithmExecutor(
      configuration
    );

    return new ChessSorter(algorithmExecutor, tokenToIntFunction, intToTokenFunction);
  }

  public static @NotNull AlgorithmExecutor<List<Integer>> createAlgorithmExecutor(
    final @NotNull ChessConfiguration configuration
  ) {
    return ChessAlgorithmFactory
      .from(configuration.algorithmType())
      .build();
  }

  public static @NotNull AlgorithmExecutor<List<Integer>> createObservableAlgorithmExecutor(
    final @NotNull ChessConfiguration configuration
  ) {
    return ChessObservableAlgorithmFactory
      .from(configuration.algorithmType())
      .withObserver(tokenIntObserver)
      .build();
  }

  @Contract("_ -> new")
  public static @NotNull Generator<Token> createGenerator(final ChessConfiguration configuration) {
    return new AdvancedTokenGenerator(configuration);
  }

  @Contract("_ -> new")
  public static @NotNull Board createBoard(final ChessConfiguration configuration) {
    return new ConsoleBoard(configuration);
  }
}