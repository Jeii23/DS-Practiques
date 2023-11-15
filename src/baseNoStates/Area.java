package baseNoStates;

import java.util.ArrayList;
import java.util.List;

public abstract class Area {
  protected String id;

  //Constructor on inicialitzem la nostra àrea.
  public Area(String id) {
    this.id = id;
  }

  //funció que ens retorna la id de l'àrea.
  public String getId() {
    return id;
  }
  public abstract void acceptVisitor(Visitor v);
  public abstract ArrayList<Door> getDoorsGivingAccess();

  public abstract Area findAreaById(String id);

  public List<Area> getAreas() {
    return new ArrayList<>();
  }
}
