package sec03.exam01;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, Java");
		
		//변수 초기화 오류
		int value = 30;
		int result = value + 10;
		System.out.println(result);
		
		
		long a = 10;
		long bb = 1L;
		
		
		char cc = 65;
		System.out.println(((Object)a).getClass().getSimpleName());
		System.out.println(((Object)bb).getClass().getSimpleName());
		System.out.println(((Object)cc).getClass().getSimpleName());
		
		System.out.println("sdff"+cc);
	
	
	}

}
