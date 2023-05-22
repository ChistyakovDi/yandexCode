package org.example.coderun.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Teambuilding_222 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]); // nodes
        int m = Integer.parseInt(parts[1]); // edges

        if (n * (n - 1) / 2 == m) {
            System.out.println(1);
            System.out.println(1);
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(i);
            }
            System.out.println(sb);
            return;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>(n);
        Set<Integer> allNodes = new HashSet<>(n);
        for (Integer i = 1; i <= n; i++) {
            allNodes.add(i);
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            parts = reader.readLine().split(" ");
            Integer node1 = Integer.parseInt(parts[0]);
            Integer node2 = Integer.parseInt(parts[1]);
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        if ((m == 0 && n != 2) || !solve(graph, allNodes)) {
            System.out.println(-1);
        }
        reader.close();
    }

    private static boolean solve(Map<Integer, Set<Integer>> graph, Set<Integer> allNodes) {
        Stack<Integer> nodeStack = new Stack<>();
        List<HashSet<Integer>> teams = new ArrayList();
        while (!allNodes.isEmpty()) {
            Set<Integer> tempTeam = new HashSet<>();
            Set<Integer> team = new HashSet<>();
            Iterator<Integer> it = allNodes.iterator();
            Integer startNode = it.next();

            nodeStack.push(startNode);
            allNodes.remove(startNode);
            while (!nodeStack.empty()) {

                boolean end = false;
                Set<Integer> currentEdgeList = graph.get(nodeStack.peek());
                tempTeam.add(nodeStack.peek());

                if (currentEdgeList.size() > 0) {
                    boolean hasItem = false;
                    Iterator<Integer> iterator = currentEdgeList.iterator();
                    while (iterator.hasNext()) {
                        Integer next = iterator.next();
                        if (allNodes.contains(next)) {
                            if (!contains(graph.get(next), tempTeam)) {
                                continue;
                            }
                            nodeStack.push(next);
                            allNodes.remove(next);
                            hasItem = true;
                            break;
                        }
                    }
                    end = !hasItem;
                } else {
                    end = true;
                }
                if (end) {
                    team.add(nodeStack.pop());
                }
            }
            teams.add((HashSet<Integer>) team);
        }
        if (teams.size() != 2) {
            return false;
        }
        System.out.println(teams.get(0).size());
        for (Set<Integer> t : teams) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : t) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(i);
            }
            System.out.println(sb.toString());
        }
        return true;
    }

    private static boolean contains(Set<Integer> where, Set<Integer> what) {
        Iterator<Integer> iterator = what.iterator();
        while (iterator.hasNext()) {
            if (!where.contains(iterator.next())) return false;
        }
        return true;
    }
}

//https://skr.sh/sJxtGOb6gX4
//Пример 1
//Ввод
//3 1
//1 2
//Вывод
//2
//1 2
//3
//Пример 2
//Ввод
//3 0
//Вывод
//-1