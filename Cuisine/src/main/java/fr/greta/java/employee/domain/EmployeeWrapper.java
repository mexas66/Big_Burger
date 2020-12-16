package fr.greta.java.employee.domain;

import fr.greta.java.employee.persistance.EmployeeEntity;
import fr.greta.java.generic.exception.ConverterException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.generic.tools.RoleConverter;

public class EmployeeWrapper {
	
	RoleConverter roleConverter = new RoleConverter();

    public EmployeeEntity toEntity(Employee model) throws ServiceException, ConverterException {
        EmployeeEntity entity = new EmployeeEntity();

        entity.setId(model.getId());
        entity.setFirstname(model.getFirstname());
        entity.setLastname(model.getLastname());
        entity.setPhone(model.getPhone());
        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());

        entity.setRole(roleConverter.fromRole(model.getRole()));

        return entity;
    }

    public Employee fromEntity(EmployeeEntity entity) throws ServiceException, ConverterException {
        Employee model = new Employee();

        model.setFirstname(entity.getFirstname());
        model.setLastname(model.getLastname());
        model.setPhone(model.getPhone());
        model.setId(entity.getId());
        model.setRole(roleConverter.toRole(entity.getRole()));
        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());
        

        return model;
       
    }
}
