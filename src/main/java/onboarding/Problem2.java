package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = removeSeqChar(cryptogram);
        return answer;
    }

    public static String removeSeqChar(String cryptogram) {

        StringBuilder cryptogramBuilder = new StringBuilder(cryptogram); // String 객체는 불변 따라서 StringBuilder 객체로 만들어 사용함
        StringBuilder stringBuilder = null; // 임시 공간
        int dup_char_end_index = 0;

        for(int i = 0; i < cryptogramBuilder.length() - 1; i++) {
            dup_char_end_index = checkSeqChar(cryptogramBuilder.toString(), i, cryptogramBuilder.charAt(i));

            if (i != dup_char_end_index) { // 중복문자가 있다면
                stringBuilder = new StringBuilder(); // 우선 임시 공간을 초기화
                cryptogramBuilder = stringBuilder.append(cryptogramBuilder.substring(0, i)).append(cryptogramBuilder.substring(dup_char_end_index + 1));
                i = -1;
            }
        }
        return cryptogramBuilder.toString();
    }

    public static int checkSeqChar(String cryptogram, int i, char c) {

        // cryptogram의 i번째 이후의 값 중에서 c와 같은 값이 있는지 체크하는 함수

        int j = i + 1;
        for (; j < cryptogram.length(); j++) {
            if (c != cryptogram.charAt(j))
                break;
        }

        return j - 1;
    }
}
