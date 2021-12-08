package days.eight;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayEight {
  private static final int DAY = 8;

  public static void main(String args[]) {
    List<String> input = Util.getFileAsList(Util.getInputFile(DAY));

    List<String> inputLines = new ArrayList<>();
    List<String> outputLines = new ArrayList<>();
    for (String line : input) {
      String[] s = line.split(" \\| ");
      inputLines.add(s[0]);
      outputLines.add(s[1]);
    }

    List<List<String>> outputValues = new ArrayList<>();
    for (String line : outputLines) {
      outputValues.add(Arrays.asList(line.split(" ")));
    }

    int one = 0;
    int four = 0;
    int seven = 0;
    int eight = 0;
    for (List<String> line : outputValues) {
      for (String val : line) {
        switch (val.length()) {
          case 2:
            one++;
            break;
          case 4:
            four++;
            break;
          case 3:
            seven++;
            break;
          case 7:
            eight++;
            break;
          default:
            break;
        }
      }
    }

    long result = one + four + seven + eight;

    Util.processResult(Long.toString(result), DAY, 1);

  }
}
