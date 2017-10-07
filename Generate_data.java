import java.io.*;
class Generate_data{

  public static void main(String args[])throws IOException
  {
    PrintWriter xwriter = new PrintWriter("x_data.txt", "UTF-8");
    PrintWriter ywriter =new PrintWriter("y_data.txt","UTF-8");

    for(int i=0;i<1000;i++)
    {
      double areamin=400;
      double areamax=10000;
      double area=areamin +(Math.random() * ((areamax - areamin) + 1));

      double agemin=1;
      double agemax=100;
      double age=agemin+ (Math.random() * ((agemax - agemin) + 1));

      double distmin=5;
      double distmax=500;
      double dist=distmin + (Math.random() * ((distmax - distmin) + 1));

      double stomin=1;
      double stomax=5;
      double sto=stomin + (Math.random() * ((stomax - stomin) + 1));

      double amt=area*600 -age*10 - dist*24+sto*8000;

      double final_amt=amt+ Math.random()*100;

      xwriter.println(area+" "+age+" "+dist+" "+sto);
      ywriter.println(final_amt);

    }

  }
}
