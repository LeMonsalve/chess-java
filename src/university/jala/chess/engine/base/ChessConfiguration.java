package university.jala.chess.engine.base;

import university.jala.chess.engine.algorithms.AlgorithmType;
import university.jala.chess.engine.colors.ColorType;
import university.jala.chess.engine.tokens.TokenConfiguration;
import university.jala.chess.engine.tokens.TokenType;

public record ChessConfiguration(
  AlgorithmType algorithmType,
  TokenType tokenType,
  ColorType colorType,
  Integer range,
  Integer pauseMilliseconds,
  TokenConfiguration tokenConfiguration
) {

}
