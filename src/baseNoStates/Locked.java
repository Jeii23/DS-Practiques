package baseNoStates;

public class Locked extends Status{
  public void locked() {setLocked(true);}
  public void unlock() {setLocked(false);}

}
