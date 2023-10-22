package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;
import baseNoStates.DirectoryDoors;

public final class DirectoryUsers {
  private static final ArrayList<User> users = new ArrayList<>();

  public static void makeUsers() {
    //TODO: make user groups according to the specifications in the comments, because
    // now all are the same
 // DirectoryDoors.findAreaById()
    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later

    ArrayList<Area> areaAccessnone = new ArrayList<Area>();
    users.add(new User("Bernat", "12345",areaAccessnone));
    users.add(new User("Blai", "77532",areaAccessnone));

    // employees :
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    ArrayList<Area> areaAccessMedium = new ArrayList<Area>();

    areaAccessMedium.add(DirectoryDoors.findAreaById("ground_floor"));
    areaAccessMedium.add(DirectoryDoors.findAreaById("floor1"));
    areaAccessMedium.add(DirectoryDoors.findAreaById("exterior"));
    areaAccessMedium.add(DirectoryDoors.findAreaById("stairs"));

    users.add(new User("Ernest", "74984",areaAccessMedium));
    users.add(new User("Eulalia", "43295",areaAccessMedium));

    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    ArrayList<Area> areaAccessTotal = new ArrayList<Area>();
    areaAccessTotal.add(DirectoryDoors.findAreaById("building"));
    users.add(new User("Manel", "95783",areaAccessTotal));
    users.add(new User("Marta", "05827",areaAccessTotal));

    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    users.add(new User("Ana", "11343",areaAccessTotal));
  }

  public static User findUserByCredential(String credential) {
    for (User user : users) {
      if (user.getCredential().equals(credential)) {
        return user;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }

}
