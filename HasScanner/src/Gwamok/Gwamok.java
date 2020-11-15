package Gwamok;
import java.util.Scanner;

public class Gwamok {
   

   private int id;
   private String name;
   


public int getId() {return id;}

public void setId(int id) {this.id = id;}

public String getName() {return name;}

public void setName(String name) {this.name = name;}

public void readFromFile(Scanner scan) {

         this.id = scan.nextInt();
         this.name = scan.next();
         
      }

   public void writeToFile() {
      System.out.println(this.id +" "+ this.name);
      
   }

   
}