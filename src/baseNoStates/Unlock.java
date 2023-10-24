package baseNoStates;

public class Unlock extends Status{

  //Inicialitzem Unlock
  public Unlock(Door door) {
    super(door);
    name = States.UNLOCKED;
  }


  //Aquesta funció ens permet cridar-la directament a una altra funció fent .locked
  // i guarda l'estat que li passem.
  public void locked() {
    this.door.setState(new Locked(this.door));
  }
  public void unlock() {
    System.out.println("Can't unlock the door " + door.getId() + " because it's already unlocked or it's open");
  }

}
