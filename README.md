# Chess Console Game by LeMonsalve

### **Chess Java: A Library for Automatic Chess Game Creation with Built-in Algorithms**

Chess Java is an open-source library focused on automating chess game creation in Java. Designed
with SOLID principles and Clean Code practices, this library provides a streamlined way to develop
automatic chess games, featuring three default algorithms for gameplay. With its modular and
extensible architecture, Chess Java allows developers to implement flexible and scalable chess games
while maintaining high code quality.

_Perfect for educational, experimental, or professional projects, Chess Java offers a reliable
foundation for building automated chess experiences in Java._

## Features

- **Token Generation**: Generates tokens for the chess game.
- **Token Sorting**: Sorts tokens based on predefined criteria.
- **Observables**: Observes algorithm changes
- **Game State Logging**: Logs the current state of the game.
- **Game Duration Logging**: Logs the duration of the game.
- **Customization**: Provided classes are fully expandable.

## Installation

### Prerequisites

- Java Development Kit (JDK) 11 or higher

### Steps

1. **Clone the repository**:
    ```shell
    git clone https://github.com/LeMonsalve/chess-java.git
    cd chess-java
    ```

2. **Open the project in IntelliJ IDEA**:
    - Open IntelliJ IDEA.
    - Click on `File` -> `Open...`.
    - Select the cloned repository folder.

## Usage

1. **Run the game**:
    - Open the terminal in IntelliJ IDEA.
    - Set program arguments:
      ```shell
      a=q t=n c=w r=16 s=369
      ```

2. **Game Flow**:
    - The game will start and display the initial state of the board.

## Information

1. **Game Arguments**:
    - `a`: Algorithm type `*`
        - Quick Sort => q
        - Insert Sort => i
        - Bubble Sort => b
    - `t`: Token type `*`
        - Numeric => n
        - Characteristic => c
    - `c`: Color type `*`
        - White => w
        - Black => b
    - `r`: Tokens Range `*`
        - Integer => 1 | 2 | 4 | 6 | 8 | 10 | 16.
    - `s`: Sleep time
        - Integer between 100 and 1000.

2. **Simple CLI Setup**:

```java
// Simple way to run the game
public class ChessConsoleGame {

  public static void main(String[] args) {
    final Map<String, String> parameters = ChessArgumentsParseFilter.parse(args);
    final ChessConfiguration configuration = ChessParametersValidationFilter.validate(parameters);
    final Chess chess = new DefaultConsoleChess(configuration);
    chess.setup();
    chess.logState();
    chess.start();
    chess.logGameDuration();
  }

}
```

## Author

- **Juan José Monsalve Orozco** - [LeMonsalve](https://github.com/LeMonsalve)