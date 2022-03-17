public class fibonacciRuntime {

			public static int fibRecursive(int n) { //function using recursive method

				if(n<=1) {
					return 1;
					}
				
				else {
					return fibRecursive(n-1)+fibRecursive(n-2);
					}
					
				}
	
	

			public static int fibIterative(int n) { //function using iterative method
				if(n<=1) {
					return 1;
					}
			
				int r=0,q=1,p=1,i;
				for(i=2;i<=n;i++)
				{
					r = q + p;
					p =q;
					q =r;
				}
				return r;
			}
			
			
			public static void main(String[] args) {


				int i,n=20, tRecursive, tIterative; //variables for time
				
				System.out.print("n\tIterative\tRecursive\n");
				System.out.print("==\t=========\t=========\n");
				
				long start_time,end_time;
				int iterativeDifference,recursiveDifference;
				
				for(i=0;i<=n;i++) { 
					
					
					
					start_time = System.nanoTime(); //for initial time
					tRecursive = fibRecursive(i); //calling function for using recursive method
					end_time = System.nanoTime(); //for end time
					recursiveDifference = (int)((end_time - start_time)); //for calculating difference
					
				
					start_time = System.nanoTime(); //initial time
					tIterative = fibIterative(i); //calls function for using iterative method
					end_time = System.nanoTime(); //end time
					iterativeDifference = (int)((end_time - start_time)); //calculates difference
				
					System.out.print(i+"\t\t"+iterativeDifference+"\t\t\t"+recursiveDifference +"\t\n"); //for outputting result
				
									}
				
				}
				
}

