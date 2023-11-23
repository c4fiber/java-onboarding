package Problem2;

import java.util.Stack;

public class eJun0SSockSSock {
    // 2jun0's Code
    // 1. Stack 생성
    // 2. for문 순회
    // 3. push || pop

    public String ConvertStackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        // 후입선출 고려 0번째 index에 add가 아닌 insert 해줌.
        while (!stack.isEmpty()) { //모두 pop() 되면 종료
            // pop()은 제거하면서 sb에 insert도 가능한가봄
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
    public String RemoveDuplicate(String cryptogram) {
        Stack<Character> stack = new Stack<Character>();

        for (char c: cryptogram.toCharArray()) {
            // 나는 문자열 비교시 equals ( 참조형 비교 위해) 썼는데 char은 기본형이라 == 시용 가능
            if (stack.size() > 0 && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return ConvertStackToString(stack);
    }


}
