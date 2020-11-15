package Gwamok;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Exception.GwamokNameNotFoundException;

public class GwamokList {
      
      private Vector<Gwamok> gwamokVector;//�л�����Ʈ�� �л����ʹ� ���԰����̴�. �ڽİ���(aggregation)
   
      public GwamokList(){ 
         this.gwamokVector = new Vector<Gwamok>();
      }
      public String getGwamokName(int gwamokID) throws GwamokNameNotFoundException {

         for(Gwamok gwamok : this.gwamokVector){
            if (gwamok.getId() == gwamokID){
               return gwamok.getName();
            }
         }
      
          throw new GwamokNameNotFoundException(gwamokID);
      }
      
      public void readFromFile() throws FileNotFoundException {
         
               
            File file = new File("data1/gwamok.txt"); 
            Scanner scan = new Scanner(file);
              while(scan.hasNext()){   
               Gwamok gwamok = new Gwamok();  
               gwamok.readFromFile(scan);  

               this.gwamokVector.add(gwamok);   //�л����� �������.    ������ ������ ���Ϳ� ����. ���� ���� �� ���� ������
            }         
            
            scan.close();
            
         } 
      public void writeToFile() {
         for (Gwamok gwamok: this.gwamokVector) {
            //���� �� ������ n�� �ݺ��ض�.
            gwamok.writeToFile();         
      }
         System.out.println("");
      }
}
