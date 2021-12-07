package days.four;

import util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
      boards.add(builder.build());
    }

    int winningResult = 0;
    int sumUnmarked = 0;
    for (Integer result : results) {
      for (BingoBoard board : boards) {
        board.markResult(result);
        if (board.hasWon()) {
          sumUnmarked = board.getSumUnmarked();
          winningResult = result;
          break;
        }

      }
      if (winningResult != 0 && sumUnmarked != 0) break;
    }

    int result = winningResult * sumUnmarked;

    Util.processResult(Integer.toString(result), DAY, 1);
  }

}
