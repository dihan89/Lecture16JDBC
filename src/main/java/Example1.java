import org.h2.tools.Server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import  javax.sql.*;

//public class Example1 {
//
//}
public class Example1 {
    // Блок объявления констант
    //public static final String DB_URL = "jdbc:h2:/D:/J/DB/stockExchange";
    //public static final String DB_Driver = "org.h2.Driver";

    public static void main(String[] args) throws SQLException {
        DataSourceHelper.createDb();
        Server serverTCP = Server.createTcpServer().start();
        System.out.println(serverTCP.getURL());
        SequenceCreator cacheFibCreator = new SequenceCreatorCache(new SequenceDaoImplDB(),
                new FibonachiCreator());
        List<Integer> list = new ArrayList<>();
        cacheFibCreator.add2Sequence(list, 4);
        list.forEach(System.out::println);
        cacheFibCreator.add2Sequence(list, 7);
        list.forEach(System.out::println);
        serverTCP.stop();
    }
}



//        try (PreparedStatement statement = DataSourceHelper.connection()
//                .prepareStatement("insert into person (name, age) values (?, ?)")) {
//            statement.setString(1, "Alexander");
//            statement.setInt(2, 20);
//            boolean b = statement.execute();
//            System.out.println(b);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (Statement statement = DataSourceHelper.connection().createStatement()
//        ) {
//            ResultSet rs = statement.executeQuery("SELECT * FROM PERSON");
//            if (rs.next()){
//                System.out.println(rs.getString("name")+
//                        " " +rs.getInt("age"));
//            } else
//                System.out.println("Table is empty");
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

