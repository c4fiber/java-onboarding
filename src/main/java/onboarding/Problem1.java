package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int plus_value(Integer i) {
        int value = 0;
        while(i > 0) {
            value += i % 10;
            i /= 10;
        }
        return value;
    }

    public static int multiple_value(Integer i) {
        int value = 1;
        while(i > 0) {
            value *= i % 10;
            i /= 10;
        }
        return value;
    }
}