package SantanderSAS.Model.Repository;

import java.io.Serializable;

public class EmployeeEntity implements Serializable{
    String id;
    String names;
    String lastNames;
    String phoneNumbers;
  
    public EmployeeEntity(String id, String names, String lastNames, String phoneNumbers) {
      this.id = id;
      this.names = names;
      this.lastNames = lastNames;
      this.phoneNumbers = phoneNumbers;
    }
    
}
