package days.four;

import util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DayFour {
  private static final int DAY = 4;
  private static final String INPUT_FILE = "data/" + DAY + "/input.txt";

  public static void main(String arg[]) {
    List<String> input = Util.getFileAsList(INPUT_FILE);

    String resultsLine = input.get(0);
    List<Integer> results = Arrays.stream(resultsLine.split(","))
                                  .map(Integer::parseInt)
                                  .collect(Collectors.toList());
    input.remove(0);
    input.remove(0);

    List<BingoBoard> boards = new ArrayList<>();
    // parse each set of boards
    int numRows = 5;
    for (int i = 0; i < input.size(); i += numRows + 1) {
      BoardBuilder builder = new BoardBuilder();
      for (int j = i; j < i + numRows; j++) {
        builder.appendRow(input.get(j));
      }
      boards.add(builder.build(i));
    }

    int winningResult = 0;
    int sumUnmarked = 0;
    Stack<BingoBoard> winningBoards = new Stack();
    for (Integer result : results) {
      for (BingoBoard board : boards) {
        if (board.getWinningResult() == null) {
          board.markResult(result);
        }
        if (board.hasWon() && board.getWinningResult() == null) {
          board.setWinningResult(result);
          winningBoards.push(board);
        }
      }
    }

    BingoBoard lastBoard = winningBoards.pop();
    int result = lastBoard.getSumUnmarked() * lastBoard.getWinningResult();

    Util.processResult(Integer.toString(result), DAY, 2);
  }

}
