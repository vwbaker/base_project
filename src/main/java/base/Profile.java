package base;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  private String firstName;
  private String lastName;
  private String email;
  
  public Profile (){};
  
  public Profile(String name1, String name2, String e) {
    firstName = name1;
    lastName = name2;
    email = e;
  }
  
  public Long getId() {
    return id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public void setFirstName(String name) {
    firstName = name;
  }
  
  public void setLastName(String name) {
    lastName = name;
  }
  
  public void setEmail(String e) {
    email = e;
  }
}
