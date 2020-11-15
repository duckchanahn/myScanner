package Haksaeng;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Gangjwa.GangjwaList;
import ValueObject.seongjeok;
import sort.Quick;

public class Haksaeng {
   
   private int id;
   private String name;
 
   public int getId() {return id;}
   public String getName() {return name;}
   
   public void readFromFile(Scanner scan) {
      this.id = scan.nextInt();
      this.name = scan.next();      
}
  
   public void printInfo(GangjwaList gangjwaList) throws FileNotFoundException{
    //원하는 정보 프린트. 학생은 강좌 리스트 어쏘시에이션 해놔야 함.
	   System.out.println("===========Haksaeng information===========");
      System.out.println(id +" "+ name);
     Vector<seongjeok> seongjeokList = gangjwaList.getSeongjeok(id);
     
     int[] year = new int[100];
     int[] semester = new int[100];
     String[] gwamokName = new String[100];
     String[] name = new String[100];
     int[] kimal = new int[100];
     char[] grade = new char[100];
     int count = 0;
     
     for(seongjeok seongjeok : seongjeokList) {    
        if(seongjeok != null) {
           if(seongjeok.getGwamokName() != null) {
      year[count] = seongjeok.getYear();
      semester[count] = seongjeok.getSemester();
      gwamokName[count] = seongjeok.getGwamokName();
      name[count] = seongjeok.getName();
      kimal[count] = seongjeok.getKimal()[id-1];
      grade[count] = seongjeok.getGrade()[id-1];
         
      count++;
           }            
        }
     }
     int count1 = 0;
     for(seongjeok seongjeok : seongjeokList) {       
        if(seongjeok != null) {
           if(seongjeok.getGwamokName() != null) {
              
              int left = 0;
              int right = count-1;
              
           Quick quick = new Quick();
           quick.quickup(left, right, year, semester, gwamokName, name, kimal, grade);
           quick.Ssem(year, semester, gwamokName, name, kimal, grade);
         System.out.println(year[count1] +"년 "+ semester[count1] + "학기 " + gwamokName[count1] + " " + name[count1] + " " + kimal[count1]+ "점 " + grade[count1]);
   
         count1++;
   }
        }
     }
}
}