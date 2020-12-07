package cn.clown.common.util;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilTest {
    JdbcUtil builder;
    Connection connection;

    @Before
    public void before() {
        builder = JdbcUtil.Builder.builder();
        connection = builder.getConnection();
    }

    @Test
    public void getConnection() {
        if (connection != null) {
            System.out.println("mysql 连接成功,connection为:" + connection);
        }
    }

    @Test
    public void free() {
        JdbcUtil.free();
    }
}