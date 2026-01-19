package tyukann_B253377_宮廻陽向;
import java.util.Scanner;

public class PrimeCheckSimple {
	
	public static boolean checkPrime(int n) {					//①
		boolean isPrime = true;
		
		if(n < 2) {
			isPrime = false;
		}else {
			for(int i = 2; i < n; i++) {
				if(n % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		
		return isPrime;
		
	}
	
	public static void checkListPrimes(int[] numList) {			//②
		for(int i = 0; i < numList.length; i++) {
			System.out.println(numList[i] + ":" + checkPrime(numList[i]));
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		
		System.out.print("整数を入力してください："); 	 		//キーボード入力
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(num);
		scanner.close();
		
										
		if(checkPrime(num)) {									//①checkPrime(int n)メゾットの呼び出し							
			System.out.println(num + " は素数です。");
		}else {
			System.out.println(num + " は素数ではありません。");
		}
		
		
		
		int[] numList = {1, 2, 4, 13, 15};						//②checkListPrimes(int[] numList) メソッドの呼び出し
		checkListPrimes(numList);
		
		
		long startTime = System.currentTimeMillis();			//③1～1000000の素数カウント、計算時間の計測
		
		int primecount = 0;								
		for(int i = 1; i <= 1000000; i++) {
			
			if(checkPrime(i)) {
				primecount++;
			}
		}
		
		System.out.println("素数の個数：" + primecount);
		
		long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("計算時間：" + timeElapsed + "[ms]");
	}
	
}
