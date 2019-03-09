package com.hhit.dao;

import java.sql.*;

/**
 * 数据访问层超类:
 *	该类的主要作用：
 *	1.连接数据库
 *  2.执行数据库的相关操作：增，删，改，查
 * @author dongruan-001
 *
 */
public class BaseDao {
	//四个常亮的定义：驱动，连接地址，数据库登录名，数据库登录密码
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	//private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	//private static final String URL="jdbc:mysql://localhost:3306/product";
	private static final String UNAME="system";
	private static final String UPWD="123456";
	
	//使用静态块加载驱动
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//声明三个核心对象(Connection,ResultSet,ParperedStatment)
	private Connection conn = null;//数据库连接对象
	protected ResultSet res = null;//结果集对象
	//预处理对象(对SQL语句中的参数进行预处理，以及可以防止SQL注入攻击)
	private PreparedStatement pstmt = null;
	/**
	 * 创建数据库连接对象
	 */
	public void getConn(){
		try {
			conn = DriverManager.getConnection(URL, UNAME, UPWD);
			System.out.println("连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 关闭数据库连接以及释放资源
	 */
	protected void closeAll(){
		if(null!=res){
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null!=pstmt){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 查询功能的封装：支持所有的查询形式
	 * @param sql
	 * @param params
	 * @return
	 */
	protected ResultSet executeSelect(String sql,Object[] params){
		//调用连接数据库的方法
		this.getConn();
		//创建SQL命令执行预处理对象
		try {
			pstmt = conn.prepareStatement(sql);
			//通过循环进行参数的预处理
			if(null!=params){
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			//执行查询并接收返回的结果集
			res = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 执行数据库操作的增，删，改
	 * @param sql
	 * @param params
	 * @return：返回操作后受影响的数据行数count
	 */
	protected int executeEit(String sql,Object[] params){
		int count = 0;
		//调用数据库连接的方法
		this.getConn();
		try {
			//创建预处理对象
			pstmt = conn.prepareStatement(sql);
			//通过循环进行参数预处理
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
			//执行数据库操作并返回结果
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return count;
	}
}
