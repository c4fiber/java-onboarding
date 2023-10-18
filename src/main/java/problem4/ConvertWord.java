package problem4;

public class ConvertWord {
//    public String ConvertWord(String word) {
//        char[] wordCharArray = word.toCharArray();  // 미리 선언 vs for문에서 한 번에 처리
//        StringBuilder builder = new StringBuilder(1024);
//        // 이 부분 리팩토링 필요 !! 23/10/18
//        for (char c: wordCharArray) {
//            if (c > 64 && c < 91) {
//                // 대문자 > 대문자
//                int T = 90 - (c - 65);
//                builder.append((char)T);
//            } else if (c > 96 && c < 123) {
//                // 소문자 > 소문자
//                int t = 122 - (c - 97);
//                builder.append((char)t);
//            } else if (c == 32) {
//                // 스페이스
//                builder.append(c);
//            }
//        }
//        return builder.toString();
//    }
    public char ConvertAlphabet(char c) {
        char startIdx = ' ';
        char lastIdx = ' ';

        // 대소문자 구분
        if (Character.isUpperCase(c)) {
            startIdx = 'A'; // 대문자
            lastIdx = 'Z';
        } else {
            startIdx = 'a'; // 소문자
            lastIdx = 'z';
        }
        return (char)(lastIdx - (c - startIdx));
    }
    public String IsAlphabet (String word) {
        StringBuilder builder = new StringBuilder(1024);
        // 2jun0 + me
        for (char c: word.toCharArray()) {  // 선언하지 않고 for문에서 한 번에 처리
            if (Character.isAlphabetic(c)) {
                // 알파벳일 경우 convert
                builder.append(ConvertAlphabet(c));
            } else {
                // !, ' ', ~ 등등은 그대로 append
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
