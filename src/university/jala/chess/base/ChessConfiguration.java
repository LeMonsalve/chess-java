package university.jala.chess.base;

import university.jala.chess.algorithms.AlgorithmType;
import university.jala.chess.colors.ColorType;
import university.jala.chess.tokens.TokenConfiguration;
import university.jala.chess.tokens.TokenType;

public record ChessConfiguration(
  AlgorithmType algorithmType,
  TokenType tokenType,
  ColorType colorType,
  Integer range,
  Integer pauseMilliseconds,
  TokenConfiguration tokenConfiguration
) {

}
