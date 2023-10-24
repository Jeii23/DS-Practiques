package baseNoStates;
import java.util.ArrayList;

public class User {
  private final String name;
  private final String credential;
  private Group group;

  //Inicialitzem el nostre User
  public User(String name, String credential, Group group) {
    this.name = name;
    this.credential = credential;
    this.group = group;

  }

  //Funció que retorna el grup al qual pertany l'usuari.
  public Group getGroup(){return group;}

  //Funció que retorna les credencials de l'usuari.
  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }




}
