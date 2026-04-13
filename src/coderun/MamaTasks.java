package coderun;
//2
public class MamaTasks {

    public static double minTime(int a, int b, int c, int v0, int v1, int v2) {

        double res = Double.MAX_VALUE;

        // 1. H -> S -> P -> H
        res = Math.min(res,
                (double)a / v0 + (double)c / v1 + (double)b / v2);

        // 2. H -> P -> S -> H
        res = Math.min(res,
                (double)b / v0 + (double)c / v1 + (double)a / v2);

        // 3. H -> S -> H -> P -> H
        res = Math.min(res,
                (double)a / v0 + (double)a / v1 +
                (double)b / v0 + (double)b / v1);

        // 4. H -> P -> H -> S -> H
        res = Math.min(res,
                (double)b / v0 + (double)b / v1 +
                (double)a / v0 + (double)a / v1);

        // 5. H -> P -> S -> P -> H
        res = Math.min(res,
                (double)b / v0 + (double)c / v1 +
                (double)c / v2 + (double)b / v2);

        // 6. H -> S -> P -> S -> H
        res = Math.min(res,
                (double)a / v0 + (double)c / v1 +
                (double)c / v2 + (double)a / v2);

        return res;
    }
}