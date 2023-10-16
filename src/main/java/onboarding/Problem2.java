package onboarding;
import Problem2.StringValidation;
import Problem2.FindAndRemoveDuplicate;
import Problem2.eJun0SSockSSock;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 문자열 validation check return boolean
        StringValidation stringValidation = new StringValidation();
        if (!stringValidation.Validate(cryptogram)) {
            return "";
        }
        // validation check 값이 true면 중복 삭제
//        FindAndRemoveDuplicate FRD = new FindAndRemoveDuplicate();
//        String result = FRD.FindAndRemve(cryptogram);
        //2jun0's
        eJun0SSockSSock ejun0 = new eJun0SSockSSock();
        String result = ejun0.RemoveDuplicate(cryptogram);
        return result;
    }
}
