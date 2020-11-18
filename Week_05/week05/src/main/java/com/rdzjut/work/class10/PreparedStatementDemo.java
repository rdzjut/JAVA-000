package com.rdzjut.work.class10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
    private static String sqlStatement;
    public static void main(String[] args) throws SQLException {
        //通过工具类获取数据库连接对象
        Connection con = JdbcUtils.getConnection();
        //通过连接创建数据库执行对象
        PreparedStatement ps = null;
        //为查询的结果集准备接收对象
        ResultSet rs = null;
        //查询
        sqlStatement = "SELECT * FROM DEPT WHERE id = ?";
        ps = con.prepareStatement(sqlStatement);
        ps.setObject(1, 2);
        query(ps,rs);
        //增加
        sqlStatement = "INSERT INTO DEPT VALUES(?,?,?,?)";
        ps = con.prepareStatement(sqlStatement);
        ps.setObject(1, "1");
        ps.setObject(2, "50");
        ps.setObject(3, "TEST");
        ps.setObject(4, "HangZhou");
        System.out.println("插入执行结果:"+update(ps,sqlStatement));
        //更新
        sqlStatement = "UPDATE DEPT SET dept_loc=? WHERE id = ?";
        ps = con.prepareStatement(sqlStatement);
        ps.setObject(1, "SHAOXING");
        ps.setObject(2, 1);
        System.out.println("更新执行结果:"+update(ps,sqlStatement));
        //删除
        sqlStatement = "DELETE FROM DEPT WHERE id = ?";
        ps = con.prepareStatement(sqlStatement);
        ps.setObject(1, 1);
        System.out.println("删除执行结果:"+update(ps,sqlStatement));
        JdbcUtils.closeResource(con, ps, rs);
    }
    /**
     * 查询
     * @param sta
     * @param rs
     * @throws SQLException
     */
    private static void query(PreparedStatement sta,ResultSet rs) throws SQLException {
        rs = sta.executeQuery();
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
    private static int update(PreparedStatement sta, String sql) throws SQLException {
        return sta.executeUpdate();
    }

}
