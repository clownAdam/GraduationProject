package cn.clown.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * mysql数据库连接工具类
 *
 * @author clown
 */
public final class JdbcUtil {
    /**
     * 单例模式--私有化构造器
     */
    private static JdbcUtil jdbcUtil;
    /**
     * JdbcUtil的内部类Builder
     */
    private static Builder builder;
    /**
     * 连接mysql使用的properties对象
     */
    private static Properties properties;
    /**
     * 连接mysql的driver类
     */
    private static String driverClass;
    /**
     * 连接mysql的url
     */
    private static String url;
    /**
     * 连接mysql的用户名
     */
    private static String username;
    /**
     * 连接mysql的密码
     */
    private static String password;

    /**
     * 数据库连接对象
     */
    private static Connection connection = null;

    /**
     * 启动时加载代码块初始化加载jdbc.properties
     */
    static {
        properties = new Properties();
        //加载jdbc配置问价
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        initParam();
    }

    /**
     * replace by <code>JdbcUtil.Builder.builder()</code>
     */
    @Deprecated
    private JdbcUtil() {
    }

    /**
     * builder 创建实例
     */
    public static class Builder {
        private Builder() {
        }

        public static synchronized JdbcUtil builder() {
            if (jdbcUtil != null) {
                return jdbcUtil;
            }
            return new JdbcUtil();
        }
    }

    /**
     * 获取实例对象
     *
     * @return 返回JdbcUtil的一个实例对象
     */
    public static JdbcUtil getInstance() {
        if (jdbcUtil != null) {
            return jdbcUtil;
        }
        return new JdbcUtil();
    }

    /**
     * 获取数据库连接
     *
     * @return 返回数据库连接对象
     */
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        try {
            //加载驱动类
            Class.forName(driverClass);
            //获取connection对象
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("class.forname()中driverClass not found");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DriverManager.getConnection 获取连接异常");
        }
        return connection;
    }

    /**
     * 初始化msyql连接参数
     */
    private static void initParam() {
        initParam(null);
        /*driverClass = properties.getProperty("mysql.driver.class");
        url = properties.getProperty("mysql.url");
        username = properties.getProperty("mysql.username");
        password = properties.getProperty("mysql.password");*/
    }

    /**
     * 初始化msyql连接参数
     *
     * @param properties 配置文件
     */
    private static void initParam(Properties properties) {
        if (properties == null) {
            properties = JdbcUtil.properties;
        }
        driverClass = properties.getProperty("mysql.driver.class");
        url = properties.getProperty("mysql.url");
        username = properties.getProperty("mysql.username");
        password = properties.getProperty("mysql.password");
    }

    /**
     * 释放mysql connection连接资源
     */
    public static void free() {
        if (connection != null) {
            try {
                System.out.println("connection为:" + connection);
                connection.close();
                System.out.println("connection资源已关闭");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("connection.close() 关闭异常");
            }
        } else {
            System.out.println("connection is null");
        }
    }
}
