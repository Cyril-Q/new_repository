package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author apple
 * @create 2021-04-17 上午11:42
 */
public class JDBCUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static{

        try {
            Properties properties = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
//        dataSource = DruidDataSourceFactory.createDataSource(properties);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null，说明获取连接失败,有值就是获取连接成功
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = conns.get();

        if (conn == null) {
            conn = dataSource.getConnection();
            conns.set(conn); //保存到ThreadLocal对象中，供后面的jdbc操作使用
            conn.setAutoCommit(false);//设置为手动管理事务
        }
        return conn;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则就会出错(因为Tomcat底层使用了线程池技术)
        conns.remove();

    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则就会出错(因为Tomcat底层使用了线程池技术)
        conns.remove();

    }


    //关闭连接，放回数据库连接池
//    public static void close(Connection conn) {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    //自己写的查询测试
//    @Test
//    public void test() throws Exception {
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//        Properties pros = new Properties();
//        pros.load(is);
//        String username = pros.getProperty("username");
//        String password = pros.getProperty("password");
//        String url = pros.getProperty("url");
//        String driverClass = pros.getProperty("driverClass");
//        Class.forName(driverClass);
//        Connection conn = DriverManager.getConnection(url, username, password);
//
//        String sql = "select id,username,email,`password` from t_user where id = ?";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setObject(1,1);
//        ResultSet rs = ps.executeQuery();
//        ResultSetMetaData rsmd = rs.getMetaData();
//        int columnCount = rsmd.getColumnCount();
//        if (rs.next()){
//            User user = new User();
//            for (int i = 0; i < columnCount; i++) {
//                String columnLabel = rsmd.getColumnLabel(i + 1);
//                Object columnValue = rs.getObject(i + 1);
//                Field field = User.class.getDeclaredField(columnLabel);
//                field.setAccessible(true);
//                field.set(user,columnValue);
//            }
//            System.out.println(user);
//        }
//        if (conn != null){
//            conn.close();
//        }
//        if (ps != null){
//            ps.close();
//        }
//        if (rs != null){
//            rs.close();
//        }
//    }
}
