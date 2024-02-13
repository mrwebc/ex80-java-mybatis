package model;

import java.io.Serializable;

public class Employee implements Serializable{
  
  String firstName;
  int departmentId;
  String departmentName;
  
  @Override
  public String toString() {
    return "Employee [firstName=" + firstName + ", departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
  }
  
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public int getDepartmentId() {
    return departmentId;
  }
  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }
  public String getDepartmentName() {
    return departmentName;
  }
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }
}
