package onboarding;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class ApplicationTest {
    @Nested
    class Problem1Test {
        @Test
        void 포비가_우승하는_경우() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void 크롱이_우승하는_경우() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void 페이지가_연속되지_않은_경우() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void 왼쪽_페이지_숫자가_더_큰_경우() {
            List<Integer> pobi = List.of(100, 99);
            List<Integer> crong = List.of(88, 89);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void 페이지가_범위를_벗어난_경우() {
            List<Integer> pobi = List.of(33, 34);
            List<Integer> crong = List.of(0, 1);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void 왼쪽_페이지가_홀수가_아닌_경우() {
            List<Integer> pobi = List.of(34, 35);
            List<Integer> crong = List.of(36, 37);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void 오른쪽_페이지가_짝수가_아닌_경우() {
            List<Integer> pobi = List.of(35, 36);
            List<Integer> crong = List.of(37, 38);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void 두_페이지로_이루어져_있지_않은_경우() {
            List<Integer> pobi = List.of(35, 36, 37);
            List<Integer> crong = List.of(37, 38);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
        private static final int MIN_LENGTH = 1;
        private static final int MAX_LENGTH = 1000;

        @Test
        void 해독_성공_케이스_1() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void 해독_성공_케이스_2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void 해독_성공_케이스_3() {
            String cryptogram = "aaabbbacccbcccbc"; // "aaabbbacccbbc" -> "aaabbbacccc" -> "aaabbba" -> "aaaa" -> ""
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void 문자열_최소길이_불충분_예외_처리() {
            String cryptogram = "";

            assertThatThrownBy(() -> Problem2.solution(cryptogram))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 문자열_최대길이_초과_예외_처리() {
            String cryptogram = "a".repeat(MAX_LENGTH + 1);

            assertThatThrownBy(() -> Problem2.solution(cryptogram))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 대문자가_있는_경우_예외_처리() {
            String cryptogram = "aA";

            assertThatThrownBy(() -> Problem2.solution(cryptogram))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 한글이_있는_경우_예외_처리() {
            String cryptogram = "a가";

            assertThatThrownBy(() -> Problem2.solution(cryptogram))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class Problem3Test {
        private static final int MIN_NUMBER = 1;
        private static final int MAX_NUMBER = 100_000_000;

        @Test
        void 성공_케이스_1() {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void 성공_케이스_2() {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void 성공_케이스_3() {
            int number = 1;
            int result = 0;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void 숫자_범위_초과_예외_처리() {
            int number = MAX_NUMBER + 1;

            assertThatThrownBy(() -> Problem3.solution(number))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자_범위_미만_예외_처리() {
            int number = MIN_NUMBER - 1;

            assertThatThrownBy(() -> Problem3.solution(number))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class Problem4Test {
        private static final int MIN_LENGTH = 1;
        private static final int MAX_LENGTH = 1000;

        @Test
        void 성공_케이스_1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void 성공_케이스_2() {
            String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String result = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void 성공_케이스_3() {
            String word = "abcdefghijklmnopqrstuvwxyz";
            String result = "zyxwvutsrqponmlkjihgfedcba";

            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void 성공_케이스_4() {
            String word = "zyxwvutsrqponmlkjihgfedcba";
            String result = "abcdefghijklmnopqrstuvwxyz";

            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void 문자열_최소길이_불충분_예외_처리() {
            String word = "";

            assertThatThrownBy(() -> Problem4.solution(word))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 문자열_최대길이_초과_예외_처리() {
            String word = "a".repeat(MAX_LENGTH + 1);

            assertThatThrownBy(() -> Problem4.solution(word))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class Problem7Test {
        @Test
        void case1() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
