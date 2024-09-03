package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    // 크루원 최소, 최대 제한사항
    private static final int MIN_FORMS = 1;
    private static final int MAX_FORMS = 1000;
    private static final int FORM_SIZE = 2;
    // 이메일 형식 및 제한사항
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 20;
    private static final String EMAIL_DOMAIN = "email.com";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9]+@" + EMAIL_DOMAIN + "$";
    // 닉네임 형식 및 제한사항
    private static final int MIN_NICKNAME_LENGTH = 1;
    private static final int MAX_NICKNAME_LENGTH = 20;
    private static final String NICKNAME_REGEX = "^[가-힣]*$";


    public static List<String> solution(List<List<String>> forms) {
        validate(forms);

        return solve(forms);
    }

    private static List<String> solve(List<List<String>> forms) {
        Set<String> result = findEmailsWithSimilarNicknames(forms);

        return result.stream()
            .sorted()
            .collect(Collectors.toUnmodifiableList());
    }

    private static Set<String> findEmailsWithSimilarNicknames(List<List<String>> forms) {
        // 나와 닉네임이 중복되는 사람이 있는지 찾는다 (내 뒷사람만 찾으면 됨)
        // 닉네임이 중복되는 경우, 그 사람의 이메일을 Set에 저장한다 (중복방지)

        Set<String> result = new HashSet<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            String myEmail = forms.get(i).get(0);
            String myNickname = forms.get(i).get(1);

            for (int j = i + 1; j < forms.size(); j++) {
                String otherEmail = forms.get(j).get(0);
                String otherNickname = forms.get(j).get(1);

                if (isSimilarNickname(myNickname, otherNickname)) {
                    result.add(myEmail);
                    result.add(otherEmail);
                }
            }
        }

        return result;
    }

    private static boolean isSimilarNickname(String myNickname, String otherNickname) {
        int length = Math.min(myNickname.length(), otherNickname.length());

        for (int i = 0; i < length; i++) {
            for (int j = i + 2; j <= length; j++) {
                String subNickname = myNickname.substring(i, j);
                if (otherNickname.contains(subNickname)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void validate(List<List<String>> forms) {
        validateCrewNumbers(forms);
        for (List<String> form : forms) {
            validateFormSize(form);
            validateEmail(form.get(0));
            validateNickname(form.get(1));
        }
    }

    private static void validateCrewNumbers(List<List<String>> forms) {
        if (forms.size() < MIN_FORMS || forms.size() > MAX_FORMS) {
            throw new IllegalArgumentException("크루원은 최소 " + MIN_FORMS + "명 이상 " + MAX_FORMS + "명 이하여야 합니다.");
        }
    }

    private static void validateFormSize(List<String> form) {
        if (form.size() != FORM_SIZE) {
            throw new IllegalArgumentException("크루원 정보는 이메일과 닉네임으로 구성되어야 합니다.");
        }
    }

    private static void validateEmail(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }

        if (email.length() < MIN_EMAIL_LENGTH || email.length() > MAX_EMAIL_LENGTH) {
            throw new IllegalArgumentException("이메일은 " + MIN_EMAIL_LENGTH + "자 이상 " + MAX_EMAIL_LENGTH + "자 이하여야 합니다.");
        }

        if (!email.endsWith(EMAIL_DOMAIN)) {
            throw new IllegalArgumentException("이메일 도메인은 " + EMAIL_DOMAIN + "으로 끝나야 합니다.");
        }
    }

    private static void validateNickname(String nickname) {
        if (nickname.length() < MIN_NICKNAME_LENGTH || nickname.length() > MAX_NICKNAME_LENGTH) {
            throw new IllegalArgumentException("닉네임은 " + MIN_NICKNAME_LENGTH + "자 이상 " + MAX_NICKNAME_LENGTH + "자 이하여야 합니다.");
        }
        if (!nickname.matches(NICKNAME_REGEX)) {
            throw new IllegalArgumentException("닉네임은 한글로만 구성되어야 합니다.");
        }
    }
}
