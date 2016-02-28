class Test2 {
	public static void main (String[] args) {
		try {
			if (args.length != 1) {
				System.out.println("usage: java Test2 bufferSize");
				System.exit(1);
			}
			System.out.println("Test2 progam starts");

			PC ex = new PC(Integer.parseInt(args[0]));
			ex.t.join();

			System.out.println("Test2 progam ends");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
