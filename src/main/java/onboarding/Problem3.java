package onboarding;

import java.util.Arrays;

public class Problem3 {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100_000_000;

    public static int solution(int number) {
        validate(number);

        return getTotalClapCount(number);
    }

    private static void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Input must be between 1 and 100,000,000");
        }
    }

    private static int getTotalClapCount(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += getEachClapCount(i);
        }

        return count;
    }

    private static int getEachClapCount(int number) {
        return (int)Arrays.stream(String.valueOf(number).split(""))
            .mapToInt(Integer::parseInt)
            .filter(i -> i == 3 || i == 6 || i == 9)
            .count();
    }

}
