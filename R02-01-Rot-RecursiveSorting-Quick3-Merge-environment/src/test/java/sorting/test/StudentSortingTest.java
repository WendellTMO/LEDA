package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
										//    0    1  2   3   4   5  6   7  8   9
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new QuickSortMedianOfThree<>();
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	public void testPartialSort01() {
		Integer[] array = new Integer[] {30, 28, 7, 4, 11, 26, 29, 22, 23, 31};
		Integer[] copyArray = Arrays.copyOf(vetorTamPar, vetorTamPar.length);
		implementation.sort(copyArray, 3, 6);
		Assert.assertArrayEquals(copyArray, array);
	}

	@Test
	public void testPartialSort02() {
		Integer[] array = new Integer[] {6, 41, 32, 7, 26, 4, 11, 18, 37, 49, 36};
		Integer[] copyArray = Arrays.copyOf(vetorTamImpar, vetorTamImpar.length);
		implementation.sort(copyArray, 6, 9);
		Assert.assertArrayEquals(copyArray, array);
	}

	@Test
	public void testPartialSort03() {
		Integer[] array = new Integer[] {4, 9, 3, 0, 1, 4, 4, 5};
		Integer[] copyArray = Arrays.copyOf(vetorValoresRepetidos, vetorValoresRepetidos.length);
		implementation.sort(copyArray, 3, 7);
		Assert.assertArrayEquals(copyArray, array);
	}


	@Test
	public void testPartialSort04() {
		//								  0  1  2  3  4  5  6  7  8  9
		Integer[] array = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		implementation.sort(array, 5, array.length - 1);
		Assert.assertArrayEquals(array, new Integer[] {10, 9, 8, 7, 6, 1, 2, 3, 4, 5});
		implementation.sort(array, 0, 4);
		Assert.assertArrayEquals(array, new Integer[] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5});
		
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}

	@Test
	public void testIndexOutOfBounds01() {		
		Integer[] array = new Integer[] {5, 4, 3, 2, 1};
		implementation.sort(array, 0, 6);
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		
		Assert.assertArrayEquals(array, copyArray);
	}

	@Test
	public void testIndexOutOfBounds02() {		
		Integer[] array = new Integer[] {5, 4, 3, 2, 1};
		implementation.sort(array, -1, 4);
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		
		Assert.assertArrayEquals(array, copyArray);
	}

	@Test
	public void testIndexOutOfBounds03() {		
		Integer[] array = new Integer[] {5, 4, 3, 2, 1};
		implementation.sort(array, 2, 2);
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		
		Assert.assertArrayEquals(array, copyArray);
	}

	@Test
	public void testIndexOutOfBounds04() {		
		Integer[] array = new Integer[] {5, 4, 3, 2, 1};
		implementation.sort(array, 4, 0);
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		
		Assert.assertArrayEquals(array, copyArray);
	}

	@Test
	public void extraCase01() {
		Integer[] array = new Integer[] {4, 4, 4, 5};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}

	@Test
	public void extraCase02() {
		Integer[] array = new Integer[] {1, 0};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}
	
	@Test
	public void extraCase03() {
		Integer[] array = new Integer[] {1};
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array, new Integer[] {1});
	}

	@Test
	public void extraCase04() {
		Integer[] array = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}

	@Test
	public void extraCase05() {
		Integer[] array = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}

	@Test
	public void extraCase06() {
		Integer[] array = new Integer[] {10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}


	@Test
	public void extraCase07() {
		Integer[] array = new Integer[] {10, 10, 10, 10, 10, 10, 10, 10, 0};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}

	@Test
	public void extraCase08() {
		Integer[] array = new Integer[] {1, 2, 3, 200, 4, 5, 200};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}

	@Test
	public void extraCase09() {
		Integer[] array = new Integer[] {1, 2, 200, 4, 5, 200};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}

	@Test
	public void extraCase10() {
		Integer[] array = new Integer[] {0, 200, 300, 400, 0, 500};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}

	@Test
	public void extraCase11() {
		Integer[] array = new Integer[] {0, 2, 3, 4, 5, 6, 0};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}

	// Extra Case Victor Edition 
	@Test
	public void extraCase12() {
		Integer[] array = new Integer[] {3, 5, 7, 2, 7, 8, 1};
		Integer[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		implementation.sort(array, 0, array.length - 1);
		Assert.assertArrayEquals(array,copyArray);
	}


	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}