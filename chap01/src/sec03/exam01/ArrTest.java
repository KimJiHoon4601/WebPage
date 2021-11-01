package sec03.exam01;

public class ArrTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int[2][];
		
		arr[0] = new int[3];
		arr[1] = new int[2];
		
		System.out.println(arr[0].length);
		System.out.println(arr[1].length);
		
		int arr2[] = new int[5];
		
		for(int i : arr2) {
			System.out.println(i);
		}
	}

}
