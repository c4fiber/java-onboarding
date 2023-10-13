package onboarding;

import java.util.List;
import hi.Page;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Page page = new Page();
        int score = page.PageValidation(pobi, crong);
        System.out.println(score);
        return score;
    }
}