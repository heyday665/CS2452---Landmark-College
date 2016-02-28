import java.io.*;

class Program1 {
	public static void main(String[] args) {
		try {
			for (int i=0; i<args.length; i++) {
				System.out.println(args[i]);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}		
}
