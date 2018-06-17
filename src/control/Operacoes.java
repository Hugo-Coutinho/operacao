package control;

public class Operacoes {

	private static StringBuffer sb;

	public static long fatorial(int n) {

		if (n <= 1) {
			return n;
		} else {

			return n * fatorial(n - 1);
		}

	}

	public static String primo(int n) {

		for (int i=2; i<=n; i++) {

			if (n%2== 0) {
				return "<span style=font-family:Bell MT;> Nao Primo </span>";
			}
//			"<span style=font-family:Bell MT;> Primo </span>";
		}
		return "<span style=font-family:Bell MT;> Primo </span>";
	}

	public static String perfeito(int n) {

		
		int temp = 0;
		for(int i = 1; i<= n/2; i++) {
			if(n%i==0) {
				temp += i;
			}
		}
		if(temp == n) {
			return n + " <span style=font-family:Bell MT;> Perfeito </span>";
		}else {
			return n + " <span style=font-family:Bell MT;>Não Perfeito </span>";
		}
		
		
//		int divisor = 0;
//		boolean resp = false;
//		for (int i = 0; i < n; i++) {
//
//			if (i % 2 == 0) {
//
//				divisor += i;
//			}
//			if (n == divisor) {
//
//				resp = true;
//			}
//		}
//
//		if (resp == true) {
//
//			return n + " <span style=font-family:Bell MT;> Perfeito </span>";
//
//		} else {
//
//			return n + " <span style=font-family:Bell MT;> Perfeito </span>";
//		}

	}
	
	
	
	
	
	
	
	
	

	public static String palavraPalindromo(String p) {

		StringBuffer palavra = new StringBuffer(p);
		palavra.reverse();

		if (palavra.toString().equals(p)) {

			return p + "<span style=font-family:Bell MT;> Palindromo </span>";

		} else {
			
			return p + "<span style=font-family:Bell MT;> Não é Palindromo</span>";
		}

	}

	public static String frasePalindromo(String p) {
		String original = p;
		String palavra = original.replace(" ", "");
		sb = new StringBuffer(palavra);
		sb.reverse();
		if (sb.toString().equals(palavra)) {

			return p + "<span style=font-family:Bell MT;> Palindromo </span>";
		} else {
			return p + "<span style=font-family:Bell MT;> Não é Palindromo</span>";
		}

	}

	public static long fibonacci(int n) {
		
		if(n<=1) {
			return n;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
		
	}
}
