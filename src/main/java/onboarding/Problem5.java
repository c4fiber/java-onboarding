package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 1_000_000_000;

    private static final int[] MONEY_UNIT = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        validate(money);

        return solve(money);
    }

    private static void validate(int money) {
        if (money < MIN_MONEY || money > MAX_MONEY) {
            throw new IllegalArgumentException("금액은 " + MIN_MONEY + "원 이상 " + MAX_MONEY + "원 이하여야 합니다.");
        }
    }

    private static List<Integer> solve(int money) {
        int[] result = new int[MONEY_UNIT.length];

        for (int i = 0; i < MONEY_UNIT.length; i++) {
            result[i] = money / MONEY_UNIT[i];
            money -= result[i] * MONEY_UNIT[i];
        }

        return Arrays.stream(result)
            .boxed()
            .collect(Collectors.toUnmodifiableList());
    }
}
