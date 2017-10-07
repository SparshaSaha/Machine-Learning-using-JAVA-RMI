import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.io.*;

public class Client{

  private static RMIInterface look_up;

  public static void main(String args[])throws MalformedURLException, RemoteException, NotBoundException,IOException
  {
    look_up = (RMIInterface) Naming.lookup("//127.0.0.1:2020/server");
    String response = look_up.hello("Sparsha");
    System.out.println(look_up.calculate(23,7));
    double[][] junk={{400},{13},{200},{5}};

      System.out.println(look_up.linear_regression_train(junk));
  }

}
