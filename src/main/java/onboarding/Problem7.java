package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private final static int MAXIMUM = 5; // 최대 5명 return

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> myFriendList = makeMyFriendList(user, friends);
        List<String> myFOAFList = makeMyFOAFList(user, friends, myFriendList);
        List<String> visitorList = makeVisitorListWithoutMyFriend(myFriendList, visitors);

        List<String> answer = makeRecFriendList(myFOAFList, visitorList);

        return answer;
    }

    public static List<String> makeRecFriendList(List<String> myFOAFList, List<String> visitorList) {
        Map<String, Integer> recFriendPoint = new HashMap<>();

        List<String> sortedRecFriendList = new ArrayList<>(MAXIMUM);

        List<String> recFriendList = new ArrayList<>(myFOAFList);
        recFriendList.addAll(visitorList); // 친구의 친구 리스트 + 방문자 리스트
        recFriendList = recFriendList.stream().distinct().collect(Collectors.toList()); // 중복 제거

        for (String recFriendName : recFriendList)
            recFriendPoint.put(recFriendName, scorePoints(recFriendName, myFOAFList, visitorList));

        List<String> keySet = new ArrayList<>(recFriendPoint.keySet());

        // compareTo() - 숫자 비교 시, a.compareTo(b)를 예를 들어, a가 b보다 클 시 1 return, 같을 시 0 return, a가 b보다 작을 시 -1 return
        keySet.sort((o1, o2) -> {
            if (recFriendPoint.get(o1).equals(recFriendPoint.get(o2))) // 추천 점수가 같으면
                return o1.compareTo(o2); // 이름순으로 정렬
            return recFriendPoint.get(o2).compareTo(recFriendPoint.get(o1));
        });

        for (int i = 0; i < MAXIMUM && i < keySet.size(); i++)
            sortedRecFriendList.add(keySet.get(i));
        
        return sortedRecFriendList;
    }

    public static int scorePoints(String recFriendName, List<String> myFOAFList, List<String> visitorList) {

        int point = 0;

        if (myFOAFList.contains(recFriendName))
            point += 10 * Collections.frequency(myFOAFList, recFriendName); // 사용자와 함께 아는 친구의 수 = 10점

        // Collections.frequency(Collections, value) 컬렉션에 value의 개수를 return하는 메서드
        if (visitorList.contains(recFriendName))
            point += Collections.frequency(visitorList, recFriendName); // 사용자의 타임 라인에 방문한 횟수 = 1점

        return point;
    }

    // 내 친구를 제외한 방문자 리스트 만들기
    public static List<String> makeVisitorListWithoutMyFriend(List<String> myFriendList, List<String> visitors) {

        List<String> visitorsList = new ArrayList<>(visitors);
        visitorsList.removeAll(myFriendList);
        return visitorsList;
    }

    // 사용자와 내 친구를 제외한 친구의 친구 리스트 만들기
    public static List<String> makeMyFOAFList(String user, List<List<String>> friends, List<String> myFriendList) {
        List<String> myFOAFList = new ArrayList<>();
        for (String friend : myFriendList)
            myFOAFList.addAll(makeMyFriendList(friend, friends)); // 내 친구가 / 자신의 친구 리스트를 만들어서 / 내 친구의 친구 리스트에 추가한다.

        Iterator it = myFOAFList.iterator();
        while(it.hasNext()) { // 사용자 제거
            String name = (String) it.next();
            if(name.equals(user))
                it.remove();
        }
        myFOAFList.removeAll(myFriendList); // 이미 내 친구인 사람도 제거

        return myFOAFList;
    }

    // 내 친구 리스트 만들기
    public static List<String> makeMyFriendList(String user, List<List<String>> friends) {
        List<String> myFriendList = new ArrayList<>();
        for (List<String> friend : friends) {
            if(friend.contains(user)) // 사용자와의 친구 관계
                myFriendList.add(getMyFriendName(user, friend));
        }
        return myFriendList;
    }

    public static String getMyFriendName(String user, List<String> friend) {
        for (String name : friend) {
            if (!name.equals(user)) // 유저가 아닌 친구
                return name;
        }
        // null 발생 시, friends 리스트 자체에 문제가 있음
        return null; // friends의 각 원소는 [아이디 A, 아이디 B] 순으로 들어있다. 유저가 아니면 친구의 아이디가 들어있어야 함.
    }
}
