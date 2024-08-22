package university.jala.chess.core.base;

import university.jala.chess.core.algorithms.AlgorithmType;
import university.jala.chess.core.colors.ColorType;
import university.jala.chess.core.tokens.TokenConfiguration;
import university.jala.chess.core.tokens.TokenType;

public record ChessConfiguration(
  AlgorithmType algorithmType,
  TokenType tokenType,
  ColorType colorType,
  Integer range,
  Integer pauseMilliseconds,
  TokenConfiguration tokenConfiguration
) {

}
