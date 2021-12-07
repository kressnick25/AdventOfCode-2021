package days.four;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoardBuilder {
  List<List<Integer>> board;

  public BoardBuilder() {
    this.board = new ArrayList<>();
  }

  public void appendRow(String row) {
    List<String> rowString = Arrays.asList(row.trim().split(Util.WHITESPACE_REGEX));
    board.add(rowString.stream()
                       .map(Integer::parseInt)
                       .collect(Collectors.toList()));
  }

  public BingoBoard build() {
    return new BingoBoard(this.board);
  }
}
