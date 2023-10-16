package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = result(pobi, crong);
        return answer;
    }

    public static int result(List<Integer> pobi, List<Integer> crong) {
        // 어떤 예외 상황이 있을까? (예외 시 -1)
        // 1. 페이지가 연달아 있지 않는 경우
        // 2. 페이지가 1 ~ 400 사이의 수가 아닌 경우
        // 3. 왼쪽 페이지가 홀수가 아니거나 오른쪽 페이지가 짝수가 아닌 경우
        // 4. 리스트에 아무 값도 들어있지 않은 경우 (null)

        if (!isSequentialNum(pobi) || !isSequentialNum(crong) || !isInRangeNum(pobi) || !isInRangeNum(crong)
                || !isLOddOrREven(pobi) || !isLOddOrREven(crong) || pobi.isEmpty() || crong.isEmpty())
            return -1;

        // 포비가 이기면 1, 무승부 0, 크롱이 이기면 2
        if (pobi_max_value(pobi) > crong_max_value(crong))
            return 1;
        else if (pobi_max_value(pobi) < crong_max_value(crong))
            return 2;
        return 0;
    }

    public static boolean isSequentialNum(List<Integer> person) {
        return (person.get(0) + 1) == person.get(1);
    }

    public static boolean isInRangeNum(List<Integer> person) {
        boolean indexZero = person.get(0) > 0 && person.get(0) < 401;
        boolean indexOne = person.get(1) > 0 && person.get(1) < 401;
        return indexZero && indexOne;
    }

    public static boolean isLOddOrREven(List<Integer> person) {
        boolean indexZero = (person.get(0) % 2) != 0; // 홀수면 true
        boolean indexOne = (person.get(1) % 2) == 0; // 짝수면 true
        return indexZero && indexOne;
    }

    private static int person_max_value(List<Integer> person) {
        int plus_max_value;
        int multiple_max_value;

        // 오른쪽 페이지 값으로만 비교?..
        // (9, 10), (19, 20)의 예를 보면 왼쪽 페이지 값이 큰 경우도 있음. 모두 비교.

        plus_max_value = Math.max(plus_value(person.get(0)), plus_value(person.get(1)));
        multiple_max_value = Math.max(multiple_value(person.get(0)), multiple_value(person.get(1)));

        return Math.max(plus_max_value, multiple_max_value);
    }

    public static int pobi_max_value(List<Integer> pobi) {
        return person_max_value(pobi);
    }

    public static int crong_max_value(List<Integer> crong) {
        return person_max_value(crong);
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