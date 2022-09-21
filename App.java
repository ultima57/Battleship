// Вот тебе пулл реквест

public class App {

    public static int[] FindDirection(int[][] a, int shipSize, int posX, int posY) {
        int right = 1;
        int down = 1;
        for (int i = 0; i < shipSize; i++) {
            if ((a[posY][posX + i]) != 0) {
                right = 0;
            }
        }
        for (int i = 0; i < shipSize; i++) {
            if ((a[posY + i][posX]) != 0) {
                down = 0;
            }
        }
        int[] Pos = { right, down };
        return (Pos);
    }

    public static int[][] paint(int[][] a, int shipSize, int direction, int posX, int posY) {

        if (direction == 1) {
            for (int i = 0; i < shipSize; i++) {
                a[posY + i][posX] = 1;
                a[posY + i][posX - 1] = 2;
                a[posY + i][posX + 1] = 2;
            }
            a[posY - 1][posX - 1] = 2;
            a[posY - 1][posX] = 2;
            a[posY - 1][posX + 1] = 2;
            a[posY + shipSize][posX] = 2;
            a[posY + shipSize][posX - 1] = 2;
            a[posY + shipSize][posX + 1] = 2;
        } else {// right{}
            for (int i = 0; i < shipSize; i++) {
                a[posY][posX + i] = 1;
                a[posY - 1][posX + i] = 2;
                a[posY + 1][posX + i] = 2;
            }
            a[posY][posX - 1] = 2;
            a[posY - 1][posX - 1] = 2;
            a[posY + 1][posX - 1] = 2;
            a[posY][posX + shipSize] = 2;
            a[posY - 1][posX + shipSize] = 2;
            a[posY + 1][posX + shipSize] = 2;
        }
        return (a);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("press 1 to 1st task ");
        System.out.println("press 2 to 2nd task ");
        System.out.println("press 3 to 3d task ");
        System.out.println("press 4 to 4th task ");

        int[][] a = new int[16][16];
        for (int i1 = 0; i1 < 16; i1++) {
            for (int j1 = 0; j1 < 16; j1++) {
                if (i1 < 3 || i1 > 12 || j1 < 3 || j1 > 12) {
                    ;
                    a[i1][j1] = 2;
                }
            }
        }
        int[] amountOfShipReq = { 0, 4, 3, 2, 1 };
        int[] amountOfShip = { 0, 0, 0, 0, 0 };
        int i, j;
        int[] pos = new int[2];
        for (int k = 4; k > 0; k--) {
            int directionMain = 0;
            while (amountOfShip[k] < amountOfShipReq[k]) {
                i = (int) Math.round((Math.random()) * 9) + 3;
                j = (int) Math.round((Math.random()) * 9) + 3;
                pos = App.FindDirection(a, k, j, i);
                if ((pos[0] + pos[1]) > 0) {
                    amountOfShip[k]++;
                    if (pos[0] * pos[1] == 1) {
                        directionMain = ((int) Math.round((Math.random()) * 10)) % 2;
                    } else if (pos[0] == 1) {
                        directionMain = 0;
                    } else {
                        directionMain = 1;
                    }
                    a = App.paint(a, k, directionMain, j, i);
                }
            }
        }
        for (int i1 = 3; i1 < 13; i1++) {
            for (int j1 = 3; j1 < 13; j1++) {
                if (a[i1][j1] == 2) {
                    a[i1][j1] = 0;
                }
                System.out.print(a[i1][j1] + " ");
            }
            System.out.println();
        }
    }
}
