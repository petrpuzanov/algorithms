package lifecoding;

import java.util.*;

public class AtmService {
        public static class InsufficientFundsException extends RuntimeException {
            public InsufficientFundsException(String message) {
                super(message);
            }
        }

        /**
         * inventory: номинал -> количество купюр
         */
        public void withdraw(int amount, Map<Integer, Integer> inventory) {
            List<Integer> denominations = new ArrayList<>(inventory.keySet());
            denominations.
            denominations.sort(Collections.reverseOrder());

            Map<Integer, Integer> used = new HashMap<>();

            boolean success = dfs(amount, 0, denominations, inventory, used);

            if (!success) {
                throw new InsufficientFundsException("Cannot dispense requested amount: " + amount);
            }

            // применяем изменения только после успеха
            for (Map.Entry<Integer, Integer> e : used.entrySet()) {
                int denom = e.getKey();
                int cnt = e.getValue();
                inventory.put(denom, inventory.get(denom) - cnt);
            }
        }

        private boolean dfs(int remaining,
                            int index,
                            List<Integer> denoms,
                            Map<Integer, Integer> inventory,
                            Map<Integer, Integer> used) {

            if (remaining == 0) {
                return true;
            }

            if (index >= denoms.size()) {
                return false;
            }

            int denom = denoms.get(index);
            int maxAvailable = inventory.get(denom);

            int maxUse = Math.min(remaining / denom, maxAvailable);

            for (int cnt = maxUse; cnt >= 0; cnt--) {
                if (cnt > 0) {
                    used.put(denom, cnt);
                } else {
                    used.remove(denom);
                }

                if (dfs(remaining - cnt * denom, index + 1, denoms, inventory, used)) {
                    return true;
                }
            }

            used.remove(denom);
            return false;
        }

        // пример
        public static void main(String[] args) {
            AtmService atm = new AtmService();

            Map<Integer, Integer> inventory = new HashMap<>();
            inventory.put(100, 2);
            inventory.put(50, 1);
            inventory.put(20, 3);
            inventory.put(10, 5);

            atm.withdraw(180, inventory);

            System.out.println(inventory);
        }
}
