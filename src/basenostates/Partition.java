package basenostates;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a partition, a type of area in the system.
 * Extends the Area class.
 */
public class Partition extends Area {

  // List of areas contained within this partition.
  private ArrayList<Area> areas;

  /**
   * Initializes a partition with a unique identifier and a list of areas it contains.
   */
  public Partition(String id, ArrayList<Area> area) {
    super(id);
    this.areas = area;
  }

  /**
   * Retrieves all areas within this partition, including nested areas.
   * Overrides the getAreas method in the base class.
   */
  @Override
  public List<Area> getArray() {
    return areas;
  }

  /**
   * Accepts a visitor for this partition.
   * Overrides the acceptVisitor method in the base class.
   */
  @Override
  public void acceptVisitor(Visitor v) {
    v.visitPartition(this);
  }
}
