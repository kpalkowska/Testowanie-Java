import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.junit.Test;

public class LibraryFunctionsTest extends DatabaseTestCase {

	private Connection jdbcConnection;
	private FlatXmlDataSet loadedDataSet;

    protected IDatabaseConnection getConnection() throws Exception {
		Class.forName("org.h2.Driver");
		jdbcConnection = DriverManager.getConnection("jdbc:h2:mem:test","sa","");
		SetupDatabase.Setup();
		DatabaseConnection result = new DatabaseConnection(jdbcConnection);
		result.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
		return result;
	}

	protected IDataSet getDataSet() throws Exception {
		loadedDataSet = new FlatXmlDataSetBuilder().build(new File("IDataSets/dbunitData.xml"));
     	return loadedDataSet;
	}
	
	@Test
	public void testHowManyBooks() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		int result = function.HowManyBooks();
		assertEquals(result,2);
	}
	
	@Test
	public void testAddBooksAndAuthors() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.AddNewAuthor("Klaudia", "Pa³kowska");
		boolean result2 = function.AddNewBook("Book", 2016);
		boolean result3 = function.AddNewBookHasAuthor(3, 3);
		assertTrue(result);
		assertTrue(result2);
		assertTrue(result3);
	}
	
	@Test
	public void testUpdateBook() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.UpdateBook("Pan Tadeusz", 2015);
		assertTrue(result);
	}
	
	@Test
	public void testUpdateAuthor() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.UpdateAuthor("Henryk", "Klaudia");
		assertTrue(result);
	}
	
	@Test
	public void testUpdateBooksHasAuthors() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.UpdateBookHasAuthor(1, 2);
		assertTrue(result);
	}
	
	@Test
	public void testDeleteBook() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		int sum = function.HowManyBooksHasAuthors();
		boolean result = function.deleteBook(1);
		assertTrue(result);
		assertEquals(sum-1, function.HowManyBooksHasAuthors());
	}
	
	@Test(expected = NullPointerException.class)
	public void testDeleteNotExistingBook() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		function.deleteBook(10);
	}
	
	@Test(expected = SQLNonTransientConnectionException.class)
	public void testNonConnecion() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		try {
			getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		function.HowManyBooksHasAuthors();
	}
	
}
