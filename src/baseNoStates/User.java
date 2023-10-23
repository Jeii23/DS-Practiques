package baseNoStates;
import java.util.ArrayList;

public class User {
  private final String name;
  private final String credential;
  private Group group;
  public User(String name, String credential, Group group) {
    this.name = name;
    this.credential = credential;
    this.group = group;

  }

  public Group getGroup(){return group;}
  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }




}
