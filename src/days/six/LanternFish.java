package days.six;

public class LanternFish {
  private static final int INITIAL_TIMER = 6;
  private int timer;

  public LanternFish(int initialTimer) {
    this(initialTimer, false);
  }

  private LanternFish(int initialTimer, boolean firstCycle) {
    this.timer = initialTimer;
    if (firstCycle) {
      this.timer += 2;
    }
  }

  public LanternFish step() {
    if (this.timer == 0) {
      LanternFish newFish = spawn();
      this.timer = INITIAL_TIMER;
      return newFish;
    } else {
      this.timer--;
      return null;
    }
  }

  private LanternFish spawn() {
    return new LanternFish(INITIAL_TIMER, true);
  }
}
