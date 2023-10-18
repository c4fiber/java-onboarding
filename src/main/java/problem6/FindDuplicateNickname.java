package problem6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateNickname {
    Set<String> nickNameSet = new HashSet<String>();
    ValidationCheck validationCheck = new ValidationCheck();
    String substringNickName = "";

    public List<String> FindDuplicateNickname (List<List<String>> forms) {
        for (int i = 0; i < forms.size(); ++i) {
            String nickName = forms.get(i).get(1); // 닉네임
            for (int j = 0; j < nickName.length() - 1; ++j) { // 닉네임 2글자 구하는 함수
                if (validationCheck.NicknameValidate(forms.get(j).get(1))) {
                    substringNickName = nickName.substring(j, j + 2); // 2글자 추출
                    IsContainNickName(i, forms);
                }
            }
        }

        SortEmail sortEmail = new SortEmail();
        return sortEmail.SortEmail(nickNameSet);
    }
    public String IsContainNickName(int i, List<List<String>> forms) {
        for (int z = i + 1; z < forms.size(); ++z) { // 이름이 다음 이름에 있는지 추출
            String email = forms.get(z).get(0);
            String compareNickName = forms.get(z).get(1);
            if ( validationCheck.EmailValidate(email) && compareNickName.contains(substringNickName)) {
                if (i == 0){
                    nickNameSet.add(forms.get(0).get(0)); // 이메일 추가
                }
                nickNameSet.add(email); // 이메일 추가
            }
        }
        return "";
    }
}
