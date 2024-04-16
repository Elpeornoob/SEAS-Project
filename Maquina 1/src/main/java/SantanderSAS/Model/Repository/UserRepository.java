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
        EmployeeRepository employeeRepository = new EmployeeRepository("C:\\Users\\Giank\\Desktop\\SEAS-Project\\Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\user.json");
        for (UserEntity userEntity : userEntities) {
          if (userEntity.username.equals(username)) {
            Employee employee = employeeRepository.getEmployee(userEntity.person);
            return new User(userEntity.username, userEntity.password, employee);
          }
        }
        return User.getNullUser();
      }

        public void addUser(User user) {
            UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
            UserEntity[] newUserEntities = new UserEntity[userEntities.length + 1];
            for (int i = 0; i < userEntities.length; i++) {
            newUserEntities[i] = userEntities[i];
            }
            newUserEntities[newUserEntities.length - 1] = new UserEntity(user.getPerson().getID(), user.getUsername(), user.getPassword());
            fileJson.writeObjects(pathFile, newUserEntities);
        }

        public void removeUser(User user) {
            UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
            UserEntity[] newUserEntities = new UserEntity[userEntities.length - 1];
            int j = 0;
            for (int i = 0; i < userEntities.length; i++) {
            if (!userEntities[i].username.equals(user.getUsername())) {
                newUserEntities[j] = userEntities[i];
                j++;
            }
            }
            fileJson.writeObjects(pathFile, newUserEntities);
        }

        public void editUser(User user) {
            UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
            for (int i = 0; i < userEntities.length; i++) {
            if (userEntities[i].username.equals(user.getUsername())) {
                userEntities[i] = new UserEntity(user.getPerson().getID(), user.getUsername(), user.getPassword());
            }
            }
            fileJson.writeObjects(pathFile, userEntities);
        }

        public User[] getUsers() {
            UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
            User[] users = new User[userEntities.length];
            EmployeeRepository employeeRepository = new EmployeeRepository("C:\\Users\\Giank\\Desktop\\SEAS-Project\\Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\user.json");
            for (int i = 0; i < userEntities.length; i++) {
            Employee employee = employeeRepository.getEmployee(userEntities[i].person);
            users[i] = new User(userEntities[i].username, userEntities[i].password, employee);
            }
            return users;
        }

}
