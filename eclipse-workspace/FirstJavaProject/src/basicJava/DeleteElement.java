package basicJava;


public class DeleteElement {

	public static void main(String[] args) {
   
		int[] array = new int[] { 1,2,3,4,5,6 };

		  
	   System.out.println("Original array:");
		for (int i =0 ; i < array.length; i++ ) {
			System.out.print(array[i]+ " ");
			
		}
		
	int[] newarray = new int[array.length-1];
	
	int index = 2;
	
	for (int i =0,k=0; i<array.length ;i++) {
		if(i == index) {
			continue;
		}
		newarray[k++] = array[i];
	}
	
    System.out.println("\nThe array after deleting element at index "+index+" is");
    for (int i =0; i<newarray.length;i++){
    	System.out.print(newarray[i]+" ");
    	
	}
	}
}
