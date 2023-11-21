package baseNoStates;

import java.util.ArrayList;

public class FindAreaByIdVisitor implements Visitor {
  private String id;
  private Area foundArea;

  public FindAreaByIdVisitor(String idToFind) {
    this.id = idToFind;
  }

  @Override
  public void visitSpace(Space space) {
    if (space.getId().equals(id)) {
      foundArea = space;
    }
  }

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

  @Override
  public Area findAreaById(String id) {
    return foundArea;
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return null;
  }
}
