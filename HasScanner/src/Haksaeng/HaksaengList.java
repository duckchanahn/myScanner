package Haksaeng;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Exception.HaksaengNumberNotExistException;
import Gangjwa.GangjwaList;

public class HaksaengList {
   //n명의 학생 명단 넣을 수 있는 공간 만들어야 함 (aggregation)(array=vector)
   //components
	private GangjwaList gangjwaList;
   private Vector<Haksaeng> haksaengVector;//학생리스트와 학생벡터는 포함관계이다. 자식관계(aggregation)
   
   public HaksaengList(){ 
      this.haksaengVector = new Vector<Haksaeng>();
   }
   
   public void associate(GangjwaList gangjwaList) {
	   
		this.gangjwaList = gangjwaList;
		
   }
   
   public String getHaksaengName(int haksaengID) throws HaksaengNumberNotExistException {
      
      for(Haksaeng haksaeng : this.haksaengVector){
         if (haksaeng.getId() == haksaengID){
            return haksaeng.getName();
         }
      }
     
       throw new HaksaengNumberNotExistException(haksaengID);
   }
   
   public void readFromFile() throws FileNotFoundException {
      
               
         File file = new File("data1/haksaeng.txt");
         Scanner scan = new Scanner(file);

         while(scan.hasNext()){   
            Haksaeng haksaeng = new Haksaeng();   
            haksaeng.readFromFile(scan);            
            this.haksaengVector.add(haksaeng);   
         }         
         
         scan.close();         
      } 


   public void printHaksaengInfo(GangjwaList gangjwaList) throws FileNotFoundException {
      
      for (Haksaeng haksaeng: haksaengVector) {
         haksaeng.printInfo(gangjwaList);
         

}
}
}