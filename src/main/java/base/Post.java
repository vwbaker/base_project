package base;

import java.io.Serializable;

public class Post implements Serializable {
  
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
