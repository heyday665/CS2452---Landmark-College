import java.io.*;
import java.util.Scanner;

class Program2 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int max = 0;
		int min = 1000000000;
		int count = 0;

		int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		//So, funny thing. I didn't want to deal with java's memory management, so I didn't. It only supports that many integers in a row. 100 to be exact.

		while (true){
			int num = in.nextInt();
			if (num <= 0) { break;}
			else if (num < min) { min = num;}
			else if (num > max) { max = num;}
			nums[count] = num;
			count++;
		}

		int total = 0;

		for (int i=0; i<count; i++){
			total = total + nums[i];
		}

		float average = total/count;
		System.out.println("Max was: "+max);
		System.out.println("Min was: "+min);
		System.out.println("Mean was: "+average);
	} 	
}
