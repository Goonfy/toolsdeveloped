public class FrontBack
{
	public static void main(String[] args) {
    		frontBack("heisenberg");

    		//receive command line argument if available
    		if(args.length>0){
      			frontBack(args[0]);
    		}
	}

	private static void frontBack(String str) {
    		// print result here
		System.out.println(str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0));
	}
}
