package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

//singleton
public final class DirectoryDoors {
  private static ArrayList<Door> allDoors;
  private static DirectoryDoors uniqueInstance = null;
  private static final Logger LOGGER = Logger.getLogger(DirectoryDoors.class.getName());

  public static DirectoryDoors getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new DirectoryDoors();
      LOGGER.info("New instance of DirectoryDoors created");
    }
    return uniqueInstance;
  }

  private static Area building;

  public static void makeDoors() {
    getInstance();
    LOGGER.info("Creating spaces and adding them to their respective partitions");

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
    LOGGER.info("Created building with all partitions");

    // basement
    Door d1 = new Door("D1", exterior, parking); // exterior, parking
    Door d2 = new Door("D2", stairs, parking); // stairs, parking

    // ground floor
    Door d3 = new Door("D3", exterior, hall); // exterior, hall
    Door d4 = new Door("D4", stairs, hall); // stairs, hall
    Door d5 = new Door("D5", hall, room1); // hall, room1
    Door d6 = new Door("D6", hall, room2); // hall, room2

    // first floor
    Door d7 = new Door("D7", stairs, corridor); // stairs, corridor
    Door d8 = new Door("D8", corridor, room3); // corridor, room3
    Door d9 = new Door("D9", corridor, it); // corridor, IT

    allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
    LOGGER.info("Created all doors and added them to the list");
  }

  public static Door findDoorById(String id) {
    for (Door door : allDoors) {
      if (door.getId().equals(id)) {
        LOGGER.info("Found door with id: " + id);
        return door;
      }
    }
    LOGGER.warning("Door with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  // This function searches in our array building, which contains all areas,
  // the area that is passed by parameter and returns it.
  public static Area findAreaById(String id) {
    LOGGER.info("Finding area by id: " + id);
    return building.findAreaById(id);
  }

  // this is needed by RequestRefresh
  public static ArrayList<Door> getAllDoors() {
    LOGGER.info("Getting all doors: " + allDoors);
    return allDoors;
  }

}

