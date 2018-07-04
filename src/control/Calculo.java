package control;

import iFunctional.ICalculoUmLong;
import iFunctional.ICalculoUmParamString;
import iFunctional.ICalculoUmString;

public class Calculo {

	
	
	
	public static ICalculoUmLong fatorial = (a) -> new Operacoes().fatorial(a);
	public static ICalculoUmString primo = (a) -> new Operacoes().primo(a);
	public static ICalculoUmString perfeito = (a) -> new Operacoes().perfeito(a);
	public static ICalculoUmLong fibonacci = (a) -> new Operacoes().fibonacci(a);
	public static  ICalculoUmParamString palavraPalindromo = (a) -> new Operacoes().palavraPalindromo(a);
	public static ICalculoUmParamString frasePalindromo = (a) -> Operacoes.frasePalindromo(a); 
	
}
