package days.six;

import util.Util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class DaySix {
  private static final int DAY = 6;
  private static final String INPUT_FILE = "data/" + DAY + "/input.txt";

  private static final int SIMULATION_DAYS = 80;

  public static void main(String args[]) {
    String input = Util.getFileAsList(INPUT_FILE).get(0);
    List<LanternFish> intialSchool = Arrays.stream(input.split(","))
                                     .map(Integer::parseInt)
                                     .map(LanternFish::new)
                                     .collect(Collectors.toList());

    List<LanternFish> finalSchool = process(intialSchool, 1);


    int numFishInSchool = finalSchool.size(); // account for marker-fish
    Util.processResult(Integer.toString(numFishInSchool), DAY, 0);

  }

  static List<LanternFish> process(List<LanternFish> school, int day) {
    List<LanternFish> nextSchool = new ArrayList<>();
    for (LanternFish fish: school) {
      LanternFish babyFish = fish.step();
      if (babyFish != null) {
        nextSchool.add(babyFish);
      }
      nextSchool.add(fish);
    }
    if (day < SIMULATION_DAYS) {
      return process(nextSchool, ++day);
    } else {
      return nextSchool;
    }
  }
}
