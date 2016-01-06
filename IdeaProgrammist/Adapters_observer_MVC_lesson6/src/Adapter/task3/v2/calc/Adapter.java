package Adapter.task3.v2.calc;

/**
 * Created by Byblik272 on 6/1/2016.
 */
public class Adapter implements Calculator{

    private Arifmetika arifmetika;

    public Adapter() {
        arifmetika = new Arifmetika();
    }

    @Override
    public int multiply(int a, int b) {
        int multiply = a;
        for(int i = 0; i < b; i++) {
           multiply = arifmetika.summa(new int[]{a, a});
        }
        return multiply;
    }

    @Override
    public int summa(int a, int b) {
        return arifmetika.summa(new int[] {a, b});
    }
}
