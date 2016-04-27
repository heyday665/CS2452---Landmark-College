import java.io.*;

public class enc {
	public static void main(String[] args){
		String word="";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{word = br.readLine();} catch (Exception e){};
		
		int temp;
		int cnt=0; cnt = word.length();
		if (cnt > 0 && cnt <= 6){
			int iword=0;
			for (int i=0;i<cnt;i++){
				temp = ((int) word.charAt(i)) - 64;
				iword |= temp;
				iword <<= 5;
			}
		}
		else if (cnt > 6 && cnt <= 12) {
			long iword=0;
			for (int i=0;i<cnt;i++){
				temp = ((int) word.charAt(i)) - 64;
				iword |= temp;
				iword <<= 5;
			}
		}
		else {
			System.out.println("Not a valid token.");
		}
	}
}
