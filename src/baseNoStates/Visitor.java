package baseNoStates;

public interface Visitor {
  void visitSpace(Space space);
  void visitPartition(Partition partition);
  Area findAreaById(String id);

}

