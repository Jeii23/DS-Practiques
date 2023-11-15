package baseNoStates;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class Area {
  protected String id;
  private static final Logger LOGGER = Logger.getLogger(Area.class.getName());

  // Constructor where we initialize our area.
  public Area(String id) {
    this.id = id;
    LOGGER.info("Area initialized with id: " + id);
  }

  // Function that returns the id of the area.
  public String getId() {
    LOGGER.info("Getting id of the area: " + id);
    return id;
  }

  public abstract ArrayList<Door> getDoorsGivingAccess();

  public abstract Area findAreaById(String id);

  public List<Area> getAreas() {
    LOGGER.info("Getting areas");
    return new ArrayList<>();
  }
}
