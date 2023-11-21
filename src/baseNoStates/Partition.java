package baseNoStates;

import java.util.ArrayList;
import java.util.List;

public class Partition extends Area {

  private ArrayList<Area> areas;

  //Inicialitzem Partició amb ajuda del constructor
  public Partition(String id, ArrayList<Area> area) {
    super(id);
    this.areas = area;
  }

  @Override
  public List<Area> getAreas() {
    List<Area> allAreas = new ArrayList<>();
    for (Area area : areas) {
      allAreas.add(area);
      allAreas.addAll(area.getAreas());
    }
    return allAreas;
  }
  @Override
  public void acceptVisitor(Visitor v) {
    v.visitPartition(this);
  }
}

