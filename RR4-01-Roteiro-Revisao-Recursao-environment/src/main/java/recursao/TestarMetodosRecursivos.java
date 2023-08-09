package recursao;

public class TestarMetodosRecursivos {
	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe MetodosRecursivos.
		
		// TODO Formalizar bonitinhos os testes do JUNIT
		MetodosRecursivos m = new MetodosRecursivos();
		
		int[] ar = {1,2,3,4,5,6,7,8,9};
		int[] bu = {1, 2};
		int[] xa = {1};
		int[] bla = {};
		System.out.println(m.calcularSomaArray(ar) + " " + m.calcularSomaArray(bu) + " " + m.calcularSomaArray(xa) + " " + m.calcularSomaArray(bla));

		//System.out.println(m.calcularFatorial(12));

		//System.out.println(m.calcularFatorial(5));



	}
}
