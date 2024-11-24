// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result=x1, i=0;
		if(x2>0){
			for(i=0; i<x2; i++)
			{
					result++;
			}
		}
		if(x2<0){
			for(i=0; i<(minus(0, x2)); i++)
			{
					result--;
			}
		}
		return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int result=x1, i=0;
		if(x2>0){
			for(i=0; i<x2; i++)
			{
				result--;
			}
		}
		if(x2<0){
			for(i=x2;i<0;i++){
				result++;
			}
		}
		return result;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result=0, i=0, temp;
		if(x1>0 && x2<0){
			temp=x2;
			x2=x1;
			x1=temp;
		}
		if(x1<0 && x2<0){
			x1= minus(0, x1);
			x2= minus(0, x2);
		}
		if(x1==0 || x2==0){
			return 0;
		}

		for(i=0; i<x2; i++)
		{
			result=plus(result, x1);
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result=x, i=0;
		if(n==0)
		{
			return 1;
		}
		if(x==0){
			return 0;
		}
		for(i=0; i<n-1; i++)
		{
			result=times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int num=x1, count=0;
		boolean neg=false;
		if(x1==0){
			return 0;
		}
		if(x1<0 && x2<0){
			x1=minus(0, x1);
			x2=minus(0, x2);
		}
		if(x1<0 && x2>0){
			x1=minus(0, x1);
			neg=true;
		}
		if(x2<0 && x1>0){
				x2=minus(0, x2);
				neg=true;
			}
		while (num>0 && (num>x2 || num == x2)) {
			num=minus(num, x2);
			count++;
		}
		if(neg){
			return minus(0, count);
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int num=x1;
		while (num>0 && (num>x2 || num == x2 )) {
			num=minus(num, x2);
		}
		return num;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int num=1;
		while (times(num, num)<x) {
			num++;
		}
		if(times(num, num)==x)
		{
			return num;
		}
		else
			return num-1;
	}	  	  
}