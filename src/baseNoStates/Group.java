package baseNoStates;

import java.util.ArrayList;
import baseNoStates.States;

public class Group {
  private ArrayList<Area> areasAccess;
  private String name;
  private ArrayList<String> actions;

  public Group( ArrayList<Area> areasAccess, String name, ArrayList<String> actions) {
    this.areasAccess = areasAccess;
    this.name = name;
    this.actions = actions;

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
}
