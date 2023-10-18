package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Partition extends Area {


  public <E> Partition(String building, ArrayList<E> es) {
    super();
  }

  @Override
public ArrayList<Door> getDoorsGivingAccess(){
  ArrayList<Door> doors = new ArrayList<>();
  for (Area fac: areas){
    for (Door d: fac.getDoorGivingAccess()) {
      if (!doors.contains(d)){
        doors.add(d);
      }
    }
  }
  return doors;
  }
}

