package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Floor implements Building {
  private final String id;
  private List<Building> components = new ArrayList<>();

  public Floor(String id) {
    this.id = id;
  }

  public void addComponent(Building component) {
    components.add(component);
  }

  public void removeComponent(Building component) {
    components.remove(component);
  }

  @Override
  public void processRequest(RequestReader request) {
    for (Building component : components) {
      component.processRequest(request);
    }
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getStateName() {
    // Implementar según sea necesario
    return null;
  }

  @Override
  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    JSONArray componentJson = new JSONArray();
    for (Building component : components) {
      componentJson.put(component.toJson());
    }
    json.put("components", componentJson);
    return json;
  }
}

