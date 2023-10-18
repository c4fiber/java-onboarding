package problem4;

public class WordValidation {
    public boolean ValidateWordLength(String word) {
        if (word.length() > 1 && word.length() < 1000) {
//            return ValidateAlphabet(word);
            return true;
        }
        return false;
    }

    // 사실 여기서 하는게 의미가 없음
    //   > 알파벳이 아니면 그냥 그대로 출력하는 것이기 때문에, 사용 안 하는게 아님.
//    public boolean ValidateAlphabet(String word) {
//        char[] wordCharArray = word.toCharArray();  // 선언하는 것 보다 for문에서 한번에 처리 가능함
//        for (char c: wordCharArray) {
//            if (c < 56 && c > 123 && c != 32) {
//                throw new IllegalArgumentException("알파벳이 아닙니다");
//            } else if (c > 90 && c < 97) {
//                throw new IllegalArgumentException("알파벳이 아닙니다");
//            }
//        }
//
//        return true;
//    }
}
