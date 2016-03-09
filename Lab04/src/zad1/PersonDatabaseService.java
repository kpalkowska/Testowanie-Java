package zad1;

import java.sql.SQLException;

public interface PersonDatabaseService {
	int AddPerson(Person person) throws SQLException;
	int Remove(int id) throws SQLException;
	Person Read(int id) throws SQLException;
	int Update(int id) throws SQLException;
}
