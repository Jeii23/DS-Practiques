package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
public abstract class Area {
  protected String id;
  public Area(String id){
    this.id=id;
  }
  public String getId(){
    return id;
  }

  public Door[] getDoorsGivingAccess() {

  }
}
