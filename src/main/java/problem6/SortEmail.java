package problem6;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortEmail {
    public List<String> SortEmail(Set<String> emailSet) {
        List<String> sortedEmail = emailSet.stream().sorted().collect(Collectors.toList());
        return sortedEmail;
    }
}
