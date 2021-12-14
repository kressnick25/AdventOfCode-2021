package days.nine;

import common.LowPoint;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayNine {

  private static final int DAY = 9;

  public static void main(String[] args) {
    List<List<Integer>> heightMap = Util.getFileAsList(Util.getInputFile(DAY))
                                        .stream()
                                        .map(e -> Arrays.stream(e.split("")).map(Integer::parseInt).collect(Collectors.toList()))
                                        .collect(Collectors.toList());
    assert(heightMap.size() > 0 && heightMap.get(0).size() > 0);

    List<LowPoint> lowPoints = new ArrayList<>();


    for (int i = 0; i < heightMap.size(); i++) {
      List<Integer> row = heightMap.get(i);
      for (int j = 0; j < row.size(); j++) {
        Integer currentHeight = row.get(j);
        Integer above = i == 0 ? null : heightMap.get(i - 1).get(j);
        Integer below = i == heightMap.size() - 1 ? null : heightMap.get(i + 1).get(j);
        Integer left = j == 0 ? null : heightMap.get(i).get(j - 1);
        Integer right = j == row.size() - 1 ? null : heightMap.get(i).get(j + 1);

        if (lessThan(currentHeight, above)
            && lessThan(currentHeight, below)
            && lessThan(currentHeight, left)
            && lessThan(currentHeight, right)) {
          lowPoints.add(new LowPoint(i, j, currentHeight));
        }
      }
    }

    int riskSum = lowPoints.stream()
                           .map(LowPoint::getRiskLevel)
                           .reduce(0, Integer::sum);

    Util.processResult(Integer.toString(riskSum), DAY, 1);


  }

  /**
   * null safe Integer comparison
   */
  static private boolean lessThan(Integer a, Integer b) {
    if (a == null && b == null) return false;
    if (a == null) return false;
    if (b == null) return true;

    return a < b;
  }
}
