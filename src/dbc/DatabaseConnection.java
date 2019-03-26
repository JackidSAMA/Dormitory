package dbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DatabaseConnection {
	private static DataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource("mysql");
	}
	public DatabaseConnection() {
		// TODO Auto-generated constructor stub
	}
	private Connection conn = null; // 声明数据库连接对象

	public Connection getConnection() { // 取得数据库连接
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.conn;
	}

	public void close() throws Exception { // 关闭数据库操作
		try {
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace(); // 抛出异常
		}
	}

}