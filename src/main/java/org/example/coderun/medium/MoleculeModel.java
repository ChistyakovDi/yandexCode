package org.example.coderun.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MoleculeModel {

    private static void test() {
        System.out.println("100000 20000");
        // System.out.println("1 2");
        for (int i = 1; i <= 20000; i++) {
            System.out.println((i) + " " + (i+1));
        }
        System.out.println("15000");
        for (int i = 1; i <= 15000; i++) {
            System.out.print(i + " ");
        }

        //System.out.println("1");

    }
    public static void main(String[] args) throws IOException {
        // test();
        //System. exit(0);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //  LocalDateTime from = LocalDateTime.now();

        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);


        // LocalDateTime toooo = LocalDateTime.now();
        // System.out.println(Duration.between(from, toooo).toMillis());

        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        Set<Integer> allNodes2 = new HashSet<>(n);
        Map<Integer, Integer[]> allEdges = new HashMap();
        //LocalDateTime tooooo = LocalDateTime.now();
        // System.out.println("цикл по всем вершинам начало " + Duration.between(from, tooooo).toMillis());
        Map <Integer, Vertex> mapVer = new HashMap<>();
        for (Integer i = 1; i <= n; i++) {
            allNodes2.add(i);
            graph.put(i, new ArrayList<>());
            mapVer.put(i, new Vertex(i, 0));
        }
        // LocalDateTime tooo = LocalDateTime.now();
        //  System.out.println("цикл по ребрам начало " + Duration.between(from, tooo).toMillis());
        // Set<Integer> allNodes2 = new HashSet<>(allNodes);
        for (int i = 0; i < m; i++) {
            parts = reader.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            Integer[] e = new Integer[] {x, y};
            List<Integer> currentEdgeList = graph.get(x);
            currentEdgeList.add(y);
            if (x != y) {
                currentEdgeList = graph.get(y);
                currentEdgeList.add(x);
            }
            allEdges.put(i + 1, e);
        }
        // LocalDateTime too = LocalDateTime.now();
        // System.out.println("цикл по ребрам конец " + Duration.between(from, too).toMillis());

        // Map <Integer, Set<Integer>> mapAreas = new HashMap<>();

        //  Set<Integer> curAreaX = null;
        //  Set<Integer> curAreaY = null;
        int ar = 0;
        for (Integer key: allEdges.keySet()) {
            Integer[] e = allEdges.get(key);
            Integer x = e[0];
            Integer y = e[1];
            Vertex vx = mapVer.get(x);
            Vertex vy = mapVer.get(y);
            //////////////////////////////////////

            if (allNodes2.contains(x) && allNodes2.contains(y)) {
                ar++;
                vx.group = ar;
                vy.group = ar;
            } else if (!Objects.equals(vx.group, vy.group) && vx.group != 0 && vy.group != 0) {
                ar--;
                vx.group = vy.group;
                for (Integer k : mapVer.keySet()) {
                    Vertex v = mapVer.get(k);
                    if (Objects.equals(v.group, vx.group)) {
                        v.group = vy.group;
                    }
                }
            } else {
                if (allNodes2.contains(x)) {
                    vx.group = vy.group;
                }
                if (allNodes2.contains(y)) {
                    vy.group = vx.group;
                }
            }
            allNodes2.remove(x);
            allNodes2.remove(y);

            /////////////////////////////////////////
//            curAreaX = mapAreas.get(x);
//            curAreaY = mapAreas.get(y);
//            allNodes2.remove(x);
//            allNodes2.remove(y);
//            if (curAreaX == null && curAreaY == null) {
//                Set curArea = new HashSet<>();
//                curArea.add(x);
//                curArea.add(y);
//                mapAreas.put(x, curArea);
//                mapAreas.put(y, curArea);
//                ar++;
//            } else if (curAreaX != null && curAreaY == null) {
//                curAreaX.add(y);
//                mapAreas.put(y, curAreaX);
//            } else if (curAreaX == null) {
//                curAreaY.add(x);
//                mapAreas.put(x, curAreaY);
//            } else if (curAreaX != curAreaY) {
//                if (curAreaX.size() > curAreaY.size()) {
//                    curAreaX.addAll(curAreaY);
//                    for (Integer el: curAreaY) {
//                        mapAreas.put(el, curAreaX);
//                    }
//                } else {
//                    curAreaY.addAll(curAreaX);
//                    for (Integer el: curAreaX) {
//                        mapAreas.put(el, curAreaY);
//                    }
//                }
//                ar--;
//            }
        }
        //int count = getAreas(graph, allNodes);
        //   int count = getAreas2(graph, allNodes);
        int count = ar + allNodes2.size();
        // LocalDateTime to = LocalDateTime.now();
        //  System.out.println("подсчет областей конец " + Duration.between(from, to).toMillis());

        int q = Integer.parseInt(reader.readLine());
        parts = reader.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < q; j++) {
            int i = Integer.parseInt(parts[j]);
            Integer[] ed = allEdges.get(i);
            List<Integer> list = graph.get(ed[0]);
            list.remove(ed[1]);
            if (ed[1] != ed[0]) {
                list = graph.get(ed[1]);
                list.remove(ed[0]);
            }
            if (!isConnectedBFS(graph, ed)) {
                count++;
            }
            sb.append(count);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
        reader.close();
        // to = LocalDateTime.now();
        //System.out.println(Duration.between(from, to).toMillis());
    }
    private static boolean isConnectedBFS(Map<Integer, List<Integer>> graph, Integer[] ed) {
        boolean result = false;
        if (ed[0] == ed[1]) {
            return true;
        }
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.offer(ed[0]);
        boolean found = false;
        Set<Integer> doneVertex = new HashSet<>();
        while (!nodeQueue.isEmpty() && !found) {
            Integer n = nodeQueue.poll();
            doneVertex.add(n);
            List<Integer> currentEdgeList = graph.get(n);
            for (Integer i: currentEdgeList) {
                if (i == ed[1]) {
                    found = true;
                    result = true;
                    break;
                }
                if (!doneVertex.contains(i)) {
                    nodeQueue.offer(i);
                    doneVertex.add(i);
                }
            }
        }
        return result;
    }

    private static int getAreas(Map<Integer, List<Integer>> graph, Set<Integer> allNodes) {
        Stack<Integer> nodeStack = new Stack<>();
        List<Set<Integer>> teams = new ArrayList();
        while (!allNodes.isEmpty()) {
            Set<Integer> tempTeam = new HashSet<>();
            Set<Integer> team = new HashSet<>();
            Iterator<Integer> it = allNodes.iterator();
            Integer startNode = it.next();
            nodeStack.push(startNode);
            allNodes.remove(startNode);
            while (!nodeStack.empty()) {
                boolean end = false;
                List<Integer> currentEdgeList = graph.get(nodeStack.peek());
                tempTeam.add(nodeStack.peek());
                if (currentEdgeList.size() > 0) {
                    boolean hasItem = false;
                    Iterator<Integer> iterator = currentEdgeList.iterator();
                    while (iterator.hasNext()) {
                        Integer n = iterator.next();
                        if (allNodes.contains(n)) {
                            nodeStack.push(n);
                            allNodes.remove(n);
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
        return teams.size();
    }

    private static int getAreas2(Map<Integer, List<Integer>> graph, Set<Integer> allNodes) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        int result = 0;
        while (!allNodes.isEmpty()) {
            Iterator<Integer> it = allNodes.iterator();
            Integer startNode = it.next();
            nodeQueue.offer(startNode);
            allNodes.remove(startNode);
            while (!nodeQueue.isEmpty()) {
                Integer n = nodeQueue.poll();
                allNodes.remove(n);
                List<Integer> currentEdgeList = graph.get(n);
                for (Integer i: currentEdgeList) {
                    if (allNodes.contains(i)) {
                        nodeQueue.offer(i);
                    }
                }
            }
            result++;
        }
        return result;
    }

    private static boolean isConnectedDFS(Map<Integer, List<Integer>> graph, Integer[] ed) {
        boolean result = false;
        if (ed[0] == ed[1]) {
            return true;
        }
        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.add(ed[0]);
        boolean found = false;
        Set<Integer> doneVertex = new HashSet<>();
        while (!nodeStack.isEmpty() && !found) {
            doneVertex.add(nodeStack.peek());
            List<Integer> currentEdgeList = graph.get(nodeStack.peek());
            if (currentEdgeList.size() > 0) {
                Iterator<Integer> iterator = currentEdgeList.iterator();
                boolean hasItem = false;
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    if (next == ed[1]) {
                        found = true;
                        result = true;
                        break;
                    }
                    if (!doneVertex.contains(next)) {
                        nodeStack.add(next);
                        hasItem = true;
                        break;
                    }
                }
                if (!hasItem) {
                    nodeStack.pop();
                }
            } else {
                nodeStack.pop();
            }
        }
        return result;
    }
}

class Vertex {
    public Integer value;
    public Integer group;

    public Vertex(Integer value, Integer group) {
        this.value = value;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex edge = (Vertex) o;
        return value == edge.value && group == edge.group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, group);
    }

}