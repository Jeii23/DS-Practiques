package basenostates;

import java.util.ArrayList;
import java.util.List;

/**
 * A visitor that collects doors giving access within areas it visits.
 */
public class GetDoorsGivingAccessVisitor implements Visitor {
  // List to store the doors giving access found during the visit.
  private ArrayList<Door> doorsGivingAccess = new ArrayList<>();

  /**
   * Visits a Space and adds its doors giving access to the list.
   */
  @Override
  public void visitSpace(Space space) {
    doorsGivingAccess.addAll(space.getDoorsGivingAccess());
  }

  /**
   * Visits a Partition and recursively visits the areas within it.
   */
  @Override
  public void visitPartition(Partition partition) {
    for (Area area : getArea(partition)) {
      area.acceptVisitor(this);
    }
  }

  /**
   * Returns null for this implementation since it's not used.
   */
  @Override
  public Area findAreaById(String id) {
    return null;
  }

  /**
   * Returns the collected list of doors giving access.
   */
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }


  @Override
  public List<Area> getArea(Area partition) {
    List<Area> allAreas = new ArrayList<>();
    for (Area area : partition.getArray()) {
      allAreas.add(area);
      allAreas.addAll(getArea(area));
    }
    return allAreas;
  }
}