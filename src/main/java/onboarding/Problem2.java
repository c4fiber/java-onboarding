package onboarding;

public class Problem2 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    public static String solution(String cryptogram) {
        validate(cryptogram);

        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        // 매번 오른쪽 끝에서부터 중복되는 연속된 문자열이 있는지 검사하고 지운다. 이 때, 연속된 문자는 3개 이상일 수 있음을 유의해라

        String decrypted = cryptogram;
        while (true) {
            String removed = removeDuplicate(decrypted);
            if (removed.equals(decrypted)) {
                break;
            }
            decrypted = removed;
        }

        return decrypted;
    }

    /**
     * 오른쪽 끝에서부터 연속된 중복된 문자열을 찾아 한 번 제거하는 메소드
     * @param cryptogram
     * @return 중복된 문자열을 제거한 문자열
     */

    private static String removeDuplicate(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);

        for (int i = sb.length() - 1; i > 0; i--) {
            if (sb.charAt(i) == sb.charAt(i-1)) {
                int count = 0;
                for (int j = i; j >= 0 && sb.charAt(i) == sb.charAt(j); j--) {
                    count++;
                }

                sb.delete(i - count + 1, i + 1);

                return sb.toString();
            }
        }
        return sb.toString();
    }

    private static void validate(String cryptogram) {
        validateInput(cryptogram);
        validateLength(cryptogram);
        validateLowerCase(cryptogram);
    }

    // 빈 값인지 검증하는 메소드
    private static void validateInput(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("암호를 입력해주세요.");
        }
    }

    // 알파벳 소문자인지 검증하는 메소드
    private static void validateLowerCase(String str) {
        if (!str.matches("[a-z]+")) {
            throw new IllegalArgumentException("암호는 소문자 알파벳으로만 이루어져야 합니다.");
        }
    }

    private static void validateLength(String str) {
        if (str.length() < MIN_LENGTH || str.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("암호의 길이는 " + MIN_LENGTH + "이상 " + MAX_LENGTH + "이하여야 합니다.");

        }
    }

}
