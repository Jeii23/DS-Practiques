package baseNoStates;

public class visitorArea implements Visitor{
  private String id;
  private Area foundArea;



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
    } else {
      for (Area area : partition.getAreas()) {
        area.acceptVisitor(this);
      }
    }
  }

  @Override
  public Area findAreaById(String id) {
    this.id = id;
    this.foundArea = null; // resetea foundArea antes de buscar

    return foundArea;
  }
}
