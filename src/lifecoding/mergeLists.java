package lifecoding;

public class mergeLists {
    public int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;

        int[] res = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }

        while (i < a.length) {
            res[k++] = a[i++];
        }

        while (j < b.length) {
            res[k++] = b[j++];
        }

        return res;
    }
}
