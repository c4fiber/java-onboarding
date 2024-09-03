package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
	private static final int FRIEND_SCORE = 10;
	private static final int VISITOR_SCORE = 1;
	private static final int TOP_N = 5;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		return solve(user, friends, visitors);
	}

	private static List<String> solve(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Integer> scores = getScores(user, friends, visitors);

		return resolveRecommendFriends(scores);
	}

	private static Map<String, Integer> getScores(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Integer> scores = getAllOthers(user, friends, visitors).stream()
			.collect(Collectors.toMap(v -> v, v -> 0));    // user와 친구가 아닌 사람들의 목록

		updateFriendsScore(scores, user, friends);
		updateVisitorsScore(scores, visitors);

		return scores;
	}

	private static List<String> resolveRecommendFriends(Map<String, Integer> scores) {
		return scores.entrySet().stream()
			.sorted((o1, o2) -> {
				if (o1.getValue().equals(o2.getValue())) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return o2.getValue().compareTo(o1.getValue());
			})
			.filter(e -> e.getValue() > 0)
			.map(Map.Entry::getKey)
			.limit(TOP_N)
			.collect(Collectors.toUnmodifiableList());
	}

	// 이미 친구를 제외한 다른 사람들
	private static Set<String> getAllOthers(String user, List<List<String>> friends, List<String> visitors) {
		Set<String> allOthers = new HashSet<>();
		Set<String> friendsOfUser = findFriendsOfUser(user, friends);

		allOthers.addAll(findOthersInFriends(user, friends, friendsOfUser));
		allOthers.addAll(findOthersInVisitors(user, visitors, friendsOfUser));

		return allOthers;
	}

	// 친구 목록 중에서 이미 친구인 사람들을 제외한 다른 사람들
	private static Set<String> findOthersInFriends(String user, List<List<String>> friends, Set<String> friendsOfUser) {
		return friends.stream()
			.flatMap(List::stream)
			.filter(person -> !person.equals(user))                // user는 제외
			.filter(person -> !friendsOfUser.contains(person))    // user와 이미 친구 관계인 사람은 제외
			.collect(Collectors.toUnmodifiableSet());
	}

	private static Set<String> findOthersInVisitors(String user, List<String> visitors, Set<String> friendsOfUser) {
		return visitors.stream()
			.filter(visitor -> !visitor.equals(user))
			.filter(visitor -> !friendsOfUser.contains(visitor))
			.collect(Collectors.toUnmodifiableSet());
	}

	private static void updateVisitorsScore(Map<String, Integer> scores, List<String> visitors) {
		for (String visitor : visitors) {
			if (scores.containsKey(visitor)) {
				scores.put(visitor, scores.get(visitor) + VISITOR_SCORE);
			}
		}
	}

	private static void updateFriendsScore(Map<String, Integer> scores, String user, List<List<String>> friends) {
		Set<String> friendsOfUser = findFriendsOfUser(user, friends);

		// ohter이 user의 친구의 친구인 경우
		for (String other : scores.keySet()) {
			for (List<String> friend : friends) {
				String friend1 = friend.get(0);
				String friend2 = friend.get(1);

				if (friend.contains(user)) {
					continue;
				}

				if (friend1.equals(other) && friendsOfUser.contains(friend2)) {
					scores.put(other, scores.get(other) + FRIEND_SCORE);
				} else if (friend2.equals(other) && friendsOfUser.contains(friend1)) {
					scores.put(other, scores.get(other) + FRIEND_SCORE);
				}
			}
		}
	}

	private static Set<String> findFriendsOfUser(String user, List<List<String>> friends) {
		Set<String> friendsOfUser = new HashSet<>();

		for (List<String> friend : friends) {
			String friend1 = friend.get(0);
			String friend2 = friend.get(1);

			if (friend1.equals(user)) {
				friendsOfUser.add(friend2);
			} else if (friend2.equals(user)) {
				friendsOfUser.add(friend1);
			}
		}

		return friendsOfUser;
	}

}

