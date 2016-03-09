package zad1;

import java.sql.SQLException;

public class PersonMockServiceImpl implements PersonMockDatabaseService {

	private PersonDatabaseService service; 
	
	
	@Override
	public boolean AddPerson(Person person) throws PersonException {
		try{
			int result = service.AddPerson(person);
			if(result == 0){
				return false;
			}
		}catch (SQLException e){
			throw new PersonException(e);
		}
		return true;
	}


	public PersonDatabaseService getService() {
		return service;
	}

	public void setService(PersonDatabaseService service) {
		this.service = service;
	}


	@Override
	public boolean Remove(int id) throws PersonException {
		try{
			int result = service.Remove(id);
			if(result == 0){
				return false;
			}
		}catch (SQLException e){
			throw new PersonException(e);
		}
		return true;
	}


	@Override
	public boolean Read(int id) throws PersonException {
		try{
			Person result = service.Read(id);
			if(result == null){
				return false;
			}
		}catch (SQLException e){
			throw new PersonException(e);
		}
		return true;
	}


	@Override
	public boolean Update(int id) throws PersonException {
		try{
			int result = service.Update(id);
			if(result == 0){
				return false;
			}
		}catch (SQLException e){
			throw new PersonException(e);
		}
		return true;
	}

}
