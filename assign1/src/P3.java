class Program3 {
	public static void main(String[] args){
		perm(args[0],"");
	}

	private static void perm(String s1, String s2) {
		if(s1.length()==0) {
			System.out.println(s2);
			return;
		}
		for (int i=0; i<s1.length(); i++){
			char c = s1.charAt(i);
			String rest = s1.substring(0,i) + s1.substring(i+1);
			perm(rest, s2+c);
		}
	}
}
