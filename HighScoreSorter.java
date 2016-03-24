/*
 * HighScoreSorter.java
 *
 * Written by Conor
 *
 */


  class HighScoreSorter{
 	 public static void main(String args[]){

 		 boolean swap = true;
 		 int change;
          int arr[];

 		 arr = new int[]{};
          int size = arr.length-2;
 		 while(swap){       //while swap is true
 			 swap = false;  //presuming array is sorted
 			for(int i=0;i<=size;i=i+1){
 				if(arr[i] > arr[i+1]){
 					change = arr[i];
 	                arr[i] = arr[i+1];
 	                arr[i+1] = change;
 	                swap = true;
 				 }
             }
    			size = size -1; //reduce length by one because 1 number alreay stored each time
    			}
          for(int i=0;i<arr.length;i=i+1){
 	         System.out.println(arr[i] + " ");
     }
   }
}