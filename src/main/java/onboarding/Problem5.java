package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());

        for (int i = 0; i < unit.length; i++) {
            if (money / unit[i] != 0) {
                answer.add(money / unit[i]);
                money = money % unit[i];
            } else if (money / unit[i] == 0) {
                answer.add(0);
            }
        }
        return answer;
    }
}
