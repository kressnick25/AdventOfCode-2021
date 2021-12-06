package days.one;

import util.Util;

import java.util.List;
import java.util.stream.Collectors;

public class DayOne {
    private static final String INPUT_FILE = "data/1/input.txt";
    private static final String DAY = "One";

    public static void main(String[] args) {
        List<String> input = Util.getFileAsList(INPUT_FILE);
        List<Integer> depths = input.stream().map(Integer::parseInt).collect(Collectors.toList());

        partOne(depths);
        partTwo(depths);
    }

    private static void partOne(List<Integer> depths) {
        int increased = 0;
        Integer prevReading = null;
        for (Integer currentReading : depths) {
            if (prevReading != null && prevReading < currentReading) {
                increased++;
            }
            prevReading = currentReading;
        }

        Util.processResult(Integer.toString(increased), DAY, 1);
    }

    private static void partTwo(List<Integer> depths) {
        int increased = 0;
        Integer prevSum = null;
        for (int i = 0; i < depths.size(); i++) {
            Integer currentDepth = Util.getSafe(depths, i);
            Integer nextDepth = Util.getSafe(depths,i + 1);
            Integer nextNextDepth = Util.getSafe(depths, i + 2);
            int currentSum = currentDepth + nextDepth + nextNextDepth;

            if (prevSum != null && prevSum < currentSum) {
                increased ++;
            }
            prevSum = currentSum;
        }

        Util.processResult(Integer.toString(increased), DAY, 2);
    }
}
