package Problem2;

public class StringValidation {
    public boolean Validate (String cryptogram) {
        // 문자열 길이 오류
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return false;
        }
        // 대문자 포함될 경우
        char[] charArray = cryptogram.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                return false;
            }
        }
        return true;
    }
}
