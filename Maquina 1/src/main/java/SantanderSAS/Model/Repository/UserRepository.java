package SantanderSAS.Model.Repository;

import java.io.Serializable;

import SantanderSAS.Model.Domain.Employee;
import SantanderSAS.Model.Domain.User;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonInterface;

public class UserRepository implements Serializable{

    private FileJsonInterface<UserEntity> fileJson;
    private String pathFile;

    public UserRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public User getUser(String username) {
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
        EmployeeRepository employeeRepository = new EmployeeRepository("../../database/employee.json");
        for (UserEntity userEntity : userEntities) {
          if (userEntity.username.equals(username)) {
            Employee employee = employeeRepository.getEmployee(userEntity.person);
            return new User(userEntity.username, userEntity.password, employee);
          }
        }
        return User.getNullUser();
      }
}
