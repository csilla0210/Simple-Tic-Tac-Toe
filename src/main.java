import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        boolean xWins = false;
        boolean oWins = false;

        char[][] ticTac = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("|       |");
        }
        System.out.println("---------");

        while (!xWins || !oWins) {
            int xCount = 0;
            int oCount = 0;
            int eCount = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticTac[i][j] == 'X') {
                        xCount++;
                    } else if (ticTac[i][j] == 'O') {
                        oCount++;
                    }
                }
            }

            System.out.print("Enter the coordinates: ");

            int xMove;
            int yMove;
            if (scanner.hasNextInt()) {
                xMove = scanner.nextInt() - 1;
                yMove = scanner.nextInt() - 1;
            } else {
                scanner.nextLine();
                scanner.next();
                System.out.println("You should enter numbers! ");
                continue;
            }

            if (!((xMove >= 0 && xMove < 3) && (yMove >= 0 && yMove < 3))) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (ticTac[xMove][yMove] != ' ' && ticTac[xMove][yMove] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            if (xCount - oCount == 0) {
                ticTac[xMove][yMove] = 'X';
            } else {
                ticTac[xMove][yMove] = 'O';
            }

            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(ticTac[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticTac[i][j] == 'X') {
                        xCount++;
                    } else if (ticTac[i][j] == 'O') {
                        oCount++;
                    } else {
                        eCount++;
                    }
                    if (j == 0 && ticTac[i][j] == 'X' && ticTac[i][j + 1] == 'X' && ticTac[i][j + 2] == 'X') {
                        xWins = true;
                    }
                    if (i == 0 && ticTac[i][j] == 'X' && ticTac[i + 1][j] == 'X' && ticTac[i + 2][j] == 'X') {
                        xWins = true;
                    }
                    if (i == 0 && i == j && ticTac[i][j] == 'X' && ticTac[i + 1][j + 1] == 'X' && ticTac[i + 2][j + 2] == 'X') {
                        xWins = true;
                    }
                    if (i == 0 && j == 0 && ticTac[i][j + 2] == 'X' && ticTac[i + 1][j + 1] == 'X' && ticTac[i + 2][j] == 'X') {
                        xWins = true;
                    }
                    if (j == 0 && ticTac[i][j] == 'O' && ticTac[i][j + 1] == 'O' && ticTac[i][j + 2] == 'O') {
                        oWins = true;
                    }
                    if (i == 0 && ticTac[i][j] == 'O' && ticTac[i + 1][j] == 'O' && ticTac[i + 2][j] == 'O') {
                        oWins = true;
                    }
                    if (i == 0 && i == j && ticTac[i][j] == 'O' && ticTac[i + 1][j + 1] == 'O' && ticTac[i + 2][j + 2] == 'O') {
                        oWins = true;
                    }
                    if (i == 0 && j == 0 && ticTac[i][j + 2] == 'O' && ticTac[i + 1][j + 1] == 'O' && ticTac[i + 2][j] == 'O') {
                        oWins = true;
                    }
                }

            }


            if (xWins && !oWins) {
                System.out.println("X wins");
                break;
            } else if (oWins && !xWins) {
                System.out.println("O wins");
                break;
            } else if (xWins && oWins || Math.abs(xCount - oCount) > 1) {
                System.out.println("Impossible");
            } /*else if (!xWins && !oWins && eCount > 0) {
                System.out.println("Game not finished");
            } */ else if (eCount == 0) {
                System.out.println("Draw");
                break;
            }
        }
    }
}
