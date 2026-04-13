package coderun;

public class NewTrafficRules {
//9
    public static long solve(long x, long y, long f, long g) {
        long dx = Math.abs(f - x);
        long dy = Math.abs(g - y);

        if (dx == 0 && dy == 0) return 0;

        if (dx == 0) return 2 * dy - 1;
        if (dy == 0) return 2 * dx - 1;

        return 2 * Math.max(dx, dy);
    }
}