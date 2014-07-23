package br.primos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class Main {


	public static void main(String args[]){
		List<Integer> numeros = preencherLista(1000);
		List<Integer> crivos = preencherLista(Math.floor(Math.sqrt(1000)));
		List<Integer> primos = recuperarPrimos(numeros,crivos);
		List<Integer> palidromos = recuperarPalindromos(primos);

//		System.out.println(primos);
//		System.out.println(palidromos);
		
		System.out.println(palidromos.get(palidromos.size()-1));

	}

	private static List<Integer> recuperarPalindromos(List<Integer> primos) {
		List<Integer> palindromos = new ArrayList<Integer>();
		
		for(Integer primo:primos){
		 String num = primo.toString(),
				 numAux="";
		 if (num.length() <2)
			 continue;
		 char [] carac = num.toCharArray();
		 for(int cont= carac.length-1; cont >= 0;cont--){
			 numAux += carac[cont];
		 }
		 if(num.equals(numAux))
			 palindromos.add(primo);
		 
			
		}
		
		return palindromos;
	}

	/**
	 * @param crivos 
	 * @param primos
	 */
	private static List<Integer> recuperarPrimos(final List<Integer> numeros, List<Integer> crivos) {
		List<Integer> 	naoPrimos = new ArrayList<Integer>();
		Iterator<Integer> iter = numeros.iterator();
		Iterator<Integer> iterCrivos = crivos.iterator();	

		int divisor = iterCrivos.next();
		if(!iterCrivos.hasNext() )
			return numeros;

		if(divisor == 1){
			iterCrivos.remove();
			divisor = iterCrivos.next();
		}
		
		crivos = atualizarCrivos(iterCrivos);
		
		List<Integer> primos = new ArrayList<Integer>();

		while(iter.hasNext()){
			int d = iter.next();
			if(d==1){
				iter.remove();
				continue;
			}else if (d == 2 || d ==3 || d==5 || d==7 || d==11){
				primos.add(d);
				continue;
			}
			if((d % divisor) != 0){
				primos.add(d);	
			}else {
				naoPrimos.add(d);
				iter.remove();
			}
		}


		crivos.removeAll(naoPrimos);
		
		return recuperarPrimos(primos, crivos);
	}

	private static List<Integer> atualizarCrivos(Iterator<Integer> iterCrivos) {
		List<Integer> copia = new ArrayList<Integer>();
		while(iterCrivos.hasNext()){
			copia.add(iterCrivos.next());
		}
		return copia;
	}

	private static List<Integer> preencherLista(Number maximo){
		List<Integer> numerosNaturais = new ArrayList<Integer>();
		for(int count=1;count<=maximo.intValue();count++){
			numerosNaturais.add(count);
		}
		return numerosNaturais;
	}
}
