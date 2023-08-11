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

		 System.out.println(m.calcularFatorial(12));

		 System.out.println(m.calcularFatorial(5));

		System.out.println(m.calcularFibonacci(6));
		
		Object[] ar2 = {1,2,null,4,null,6,7,8,9};
		Object[] bu2 = {1, null};
		Object[] xa2 = {null};
		Object[] bla2 = {};

		System.out.println(m.countNotNull(bla2));

		 System.out.println(m.potenciaDe2(0));
		 System.out.println(m.potenciaDe2(1));
		 System.out.println(m.potenciaDe2(2));
		 System.out.println(m.potenciaDe2(3));
		 System.out.println(m.potenciaDe2(4));
		 System.out.println(m.potenciaDe2(5));
		 System.out.println(m.potenciaDe2(6));

		System.out.println(m.progressaoAritmetica(4, 8, 5));

		System.out.println(m.progressaoGeometrica(4, 3, 5));



	}
}
