package fr.greta.java.employee.domain;

import fr.greta.java.employee.persistance.EmployeeRepository;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;

public class EmployeeService {

    EmployeeWrapper wrapper = new EmployeeWrapper();
    EmployeeRepository repository = new EmployeeRepository();


    public EmployeeRole toRole(String role) throws ServiceException {
        switch(role){
            case "ADMIN":
                return EmployeeRole.ADMIN;
            case "COOKER":
                return EmployeeRole.COOKER;
            case "DELIVERY":
                return EmployeeRole.DELIVERY;
            default:
                throw new ServiceException("Role invalide");
        }
    }

    public String fromRole(EmployeeRole role) throws ServiceException {
        switch (role){
            case ADMIN:
                return "ADMIN";
            case DELIVERY:
                return  "DELIVERY";
            case COOKER:
                return "COOKER";
            default:
                throw new ServiceException("Erreur dans la conversion du rôle");
        }
    }

    public Employee create(Employee employee) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.create(wrapper.toEntity(employee)));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }


}
