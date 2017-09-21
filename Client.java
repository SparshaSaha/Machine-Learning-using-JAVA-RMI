import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client{

  private static RMIInterface look_up;

  public static void main(String args[])throws MalformedURLException, RemoteException, NotBoundException
  {
    look_up = (RMIInterface) Naming.lookup("//127.0.0.1:2020/server");
    String response = look_up.hello("Sparsha");
    System.out.println(look_up.calculate(23,7));
  }

}
