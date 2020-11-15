package Gangjwa;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Exception.GwamokNameNotFoundException;
import Exception.HaksaengNumberNotExistException;
import Gwamok.GwamokList;
import Haksaeng.HaksaengList;
import ValueObject.seongjeok;
import sort.Quick;

public class Gangjwa {    
      
   private int haksaengID[] = new int[100];
   private int kimal[] = new int[100];
   
   private String name;   
   private int year;   
   private int semester;   
   private int gwamokID;   
   private int gangjwaID;
   
   private char[] kgrade = new char[100];
   private int ma[] = new int[100];
   
   Vector<Score> scoreVector;

   GwamokList gwamokList;
   HaksaengList haksaengList;

   Score score = new Score();
   int length = 0;
   
   public Gangjwa() {
      this.scoreVector = new Vector<Score>();
   }
public void associate(GwamokList gwamokList, HaksaengList haksaengList) {
      //이런 관계는 constructor 밑에 놔.
      this.gwamokList = gwamokList;
      this.haksaengList = haksaengList;
      //밖에서 받아온 주소를 파란 강좌리스트와 학생리스트에 저장.   
   }

   public void readFromFile(String name) throws FileNotFoundException{
         
         File file = new File(name);   //파일 열었어
         Scanner scan = new Scanner(file);
                           
         this.gangjwaID = scan.nextInt();   
         this.name = scan.next();   
         this.year = scan.nextInt();
         this.semester = scan.nextInt();
         this.gwamokID = scan.nextInt();
         scan.nextLine();
         
         int count = 0;
         
         while(scan.hasNext()){   
            score.readFromFile(scan, count);   //스코어에게 읽으라고 시킴               
            this.scoreVector.add(score);
            count++;
         }
         length = count;
      scan.close();
   }

   private class Score{
      
      public void readFromFile(Scanner scan, int count) {
               
         haksaengID[count] = scan.nextInt();   
         kimal[count] = scan.nextInt();//성적
         ma[count] = kimal[count];
               
      }      
      public void printInfo(int count,HaksaengList haksaengList) throws HaksaengNumberNotExistException {
                            
          int left = 0;
            int right = length;
           char grade = 0;
          
            if(85<=ma[count]) {
                 grade = 'A';
              } else if(70 <= ma[count]) {
                 grade = 'B';
              } else if(50 <= ma[count]) {
                 grade = 'C';
              } else if(20 <= ma[count]) {
                 grade = 'D';
              } else {
                 grade = 'F';
              }     
          
           kgrade[count] = grade;
            
           Quick quick = new Quick();
             quick.quickdown(kimal, left, right, haksaengID);
             
             if(85<=kimal[count]) {
                 grade = 'A';
              } else if(70 <= kimal[count]) {
                 grade = 'B';
              } else if(50 <= kimal[count]) {
                 grade = 'C';
              } else if(20 <= kimal[count]) {
                 grade = 'D';
              } else {
                 grade = 'F';
              } 
            
           String haksaengName = haksaengList.getHaksaengName(haksaengID[count]);                
              System.out.println(haksaengName + " " +kimal[count] + " " + grade);
              
      }
      
   }
   
   public void printInfo(GwamokList gwamokList, HaksaengList haksaengList) throws GwamokNameNotFoundException {
      
      String gwamokName = gwamokList.getGwamokName(gwamokID);
      System.out.println("===========Gangjwa information===========");
      if(gwamokName != null){
         System.out.println("강좌번호"+this.gangjwaID + " " + name + " " + year + "년" + " " + semester + "학기" + '\n' + "과목: " + gwamokName);            
      }else{
         throw new GwamokNameNotFoundException(gwamokID);
      }   
      
      int count = 0;
      
      for (Score score : this.scoreVector) {//스코어벡터가 원소 가진만큼 반복해라
      try {
         score.printInfo(count, haksaengList);
      } catch (HaksaengNumberNotExistException e) {
         e.printStackTrace();
      }
      count++;      
   }   
}
   
   public seongjeok getseongjeok(int id) throws FileNotFoundException{
      
      GwamokList gwamokList = new GwamokList();
      gwamokList.readFromFile();
      
           
      seongjeok seongjeok = new seongjeok();
      Vector<seongjeok> seongjeokList;
      
       int idx = 0;
         
         for (Score score : this.scoreVector) {
            if(id == this.haksaengID[idx]) {   
               
               seongjeok.setGrade(kgrade);
               seongjeok.setKimal(ma);   
               seongjeok.setName(name);
               seongjeok.setSemester(semester);
               seongjeok.setYear(year);
               
               try {
                 String gwamokName = gwamokList.getGwamokName(gwamokID);
                   seongjeok.setGwamokName(gwamokName);
              } catch (GwamokNameNotFoundException e) {
   //              e.printStackTrace();
              }           
               return seongjeok;
            }
            idx++;
         }
         return null;
      }   
   
}