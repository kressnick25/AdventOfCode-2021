package days.seven;

import util.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaySeven {
  private static final int DAY = 7;
  private static final String INPUT_FILE = "data/" + DAY + "/input.txt";

  private static final Map<Long, Long> costLookup = new HashMap<>();

  public static void main(String args[]) {
    List<Integer> positions = Arrays.stream(Util.getFileAsList(INPUT_FILE).get(0).split(","))
                                .map(Integer::parseUnsignedInt)
                                .collect(Collectors.toList());

    int max = positions.stream().max(Integer::compareTo).get();
    long minSum = Long.MAX_VALUE;
    long currentSum;
    for (int i = 0; i <= max; i++) {
      currentSum = 0;
      for (int position : positions) {
        currentSum += getFuelCost(Math.abs(position - i));
      }
      if (currentSum < minSum) {
        minSum = currentSum;
      }
    }

    Util.processResult(Long.toString(minSum), DAY, 2);
  }

  static long getFuelCost(long n) {
    // we can reuse these values, cache them
    if (costLookup.containsKey(n)) return costLookup.get(n);

    long total = 0;
    for (int i = 0; i < n; i++) {
      total += i + 1;
    }
    costLookup.put(n, total);
    return total;
  }
}
