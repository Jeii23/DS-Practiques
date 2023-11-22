package basenostates;

import java.util.ArrayList;

// Interface representing a visitor in the system.
public interface Visitor {

  // Method for visiting a 'Space'.
  void visitSpace(Space space);

  // Method for visiting a 'Partition'.
  void visitPartition(Partition partition);

  // Method to find an area by its ID.
  Area findAreaById(String id);

  // Method to get a list of doors giving access.
  ArrayList<Door> getDoorsGivingAccess();
}

