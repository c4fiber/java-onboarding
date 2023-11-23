package hi;

import java.util.List;
import hi.Score;

public class Page {
    private static final int MIN = 3;
    private static final int MAX =398;

    public int PageValidation (List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobiRight - pobiLeft != 1 || crongRight - crongLeft != 1) {
            return -1;
        }
        if (pobiLeft < MIN || pobiLeft > MAX || crongLeft < MIN || crongLeft > MAX
                || pobiRight < MIN || pobiRight > MAX || crongRight < MIN || crongRight > MAX) {
            return -1;
        }
        Score score = new Score();
        int win = score.LargeScore(pobiLeft, pobiRight, crongLeft, crongRight);

        return win;
    }
}