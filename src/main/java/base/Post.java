package base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Post implements Serializable {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String messageBody;
  private String name;
  private String title;
  private String location;
  private ArrayList<String> tags = new ArrayList<String>();
  
  public Post (){};
  
  public Post(String messageBody, String name, String title, String location, ArrayList<String> tags) {
    this.messageBody = messageBody;
    this.name = name;
    this.title = title;
    this.location = location;
    this.tags = tags;
  }
  
  public Long getId() {
    return id;
  }
  
  public String getMessageBody() {
    return messageBody;
  }
  
  public String getName() {
    return name;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getLocation() {
    return location;
  }
  
  public ArrayList<String> getTags() {
    return tags;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public void setMessageBody(String m) {
    messageBody = m;
  }
  
  public void setName(String n) {
    name = n;
  }
  
  public void setTitle(String t) {
    title = t;
  }
  
  public void setLocation(String l) {
    location = l;
  }
  
  public void setTags(ArrayList<String> t) {
    tags = t;
  }
}
