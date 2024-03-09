package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P01MathOperation;

public class MathOperation {

    public int add(int a, int b) {
        return this.add(new int[]{a, b});
    }

    public int add(int a, int b, int c) {
        return this.add(new int[]{a, b, c});
    }

    public int add(int a, int b, int c, int d) {
        return this.add(new int[]{a, b, c, d});    }

    public int add(int... num) {
        int res = 0;
        for (int i : num) {
            res += i;
        }
        return res;
    }
}
