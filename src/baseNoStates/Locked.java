package baseNoStates;

public class Locked extends Status{

  //Inicialitzem Locked, amb ajuda del costructor.
  public Locked(Door door) {
    super(door);
    name = States.LOCKED;
  }


  public void locked(){
    System.out.println("Can't lock the door " + this.door.getId() + " because it's already locked");
  }

  //
  public void unlock(){
    this.door.setState(new Unlock(this.door));
  }

}
