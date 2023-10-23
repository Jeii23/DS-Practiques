package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Partition extends Area {

  private ArrayList<Area> areas;

  //Inicialitzem Partició amb ajuda del constructor
  public Partition(String id, ArrayList<Area> area) {
    super(id);
    this.areas=area;
  }


  // Aquesta funció crea una llista de portes que conté cada area. Primer recorrem l'array
  //areas i dins recorrem les seves portes, si no conté la porta, l'afegim a l'array
  //de portes d'aquesta area. Retornem l'array de portes.
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

  //Realitzem recursivitat per trobar l'area amb l'ID q es passa com a paràmetre. Comença
  //comparant l'ID de l'area actual amb la que es passa i si coincideixen retorna true, si no,
  //es va d'àrea en àrea  i es segueix comprovant si els ID coincideixen, si ho fan retornen l'àrea, si no,
  //l'area no existeix i es null.
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

