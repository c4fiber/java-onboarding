package problem3;

public class NumberValidation {
    public int validateNumber (int number) {
        if (number < 1 || number > 1000) {
            System.out.println("1 이상 1000 이하의 숫자만 가능합니다.");
            return -1;
        }
        ClapCount clapCount = new ClapCount();
        return clapCount.CountCalp(number);
    }
}
