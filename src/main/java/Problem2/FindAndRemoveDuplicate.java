package Problem2;
import java.util.ArrayList;
import java.util.Arrays;
public class FindAndRemoveDuplicate {
    public String FindAndRemve (String cryptogram)
    {
        String[] cryptogramArray = cryptogram.split("");
        ArrayList<String> cryptogramList = new ArrayList<>(Arrays.asList(cryptogramArray));
        for (int i = 0; i <cryptogramList.size() - 1; i++) {
            if (cryptogramList.get(i).equals(cryptogramList.get(i + 1))) {
                cryptogramList.remove(i);
                cryptogramList.remove(i);
                i -= 2;
            }
        }
        String str = String.join("",cryptogramList);
     return str;
    }
}
