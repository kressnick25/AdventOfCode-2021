package days.two;

public class Submarine {
  private int horizontalPosition;
  private int depth;
  private int aim;

  Submarine() {
    this.horizontalPosition = 0;
    this.depth = 0;
    this.aim = 0;
  }

  public int getHorizontalPosition() {
    return horizontalPosition;
  }

  public int getDepth() {
    return depth;
  }

  public void pilotControls(Command command) {
    switch (command.getDirection()) {
      case UP:
        this.aim -= command.getMagnitude();
        break;
      case DOWN:
        this.aim += command.getMagnitude();
        break;
      case FORWARD:
        this.horizontalPosition += command.getMagnitude();
        this.depth += this.aim * command.getMagnitude();
        break;
      default:
        throw new RuntimeException("Switch case not handled");
    }
  }
}
