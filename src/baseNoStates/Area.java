package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import java.util.ArrayList;
public abstract class Area {
  protected String id;
  public Area(String id){
    this.id=id;
  }
  public String getId(){
    return id;
  }

  public abstract ArrayList<Door> getDoorsGivingAccess();

  public abstract Area findAreaById(String id);
}
