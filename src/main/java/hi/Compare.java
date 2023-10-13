package hi;

public class Compare {
    public int CompareScore(Integer largePobiScore ,Integer largeCrongScore) {
        if (largePobiScore < largeCrongScore) {
            return 2;
        } else if (largePobiScore > largeCrongScore) {
            return 1;
        }
        return 0;
    }
}
