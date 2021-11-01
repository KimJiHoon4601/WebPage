package sec03.exam01;

import java.util.Scanner;

public class KeyCodeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int keyCode;
		
		try {
			Scanner scanner = new Scanner(System.in);
			String inputData = scanner.nextLine();
			System.out.println(inputData);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
