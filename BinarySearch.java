package BankAccount.Bank_Account;


class BinarySearch{
    private static final int[] Account = null;
    public static void binarySearch(int arr[], int first, int last, int key){
      int mid = (first + last)/2;
      while( first <= last ){
         if ( arr[mid] < key ){
           first = mid + 1;   
         }else if ( arr[mid] == key ){
           System.out.println("Element is found at index: " + mid);
           break;
         }else{
            last = mid - 1;
         }
         mid = (first + last)/2;
      }
      if ( first > last ){
         System.out.println("Element is not found!");
      }
    }
    public static void main(String args[]){
           int arr[] = Account;
           int key = 10;
           int last=arr.length-1;
           binarySearch(arr,0,last,key);	
    }
   }