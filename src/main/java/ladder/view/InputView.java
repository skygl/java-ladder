package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int MIN_HEIGHT = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String names = scanner.nextLine();
        try {
            validateNoConsecutiveCommas(names);
            final List<String> splittedNames = Arrays.asList(names.split(","));
            validateNoDuplication(splittedNames);
            return splittedNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getNames();
        }
    }

    static void validateNoConsecutiveCommas(final String names) {
        if (names.contains(",,")) {
            throw new IllegalArgumentException("','가 두개 이상 연달아 있으면 안 됩니다.");
        }
    }

    static void validateNoDuplication(final List<String> names) {
        final List<String> reducedNames = names.stream().distinct().collect(Collectors.toList());
        if (names.size() != reducedNames.size()) throw new IllegalArgumentException("중복된 이름이 존재하면 안됩니다.");
    }


    public static List<String> getRewards() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        final String rewards = scanner.nextLine();
        try {
            validateNoConsecutiveCommas(rewards);
            return Arrays.asList(rewards.split(","));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getRewards();
        }
    }

    public static int getHeight() {
        try {
            System.out.println("\n최대 사다리 높이는 몇 개인가요?");
            final int height = Integer.parseInt(scanner.nextLine());
            validateNaturalNumber(height);
            return height;
        } catch (NumberFormatException e) {
            System.out.println("정수만 입력할 수 있습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return getHeight();
    }

    static void validateNaturalNumber(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 최소 1 이어야 합니다.");
        }
    }

    public static String getName() {
        System.out.println("결과를 보고 싶은 사람은?");
        final String name = scanner.nextLine();
        return name;
    }
}