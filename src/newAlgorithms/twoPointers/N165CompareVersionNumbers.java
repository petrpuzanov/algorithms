package newAlgorithms.twoPointers;

public class N165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");

        for (int i = 0; i < Math.max(vs1.length, vs2.length); i++) {
            StringBuilder s1 = new StringBuilder(i < vs1.length ? vs1[i] : "0");
            StringBuilder s2 = new StringBuilder(i < vs2.length ? vs2[i] : "0");

            while (s1.length() > 0 && s1.toString().charAt(0) == '0') {
                s1.deleteCharAt(0);
            }

            while (s2.length() > 0 && s2.toString().charAt(0) == '0') {
                s2.deleteCharAt(0);
            }

            int num1 = s1.length() == 0 ? 0 : Integer.parseInt(s1.toString());
            int num2 = s2.length() == 0 ? 0 : Integer.parseInt(s2.toString());

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
