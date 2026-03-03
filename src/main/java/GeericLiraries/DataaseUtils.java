package GeericLiraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataaseUtils {
	 // Step 1: Register driver
	Connection conn = null;
	ResultSet result = null;
	/**
	 * register the dataase	
	 * @throws SQLException
	 */
	public void connectTODB() throws SQLException
	{
	//register the dataase	
    Driver driver = new Driver();
    DriverManager.registerDriver(driver);

    /**
     * Create connection
     */
    // Step 2: Create connection
    // conn = DriverManager.getConnection(IPathCostats.dURL, IPathCostats.duserame, IPathCostats.dPassword);
	}
	
	/**
	 * Create statement, Execute query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
     public ResultSet executeQuery(String query) throws SQLException {
    	 
    // Step 3: Create statement
    Statement state = conn.createStatement();

    // Step 4: Write query
    

    // Step 5: Execute query
   result = state.executeQuery(query);
   return result;
     }
     
     /**
      * updateQuery
      * @param query
      * @return
      * @throws SQLException
      */
     public int updateQuery(String query) throws SQLException
     {
    	 Statement state = conn.createStatement();
    	 int res = state.executeUpdate(query);
    	 return res;
     }
   /**
    * disconnectDataase
    * @throws SQLException
    */
     public void disconnectD() throws SQLException
     {
    // Step 7: Close connection
    conn.close();
}
}




