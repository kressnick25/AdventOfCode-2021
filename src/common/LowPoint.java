package common;

public class LowPoint extends Point {
  private int height;

  public LowPoint(int x, int y, int height) {
    super(x, y);
    this.height = height;
  }

  public int getHeight() {
    return this.height;
  }

  public int getRiskLevel() {
    return this.height + 1;
  }

}
