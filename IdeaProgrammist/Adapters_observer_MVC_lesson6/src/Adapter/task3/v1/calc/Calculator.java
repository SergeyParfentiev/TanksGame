package Adapter.task3.v1.calc;

public class Calculator {

	public int summa(int a, int b) {
		return Arifmetika.summa(new int[] {a, b});
	}

	public int multiply(int a, int b) {
		return Arifmetika.multiply(a, b);
	}
}
