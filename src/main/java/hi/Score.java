package hi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Score {
    public Integer LargeScore(Integer pobiLeft, Integer pobiRight, Integer crongLeft, Integer crongRight) {

        int largePobiScoreLeft = Calculate(pobiLeft);
        int largePobiScoreRight = Calculate(pobiRight);
        int largeCrongScoreLeft = Calculate(crongLeft);
        int largeCrongScoreRight = Calculate(crongRight);

        int largePobiScore = largePobiScoreLeft < largePobiScoreRight ? largePobiScoreRight : largePobiScoreLeft;
        int largeCrongScore = largeCrongScoreLeft < largeCrongScoreRight ? largeCrongScoreRight : largeCrongScoreLeft;

        Compare compare = new Compare();
        int win = compare.CompareScore(largePobiScore, largeCrongScore);

        return win;
    }
    public int Calculate (int score) {
        LinkedList<Integer> scoreLists = new LinkedList<>();
        while (score > 0) {
            scoreLists.push(score % 10);
            score /= 10;
        }
        int add = 0;
        int mul = 1;
        for (int i = 0; i < scoreLists.size(); i++) {
            add += scoreLists.get(i);
            mul *= scoreLists.get(i);
        }

        return add < mul ? mul : add;
    }
}


