package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Partition extends Area {

  private ArrayList<Area> areas;

  public Partition(String id, ArrayList<Area> area) {
    super(id);
    this.areas=area;
  }

  @Override
public ArrayList<Door> getDoorsGivingAccess(){
  ArrayList<Door> doors = new ArrayList<>();
  for (Area fac: areas){
    for (Door d: fac.getDoorsGivingAccess()) {
      if (!doors.contains(d)){
        doors.add(d);
      }
    }
  }
  return doors;
  }
  public  Area findAreaById(String id) {
    if (this.id.equals(id)) {
      return this;
    }
    else {
      for (Area fac: areas){
        if( fac.findAreaById(id)!=null)
          return fac.findAreaById(id);
      }
    }
    return null;
  }
}

