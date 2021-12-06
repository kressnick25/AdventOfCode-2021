package days.two;

public class Command {
  private final Direction direction;
  private final int magnitude;

  public Command(Direction direction, int magnitude) {
    this.direction = direction;
    this.magnitude = magnitude;
  }

  public Direction getDirection() {
    return direction;
  }

  public int getMagnitude() {
    return magnitude;
  }

}
