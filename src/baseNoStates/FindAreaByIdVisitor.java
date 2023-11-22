package baseNoStates;

import java.util.ArrayList;

/**
 * A visitor that finds an area by its unique identifier.
 */
public class FindAreaByIdVisitor implements Visitor {
  private String id;
  private Area foundArea;

  /**
   * Constructs a FindAreaByIdVisitor with the given identifier to find.
   */
  public FindAreaByIdVisitor(String idToFind) {
    this.id = idToFind;
  }


  /**
   * Visits a Space and checks if it has the specified identifier.
   * If found, sets the foundArea to the visited Space.
   */
  @Override
  public void visitSpace(Space space) {
    if (space.getId().equals(id)) {
      foundArea = space;
    }
  }

  /**
   * Visits a Partition, checks if it has the specified identifier.
   * If found, sets the foundArea to the visited Partition.
   * Otherwise, recursively visits the areas within the Partition.
   */
  @Override
  public void visitPartition(Partition partition) {
    if (partition.getId().equals(id)) {
      foundArea = partition;
      return;
    } else {
      for (Area area : partition.getAreas()) {
        area.acceptVisitor(this);

      }
    }
  }

  /**
   * Returns the found area by its identifier.
   */
  @Override
  public Area findAreaById(String id) {
    return foundArea;
  }

  /**
   * Returns null for this implementation since it's not used.
   */
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return null;
  }
}
