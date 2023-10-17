package problem4;

public class ConvertWord {
    public String ConvertWord(String word) {
        char[] wordCharArray = word.toCharArray();
        StringBuilder builder = new StringBuilder(1024);
        // 기준점
//        int A = 65;
//        int Z = 90;
//        int a = 97;
//        int z = 123;

        // 이 부분 리팩토링 필요 !! 23/10/18
        for (char c: wordCharArray) {
            if (c > 64 && c < 91) {
                // 대문자 > 대문자
                int T = 90 - (c - 65);
                builder.append((char)T);
            } else if (c > 96 && c < 123) {
                // 소문자 > 소문자
                int t = 122 - (c - 97);
                builder.append((char)t);
            } else if (c == 32) {
                // 스페이스
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
