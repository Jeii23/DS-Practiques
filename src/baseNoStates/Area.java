package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import java.util.ArrayList;
public abstract class Area {
  protected String id;
  //Constructor on inicialitzem la nostra àrea.
  public Area(String id){this.id=id;
  }

  //funció que ens retorna la id de l'àrea.
  public String getId(){
    return id;
  }

  public abstract ArrayList<Door> getDoorsGivingAccess();

  public abstract Area findAreaById(String id);
}
