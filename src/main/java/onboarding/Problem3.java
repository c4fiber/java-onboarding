package onboarding;
import problem3.NumberValidation;

public class Problem3 {
    public static int solution(int number) {
        NumberValidation numberValidation = new NumberValidation();
        return numberValidation.validateNumber(number);
    }
}
