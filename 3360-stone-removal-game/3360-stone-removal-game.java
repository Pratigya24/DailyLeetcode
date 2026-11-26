class Solution {
    public boolean canAliceWin(int n) {
        int total = 0, moves = 0;

        for (int remove = 10; remove >= 1; remove--) {
            total += remove;
            if (total > n) break;
            moves++;
        }

        return moves % 2 == 1;
    }
}