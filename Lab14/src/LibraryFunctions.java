import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LibraryFunctions {

  private Connection getConnection() throws SQLException {
	  return DriverManager.getConnection("jdbc:h2:mem:test","sa","");
  }
 
  public int HowManyBooks() throws SQLException {
	Statement stmt = getConnection().createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM Books;");
	int howBooks = 0;
	while(rs.next()){
		howBooks++;
	}
	getConnection().close();
	return howBooks;
  }
  
  public int HowManyBooksHasAuthors() throws SQLException {
	Statement stmt = getConnection().createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM Books_has_authors;");
	int howBHA = 0;
	while(rs.next()){
		howBHA++;
	}
	getConnection().close();
	return howBHA;
  }
  
  public boolean AddNewAuthor(String firstname, String lastname) throws SQLException {
	  Statement stmt = getConnection().createStatement();
	  String query = "INSERT INTO Authors(FirstName, LastName)" + "VALUES('" +firstname+ "', '"+lastname+"');";
	  if(firstname == null || lastname == null)
		  throw new NullPointerException();
	  int set = stmt.executeUpdate(query);
	  	if(set == 0){
	  		return false; 
		}
		getConnection().close();
		return true;
  }
  
  public boolean AddNewBook(String title, int year) throws SQLException {
	  Statement stmt = getConnection().createStatement();
	  String query = "INSERT INTO Books(Title, Year)"  + "VALUES('" +title+ "', '"+year+"');";
	  int set = stmt.executeUpdate(query);
	  	if(set == 0){
	  		return false;	  
		}
	  	getConnection().close();
		return true;
  }
  
  public boolean AddNewBookHasAuthor(int book_id, int author_id) throws SQLException {
	  Statement stmt = getConnection().createStatement();
	  String query = "INSERT INTO Books_has_authors(Books_id_book, Authors_id_author)"  + "VALUES('" +book_id+ "', '"+author_id+"');";
	  int set = stmt.executeUpdate(query);
		if(set == 0){
			return false;  
		}
		getConnection().close();
		return true;
  }
  
	public boolean UpdateAuthor(String name, String name1) throws SQLException {
		Statement stmt = getConnection().createStatement();
		String query = "UPDATE Authors SET FirstName='" +name1+ "' WHERE FirstName='" + name + "';";
		int set = stmt.executeUpdate(query);
		  if(set == 0){
			  return false;
			  
		  }
		return true;
	}
	
	public boolean UpdateBook(String title, int year) throws SQLException {
		Statement stmt = getConnection().createStatement();
		String query = "UPDATE Books SET Year='" +year+ "' WHERE Title='" + title + "';";
		int set = stmt.executeUpdate(query);
		  if(set == 0){
			  return false;
			  
		  }
		return true;
	}
	
	public boolean UpdateBookHasAuthor(int book_id, int author_id) throws SQLException {
		Statement stmt = getConnection().createStatement();
		String query = "UPDATE Books_has_authors SET Authors_id_author='" +author_id+ "' WHERE Books_id_book='" + book_id + "';";
		int set = stmt.executeUpdate(query);
		  if(set == 0){
			  return false;
			  
		  }
		return true;
	}
	
	public Boolean deleteBook(int book_id) throws SQLException {
		Statement stmt = getConnection().createStatement();
		String query = "DELETE FROM Books_has_authors WHERE Books_id_book ='" + book_id + "';";
		int set = stmt.executeUpdate(query);
		  if(set == 0){
			  return false;  
		  }
		  else{
				String query2 = "DELETE FROM Books WHERE id_book='" + book_id + "';";
				int set2 = stmt.executeUpdate(query2);
				if(set2 == 0)
					return true;
		  }
		return true;
	}
	
	public Boolean deleteBooksHasAuthors(int book_id) throws SQLException {
		Statement stmt = getConnection().createStatement();
		String query = "DELETE FROM Books_has_authors WHERE Books_id_book='" + book_id + "';";
		int set = stmt.executeUpdate(query);
		  if(set == 0){
			  return false;
			  
		  }
		return true;
	}
  
}
