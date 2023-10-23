package mm;
import java.sql.*;

public class Conn1 {
	public Connection con;
	public Statement st;
	public ResultSet rs10,rs9;
	public double bills=0;
	public Conn1()
		{
		try{
		       Class.forName("com.mysql.jdbc.Driver");
	               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digipayroll", "root", "root");
		       st=con.createStatement();

			System.out.println("connected Conn ");
			}
		catch(Exception e){
			System.out.println("Sorry Error Conn"+e);
			}
		}

	public ResultSet executeQuery(String sql) throws SQLException
		{
		return st.executeQuery(sql);
		}
	public int executeUpdate(String sql) throws SQLException
		{
		return st.executeUpdate(sql);
		}
}
