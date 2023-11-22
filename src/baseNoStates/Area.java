package baseNoStates;

import java.util.ArrayList;
import java.util.List;

public abstract class Area {
  protected String id;

  /**
   * Constructor where the area is initialized with a unique identifier.
   *
   * @param id The unique identifier of the area.
   */
  public Area(String id) {
    this.id = id;
  }

  /**
   * Gets the unique identifier of the area.
   *
   * @return The unique identifier of the area.
   */
  public String getId() {
    return id;
  }

  /**
   * Accepts a visitor for the area.
   *
   * @param v The visitor to be accepted.
   */
  public abstract void acceptVisitor(Visitor v);

  /**
   * Gets a list of areas. This method is implemented in this base class
   * to provide an empty list. Subclasses may override it if needed.
   *
   * @return An empty list of areas.
   */
  public List<Area> getAreas() {
    return new ArrayList<>();
  }
}
