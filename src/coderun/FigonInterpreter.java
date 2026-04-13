package coderun;

import java.util.*;
//10
public class FigonInterpreter {

    static class ListObj {
        List<Integer> data;
        int l, r;
        boolean canAdd;

        ListObj(List<Integer> data, int l, int r, boolean canAdd) {
            this.data = data;
            this.l = l;
            this.r = r;
            this.canAdd = canAdd;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, ListObj> map = new HashMap<>();

        while (n-- > 0) {
            String line = sc.nextLine();

            if (line.contains("new List")) {
                // List a = new List(1,2,3)
                String name = line.substring(5, line.indexOf('=') - 1);

                String inside = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
                List<Integer> data = new ArrayList<>();

                if (!inside.isEmpty()) {
                    for (String s : inside.split(",")) {
                        data.add(Integer.parseInt(s));
                    }
                }

                map.put(name, new ListObj(data, 0, data.size() - 1, true));
            }

            else if (line.contains("subList")) {
                // List b = a.subList(1,3)
                String name = line.substring(5, line.indexOf('=') - 1);

                String rest = line.substring(line.indexOf('=') + 2);
                String parent = rest.substring(0, rest.indexOf('.'));

                String inside = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
                String[] parts = inside.split(",");

                int from = Integer.parseInt(parts[0]);
                int to = Integer.parseInt(parts[1]);

                ListObj p = map.get(parent);

                map.put(name, new ListObj(
                        p.data,
                        p.l + from,
                        p.l + to,
                        false
                ));
            }

            else if (line.contains(".set")) {
                String name = line.substring(0, line.indexOf('.'));
                String inside = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
                String[] parts = inside.split(",");

                int i = Integer.parseInt(parts[0]);
                int x = Integer.parseInt(parts[1]);

                ListObj obj = map.get(name);
                obj.data.set(obj.l + i, x);
            }

            else if (line.contains(".add")) {
                String name = line.substring(0, line.indexOf('.'));
                int x = Integer.parseInt(
                        line.substring(line.indexOf('(') + 1, line.indexOf(')'))
                );

                ListObj obj = map.get(name);
                obj.data.add(x);
                obj.r++;
            }

            else if (line.contains(".get")) {
                String name = line.substring(0, line.indexOf('.'));
                int i = Integer.parseInt(
                        line.substring(line.indexOf('(') + 1, line.indexOf(')'))
                );

                ListObj obj = map.get(name);
                System.out.println(obj.data.get(obj.l + i));
            }
        }
    }
}