

import java.util.Scanner;

public class Main {

    static void printGrid(char[] array_ch) {
        int k = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array_ch[k + j] + " ");
            }
            k += 3;
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static boolean checkGrid(char[] array_ch) {
        boolean[] comb = new boolean[8];
        //определяем наличие три в ряд
        comb[0] = array_ch[0] == array_ch[1] && array_ch[1] == array_ch[2] && (array_ch[0] == 'X' || array_ch[0] == 'O');
        comb[1] = array_ch[3] == array_ch[4] && array_ch[4] == array_ch[5] && (array_ch[3] == 'X' || array_ch[3] == 'O');
        comb[2] = array_ch[6] == array_ch[7] && array_ch[7] == array_ch[8] && (array_ch[6] == 'X' || array_ch[6] == 'O');
        comb[3] = array_ch[0] == array_ch[3] && array_ch[3] == array_ch[6] && (array_ch[0] == 'X' || array_ch[0] == 'O');
        comb[4] = array_ch[1] == array_ch[4] && array_ch[4] == array_ch[7] && (array_ch[1] == 'X' || array_ch[1] == 'O');
        comb[5] = array_ch[2] == array_ch[5] && array_ch[5] == array_ch[8] && (array_ch[2] == 'X' || array_ch[2] == 'O');
        comb[6] = array_ch[0] == array_ch[4] && array_ch[4] == array_ch[8] && (array_ch[0] == 'X' || array_ch[0] == 'O');
        comb[7] = array_ch[2] == array_ch[4] && array_ch[4] == array_ch[6] && (array_ch[2] == 'X' || array_ch[2] == 'O');
        int empty = 0;
        int count_x = 0;
        int count_o = 0;
        int diff = 0;
        boolean flag = false;
        boolean flag1000 = false;
        int er = 0;
        //определяем количество х, о, _
        for (int i = 0; i < 9; i++) { //ищет наличие пустых клеток
            if(array_ch[i]=='_') {
                empty++;
            }
            if(array_ch[i]=='X') {
                count_x++;
            }
            if(array_ch[i]=='O') {
                count_o++;
            }
        }
        diff = Math.abs(count_x - count_o);
        for (int i = 0; i < 8; i++) {//проверяет комбинации на наличие три в ряд и количества три в ряд
            if(comb[i]) {
                flag = true;
                er++;
            }
        }
        if (diff >= 2) {
            System.out.println("Impossible, x - o > 2");
            flag1000 = false;
        } else {
            if (flag == false) {
                if(empty != 0) {
                    //System.out.println("Game not finished");
                    flag1000 = true;
                } else {
                    System.out.println("Draw");
                    flag1000 = false;
                }
            } else if (flag == true) {
                if (er > 1) {
                    System.out.println("Impossible");
                    flag1000 = false;
                }
                else {
                    if(comb[0]) {
                        System.out.print(array_ch[0] + " wins");
                        flag1000 = false;

                    } else if (comb[1]) {
                        System.out.print(array_ch[3] + " wins");
                        flag1000 = false;

                    } else if (comb[2]) {
                        System.out.print(array_ch[6] + " wins");
                        flag1000 = false;

                    } else if (comb[3]) {
                        System.out.print(array_ch[0] + " wins");
                        flag1000 = false;

                    } else if (comb[4]) {
                        System.out.print(array_ch[1] + " wins");
                        flag1000 = false;

                    } else if (comb[5]) {
                        System.out.print(array_ch[2] + " wins");
                        flag1000 = false;

                    } else if (comb[6]) {
                        System.out.print(array_ch[0] + " wins");
                        flag1000 = false;

                    } else if (comb[7]) {
                        System.out.print(array_ch[2] + " wins");
                        flag1000 = false;

                    }
                }
            }
        }
        return flag1000;
    }

    static void changeGrid(char[] array_ch, int xO) {
        Scanner scanner = new Scanner(System.in);
        boolean flag1 = true;
        while (flag1) {
            System.out.println("Write your coordinates");
            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                continue;
            } else {
                int coord1 = scanner.nextInt();
                int coord2 = scanner.nextInt();
                if (coord1 <= 0 || coord1 > 3 || coord2 <= 0 || coord2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else {
                    int coordToArray = (coord1 - 1) * 3 + coord2 - 1;
                    if (array_ch[coordToArray] != '_') {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    } else {
                        if(xO % 2 == 0) {
                            array_ch[coordToArray] = 'X';
                            flag1 = false;
                        } else {
                            array_ch[coordToArray] = 'O';
                            flag1 = false;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        // write your code here
        /*System.out.println("X O X");
        System.out.println("O X O");
        System.out.println("X O O");*/
        Scanner scanner = new Scanner(System.in);
        //String str = scanner.next();
        char[] array_ch = new char[9];
        for (int i = 0; i < 9; i++) {
            array_ch[i] = '_';
        }


        boolean flag10 = true;
        int xO = 0;
        while (flag10) {

            changeGrid(array_ch, xO);
            printGrid(array_ch);
            flag10 = checkGrid(array_ch);
            //printGrid(array_ch);
            xO++;
        }
        ///////////////////////////////

        /////////////////////////////////










        /*k = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array_ch[k + j] + " ");
            }
            k += 3;
            System.out.println("|");
        }
        System.out.println("---------");*/


    }
}

