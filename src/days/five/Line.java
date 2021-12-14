package days.five;

import common.Point;

public class Line {
  private final Point start;
  private final Point end;

  public Line(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  public Point getEnd() {
    return end;
  }

  public Point getStart() {
    return start;
  }

  void draw(int[][] grid) {
    if (isXSame()) {
      int startY = Math.min(start.getY(), end.getY());
      int endY = Math.max(start.getY(), end.getY());
      for (int j = startY; j <= endY; j++) {
        grid[j][start.getX()]++;
      }
    }
    else if (isYSame()) {
      int startX = Math.min(start.getX(), end.getX());
      int endX = Math.max(start.getX(), end.getX());
      for (int i = startX; i <= endX; i++) {
        grid[start.getY()][i]++;
      }
    }
    else {
      int directionX = Integer.signum(end.getX() - start.getX());
      int directionY = Integer.signum(end.getY() - start.getY());
      int y = start.getY();
      int x = start.getX();
      for(int i = 0; i <= Math.abs(end.getX() - start.getX()); i++) {
        grid[y][x]++;
        y += directionY;
        x += directionX;
      }


    }

  }

  private boolean isXSame() {
    return this.start.getX() == this.end.getX();
  }

  private boolean isYSame() {
    return this.start.getY() == this.end.getY();
  }
}
