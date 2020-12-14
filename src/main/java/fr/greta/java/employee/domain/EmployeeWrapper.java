package fr.greta.java.employee.domain;

import fr.greta.java.employee.persistance.EmployeeEntity;
import fr.greta.java.generic.exception.ServiceException;

public class EmployeeWrapper {

    EmployeeService service = new EmployeeService();

    public EmployeeEntity toEntity(Employee model) throws ServiceException {
        EmployeeEntity entity = new EmployeeEntity();

        entity.setId(model.getId());
        entity.setFirstname(model.getFirstname());
        entity.setLastname(model.getLastname());
        entity.setPhone(model.getPhone());

        entity.setRole(service.fromRole(model.getRole()));

        return entity;
    }

    public Employee fromEntity(EmployeeEntity entity) throws ServiceException {
        Employee model = new Employee();

        model.setFirstname(entity.getFirstname());
        model.setLastname(model.getLastname());
        model.setPhone(model.getPhone());
        model.setId(entity.getId());
        model.setRole(service.toRole(entity.getRole()));

        return model;
    }
}
