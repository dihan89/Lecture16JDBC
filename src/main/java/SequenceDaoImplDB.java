import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequenceDaoImplDB implements SequenceDao{

    final String SQL_SELECT = "select * from SEQUENCE where (ind < ?)";
    final String SQL_INSERT = "insert  into SEQUENCE (ind, val) values (?, ?) ";

    @Override
    public List<Integer> readFromSource(int n) {
        List<Integer> list = new ArrayList<>();
        try {
            System.out.println(DataSourceHelper.connection().toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try (PreparedStatement statement = DataSourceHelper.connection().prepareStatement(SQL_SELECT)) {
            statement.setInt(1, n);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getInt("val"));
            }
            Collections.sort(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean writeToSource(int existedN, List<Integer> list) {
        try (PreparedStatement statement = DataSourceHelper.connection().prepareStatement(SQL_INSERT)) {
            for (int i = existedN; i < list.size(); ++i){
                statement.setInt(1, i);
                statement.setInt(2, list.get(i));
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException exc){
            System.out.println("SQL query is wrong!" + SQL_INSERT);
            return false;
        }
        return true;
    }
}
