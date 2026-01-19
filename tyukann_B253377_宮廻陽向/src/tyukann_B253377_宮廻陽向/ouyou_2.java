package tyukann_B253377_宮廻陽向;

public class ouyou_2 {

	public static boolean squarecheckPrime(int n) {				//②√ｎまでを計算
		
			if(n < 2) return false;
			int sqrtN = (int) Math.sqrt(n);
			
			for(int i = 2; i <= sqrtN; i++) {
				if(n % i == 0) {
					return false;	
				}	
			}	
			
			return true;
			
		}
	
	
	public static void main(String[] args) {
		
		System.out.println("==== 素数判定：上限 1000000====");
        
        long startTime = System.currentTimeMillis();			//1～1000000の素数カウント、計算時間の計測
		int primecount = 0;								
		for(int i = 1; i <= 1000000; i++) {
			
			if(squarecheckPrime(i)) {
				primecount++;
			}
		}
		
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.println("√1000000まで調べる：素数の個数 = " + primecount + ", 処理時間 = " + timeElapsed + " ms");
	}

}
