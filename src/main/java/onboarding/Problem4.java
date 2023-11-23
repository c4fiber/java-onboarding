package onboarding;
import problem4.WordValidation;
import problem4.ConvertWord;

public class Problem4 {
    public static String solution(String word) {
        WordValidation wordValidation = new WordValidation();
        if (wordValidation.ValidateWordLength(word)) {
            ConvertWord convertWord = new ConvertWord();
            return convertWord.IsAlphabet(word);
        }

        String answer = "";
        return answer;
    }
}
