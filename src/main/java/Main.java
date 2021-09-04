import java.io.FileNotFoundException;
import java.sql.*;

public class Main  {
    static final int size =1000;
    static final int h = size/8;
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;
   // static GenerateArray generateArray =new GenerateArray();

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

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        connect();
        GenerateArray generateArray =new GenerateArray();
        multiThreads(generateArray.generateArrays());



       /* try {ResultSet rs = stmt.executeQuery("select * from students");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +rs.getString("name")+ " " +rs.getString("score"));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

       /*ResultSet rs = stmt.executeQuery("select * from students");
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i=1; i<=rsmd.getColumnCount(); i++) {
            System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i));
        }*/

   /* int res = stmt.executeUpdate("Insert Into students (name,score) values ('Bob',50)");
    System.out.println(res);
    long t = System.currentTimeMillis();
    connection.setAutoCommit(false);
    for (int i=0; i<1000;i++){
        stmt.executeUpdate("Insert Into students (name,score) values ('test_name',100)");
    }
    connection.setAutoCommit(true);
    System.out.println(System.currentTimeMillis()-t);*/
   /* try {
        long t = System.currentTimeMillis();
        connection.setAutoCommit(false);
        pstmt = connection.prepareStatement("Insert into students (name,score) values(?,?)");
        for (int i = 0; i < 1000; i++) {
            pstmt.setString(1, generateArray.getElementArray(i));
            pstmt.setInt(2, 2);
            pstmt.addBatch();
        }
        pstmt.executeBatch();
        connection.setAutoCommit(true);
        System.out.println(System.currentTimeMillis() - t);
    }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            disconnect();
        }*/




    }

    private synchronized static void multiThreads(String[] array) throws SQLException {
        int x =1;
        String[] firstArray=new String[h];
        String[] secondArray=new String[h];
        String[] threeArray=new String[h];
        String[] fourArray=new String[h];
        String[] fiveArray=new String[h];
        String[] sixArray=new String[h];
        String[] sevenArray=new String[h];
        String[] eightArray=new String[h];
        long startTime = System.currentTimeMillis();
        System.arraycopy(array, 0, firstArray, 0, h);
        System.arraycopy(array, h, secondArray, 0, h);
        System.arraycopy(array, (2*h), threeArray, 0, h);
        System.arraycopy(array, (3*h), fourArray, 0, h);
        System.arraycopy(array, (4*h), fiveArray, 0, h);
        System.arraycopy(array, (5*h), sixArray, 0, h);
        System.arraycopy(array, (6*h), sevenArray, 0, h);
        System.arraycopy(array, (7*h), eightArray, 0, h);
        connection.setAutoCommit(false);
        pstmt = connection.prepareStatement("Update  students set score=? where name=?;");
        Thread d = new Thread(()-> System.out.println(1));
        d.setDaemon(true);
        d.start();
        Thread doFirst = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (array){
                for (int i=0;i<firstArray.length;i++) {
                    try {
                        pstmt.setString(2, firstArray[i]);
                        pstmt.setInt(1, x);
                        pstmt.addBatch();
                        pstmt.executeBatch();
                        connection.setAutoCommit(true);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    }

                }}

        });

        Thread doSecond = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (array){
                for (int q=0;q<secondArray.length;q++) {
                    try {
                        pstmt.setString(2, secondArray[q]);
                        pstmt.setInt(1, x);
                        pstmt.addBatch();
                        pstmt.executeBatch();
                        connection.setAutoCommit(true);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

            }}

        });
        Thread doThree = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (array) {
                    for (int w = 0; w < threeArray.length; w++) {
                        try {
                            pstmt.setString(2, threeArray[w]);
                            pstmt.setInt(1, x);
                            pstmt.addBatch();
                            pstmt.executeBatch();
                            connection.setAutoCommit(true);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }
        });
        Thread doFour = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (array) {
                    for (int a = 0; a < fourArray.length; a++) {
                        try {
                            pstmt.setString(2, fourArray[a]);
                            pstmt.setInt(1, x);
                            pstmt.addBatch();
                            pstmt.executeBatch();
                            connection.setAutoCommit(true);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }

        });
        Thread doFive = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (array) {
                    for (int f = 0; f < fiveArray.length; f++) {
                        try {
                            pstmt.setString(2, fiveArray[f]);
                            pstmt.setInt(1, x);
                            pstmt.addBatch();
                            pstmt.executeBatch();
                            connection.setAutoCommit(true);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }

        });
        Thread doSix = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (array) {
                    for (int b = 0; b < sixArray.length; b++) {
                        try {
                            pstmt.setString(2, sixArray[b]);
                            pstmt.setInt(1, x);
                            pstmt.addBatch();
                            pstmt.executeBatch();
                            connection.setAutoCommit(true);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

        });
        Thread doSeven = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (array) {
                    for (int l = 0; l < sevenArray.length; l++) {
                        try {
                            pstmt.setString(2, sevenArray[l]);
                            pstmt.setInt(1, x);
                            pstmt.addBatch();
                            pstmt.executeBatch();
                            connection.setAutoCommit(true);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }

        });
        Thread doEight = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (array) {
                    for (int p = 0; (p < (eightArray).length); p++) {
                        try {
                            pstmt.setString(2, eightArray[p]);
                            pstmt.setInt(1, x);
                            pstmt.addBatch();
                            pstmt.executeBatch();
                            connection.setAutoCommit(true);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }

        });
        doFirst.start();
        doSecond.start();
        doThree.start();
        doFour.start();
        doFive.start();
        doSix.start();
        doSeven.start();
        doEight.start();

        try {
            doFirst.join();
            doSecond.join();
            doThree.join();
            doFour.join();
            doFive.join();
            doSix.join();
            doSeven.join();
            doEight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            disconnect();
            System.out.println("Godbye!");
        }


    }




    }
