package baseNoStates;

public class getDoorByIdVisitor implements Visitor{
  @Override
  public void visitSpace(Space space) {
    // aquí va la lógica de getDoorsGivingAccess para Space
  }

  @Override
  public void visitPartition(Partition partition) {
    // aquí va la lógica de getDoorsGivingAccess para Partition
  }
}
