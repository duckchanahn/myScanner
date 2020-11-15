package sort;
public class Quick {

public void quickdown(int[] arr, int left, int right, int[] arr1){
      int temp; 
      int pivot = arr[left];
      
      int low = left + 1;
      int high = right;
      
      while(low <= high){
         
         while( low <= right && pivot <= arr[low])
            low++;
         
         while( pivot >= arr[high] && left+1 <= high)
            high--;
         
         if(low <= high){
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            
            temp = arr1[low];
            arr1[low] = arr1[high];
            arr1[high] = temp;
         }
      }  
      
      temp = arr[left];
      arr[left] = arr[high];
      arr[high] = temp;
      
      temp = arr1[left];
      arr1[left] = arr1[high];
      arr1[high] = temp;
      
      if(left < high) 
         quickdown(arr, left, high-1, arr1);
      if(low < right)
         quickdown(arr, low, right, arr1);
   }

public static void printArr(int[] arr, int[]arr1){
    for(int i = 0; i < arr.length; i++){
       System.out.println(arr1[i] +"   "+ arr[i]);
    }
    System.out.println();
 }

public void quickup(int left, int right, int[] year, int[] semester, String[] gwamokName, String[] name, int[] kimal, char[] grade) {
    int temp; 
    String gwa;
    char mok;
     int pivot = year[left];
     
     int low = left + 1;
     int high = right;
     
     while(low <= high){
        
        while( low <= right && pivot >= year[low])
           low++;
        
        while( pivot <= year[high] && left+1 <= high)
           high--;
        
        if(low <= high){
           temp = year[low];
           year[low] = year[high];
           year[high] = temp;  
           
           temp = semester[low];
           semester[low] = semester[high];
           semester[high] = temp;  
           
           gwa = gwamokName[low];
           gwamokName[low] = gwamokName[high];
           gwamokName[high] = gwa; 
           
           gwa = name[low];
           name[low] = name[high];
           name[high] = gwa; 
           
           temp = kimal[low];
           kimal[low] = kimal[high];
           kimal[high] = temp; 
           
           mok = grade[low];
           grade[low] = grade[high];
           grade[high] = mok; 
          
        }
     }    
     temp = year[left];
     year[left] = year[high];
     year[high] = temp;
     
     temp = semester[left];
     semester[left] = semester[high];
     semester[high] = temp;  
     
     gwa = gwamokName[left];
     gwamokName[left] = gwamokName[high];
     gwamokName[high] = gwa; 
     
     gwa = name[left];
     name[left] = name[high];
     name[high] = gwa; 
     
     temp = kimal[left];
     kimal[left] = kimal[high];
     kimal[high] = temp; 
     
     mok = grade[left];
     grade[left] = grade[high];
     grade[high] = mok;
  
     if(left < high) 
        quickup(left, high-1, year, semester, gwamokName, name, kimal, grade);
     if(low < right)
        quickup(low, right, year, semester, gwamokName, name, kimal, grade);
   
   
}

public void Ssem(int[] year, int[] semester, String[] gwamokName, String[] name, int[] kimal, char[] grade) {
   int temp;
   String gwa;
   char mok;
      
   for(int i = 0; i<year.length-1; i++) {
      if(year[i] == year[i+1]) {
         if(semester[i] > semester[i+1]) {
            
             temp = year[i];
              year[i] = year[i+1];
              year[i+1] = temp;
              
              temp = semester[i];
              semester[i] = semester[i+1];
              semester[i+1] = temp;  
              
              gwa = gwamokName[i];
              gwamokName[i] = gwamokName[i+1];
              gwamokName[i+1] = gwa; 
              
              gwa = name[i];
              name[i] = name[i+1];
              name[i+1] = gwa; 
              
              temp = kimal[i];
              kimal[i] = kimal[i+1];
              kimal[i+1] = temp; 
              
              mok = grade[i];
              grade[i] = grade[i+1];
              grade[i+1] = mok;
         }
      }
   }
}

}