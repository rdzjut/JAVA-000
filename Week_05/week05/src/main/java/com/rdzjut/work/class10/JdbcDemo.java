package com.rdzjut.work.class10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
    private static String sqlStatement;
    public static void main(String[] args) throws Exception {
        //通过工具类获取数据库连接对象
        Connection con = JdbcUtils.getConnection();
        //通过连接创建数据库执行对象
        Statement sta = con.createStatement();
        //为查询的结果集准备接收对象
        ResultSet rs = null;
        //查询
        sqlStatement = "select * from dept";
        query(sta,sqlStatement,rs);
        //增加
        sqlStatement = "insert into dept values(1,'1','TEST','CHINA')";
        System.out.println("插入执行结果:"+update(sta,sqlStatement));
        //更新
        sqlStatement = "UPDATE DEPT SET dept_loc='HangZhou' WHERE id = 1";
        System.out.println("更新执行结果:"+update(sta,sqlStatement));
        //删除
        sqlStatement = "DELETE FROM DEPT WHERE id = 1";
        System.out.println("删除执行结果:"+update(sta,sqlStatement));
        JdbcUtils.closeResource(con, sta, rs);
    }
    /**
     * 查询
     * @param sta
     * @param sql
     * @param rs
     * @throws SQLException
     */
    private static void query(Statement sta,String sql,ResultSet rs) throws SQLException {
        rs = sta.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getObject("dept_loc"));
        }
    }
    /**
     * 增删改
     * @param sta
     * @param sql
     * @return
     * @throws SQLException
     */
    private static int update(Statement sta,String sql) throws SQLException {
        return sta.executeUpdate(sql);
    }


}
