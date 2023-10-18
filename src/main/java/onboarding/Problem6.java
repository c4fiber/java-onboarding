package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nicknameList = new ArrayList<>(extractNickname(forms));
        List<String> answer = findSimilarCrewEmail(forms, nicknameList);
        return answer;
    }

    // 크루 목록(이하 forms)에서 닉네임만 추출한 List를 return 하는 함수
    public static List<String> extractNickname(List<List<String>> forms) {
        List<String> nicknameForm = new ArrayList<>();
        for (List<String> form : forms)
            nicknameForm.add(form.get(1)); // [email address, nickname]
        return nicknameForm;
    }

    // 닉네임에서 생성 가능한 연속 문자를 list에 모두 모아 return 하는 함수
    public static List<String> extractAllStrCase(String nickname) {
        List<String> allStrCase = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) { // 닉네임이 1자일 경우 아무런 값도 들어가지 않음
            for (int j = i + 2; j <= nickname.length(); j++) { // 두 글자 이상의 문자를 추출해야 함. substring의 endIndex는 불포함되므로 startIndex + 2부터 시작
                String strCase = nickname.substring(i, j);
                allStrCase.add(strCase);
            }
        }
        return allStrCase;
    }

    // 크루의 닉네임 목록(List<String>)을 처음부터 끝까지 돌면서 contains 메서드를 통해 '같은 글자가 연속적으로 포함'되어 있는 크루를 list에 모아 return 하는 함수
    // 크루 한 명을 기준으로 유사한 닉네임을 가진 크루들을 찾아내는 함수
    public static List<String> findSimilarNicknameCrew(String crewNickname, List<String> nicknameList, List<String> allStrCaseList) {
        List<String> similarCrewNickname = new ArrayList<>();

        for (String strCase : allStrCaseList) {
            for (String nickname : nicknameList) {
                if (nickname.contains(strCase) && !nickname.equals(crewNickname)) {
                    similarCrewNickname.add(nickname);
                }
            }
        }

//        similarCrewNickname.remove(crewNickname); // '같은 글자가 연속적으로 포함'되어 있는 크루 리스트에 '자기 자신'은 제외함

        return similarCrewNickname;
    }


    // 크루의 닉네임 목록(List<String>)을 처음부터 끝까지 돌면서 닉네임에서 가능한 연속 문자가 들어있는 list를 추출하고(method)
    // 그 리스트를 통해 '같은 글자가 연속적으로 포함'되어 있는 크루의 닉네임이 들어있는 list를 추출해서(method)
    // 하나의 set에 모으고 (중복 값 방지를 위함), list로 변환한 뒤, 그 nickname에 해당하는 이메일을 list에 모아서 return
    public static List<String> findSimilarCrewEmail(List<List<String>> forms, List<String> nicknameList) {
        List<String> allStrCase = new ArrayList<>();
        List<String> similarCrewNickname = new ArrayList<>();
        List<String> similarCrewEmail = new ArrayList<>();

        for (String nickname : nicknameList) {
            allStrCase.clear();
            allStrCase.addAll(extractAllStrCase(nickname));
            similarCrewNickname.addAll(findSimilarNicknameCrew(nickname, nicknameList, allStrCase));
        }

        similarCrewNickname = similarCrewNickname.stream().distinct().collect(Collectors.toList()); // 중복 제거

        similarCrewEmail.addAll(extractCrewEmail(forms, similarCrewNickname));
        similarCrewEmail.sort(Comparator.naturalOrder()); // 오름차순 정렬. 내림차순은 reverseOrder()
        return similarCrewEmail;
    }

    public static List<String> extractCrewEmail(List<List<String>> forms, List<String> similarCrewNickname) {
        List<String> emailList = new ArrayList<>();

        for (String nickname : similarCrewNickname) {
            for (List<String> form : forms) {
                if (form.get(1).equals(nickname)) {
                    emailList.add(form.get(0));
                    break;
                }
            }
        }

        return emailList;
    }

}
