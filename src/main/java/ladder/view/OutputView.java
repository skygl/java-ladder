package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Result;
import ladder.dto.PointsTupleDto;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int PADDING_WIDTH = 5;

    public static void printRewardErrorMsg() {
        System.out.println("보상은 1자 이상 5자 이내여야 합니다.");
    }

    public static void printLadderMessage() {
        System.out.println("\n사다리 결과\n");
    }

    public static void printNames(final List<Player> players) {
        for (Player player : players) {
            System.out.printf("%s ", StringUtils.center(player.getName(), PADDING_WIDTH));
        }
        System.out.println();
    }

    public static void printLadder(final Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(final Line line) {
        List<PointsTupleDto> points = line.makeTupleDto();
        Iterator<PointsTupleDto> iter = new Iterator<PointsTupleDto>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < points.size() - 1;
            }

            @Override
            public PointsTupleDto next() {
                return points.get(count++);
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append("  |");
        while (iter.hasNext()) {
            sb.append(printPoint(iter.next().getRight()));
            sb.append("|");
        }
        System.out.println(sb.toString());
    }

    private static String printPoint(final Boolean point) {
        if (point) {
            return "-----";
        }
        return "     ";
    }

    public static void printRewards(final List<String> rewards) {
        for (String reward : rewards) {
            System.out.printf("%s ", StringUtils.center(reward, PADDING_WIDTH));
        }
        System.out.println("\n");
    }

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(final String name, final Result result) {
        printResultMessage();
        System.out.println(result.getResult().get(name) + "\n");
    }

    public static void printResultAll(final Result result) {
        printResultMessage();
        final Map<String, String> a = result.getResult();
        for (Map.Entry<String, String> entry : a.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
