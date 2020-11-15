package main;
import java.io.FileNotFoundException;

import Gangjwa.GangjwaList;
import Gwamok.GwamokList;
import Haksaeng.HaksaengList;

public class Main {

      public static void main(String[] args){
         
    try {

        GwamokList gwamokList = new GwamokList();
        gwamokList.readFromFile();   //���� �б�
        gwamokList.writeToFile();
        
         HaksaengList haksaengList = new HaksaengList();
         haksaengList.readFromFile(); //�л� �б�
         
         
         GangjwaList gangjwaList = new GangjwaList();
         gangjwaList.readFromFile();
                  
         //1. ����Ʈ ���� ����
         gangjwaList.associate(gwamokList, haksaengList);
         gangjwaList.printInfo(gwamokList, haksaengList);
         //2. ����Ʈ �л� ����
         
         
         
         
         haksaengList.associate(gangjwaList);
         haksaengList.printHaksaengInfo(gangjwaList);
 
                 
      }catch (FileNotFoundException e) {
         e.printStackTrace();
      }
    }
}