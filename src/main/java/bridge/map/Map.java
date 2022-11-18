package bridge.map;

import bridge.input.Command;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<String> up;
    private final List<String> down;

    public Map() {
        up = new ArrayList<>();
        down = new ArrayList<>();
    }

    public void addCanCross(String moving) {
        if (moving.equals(Command.UP.getLetter())) {
            up.add(Status.CAN_CROSS.getLetter());
            down.add(Status.BLANK.getLetter());
            return;
        }
        up.add(Status.BLANK.getLetter());
        down.add(Status.CAN_CROSS.getLetter());
    }

    public void addCanNotCross(String moving) {
        if (moving.equals(Command.UP.getLetter())) {
            up.add(Status.CAN_NOT_CROSS.getLetter());
            down.add(Status.BLANK.getLetter());
            return;
        }
        up.add(Status.BLANK.getLetter());
        down.add(Status.CAN_NOT_CROSS.getLetter());
    }

    @Override
    public String toString() {
        return format(up) + "\n" + format(down);
    }

    private String format(List<String> part) {
        StringBuilder result = new StringBuilder();
        result.append(Format.BEGIN.getLetters());

        String status = String.join(Format.DIVISION.getLetters(), part);
        result.append(status);

        result.append(Format.END.getLetters());
        return result.toString();
    }
}
