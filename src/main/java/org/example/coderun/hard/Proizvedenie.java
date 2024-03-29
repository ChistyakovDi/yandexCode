package org.example.coderun.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Proizvedenie {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // размер массива А
        int m = Integer.parseInt(input[1]); // произведение
        int k = Integer.parseInt(input[2]); // количество выбираемых элементов

        String[] numbersStr = reader.readLine().split(" ");
        List<Point> array = new ArrayList<>(n);
        List<Point> arrayCorrect = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            Integer cur = Integer.parseInt(numbersStr[i]);
            Point p = new Point(i, cur);
            array.add(p);
            if (cur == 0 && m != 0) {
                continue;
            }
            if (cur == 0) {
                if (m == 0) {
                    arrayCorrect.add(p);
                }
            } else if (m % cur == 0) {
                arrayCorrect.add(p);
            }
        }
        reader.close();

        String res = solve(array, arrayCorrect, k, m);
        System.out.println(res);
    }

    private static String solve(List<Point> array, List<Point> arrayCorrect, int k, int m) {
        Collections.sort(arrayCorrect, Collections.reverseOrder());
        StringBuilder result = new StringBuilder(k);
        if (m == 0) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).value == 0) {
                    result.append(i + 1);
                    result.append(" ");
                    k--;
                    for (int j = 0; j < array.size(); j++) {
                        if (i == j) continue;
                        if (k == 0) break;
                        result.append(j + 1);
                        result.append(" ");
                        k--;
                    }
                    return result.toString().trim();
                }
            }
        }
        if (m == 1) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).value == 1) {
                    result.append(i + 1);
                    result.append(" ");
                    k--;
                    if (k <= 0) break;
                }
            }
            return result.toString().trim();
        }

        Deque<Integer> indexStack = new ArrayDeque<>();
        Deque<Point> st = new ArrayDeque<>();
        int lastBad = 0;
        int end = arrayCorrect.size() - 1;
        int rest = m;
        Map<Integer, Integer> indexOfNextValue = new HashMap<>(end);
        Integer indexOfOne = -1;
        int amountOfOne = 0;
        Integer prev = -1;

        for (int i = 0; i <= end; ++i) {
            Point p = arrayCorrect.get(i);
            Integer cur = p.value;
            if (cur != prev && prev != -1) {
                indexOfNextValue.put(prev, i);
            }
            if (cur == 1 && indexOfOne == -1) {
                indexOfOne = i;
                amountOfOne = end - i + 1;
            }
            prev = cur;
        }

        for (int i = 0; i <= end; ++i) {
            Point p = arrayCorrect.get(i);
            Integer cur = p.value;
            if (rest == 1) {
                if (indexOfOne == -1) {
                    rest = rest * st.peekLast().value;
                    lastBad = st.pollLast().value;
                    i = indexStack.pollLast();
                    continue;
                } else {
                    if (i < (indexOfOne - 1)) {
                        int need = k - st.size();
                        if (need <= amountOfOne) {
                            for (int j = indexOfOne; j < indexOfOne + need; j++) {
                                Point pp = arrayCorrect.get(j);
                                st.offerLast(pp);
                            }
                            break;
                        } else {
                            rest = rest * st.peekLast().value;
                            lastBad = st.pollLast().value;
                            i = indexStack.pollLast();
                        }
                        continue;
                    }
                }
            }
            if (lastBad == cur) {
                Integer in = indexOfNextValue.get(cur);
                if (in == null) {
                    rest = rest * st.peekLast().value;
                    lastBad = st.pollLast().value;
                    i = indexStack.pollLast();
                } else {
                    i = in - 1;
                }
                continue;
            }
            if (cur > rest || (rest % cur != 0)) {
                lastBad = cur;
                if (i == end) {
                    while (i >= (end - 1)) {
                        lastBad = st.pollLast().value;
                        rest *= lastBad;
                        i = indexStack.pollLast();
                    }
                }
                continue;
            }
            rest = rest / cur;
            st.offerLast(p);
            indexStack.offerLast(i);
            if (st.size() == k && rest == 1) {
                break;
            }
            if (i == end) {
                while (i >= (end - 1)) {
                    lastBad = st.pollLast().value;
                    rest *= lastBad;
                    i = indexStack.pollLast();
                }
            }
        }

        for (Point point : st) {
            result.append(point.index + 1);
            result.append(" ");
        }
        return result.toString().trim();
    }
}

class Point implements Comparable<Point> {
    public Integer index;
    public Integer value;

    public Point(Integer index, Integer value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, value);
    }

    @Override
    public int compareTo(Point o) {
        return value.compareTo(o.value);
    }
}


//https://skr.sh/sJxOtt5vc1r
//Пример 1
//Ввод
//7 27 2
//9 1 1 27 3 27 3
//Вывод
//4 2
//Пример 2
//Ввод
//7 60 4
//30 1 1 3 10 6 4
//Вывод
//5 6 3 2