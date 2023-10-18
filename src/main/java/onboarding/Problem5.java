package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = transformMoney(money);
        return answer;
    }

    public static List<Integer> transformMoney(int money) {
        List<Integer> wallet = new ArrayList<>();

        List<Integer> billType = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        int i = 0;
        int j = billType.size();
        while(j-- > 0) {
            wallet.add(i, money / billType.get(i));
            money %= billType.get(i++);
        }

        return wallet;
    }
}
