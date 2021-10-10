

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSourceHelper {
    public static Connection connection() throws SQLException {
        final Connection connection = DriverManager.getConnection("jdbc:h2:~/testFIB", "sa", "");
        connection.setAutoCommit(true);
        return connection;
    }

    public static void createDb() {
        String sql;

        try {

            System.out.println(DataSourceHelper.class.getResource("FibonachiDB.sql").getFile());

            sql = FileUtils.readFileToString(new File(
                            DataSourceHelper.class.getResource("FibonachiDB.sql").getFile()),
                    Charset.defaultCharset() );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (PreparedStatement statement = DataSourceHelper.connection()
                .prepareStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
