package days.four;

import java.util.List;

public class BingoBoard {
  private List<List<Integer>> board;

  public BingoBoard(List<List<Integer>> board) {
    this.board = board;
  }

  public int getSumUnmarked() {
    int result = 0;
    for (List<Integer> row: this.board) {
      for (Integer square: row) {
        if (square != null) {
          result += square;
        }
      }
    }
    return result;
  }

  public void markResult(int result) {
    for (int j = 0; j < board.size(); j++) {
      List<Integer> row = board.get(j);
      for (int i = 0; i < row.size(); i++) {
        if (row.get(i) != null && result == row.get(i)) {
          (board.get(j)).set(i, null);
        }
      }
    }
  }

  public boolean hasWon() {
    for (int i = 0; i < board.size(); i++) {
      List<Integer> row = board.get(i);
      for (int j = 0; j < row.size(); j++) {
        Integer current = row.get(j);
        // is also 0 because fist is part of win condition
        if (current == null && (i == 0 || j == 0)) {

          // check the row
          boolean allMarked = true;
          for (Integer square : row) {
            if (square != null) {
              allMarked = false;
              break;
            }
          }
          if (allMarked) return true;

          allMarked = true;
          for (int k = 0; k < board.size(); k++) {
            List<Integer> nextRow = board.get(k);
            if (nextRow.get(j) != null) {
              allMarked = false;
              break;
            }
          }
          if (allMarked) return true;
        }
      }
    }
    return false;
  }
}
