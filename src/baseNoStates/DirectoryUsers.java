package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;
import baseNoStates.DirectoryDoors;
import baseNoStates.Area;

public final class DirectoryUsers {
  private static final ArrayList<User> users = new ArrayList<>();

  public static void makeUsers() {
    //TODO: make user groups according to the specifications in the comments, because
    // now all are the same
    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    ArrayList<Area> areaAccessnone = new ArrayList<Area>();
    String noPriv = "no Privilege";
    ArrayList<String> actionsNoPriv = new ArrayList<String>();
    Group noPrivilege = new Group(areaAccessnone, noPriv, actionsNoPriv);
    users.add(new User("Bernat", "12345",noPrivilege));
    users.add(new User("Blai", "77532",noPrivilege));

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
    String employee = "employee";
    ArrayList<String> employeeActions = new ArrayList<String>();
    employeeActions.add(Actions.OPEN);
    employeeActions.add(Actions.CLOSE);
    employeeActions.add(Actions.UNLOCK_SHORTLY);

    Group employees = new Group(areaAccessMedium, employee, employeeActions);

    users.add(new User("Ernest", "74984",employees));
    users.add(new User("Eulalia", "43295",employees));

    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    ArrayList<Area> areaAccessTotal = new ArrayList<Area>();
    String manager = "manager";
    ArrayList<String> managerAction = new ArrayList<String>();
    managerAction.add(Actions.OPEN);
    managerAction.add(Actions.CLOSE);
    managerAction.add(Actions.UNLOCK_SHORTLY);
    managerAction.add(Actions.UNLOCK);
    managerAction.add(Actions.LOCK);

    Group managers = new Group(areaAccessTotal, manager, managerAction);
    areaAccessTotal.add(DirectoryDoors.findAreaById("building"));
    users.add(new User("Manel", "95783",managers));
    users.add(new User("Marta", "05827",managers));

    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    String admin = "admin";
    Group admins = new Group(areaAccessTotal, admin, managerAction);
    users.add(new User("Ana", "11343",admins));
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
