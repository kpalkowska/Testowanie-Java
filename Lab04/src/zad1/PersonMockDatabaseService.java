package zad1;


public interface PersonMockDatabaseService {
	boolean AddPerson(Person person) throws PersonException;
	boolean Remove(int id) throws PersonException;
	boolean Read(int id) throws PersonException;
	boolean Update(int id) throws PersonException;
}

