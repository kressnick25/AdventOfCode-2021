package days.six;

import util.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DaySix {
  private static final int DAY = 6;
  private static final String INPUT_FILE = "data/" + DAY + "/input.txt";

  private static final int SIMULATION_DAYS = 256;

  public static void main(String args[]) {
    String input = Util.getFileAsList(INPUT_FILE).get(0);
    List<Integer> inputSpawns = Arrays.stream(input.split(","))
                                     .map(Integer::parseInt)
                                     .collect(Collectors.toList());

    long[] fish = new long[] {0, 0, 0, 0, 0, 0, 0, 0, 0};

    inputSpawns.forEach(e -> fish[e]++);

    int day = 0;
    while (day < SIMULATION_DAYS) {
      long temp = fish[0];
      for (int i = 0; i < fish.length - 1; i++) {
        fish[i] = fish[i + 1];
      }
      fish[6] += temp;
      fish[8] = temp;

      day++;
    }

    long total = Arrays.stream(fish).sum();

    Util.processResult(Long.toString(total), DAY, 2);

  }
}
