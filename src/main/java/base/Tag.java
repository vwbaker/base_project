package base;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag implements Serializable {
  
  @Id
  private String name;
  ArrayList<Long> posts = new ArrayList<Long>();
  
  public Tag() { }
  public Tag(String name, Long postId) {
    this.name = name;
    posts.add(postId);
  }
  
  public void setName(String in) {
    name = in;
  }
  
  public String getName() {
    return name;
  }
  
  public void setPosts(ArrayList<Long> in) {
    posts = in;
  }
  
  public ArrayList<Long> getPosts() {
    return posts;
  }
  
  public void addPost(Long in) {
    posts.add(in);
  }
}
