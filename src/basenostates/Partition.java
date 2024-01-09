package basenostates;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a partition, a type of area in the system.
 * Extends the Area class.
 */
public class Partition extends Area {

  // List of areas contained within this partition.
  private ArrayList<Area> areas;
  public JSONObject toJson(int depth) {
    // for depth=1 only the root and children,
    // for recusive = all levels use Integer.MAX_VALUE
    JSONObject json = new JSONObject();
    json.put("class", "partition");
    json.put("id", id);
    JSONArray jsonAreas = new JSONArray();
    if (depth > 0) {
      for (Area a : areas) {
        jsonAreas.put(a.toJson(depth - 1));
      }
      json.put("areas", jsonAreas);
    }
    return json;
  }
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
  public List<Area> getAreas() {
    List<Area> allAreas = new ArrayList<>();
    for (Area area : areas) {
      allAreas.add(area);
      allAreas.addAll(area.getAreas());
    }
    return allAreas;
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

