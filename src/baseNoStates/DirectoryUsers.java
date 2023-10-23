package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.*;
import baseNoStates.DirectoryDoors;
import baseNoStates.Area;

public final class DirectoryUsers {
  private static final ArrayList<User> users = new ArrayList<>();

  public static void makeUsers() {
    //Creating Monday to Friday and monday to saturday array
    ArrayList<DayOfWeek> monToFri = new
        ArrayList<>(Arrays.asList(DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,DayOfWeek.WEDNESDAY,DayOfWeek.THURSDAY,DayOfWeek.FRIDAY));
    ArrayList<DayOfWeek> monToSat = (ArrayList<DayOfWeek>) monToFri.clone();
    monToSat.add(DayOfWeek.SATURDAY);
    ArrayList<DayOfWeek> everyday = (ArrayList<DayOfWeek>) monToSat.clone();
    everyday.add(DayOfWeek.SUNDAY);
    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    LocalDate pastDate = LocalDate.of(2000, 1, 1);
    ArrayList<DayOfWeek> noDays = new ArrayList<>();
    LocalTime midnight = LocalTime.MIDNIGHT;
    Schedule scheduleNoPriv = new Schedule(pastDate, pastDate, noDays, midnight, midnight);
    ArrayList<Area> areaAccessnone = new ArrayList<Area>();
    ArrayList<String> actionsNoPriv = new ArrayList<String>();
    Group noPrivilege = new Group(areaAccessnone, "no Privilege", actionsNoPriv,scheduleNoPriv);
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
    ArrayList<String> employeeActions = new ArrayList<String>();
    employeeActions.add(Actions.OPEN);
    employeeActions.add(Actions.CLOSE);
    employeeActions.add(Actions.UNLOCK_SHORTLY);
    //Setting employees schedule
    LocalDate firstDayEmployees = LocalDate.of(2023,9,1);
    LocalDate lastDayEmployees = LocalDate.of(2024,3,1);

    Schedule scheduleEmployees = new Schedule(firstDayEmployees,lastDayEmployees,monToFri,
        LocalTime.of(9,0),LocalTime.of(17,0));

    Group employees = new Group(areaAccessMedium, "employee", employeeActions,scheduleEmployees);

    users.add(new User("Ernest", "74984",employees));
    users.add(new User("Eulalia", "43295",employees));

    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    ArrayList<Area> areaAccessTotal = new ArrayList<Area>();
    ArrayList<String> managerAction = new ArrayList<String>();
    managerAction.add(Actions.OPEN);
    managerAction.add(Actions.CLOSE);
    managerAction.add(Actions.UNLOCK_SHORTLY);
    managerAction.add(Actions.UNLOCK);
    managerAction.add(Actions.LOCK);
    //Schedule Setting
    LocalDate firstDayManagers = LocalDate.of(2023,9,1);
    LocalDate lastDayManagers = LocalDate.of(2024,3,1);

    Schedule scheduleManagers = new Schedule(firstDayManagers,lastDayManagers,monToSat,
        LocalTime.of(8,0),LocalTime.of(20,0));

    Group managers = new Group(areaAccessTotal, "manager", managerAction,scheduleManagers);
    areaAccessTotal.add(DirectoryDoors.findAreaById("building"));
    users.add(new User("Manel", "95783",managers));
    users.add(new User("Marta", "05827",managers));

    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    //Setting schedule for admin
    LocalDate firstDayAdmin = LocalDate.of(2023,1,1);
    LocalDate lastDayAdmin = LocalDate.of(2100,12,31);

    Schedule scheduleAdmin = new Schedule(firstDayManagers,lastDayManagers,everyday,
        LocalTime.of(0,0),LocalTime.of(23,59));
    Group admins = new Group(areaAccessTotal, "admin", managerAction,scheduleAdmin);
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
