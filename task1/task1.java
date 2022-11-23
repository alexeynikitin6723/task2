public class task1{
	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		int i=1;
		String result = "";
		do{
			result+=Integer.toString(i);
			i = 1 + (i+m-2)%n;
		}while(i!=1);
		System.out.println(result);
	}
}