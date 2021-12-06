package days.two;

import java.text.ParseException;

public enum Direction {
  FORWARD,
  DOWN,
  UP;

  public static Direction parseDirection(String s) throws ParseException {
    if ("forward".equals(s)) {
      return Direction.FORWARD;
    }
    if ("down".equals(s)) {
      return Direction.DOWN;
    }
    if ("up".equals(s)) {
      return Direction.UP;
    }

    throw new ParseException(s + " is not a valid direction", 0);
  }
}
