import java.util.ArrayList;
import java.util.List;

public class FibonachiCreator  implements SequenceCreator {

    public int add2Sequence(List<Integer> list, final int n) {
        System.out.println("FIB CREATOR");
        if (list.size() < 2) {
              list.clear();
              for(int i = 0; i < Math.min(2, n); i++) {
                  list.add(1);
              };
        }
        int start = list.size();
        for(int i =  start; i < n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list.size() - start;
    }
}
