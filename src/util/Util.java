package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Util {

  /**
   * Matches any whitespace
   */
  public static final String WHITESPACE_REGEX = "\\s+";

  public static List<String> getFileAsList(String filename) {
    try {
      Path path = Paths.get(filename);
      List<String> result = Files.readAllLines(path);
      return result;
    } catch (IOException e){
      throw new RuntimeException();
    }
  }

  public static void processResult(String buffer, String day, Integer part) {
    displayResult(buffer, part);
    writeResult(buffer, day, part);
  }

  public static Integer getSafe(List<Integer> list, int idx) {
    if (idx >= list.size()) {
      return 0;
    }
    return list.get(idx);
  }

  private static void displayResult(String buffer, Integer part) {
    System.out.println("Part " + part.toString() + ": " + buffer);
  }

  private static void writeResult(String buffer, String day, Integer part) {
    // Where Main is running
    StringBuilder builder = new StringBuilder();
    builder.append("results/day");
    builder.append(day);
    if (part != null) {
      builder.append("_part");
      builder.append(part);
    }
    builder.append("Result.txt");

    Path current =  Paths.get(builder.toString());

    try {
      Files.write(current, buffer.getBytes());
    } catch (IOException e) {
      System.out.println("Failed to write to result to file: " + e.getStackTrace());
      throw new RuntimeException(e);
    }
  }

}
