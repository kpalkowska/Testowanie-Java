package zad1;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zad1.Person;
import zad1.PersonDatabaseService;
import zad1.PersonException;
import zad1.PersonMockServiceImpl;

public class PersonDatabaseTest {

	
	private PersonMockServiceImpl serv;
	private PersonDatabaseService mockService;
	
	@Before
	public void setUp() throws Exception {
		mockService = EasyMock.createMock(PersonDatabaseService.class);
		serv = new PersonMockServiceImpl();
		serv.setService(mockService);
	}

	@After
	public void tearDown() throws Exception {
		mockService = null;
		serv = null;
	}

	@Test
	public void test() throws SQLException, PersonException {
		Person person = new Person(1,"Jan","Kowalski",2000);
		EasyMock.expect(mockService.AddPerson(person)).andReturn(1);
		EasyMock.replay(mockService);
		boolean result = serv.AddPerson(person);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test(expected=PersonException.class)
	public void test2() throws SQLException, PersonException{
		Person person = new Person();
		EasyMock.expect(mockService.AddPerson(person)).andThrow(new SQLException());
		EasyMock.replay(mockService);
		boolean result = serv.AddPerson(person);
		assertTrue(result);
		EasyMock.verify(mockService);
	}

}
