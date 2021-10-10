import java.util.List;

public interface SequenceDao {
    List<Integer> readFromSource(int n);
    boolean writeToSource(int existedN, List<Integer> list);

}
