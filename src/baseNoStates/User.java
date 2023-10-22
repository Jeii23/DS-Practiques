package baseNoStates;

import java.util.ArrayList;

public class User {
  private final String name;
  private final String credential;
  private ArrayList<Area> areasAccess;
  public User(String name, String credential, ArrayList<Area> areasAccess) {
    this.name = name;
    this.credential = credential;
    this.areasAccess = areasAccess;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }

  public boolean canAccess(Area space) {
    if (areasAccess.get(0) == space) {
      return true;
    }
    else {
      for (Area access: areasAccess){
        if(this.canAccess(access))
          return this.canAccess(access);
      }
    }
    return false;
  }
}
