package baseNoStates;

public abstract class Status {
 protected Door door;
 protected String name;


 //Inicialitzem Status
  public Status(Door door) {
    this.door =door;
  }

 //Funció que retorna el nom de l'estat
  public  String getName(){return name;}

  public abstract void locked();
  public abstract void unlock();


}
