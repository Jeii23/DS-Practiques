package baseNoStates;

import java.util.ArrayList;
import ch.qos.logback.classic.Logger;

public class Space extends Area {

  private ArrayList<Door> doorsGivingAccess;
  Logger logger;

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
  public Area findAreaById(String id) {
    if (this.id.equals(id)) {
      return this;
    }
    logger.warn("Area with id " + id + " not found");
    return null; // otherwise we get a Java error
  }
  @Override
  public void acceptVisitor(Visitor v) {
    v.visitSpace(this);
  }
}
