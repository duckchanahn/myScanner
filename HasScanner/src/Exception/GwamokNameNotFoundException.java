package Exception;
public class GwamokNameNotFoundException extends Exception {



    

      public GwamokNameNotFoundException(int gwamokid){

         super("해당 과목이 존재하지 않습니다."+gwamokid);

      }

    

   }