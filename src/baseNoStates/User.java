package baseNoStates;

import java.util.ArrayList;

// 'User' class representing a user in the system.
public class User {

  // Private fields to store user information.
  private final String name;
  private final String credential;
  private Group group;

  /**
   * Constructor for initializing an instance of 'User'.
   * Takes the user's name, credentials, and initial group as parameters.
  */
  public User(String name, String credential, Group group) {
    this.name = name;
    this.credential = credential;
    this.group = group;

  }

  // Function that returns the group to which the user belongs.
  public Group getGroup() {
    return group;
  }

  // Function that returns the credentials of the user.
  public String getCredential() {
    return credential;
  }

  // Override method to provide a custom string representation of the user.
  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }


}
