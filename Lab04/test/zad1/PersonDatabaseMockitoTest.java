package zad1;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import zad1.Person;
import zad1.PersonDatabaseService;
import zad1.PersonException;
import zad1.PersonMockServiceImpl;

import static org.mockito.Mockito.*;

public class PersonDatabaseMockitoTest {

	@Mock
	PersonDatabaseService service;
	private PersonMockServiceImpl serv;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		serv = new PersonMockServiceImpl();
		serv.setService(service);
	}
	
	@After
	public void tearDown(){
		service = null;
		serv = null;
	}
	
	@Test
	public void AddTest() throws SQLException, PersonException {
		Person person = new Person(1, "Jan", "Kowalski", 2000);
		when(service.AddPerson(person)).thenReturn(new Integer(1));
		boolean result = serv.AddPerson(person);
		assertTrue(result);
		verify(service).AddPerson(person);
	}
	
	@Test(expected = PersonException.class)
	public void AddExceptionTest() throws SQLException, PersonException {
		Person person = new Person();
		when(service.AddPerson(person)).thenThrow(new SQLException());
		boolean result = serv.AddPerson(person);
		assertFalse(result);
		verify(service).AddPerson(person);
	}
	
	@Test
	public void AddBadTest() throws SQLException, PersonException {
		Person person = new Person(1, "Jan", "Kowalski", 2000);
		when(service.AddPerson(person)).thenReturn(new Integer(0));
		boolean result = serv.AddPerson(person);
		assertFalse(result);
		verify(service).AddPerson(person);
	}
	
	@Test
	public void RemoveTest() throws SQLException, PersonException {
		int id = 1;
		when(service.Remove(id)).thenReturn(new Integer(1));
		boolean result = serv.Remove(id);
		assertTrue(result);
		verify(service).Remove(id);
	}
	
	@Test(expected = PersonException.class)
	public void RemoveExceptionTest() throws SQLException, PersonException {
		int id = 1;
		when(service.Remove(id)).thenThrow(new SQLException());
		boolean result = serv.Remove(id);
		assertFalse(result);
		verify(service).Remove(id);
	}
	
	@Test
	public void RemoveBadTest() throws SQLException, PersonException {
		int id = 1;
		when(service.Remove(id)).thenReturn(new Integer(0));
		boolean result = serv.Remove(id);
		assertFalse(result);
		verify(service).Remove(id);
	}
	
	@Test
	public void ReadTest() throws SQLException, PersonException {
		int id = 1;
		when(service.Read(id)).thenReturn(new Person(1, "Klaudia", "Pa³kowska", 5000));
		boolean result = serv.Read(id);
		assertTrue(result);
		verify(service).Read(id);
	}
	
	@Test(expected = PersonException.class)
	public void ReadExceptionTest() throws SQLException, PersonException {
		int id = 1;
		when(service.Read(id)).thenThrow(new SQLException());
		boolean result = serv.Read(id);
		assertFalse(result);
		verify(service).Read(id);
	}
	
	@Test
	public void ReadBadTest() throws SQLException, PersonException {
		int id = 1;
		when(service.Read(id)).thenReturn(null);
		boolean result = serv.Read(id);
		assertFalse(result);
		verify(service).Read(id);
	}
	
	@Test
	public void UpdateTest() throws SQLException, PersonException {
		int id = 1;
		when(service.Update(id)).thenReturn(new Integer(0));
		boolean result = serv.Update(id);
		assertFalse(result);
		verify(service).Update(id);
	}
	
	@Test(expected = PersonException.class)
	public void UpdateExceptionTest() throws SQLException, PersonException {
		int id = 1;
		when(service.Update(id)).thenThrow(new SQLException());
		boolean result = serv.Update(id);
		assertFalse(result);
		verify(service).Update(id);
	}
}
