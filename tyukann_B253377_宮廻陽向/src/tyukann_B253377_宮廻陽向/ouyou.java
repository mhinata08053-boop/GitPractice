package tyukann_B253377_宮廻陽向;

public class ouyou {
	
	public static boolean evencheckPrime(int n) {			//①偶数のみ除外
		
		if(n < 2) return false;
		if(n == 2) return true;
		if(n % 2 == 0) return false;
		
		for(int i = 3; i < n; i++) {
			if(n % i == 0) {
				return false;	
			}	
		}	
		
		return true;
		
	}
	
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
	
	public static boolean evensquarecheckPrime(int n) {			//③偶数のみ除外し√ｎまでを計算
		
		if(n < 2) return false;
		if(n == 2) return true;
		if(n % 2 == 0) return false;
		int sqrtN = (int) Math.sqrt(n);
		
		for(int i = 3; i <= sqrtN; i += 2) {
			if(n % i == 0) {
				return false;	
			}	
		}	
		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("==== 素数判定：上限 1000000====");
		
		long startTime1 = System.currentTimeMillis();			//1～1000000の素数カウント、計算時間の計測
		int primecount1 = 0;								
		for(int i = 1; i <= 1000000; i++) {
			
			if(evencheckPrime(i)) {
				primecount1++;
			}
		}
		
        long timeElapsed1 = System.currentTimeMillis() - startTime1;
        System.out.println("方法①（偶数スキップのみ） ：素数の個数 = " + primecount1 + ", 処理時間 = " + timeElapsed1 + " ms");
        
        
        long startTime2 = System.currentTimeMillis();			//1～1000000の素数カウント、計算時間の計測
		int primecount2 = 0;								
		for(int i = 1; i <= 1000000; i++) {
			
			if(squarecheckPrime(i)) {
				primecount2++;
			}
		}
		
        long timeElapsed2 = System.currentTimeMillis() - startTime2;
        System.out.println("方法②（√1000000まで） ：素数の個数 = " + primecount2 + ", 処理時間 = " + timeElapsed2 + " ms");
        
        
        long startTime3 = System.currentTimeMillis();			//1～1000000の素数カウント、計算時間の計測
		int primecount3 = 0;								
		for(int i = 1; i <= 1000000; i++) {
			
			if(evensquarecheckPrime(i)) {
				primecount3++;
			}
		}
		
        long timeElapsed3 = System.currentTimeMillis() - startTime3;
        System.out.println("方法③（偶数スキップ＋√1000000まで）：素数の個数 = " + primecount3 + ", 処理時間 = " + timeElapsed3 + " ms");
	}

}
