package onboarding;

import java.util.List;
import java.util.Map;

/**
 * ☑️ 구현 기능 목록 작성
 * 1. 주어진 페이지 유효성 검사하는 기능.
 *  1-1. 왼쪽 페이지가 홀수가 아니고 오른쪽 페이지가 짝수가 아닐 떄.
 *  1-2. 페이지 번호가 1부터 시작되고 400페이지 까지 있다.
 *  1-3. 배열 안에 원소가 2개가 아닐 때 체크
 *  1-4. 입력한 페이지가 한 페이지 차이가 아닐 때 -> 예외사항 이므로 -1 리턴
 *  1-5. 0 이하의 값을 입력할 경우
 * 2. 포비가 펼친 페이지의 숫자를 비교해 가장 큰 수를 구하는 기능.
 * 3. 크롱이 펼친 페이지의 숫자를 비교해 가장 큰 수를 구하는 기능.
 * 4. 포비와 크롱의 수를 비교하여 더 큰 사람 결정 하는  기능.
 *   4-1. 포비가 이기면1  return
 *   4-2. 크롱이 이기면2  return
 *   4-3. 무승부면 0  return
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}

