package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int countClap(int number) {
        
    }

    public static int isInThree(int number) {
        int count = 0;
        while(number > 0) {
            int check_num = number % 10;
            if (check_num == 3)
                count++;
            number /= 10;
        }
        return count;
    }

    public static int isInSix(int number) {
        int count = 0;
        while(number > 0) {
            int check_num = number % 10;
            if (check_num == 6)
                count++;
            number /= 10;
        }
        return count;
    }

    public static int isInNine(int number) {
        int count = 0;
        while(number > 0) {
            int check_num = number % 10;
            if (check_num == 9)
                count++;
            number /= 10;
        }
        return count;
    }
}
