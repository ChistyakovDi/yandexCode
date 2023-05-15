package org.example.lineSearch.gameIrland2Array;

/*
По ландшафту острова определите, сколько блоков воды осталось после дождя в низинах на острове
(остров игрока представляет собой набор столбцов расличной высоты,сотоящих из блоков камня и окруженный морем.
Над островом прошёл сильный дождь, который заполнил водой все низины, а не поместившася в них вода
стелка в море,не увелив его уровень)
 */

public class Game_PitCraft {
    public static void main(String[] args) {

        int[] arr = new int[]{3, 1, 4, 3, 5, 1, 1, 3, 1};
        System.out.println(solution(arr));

    }

    public static int solution(int[] h) {

        int maxPosition = 0;
        for (int i = 0; i < h.length; i++) {
            if (h[i] > h[maxPosition]) {
                maxPosition = i;
            }
        }
        int answer = 0;
        int nowMax = 0;

        for (int i = 0; i < maxPosition; i++) {
            if (h[i] > nowMax) {
                nowMax = h[i];
            }
            answer += nowMax - h[i];
        }
        nowMax = 0;

        for (int i = h.length - 1; i > maxPosition; i--) {
            if (h[i] > nowMax) {
                nowMax = h[i];
            }
            answer += nowMax - h[i];
        }
        return answer;
    }
}



//    def solution(h):
//        maxpos = 0
//        for i in range(lenCh)):
//        if h[i] > h[maxpos]:
//        maxpos = 1
//        ans = 0
//        nowm = O
//        for i in range(maxpos):
//        if h[1] > novm:
//        nowm = h[i]
//        ans += howm - h[i]
//        nowm = 0
//        for i in range(len(h) - 1, maxpos, -1):
//        1f h[i] > novm
//        nowm = h[i]
//        ans += nowm - h[i]
//        return ans