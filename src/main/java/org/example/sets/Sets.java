package org.example.sets;

import java.util.ArrayList;

public class Sets{
    static int setSize = 10;
    static ArrayList<Integer>[] myset = new ArrayList[setSize];

    public static void main(String[] args) {
        // Initialize each element of the array to a new empty ArrayList
        for(int i = 0; i < setSize; i++) {
            myset[i] = new ArrayList<Integer>();
        }

        // Test the add method
        add(5);
        add(15);
        add(25);
        add(35);
        System.out.println("myset[5] = " + myset[5]); // [5, 15, 25, 35]

        // Test the find method
        System.out.println("find(15) = " + find(15)); // true
        System.out.println("find(20) = " + find(20)); // false

        // Test the delete method
        delete(15);
        System.out.println("myset[5] = " + myset[5]); // [5, 35]
    }

    public static void add(int x) {
        myset[x % setSize].add(x);
    }

    public static boolean find(int x) {
        for(int now : myset[x % setSize]) {
            if(now == x) {
                return true;
            }
        }
        return false;
    }

    public static void delete(int x) {
        ArrayList<Integer> xList = myset[x % setSize];
        for(int i = 0; i < xList.size(); i++) {
            if(xList.get(i) == x) {
                xList.set(i, xList.get(xList.size() - 1));
            }
        }
        xList.remove(xList.size() - 1);
    }
}



//        setsize = 10
//        myset = [[] for _ in range(setsize)]

//        def add(x):
//        myset[x % setsize].append(x)
//
//        def find(x):
//        for now in myset[x % setsize]:
//        if now == x:
//        return True
//        return False
//
//        def delete(x):
//        xlist = myset[x % setsize]
//        for i in range(len(xlist)):
//        it xlist[i] == x:
//                xlist[i] = xlist[len(xlist) - 1]
//        xlist.pop()
//        return