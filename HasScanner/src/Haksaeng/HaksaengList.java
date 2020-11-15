package Haksaeng;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Exception.HaksaengNumberNotExistException;
import Gangjwa.GangjwaList;

public class HaksaengList {
   //n���� �л� ��� ���� �� �ִ� ���� ������ �� (aggregation)(array=vector)
   //components
	private GangjwaList gangjwaList;
   private Vector<Haksaeng> haksaengVector;//�л�����Ʈ�� �л����ʹ� ���԰����̴�. �ڽİ���(aggregation)
   
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