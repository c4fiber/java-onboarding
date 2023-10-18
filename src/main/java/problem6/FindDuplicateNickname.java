package problem6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateNickname {
    public List<String> FindDuplicateNickname (List<List<String>> forms) {
        Set<String> nickNameSet = new HashSet<String>();
        ValidationCheck validationCheck = new ValidationCheck();

        for (int i = 0; i < forms.size(); ++i) {
            String nickName = forms.get(i).get(1); // 닉네임
            for (int j = 0; j < nickName.length() - 1; ++j) {
                if (validationCheck.NicknameValidate(forms.get(j).get(1))) {
                    String substringNickName = ""; //마지막 OutOfBoundsException 방지
                    if (j == nickName.length() - 1) {
                        substringNickName = nickName.substring(j);  //마지막 OutOfBoundsException 방지
                    } else {
                        substringNickName = nickName.substring(j, j + 2); // 2글자 추출
                    }
                    for (int z = i + 1; z < forms.size(); ++z) {
                        String email = forms.get(z).get(0);
                        if ( validationCheck.EmailValidate(email) && email.contains(substringNickName)) {
                            nickNameSet.add(email); // 이메일 추가
                        }
                    }
                }
            }
        }
        SortEmail sortEmail = new SortEmail();
        return sortEmail.SortEmail(nickNameSet);
    }
}
