import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.jdbc.JDBCDataSource;


public class PersonRepository {

	private Connection conn;
	private Person personTemp;
	private Statement stmt;
	
	public PersonRepository(JDBCDataSource jdbcDataSource) throws SQLException{
		conn = jdbcDataSource.getConnection();
	}

	public Person findPersonByFirstName(String name) throws SQLException {
		stmt = null;
		stmt = conn.createStatement();
		String query = "SELECT * FROM PERSON WHERE NAME LIKE '" + name + "';";
		ResultSet set = stmt.executeQuery(query);
		  if(!set.next()){
			  personTemp = null;
			  
		  }
		  else{
			  personTemp = new Person();
			  personTemp.setNAME(set.getString(2));
			  personTemp.setLAST_NAME(set.getString(3));
		  }
		return personTemp;
	}
	
	public Boolean addPerson(String name, String lastname, int age) throws SQLException {
		stmt = null;
		stmt = conn.createStatement();
		String query = "INSERT INTO PERSON(NAME, LAST_NAME, AGE)" + "VALUES('" +name+ "', '"+lastname+"', '"+age+"');";
		int set = stmt.executeUpdate(query);
		  if(set == 0){
			  return false;
			  
		  }
		return true;
	}
	
	public Boolean updatePerson(String name, String name1) throws SQLException {
		stmt = null;
		stmt = conn.createStatement();
		String query = "UPDATE PERSON SET NAME='" +name+ "' WHERE NAME='" + name1 + "';";
		System.out.println(query);
		int set = stmt.executeUpdate(query);
		  if(set == 0){
			  return false;
			  
		  }
		return true;
	}
	
	public Boolean deletePerson(String name) throws SQLException {
		stmt = null;
		stmt = conn.createStatement();
		String query = "DELETE FROM PERSON WHERE NAME='" + name + "';";
		int set = stmt.executeUpdate(query);
		  if(set == 0){
			  return false;
			  
		  }
		return true;
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}

}
