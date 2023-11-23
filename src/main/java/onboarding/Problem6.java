package onboarding;

import java.util.List;
import problem6.FindDuplicateNickname;
import problem6.ValidationCheck;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ValidationCheck validationCheck = new ValidationCheck();
        FindDuplicateNickname findDuplicateNickname = new FindDuplicateNickname();

        boolean validateMemberCount =  validationCheck.MemberCountValidate(forms);
        if (validateMemberCount) {
            List<String> reslut = findDuplicateNickname.FindDuplicateNickname(forms);
            return reslut;
        }
        List<String> answer = List.of("answer");
        return answer;
    }
}
