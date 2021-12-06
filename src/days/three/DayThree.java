package days.three;

import util.Util;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

public class DayThree {

  private static final int DAY = 3;
  private static final String INPUT_FILE = "data/" + DAY + "/input.txt";

  public static void main(String[] args) {
    List<String> input = Util.getFileAsList(INPUT_FILE);

    // this can be done with bitwise operations, I can feel it...
    int byteLength = input.get(0).toCharArray().length;
    int[] counts = new int[byteLength];
    for (String b : input) {
      char[] bs = b.toCharArray();
      for (int i = 0; i < byteLength; i++) {
        counts[i] += Integer.parseInt(Character.toString(bs[i]));
      }
    }

    BitSet gammaRate = new BitSet(byteLength);
    BitSet epsilonRate = new BitSet(byteLength);

    // must flip position, byte pos starts at right
    int bitPos = byteLength - 1;
    for (int count : counts) {
      int mostCommon = Math.round((float) count / (float) input.size());
      if (mostCommon == 1) {
        gammaRate.set(bitPos);
      } else {
        epsilonRate.set(bitPos);
      }
      bitPos--;
    }

    int powerConsumption = toInt(gammaRate) * toInt(epsilonRate);
    Util.processResult(Integer.toString(powerConsumption), DAY, 1);
  }

  public static int toInt(BitSet bitSet) {
    int intValue = 0;
    for (int bit = 0; bit < bitSet.length(); bit++) {
      if (bitSet.get(bit)) {
        intValue |= (1 << bit);
      }
    }
    return intValue;
  }
}
