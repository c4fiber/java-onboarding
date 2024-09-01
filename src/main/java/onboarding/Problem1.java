package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int PAGE_SIZE = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validate(pobi);
            validate(crong);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return EXCEPTION;
        }

        return calculateWinner(pobi, crong);
    }

    private static void validate(List<Integer> pages) {
        if (pages.size() != PAGE_SIZE) {
            throw new IllegalArgumentException("두 페이지로 이루어져야합니다.");
        }

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage >= rightPage) {
            throw new IllegalArgumentException("왼쪽 페이지가 오른쪽 페이지보다 클 수 없습니다.");
        }
        if (isOutOfRange(leftPage) || isOutOfRange(rightPage)) {
            throw new IllegalArgumentException("페이지 수는 1부터 400까지입니다.");
        }
        if (leftPage % 2 != 1) {
            throw new IllegalArgumentException("왼쪽 페이지는 홀수 번호여야 합니다.");
        }
        if (rightPage % 2 != 0) {
            throw new IllegalArgumentException("오른쪽 페이지는 짝수 번호여야합니다.");
        }
        if (rightPage - leftPage != 1) {
            throw new IllegalArgumentException("페이지는 연속된 수여야합니다.");
        }
    }

    private static boolean isOutOfRange(int page) {
        final int MIN_PAGE = 1;
        final int MAX_PAGE = 400;

        if (MIN_PAGE <= page && page <= MAX_PAGE) {
            return false;
        }

        return true;
    }

    private static int findMaxPageValue(List<Integer> pages) {
        return pages.stream()
            .mapToInt(page -> getMaxDigitOperation(page))
            .max()
            .orElse(0);
    }

    private static int getMaxDigitOperation(int page) {
        int sum = sumOfDigits(page);
        int multiplication = multiplyOfDigits(page);

        return Math.max(sum, multiplication);
    }

    private static int sumOfDigits(int page) {
        int result = 0;
        while(page > 0) {
            result += (page % 10);
            page /= 10;
        }

        return result;
    }

    private static int multiplyOfDigits(int page) {
        int result = 1;
        while (page > 0) {
            result *= (page % 10);
            page /= 10;
        }

        return result;
    }

    private static int calculateWinner(List<Integer> pobi, List<Integer> crong) {
        int pobiValue = findMaxPageValue(pobi);
        int crongValue = findMaxPageValue(crong);

        if (pobiValue > crongValue) {
            return POBI_WIN;
        } else if (pobiValue < crongValue) {
            return CRONG_WIN;
        } else {
            return DRAW;
        }
    }
}