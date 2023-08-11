package recursao;
import java.util.*;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		// ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY
		if (array == null || array.length == 0) return result;

		if (array.length == 1) {
			result = array[0];

		} else {
			int copiedArray[] = new int[array.length-1];
			System.arraycopy(array, 0, copiedArray, 0, copiedArray.length);
			copiedArray[copiedArray.length-1] = array[copiedArray.length] + array[copiedArray.length - 1];

			result = calcularSomaArray(copiedArray);
		}

		return result;
	}


	public long calcularFatorial(int n) {
		long result = 1;
		// ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS

		if (n == 0) {
			result = 1;

		} else {
			
			result = n * calcularFatorial(n - 1);
		}
		System.out.println(n + "! = " + result);

		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS
		
		if (n == 0 ) {
			return 0;
		}
		if (n == 1 || n == 2) {

			return 1;
			
		}

		result = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);

		return result;
	}


	public int countNotNull(Object[] array) {
		int result = 0;
		// IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		
		result = countNotNullRec(array, 0);

		return result;
	}

	private int countNotNullRec(Object[] array, int length) {

		if (array.length == length) {
			return 0;
		}

		if (array[length] == null) return countNotNullRec(array, length + 1) + 1;
		return countNotNullRec(array, length + 1);
		
	}


	public long potenciaDe2(int expoente) {
		long result = 1;
		// IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2

		if (expoente > 0) {
			result = 2 * potenciaDe2(expoente - 1);
		}

		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		// IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO

		if (n == 1) return termoInicial;
		
		result = progressaoAritmetica(termoInicial, razao, n - 1) + razao;

		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		// IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO

		if (n == 1) return termoInicial;

		result = progressaoGeometrica(termoInicial, razao, n - 1) * razao;

		return result;
	}
	
	
}
