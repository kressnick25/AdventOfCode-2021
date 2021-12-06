package days.two;

import util.Util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {
    private static final String INPUT_FILE = "data/2/input.txt";
    private static final String DAY = "Two";

    public static void main(String[] args) {
        List<String> input = Util.getFileAsList(INPUT_FILE);
        List<Command> commands = new ArrayList<>();
        Submarine sub = new Submarine();

        for (String i: input) {
            String[] s = i.split(Util.WHITESPACE_REGEX);

            int magnitude = Integer.parseInt(s[1]);
            Direction direction = null;
            try {
                direction = Direction.parseDirection(s[0]);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            commands.add(new Command(direction, magnitude));
        }

        for (Command c: commands) {
            sub.pilotControls(c);
        }

        int result = sub.getDepth() * sub.getHorizontalPosition();
        Util.processResult(Integer.toString(result), DAY, 1);
    }
}
