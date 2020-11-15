package Exception;
public class HaksaengNumberNotExistException extends Exception {



    

      public HaksaengNumberNotExistException(int haksaengid/*String string*/){

         super("해당 학생이 존재하지 않습니다."+haksaengid);

      }

    

   }