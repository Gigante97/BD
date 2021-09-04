import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    public static void connect(){
       try {
           Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection("jdbc:sqlite:main.db");
           stmt = connection.createStatement();
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }

    }
    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException{
        connect();
       /* try {ResultSet rs = stmt.executeQuery("select * from students");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +rs.getString("name")+ " " +rs.getString("score"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

/*        ResultSet rs = stmt.executeQuery("select * from students");

        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i=1; i<=rsmd.getColumnCount(); i++) {
            System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i));
        }*/
try {
    /*int res = stmt.executeUpdate("Insert Into students (name,score) values ('Bob',50)");
    System.out.println(res);*/
    /*long t = System.currentTimeMillis();
    connection.setAutoCommit(false);
    for (int i=0; i<1000;i++){
        stmt.executeUpdate("Insert Into students (name,score) values ('test_name',100)");
    }
    connection.setAutoCommit(true);
    System.out.println(System.currentTimeMillis()-t);*/
    /*long t = System.currentTimeMillis();
    connection.setAutoCommit(false);
    pstmt = connection.prepareStatement("Insert Into students (name,score) values (?,?);");
    for (int i=0; i<1000; i++) {
        pstmt.setString(1,"Bob" + i);
        pstmt.setInt(2,i);
        pstmt.addBatch();
    }
    pstmt.executeBatch();
    connection.setAutoCommit(true);
    System.out.println(System.currentTimeMillis()-t);*/


} catch (SQLException throwables) {
    throwables.printStackTrace();
} finally {
    disconnect();
}




    }
}
