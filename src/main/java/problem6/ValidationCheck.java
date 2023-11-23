package problem6;

import java.util.List;

public class ValidationCheck {
    // 크루원 수 check
    public boolean MemberCountValidate(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10000) {
            return false;
        }
        return true;
    }
    // 이메일 길이, 도메인 일치 체크
    public boolean EmailValidate(String email) {
        int length = email.length();

        if (length < 11 || length > 19) {
            return false;
        }
        if (email.substring(length - 10) != "@email.com") {
            return false;
        }
        return true;
    }
    // 닉네임 한글 체크, 글자수 체크
    public boolean NicknameValidate(String nickname) {
        if (nickname.length() < 1 || nickname.length() > 19) {
            return false;
        }
        if (!nickname.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            return false;
        }
        return true;
    }
}
