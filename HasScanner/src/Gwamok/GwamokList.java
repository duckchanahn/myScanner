package Gwamok;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Exception.GwamokNameNotFoundException;

public class GwamokList {
      
      private Vector<Gwamok> gwamokVector;//학생리스트와 학생벡터는 포함관계이다. 자식관계(aggregation)
   
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

               this.gwamokVector.add(gwamok);   //학생벡터 비어있음.    위에서 읽은거 벡터에 저장. 파일 읽을 것 없을 때까지
            }         
            
            scan.close();
            
         } 
      public void writeToFile() {
         for (Gwamok gwamok: this.gwamokVector) {
            //끝에 갈 때까지 n번 반복해라.
            gwamok.writeToFile();         
      }
         System.out.println("");
      }
}
