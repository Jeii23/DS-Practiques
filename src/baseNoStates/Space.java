package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;

import java.util.ArrayList;

public class Space extends Area{
  private ArrayList<Door> doorsGivingAccess;
  public Space(String id) {
    super(id);
    doorsGivingAccess = new ArrayList<Door>();

  }

  @Override

  //en retorna la llista de portes a les que podem accedir
  public ArrayList<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }


  //Funció que ens permet afegir una porta a l'array.
  public void addDoorGivingAccess(Door door) {
    doorsGivingAccess.add(door);
  }

  //Funció que ens busca una àrea mitjançant el seu id, si la troba la retorna, si no,
  // ens printa que no s'ha trobat.
  public  Area findAreaById(String id) {
    if (this.id.equals(id)) {
      return this;
    }
    System.out.println("Area with id " + id + " not found");
    return null; // otherwise we get a Java error
  }
}
