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

		for (int i = 2; i <= n; i++) {

			if (n % 2 == 0) {
				return n + " nã é primo";
			}

		}
		return n + " é número primo";

	}

	public static String perfeito(int n) {

		int divisor = 0;
		boolean resp = false;
		for (int i = 0; i < n; i++) {

			if (i % 2 == 0) {

				divisor += i;
			}
			if (n == divisor) {

				resp = true;
			}
		}

		if (resp == true) {

			return n + " perfeito";

		} else {

			return n + " não é perfeito";
		}

	}

	public static String palavraPalindromo(String p) {

		StringBuffer palavra = new StringBuffer(p);
		palavra.reverse();

		if (palavra.toString().equals(p)) {

			return p + " é palindromo";

		} else {

			return p + " não é  palindromo";
		}

	}

	public static String frasePalindromo(String p) {
		String original = p;
		String palavra = original.replace(" ", "");
		sb = new StringBuffer(palavra);
		sb.reverse();
		if (sb.toString().equals(palavra)) {

			return p + " é palindromo";
		} else {
			return p + " não é palindromo";
		}

	}

	public static long fibonacci(int n) {
		
		if(n<=1) {
			return n;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
		
	}
}
