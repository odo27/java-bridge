package bridge.output;

import bridge.map.Map;
import bridge.output.message.Error;
import bridge.output.message.Read;
import bridge.output.message.Status;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStartMessage() {
        System.out.println(Status.START.getMessage());
    }

    public static void printReadBridgeSizeMessage() {
        System.out.println(Read.BRIDGE_SIZE.getMessage());
    }

    public static void printReadBridgeSizeErrorMessage() {
        System.out.println(Error.BRIDGE_SIZE.getMessage());
    }

    public static void printReadMovingMessage() {
        System.out.println(Read.MOVING.getMessage());
    }

    public static void printReadMovingErrorMessage() {
        System.out.println(Error.MOVING.getMessage());
    }

    public static void printReadGameCommandMessage() {
        System.out.println(Read.GAME_COMMAND.getMessage());
    }

    public static void printReadGameCommandErrorMessage() {
        System.out.println(Error.GAME_COMMAND.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map map) {
        System.out.println(map.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Map map, boolean success, int totalTry) {
        System.out.println(Status.FINISH.getMessage());
        printMap(map);
        System.out.print(Status.SUCCESS_OR_NOT.getMessage());
        System.out.println(successOrNotToString(success));
        System.out.print(Status.TOTAL_TRY.getMessage());
        System.out.println(totalTry);
    }

    private String successOrNotToString(boolean success) {
        if (success) {
            return Status.SUCCESS.getMessage();
        }
        return Status.FAIL.getMessage();
    }
}
