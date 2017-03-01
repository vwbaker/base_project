package base;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Post implements Serializable {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String messageBody;
  
  public Post (){};
  
  public Post(String m) {
    messageBody = m;
  }
  
  public Long getId() {
    return id;
  }
  
  public String getMessageBody() {
    return messageBody;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public void setMessageBody(String m) {
    messageBody = m;
  }
}
