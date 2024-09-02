package onboarding;

public class Problem4 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;

    public static String solution(String word) {
        validate(word);

        return translateWord(word);
    }

    private static String translateWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append(translateCharacter(c));
        }

        return sb.toString();
    }

    private static char translateCharacter(char c) {
        if(Character.isUpperCase(c)) {
            return (char)('Z' - c + 'A');
        } else if(Character.isLowerCase(c)) {
            return (char)('z' - c + 'a');
        } else {
            return c;
        }
    }

    private static void validate(String word) {
        validateInput(word);
        validateLength(word);
    }

    private static void validateInput(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("입력값을 입력해주세요.");
        }
    }

    private static void validateLength(String word) {
        if (word.length() < MIN_LENGTH || word.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("입력 길이는 %d 이상 %d이하여야합니다.", MIN_LENGTH, MAX_LENGTH));
        }
    }
}
