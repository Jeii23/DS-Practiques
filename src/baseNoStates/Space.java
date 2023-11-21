package baseNoStates;

import java.util.ArrayList;

public class Space extends Area {

  private ArrayList<Door> doorsGivingAccess;

  public Space(String id) {
    super(id);
    doorsGivingAccess = new ArrayList<Door>();

  }
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

  @Override
  public void acceptVisitor(Visitor v) {
    v.visitSpace(this);
  }
}
