package problem4;

public class WordValidation {
    public boolean ValidateWordLength(String word) {
        if (word.length() > 1 && word.length() < 1000) {
            return ValidateAlphabet(word);
        }
        return false;
    }

    public boolean ValidateAlphabet(String word) {
        char[] wordCharArray = word.toCharArray();
        for (char c: wordCharArray) {
            if (c < 56 && c > 123 && c != 32) {
                throw new IllegalArgumentException("알파벳이 아닙니다");
            } else if (c > 90 && c < 97) {
                throw new IllegalArgumentException("알파벳이 아닙니다");
            }
        }
        return true;
    }
}
