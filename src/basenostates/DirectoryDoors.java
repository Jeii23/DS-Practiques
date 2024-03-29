package basenostates;

import java.util.ArrayList;
import java.util.Arrays;
import org.slf4j.LoggerFactory;

/**
 * Represents a directory of doors in the system. Implements the Singleton pattern.
 */
public final class DirectoryDoors {
  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DirectoryDoors.class);

  private static ArrayList<Door> allDoors;
  private static DirectoryDoors uniqueInstance = null;
  private static Area building;

  /**
   * Gets the instance of DirectoryDoors (Singleton pattern).
   *
   * @return The instance of DirectoryDoors.
   */
  public static DirectoryDoors getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new DirectoryDoors();
    }
    return uniqueInstance;
  }


  /**
   * Creates doors and initializes the building structure.
   */
  public static void makeDoors() {
    getInstance();

    //Basement
    Space parking = new Space("parking");
    Partition basement = new Partition("basement", new ArrayList<>(Arrays.asList(parking)));

    //Ground Floor
    Space hall = new Space("hall");
    Space room1 = new Space("room1");
    Space room2 = new Space("room2");
    Partition groundFloor = new Partition("ground_floor",
        new ArrayList<>(Arrays.asList(hall, room1, room2)));

    //floor 1
    Space room3 = new Space("room3");
    Space corridor = new Space("corridor");
    Space it = new Space("IT");
    Partition floor1 = new Partition("floor1", new ArrayList<>(Arrays.asList(room3, corridor, it)));

    //Building
    Space stairs = new Space("stairs");
    Space exterior = new Space("exterior");
    building = new Partition("building",
        new ArrayList<>(Arrays.asList(stairs, exterior, floor1, groundFloor, basement)));
    // Basement
    Door d1 = new Door("D1", exterior, parking); // exterior, parking
    Door d2 = new Door("D2", stairs, parking); // stairs, parking

    // Ground floor
    Door d3 = new Door("D3", exterior, hall); // exterior, hall
    Door d4 = new Door("D4", stairs, hall); // stairs, hall
    Door d5 = new Door("D5", hall, room1); // hall, room1
    Door d6 = new Door("D6", hall, room2); // hall, room2

    // First floor
    Door d7 = new Door("D7", stairs, corridor); // stairs, corridor
    Door d8 = new Door("D8", corridor, room3); // corridor, room3
    Door d9 = new Door("D9", corridor, it); // corridor, IT

    allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
  }

  /**
   * Finds a door by its unique identifier.
   *
   * @param id The unique identifier of the door.
   * @return The door with the specified ID, or null if not found.
   */
  public static Door findDoorById(String id) {
    for (Door door : allDoors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    logger.error("door with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  /**
   * Finds an area by its unique identifier.
   *
   * @param id The unique identifier of the area.
   * @return The area with the specified ID, or null if not found.
   */
  public static Area findAreaById(String id) {
    if (id.equals("ROOT")) {
      // Special id that means that the wanted area is the root.
      // This is because the Flutter app client doesn't know the
      // id of the root, differently from the simulator
      return building;
    } else {
      Visitor visitor = new FindAreaByIdVisitor(id);
      building.acceptVisitor(visitor);
      return visitor.findAreaById(id);
    }
  }

  /**
   * Gets a list of all doors in the system.
   *
   * @return A list of all doors.
   */
  public static ArrayList<Door> getAllDoors() {
    logger.info(String.valueOf(allDoors));
    return allDoors;
  }

}
