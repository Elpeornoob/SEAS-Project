package SantanderSAS.Model.Repository;

import java.io.Serializable;

import SantanderSAS.Model.Domain.Employee;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonInterface;
import bryan.io.array.Array;

public class EmployeeRepository implements Serializable{
    private FileJsonInterface<EmployeeEntity> fileJson;
    private String pathFile;
  
    public EmployeeRepository(String pathFile) {
      this.pathFile = pathFile;
      this.fileJson = FileJsonAdapter.getInstance();
    }
  
    public Employee getEmployee(String id) {
      EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
      for (EmployeeEntity employeeEntity : employeeEntities) {
        if (employeeEntity.id.equals(id)) {
          return new Employee(
              employeeEntity.names,
              employeeEntity.lastNames,
              new Array<>(employeeEntity.phoneNumbers.split(",")),
              employeeEntity.id);
        }
      }
      return Employee.getNullEmployee();
    }
}
