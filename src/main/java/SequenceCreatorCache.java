
import java.util.List;

public class SequenceCreatorCache implements SequenceCreator {
    private SequenceDao sequenceDao;
    private SequenceCreator sequenceCreator;
    SequenceCreatorCache(SequenceDao sequenceDao, SequenceCreator sequenceCreator){
        this.sequenceDao = sequenceDao;
        this.sequenceCreator = sequenceCreator;
    }
    @Override
    public int add2Sequence(List<Integer> list, int n) {
        list.clear();
        list.addAll(sequenceDao.readFromSource(n));
        System.out.println("List SIZE BEFORE:  "+list.size());
        if (list.size() >= n)
            return 0;
        int start = list.size();
        System.out.println("List START:  "+start);
        int nAdded = sequenceCreator.add2Sequence(list, n);
        System.out.println("List SIZE AFTER:  "+list.size());
        sequenceDao.writeToSource(start, list);
        return nAdded;
    }



}
