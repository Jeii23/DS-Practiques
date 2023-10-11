package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
public interface Building {
  void processRequest(RequestReader request);
  String getId();
  String getStateName();
  JSONObject toJson();
}
