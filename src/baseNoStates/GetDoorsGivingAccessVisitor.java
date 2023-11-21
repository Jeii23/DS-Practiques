package baseNoStates;

import java.util.ArrayList;

public class GetDoorsGivingAccessVisitor implements Visitor {
  private ArrayList<Door> doorsGivingAccess = new ArrayList<>();

  @Override
  public void visitSpace(Space space) {
    doorsGivingAccess.addAll(space.getDoorsGivingAccess());
  }

  @Override
  public void visitPartition(Partition partition) {
    for (Area area : partition.getAreas()) {
      area.acceptVisitor(this);
    }
  }

  @Override
  public Area findAreaById(String id) {
    return null;
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }
}