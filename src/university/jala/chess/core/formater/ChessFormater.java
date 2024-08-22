package university.jala.chess.core.formater;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import university.jala.chess.core.algorithms.AlgorithmType;
import university.jala.chess.core.base.ChessState;
import university.jala.chess.core.colors.ColorType;
import university.jala.chess.core.tokens.Token;
import university.jala.chess.core.tokens.TokenType;

public class ChessFormater implements Formater<ChessState> {

  private static final String INVALID = "Invalid";

  @Override
  public String format(ChessState state) {
    return switch (state.configuration().tokenType()) {
      case NUMERIC -> formatTokenWithInt(state, Token::getOrderLevel);
      case CHARACTERISTIC -> formatTokenWithString(state, Token::getIdentifier);
      default ->
        throw new IllegalStateException("Unexpected value: " + state.configuration().tokenType());
    };
  }

  public String formatInvalid(ChessState state) {
    final AlgorithmType algorithmType = state.configuration().algorithmType();
    final TokenType tokenType = state.configuration().tokenType();
    final ColorType colorType = state.configuration().colorType();

    return String.format("""
        
        Algorithm: %s
        Type: %s
        Color: %s
        Values: %s
        Order: %s
        """,
      algorithmType == AlgorithmType.NONE ? INVALID : algorithmType.getValue(),
      tokenType == TokenType.NONE ? INVALID : tokenType.getValue(),
      colorType == ColorType.NONE ? INVALID : colorType.getValue(),
      "[]",
      INVALID
    );
  }

  private String formatTokenWithString(ChessState state, Function<Token, String> tokenFunction) {
    List<String> initialTokens = state.initialTokens().stream().map(tokenFunction).toList();
    List<String> tokens = state.tokens().stream().map(tokenFunction).toList();
    return baseFormat(state, initialTokens, tokens);
  }

  private String formatTokenWithInt(ChessState state, ToIntFunction<Token> tokenFunction) {
    List<String> initialTokens = state.initialTokens().stream()
      .map(token -> String.valueOf(tokenFunction.applyAsInt(token))).toList();
    List<String> tokens = state.tokens().stream()
      .map(token -> String.valueOf(tokenFunction.applyAsInt(token))).toList();
    return baseFormat(state, initialTokens, tokens);
  }

  private String baseFormat(final ChessState state, final List<String> initialTokens,
    final List<String> tokens) {
    final AlgorithmType algorithmType = state.configuration().algorithmType();
    final TokenType tokenType = state.configuration().tokenType();
    final ColorType colorType = state.configuration().colorType();

    return String.format("""
        
        Algorithm: [%s]
        Type: [%s]
        Color: [%s]
        Values: %s
        Order: %s
        """,
      algorithmType.getValue(),
      tokenType.getValue(),
      colorType.getValue(),
      initialTokens,
      tokens
    );
  }
}
