package days.five;

import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DayFive {
  private static final int DAY = 5;

  public static void main(String args[]) {
    List<String> input = Util.getFileAsList(Util.getInputFile(DAY));

    List<Line> lines = parseLines(input);
    assert(lines.size() > 0);

    int maxX = Math.max(lines.stream().map(e -> e.getStart().getX()).max(Integer::compareTo).get(),
                        lines.stream().map(e -> e.getEnd().getX()).max(Integer::compareTo).get());
    int maxY = Math.max(lines.stream().map(e -> e.getStart().getY()).max(Integer::compareTo).get(),
                        lines.stream().map(e -> e.getEnd().getY()).max(Integer::compareTo).get());


    int[][] grid = new int[maxY + 1][maxX + 1];
    for (Line l : lines) {
      l.draw(grid);
    }

    int result = getAllAboveThreshold(grid, 2);

    Util.processResult(Integer.toString(result), DAY, 1);
  }

  static int getAllAboveThreshold(int[][] grid, int threshold) {
    int result = 0;
    for (int[] row : grid) {
      for (int square : row) {
        if (square >= 2) result++;
      }
    }
    return result;
  }

  static void printGrid(int[][] grid) {
    for (int[] row : grid) {
      for (int square : row) {
        if (square == 0)
          System.out.print('.');
        else
          System.out.print(square);
      }
      System.out.print('\n');
    }
  }

  static boolean onlyHorizontalOrVertical(Line l) {
    return l.getStart().getX() == l.getEnd().getX()
           || l.getStart().getY() == l.getEnd().getY();
  }

  static List<Line> parseLines(List<String> input) {
    List<Line> result = new ArrayList<>();
    for (String i : input) {
      String[] unparsedLine = i.split(" -> ");
      String[] p1 = unparsedLine[0].split(",");
      String[] p2 = unparsedLine[1].split(",");
      Point point1 = new Point(Integer.parseInt(p1[0]), Integer.parseInt(p1[1]));
      Point point2 = new Point(Integer.parseInt(p2[0]), Integer.parseInt(p2[1]));

      result.add(new Line(point1, point2));
    }
    return result;
  }
}
