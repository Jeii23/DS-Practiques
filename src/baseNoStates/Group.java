package baseNoStates;

import java.time.LocalDateTime;
import java.util.ArrayList;
import baseNoStates.States;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
public class Group {
  private ArrayList<Area> areasAccess;
  private String name;
  private ArrayList<String> actions;
  private Schedule schedule;
  public Group( ArrayList<Area> areasAccess, String name, ArrayList<String> actions, Schedule schedule) {
    this.areasAccess = areasAccess;
    this.name = name;
    this.actions = actions;
    this.schedule = schedule;
  }


  public boolean canAccess(Area space) {
    for (Area access: areasAccess){
      if(access.equals(space)) {
        return true;
      }
      if(access instanceof Partition) {
        Partition partition = (Partition) access;
        if(partition.findAreaById(space.getId()) != null) {
          return true;
        }
      }
    }
    return false;
  }
  public boolean canDoAction(String action)
  {
    for (String actions: actions) {
      if(actions.equals(action))
        return true;
    }
    return false;
  }

  public boolean isInSchedule(LocalDateTime now) {
    LocalDate currentDate = now.toLocalDate();
    LocalTime currentTime = now.toLocalTime();
    DayOfWeek currentDayOfWeek = now.getDayOfWeek();

    if ((currentDate.isEqual(schedule.getStartDate()) || currentDate.isAfter(schedule.getStartDate())) &&
        (currentDate.isEqual(schedule.getEndDate()) || currentDate.isBefore(schedule.getEndDate())) &&
        schedule.getDaysOfWeek().contains(currentDayOfWeek) &&
        (currentTime.equals(schedule.getStartTime()) || currentTime.isAfter(schedule.getStartTime())) &&
        (currentTime.equals(schedule.getEndTime()) || currentTime.isBefore(schedule.getEndTime()))) {
      return true;
    } else {
      return false;
    }
  }

}
