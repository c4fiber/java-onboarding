package onboarding;

import java.util.List;

class Problem1 {

    public static boolean checkException(List<Integer> pages){
        int left = pages.get(0);
        int right = pages.get(1);
        if(left != right - 1){
            return false;
        }
        if(left < 1 || right > 400){
            return false;
        }
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!checkException(pobi)){
            return -1;
        }
        if(!checkException(crong)){
            return -1;
        }
        return answer;
    }

}