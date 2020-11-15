package main;
import java.io.FileNotFoundException;

import Gangjwa.GangjwaList;
import Gwamok.GwamokList;
import Haksaeng.HaksaengList;

public class Main {

      public static void main(String[] args){
         
    try {

        GwamokList gwamokList = new GwamokList();
        gwamokList.readFromFile();   //과목 읽기
        gwamokList.writeToFile();
        
         HaksaengList haksaengList = new HaksaengList();
         haksaengList.readFromFile(); //학생 읽기
         
         
         GangjwaList gangjwaList = new GangjwaList();
         gangjwaList.readFromFile();
                  
         //1. 프린트 강좌 인포
         gangjwaList.associate(gwamokList, haksaengList);
         gangjwaList.printInfo(gwamokList, haksaengList);
         //2. 프린트 학생 인포
         
         
         
         
         haksaengList.associate(gangjwaList);
         haksaengList.printHaksaengInfo(gangjwaList);
 
                 
      }catch (FileNotFoundException e) {
         e.printStackTrace();
      }
    }
}