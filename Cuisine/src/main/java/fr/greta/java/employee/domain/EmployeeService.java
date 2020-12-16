package fr.greta.java.employee.domain;

import fr.greta.java.employee.persistance.EmployeeRepository;
import fr.greta.java.generic.exception.ConverterException;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;

public class EmployeeService {

    EmployeeWrapper wrapper = new EmployeeWrapper();
    EmployeeRepository repository = new EmployeeRepository();

    public Employee create(Employee employee) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.create(wrapper.toEntity(employee)));
        } catch (RepositoryException | ConverterException e) {
            throw new ServiceException(e);
        }
    }

	public Employee findEmployee(String email, String password) throws ServiceException {
		try {
			return wrapper.fromEntity(repository.findEmployee(email, password));
		} catch (RepositoryException | ConverterException e) {
			throw new ServiceException(e);
		}
	}


}
