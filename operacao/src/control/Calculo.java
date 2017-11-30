package control;

import functional.ICalculoUmLong;
import functional.ICalculoUmParamString;
import functional.ICalculoUmString;

public class Calculo {

	
	
	
	public static ICalculoUmLong fatorial = (a) -> new Operacoes().fatorial(a);
	public static ICalculoUmString primo = (a) -> new Operacoes().primo(a);
	public static ICalculoUmString perfeito = (a) -> new Operacoes().perfeito(a);
	public static ICalculoUmLong fibonacci = (a) -> new Operacoes().fibonacci(a);
	public static  ICalculoUmParamString palavraPalindromo = (a) -> new Operacoes().palavraPalindromo(a);
	public static ICalculoUmParamString frasePalindromo = (a) -> Operacoes.frasePalindromo(a); 
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("fatorial = " + Calculo.fatorial.operacao(5));
		System.out.println(Calculo.primo.operacao(17));
		System.out.println(Calculo.perfeito.operacao(6));
		System.out.println("fibonacci = " + Calculo.fibonacci.operacao(9));
		System.out.println(Calculo.palavraPalindromo.operacao("arara"));
		System.out.println(Calculo.frasePalindromo.operacao("luz azul"));
		
	}
	
	

}
