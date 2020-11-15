package Gangjwa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Exception.GwamokNameNotFoundException;
import Gwamok.GwamokList;
import Haksaeng.HaksaengList;
import ValueObject.seongjeok;


public class GangjwaList {
   
private Vector<Gangjwa> gangjwaVector;//�л�����Ʈ�� �л����ʹ� ���԰����̴�. �ڽİ���(aggregation)
   
GwamokList gwamokList;
HaksaengList haksaengList;
Gangjwa gangjwa = new Gangjwa();

   public GangjwaList(){ 
      this.gangjwaVector = new Vector<Gangjwa>();
   }
   
   public void associate(GwamokList gwamokList, HaksaengList haksaengList) {
      this.gwamokList = gwamokList;
      this.haksaengList = haksaengList;      
   }
   
   public void readFromFile() throws FileNotFoundException {
         //   int Ah = 0;
      File file = new File("data1/gangjwaList.txt");   
      Scanner scan = new Scanner(file);
      while(scan.hasNext()){   
         String name = scan.next();
         Gangjwa gangjwa = new Gangjwa();
         gangjwa.associate(this.gwamokList, this.haksaengList);
         gangjwa.readFromFile(name);
        // Ah++;
         
         this.gangjwaVector.add(gangjwa);
      }               
      scan.close();         
   }

   public void printInfo(GwamokList gwamokList,HaksaengList haksaengList)  {
      
      for (Gangjwa gangjwa: gangjwaVector) {
         //���� �� ������ n�� �ݺ��ض�.
         try {
			gangjwa.printInfo(gwamokList, haksaengList);
		} catch (GwamokNameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   //���¸���Ʈ�� �л� ����Ʈ�� ���񸮽�Ʈ�� �˰� �־�� ��   -> ���¿��� �˷���� ��
      
      }   
   }  
   
	public Vector<seongjeok> getSeongjeok(int id) throws FileNotFoundException {
		Vector<seongjeok> seongjeokList = new Vector<seongjeok>();
		for(Gangjwa gangjwa: this.gangjwaVector) {
			seongjeok seongjeok = gangjwa.getseongjeok(id);
			
			if(seongjeok != null) {
				
				seongjeokList.add(seongjeok);
			}
		}
		return seongjeokList;
	}


   
}