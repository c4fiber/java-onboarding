package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = changeRascalWord(word);
        return answer;
    }

    public static String changeRascalWord(String word) {
        StringBuilder rascalWord = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!isAlphabet(ch)) { // Character.isAlphabetic()은 한글도 문자로 인식하므로 새로 메서드 생성
                rascalWord.append(ch);
                continue;
            }

            // 현재 단어에서 A(혹은 a)와의 차를 Z(혹은 z)에서 빼면 청개구리 사전이 됨
            // 'A' + ('Z' - 현재단어) 도 가능
            if (Character.isUpperCase(ch)) {
                rascalWord.append( (char) ('Z' - (ch - 'A')) );
            } else
                rascalWord.append( (char) ('z' - (ch - 'a')) );
        }
        return rascalWord.toString();
    }

    public static boolean isAlphabet(char ch) {
        if ( (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') )
            return true;
        return false;
    }
}
