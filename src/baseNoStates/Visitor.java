package baseNoStates;

import java.util.ArrayList;

public interface Visitor {
  void visitSpace(Space space);
  void visitPartition(Partition partition);
  Area findAreaById(String id);
  ArrayList<Door> getDoorsGivingAccess();

}

