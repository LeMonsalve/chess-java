package university.jala.chess.filters;

import com.lemonsalve.tools.parsers.CLIParser;
import com.lemonsalve.tools.validators.StringValidator;
import java.util.Map;

public final class ChessArgumentsParseFilter {

  private ChessArgumentsParseFilter() {
  }

  public static Map<String, String> parse(final String[] arguments) {
    final StringValidator paramsValidator = new StringValidator()
      .minLength(3);

    final CLIParser parser = new CLIParser(paramsValidator);

    return parser.parse(arguments);
  }
}
