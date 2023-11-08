package baseNoStates;

import java.util.ArrayList;

public class Group {
  private ArrayList<Area> areasAccess;
  private String name;
  private ArrayList<String> actions;
  private Schedule schedule;

  //Constructor que ens inicialitza el nostre grup.
  public Group(ArrayList<Area> areasAccess,
               String name, ArrayList<String> actions, Schedule schedule) {
    this.areasAccess = areasAccess;
    this.name = name;
    this.actions = actions;
    this.schedule = schedule;
  }

  public Schedule getSchedule() {
    return schedule;
  }

  /*
Funció que ens diu si es pot accedir a un espai iterant l'array areasAcces
 i si aquest espai es troba ens permet l'accés, sino,verifiquem si e suna instancia de partició,
 si ho és, convertim les arees del array en particions i busquem dins aquesta partició si l'espai
 donat es troba,si es troba retornem true sino, retornem false.
*/
  public boolean canAccess(Area space) {
    for (Area access : areasAccess) {
      for (Area a : access.getAreas()) {
        if (a.equals(space)) {
          return true;
        }
      }
    }
    return false;
  }

  //Aquesta funció ens permet saber si es pot realitzar una acció. Es recorre l'array actions
  //on a cada iteració comproba si l'acció es troba a l'aray, si es troba retora true, si no, false.
  public boolean canDoAction(String action) {
    for (String actions : actions) {
      if (actions.equals(action)) {
        return true;
      }
    }
    return false;
  }

  //Funció que comprova si es troba dins l'horari d'accés


}
