import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class PgnReader {
    /**
     * Find the tagName tag pair in a PGN game and return its value.
     *
     * @see http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm
     *
     * @param tagName the name of the tag whose value you want
     * @param game a `String` containing the PGN text of a chess game
     * @return the value in the named tag pair
     */
    public static String tagValue(String tagName, String game) {
        //System.out.println(game);
        if (tagName.equals("Event") && game.contains("Event")) {
            String eventSub = game.substring(game.indexOf("Event") + 7);
            String[] eventSplit = eventSub.split("\"");
            return eventSplit[0];
        }
        if (tagName.equals("Site") && game.contains("Site")) {
            String eventSub = game.substring(game.indexOf("Site") + 6);
            String[] eventSplit = eventSub.split("\"");
            return eventSplit[0];
        }
        if (tagName.equals("Date") && game.contains("Date")) {
            String eventSub = game.substring(game.indexOf("Date") + 6);
            String[] eventSplit = eventSub.split("\"");
            return eventSplit[0];
        }
        if (tagName.equals("Round") && game.contains("Round")) {
            String eventSub = game.substring(game.indexOf("Round") + 7);
            String[] eventSplit = eventSub.split("\"");
            return eventSplit[0];
        }
        if (tagName.equals("White") && game.contains("White")) {
            String eventSub = game.substring(game.indexOf("White") + 7);
            String[] eventSplit = eventSub.split("\"");
            return eventSplit[0];
        }
        if (tagName.equals("Black") && game.contains("Black")) {
            String eventSub = game.substring(game.indexOf("Black") + 7);
            String[] eventSplit = eventSub.split("\"");
            return eventSplit[0];
        }
        if (tagName.equals("Result") && game.contains("Result")) {
            String eventSub = game.substring(game.indexOf("Result") + 8);
            String[] eventSplit = eventSub.split("\"");
            return eventSplit[0];
        }
        return "NOT GIVEN";
    }
    /**
     * Finds the final position of the game provided (PGN format)
     * @return FEN notation of the final position of the game
     */
    public static String finalPosition(String game) {
        String movesSub = game.substring(game.indexOf("1."));
        String[] movesNumber = movesSub.replace("+", "").replace("?", "")
            .replace("#", "").replace("\n", " ").split(" ");
        int counterPer = 0;
        for (String i: movesNumber) {
            //System.out.println(i);
            if (!i.contains(".")) {
                counterPer++;
            }
        }
        //System.out.println(counterPer);
        String[] moves = new String[counterPer];
        counterPer = 0;
        for (String iter: movesNumber) {
            if (!iter.contains(".")) {
                moves[counterPer] = iter;
                //System.out.println(moves[counterPer]);
                counterPer++;
            }
        }

        String[][] board = new String[8][8];
        startupBoard(board);
        int count = 0;
        for (int i = 0; i < counterPer; i++) {
            //System.out.println(moves[i]);
            if (count % 2 == 0) {
                updBoard(board, moves[i], "W");
            } else {
                updBoard(board, moves[i], "b");
            }
            count++;
        }
        return fenNotation(board);
    }
    /**
     * Provided a 2 dimenstional array it calculates FEN notation
     * @return FEN notation of given board
     */
    public static String fenNotation(String[][] board) {
        String line = "";
        String overall = "";
        int zeroCount = 0;
        for (int i = 0; i < 8; i++) {
            line = "";
            zeroCount = 0;
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals("000")) {
                    zeroCount++;
                } else {
                    if (board[i][j].contains("W")) {
                        line = line + Integer.toString(zeroCount) + board[
                            i][j].substring(0, 1);
                        zeroCount = 0;
                    } else {
                        line = line + zeroCount + board[i][j].substring(0,
                            1).toLowerCase();
                        zeroCount = 0;
                    }
                }
            }
            overall = overall + line + Integer.toString(zeroCount) + "/";
        }
        return overall.replace("0", "");
    }
    /**
     * converts letter to integer that correlates with board postion
     * @return board integer value of letter provided
     */
    public static int numLetter(char letter) {
        return (int) letter - (int) 'a';
    }
    /**
     * takes in current board posiiton, move that needs to be excuted and
     * color of piece moving then updates to board after that move has been
     * excuted
     * @return returns nothing
     */
    public static void updBoard(String[][] board, String move, String color) {
        boolean promo = false;
        //System.out.println("pawned1");
        char endPos = 'j';
        if (move.contains("=")) {
            endPos = move.charAt(move.length() - 1);
            move = move.substring(0, move.length() - 2);
            promo = true;
            //System.out.println(move);
        }
        int xGoal = 99999;
        int yGoal = 99999;
        boolean disambi = false;
        if (move.length() >= 4 && !move.contains("O-")) {
            String indicator = move.replace("=", "").replace("x", "");
            if (indicator.length() >= 4) {
                indicator = indicator.substring(1, move.length() - 2);
                if (indicator.length() == 2) {
                    xGoal = numLetter(indicator.charAt(0));
                    yGoal = Character.getNumericValue(indicator.charAt(1));
                    disambi = true;
                } else if (indicator.matches(".*[a-z].*")) {
                    xGoal = numLetter(indicator.charAt(0));
                    disambi = true;
                } else if (indicator.length() == 1) {
                    yGoal = Character.getNumericValue(indicator.charAt(1));
                    disambi = true;
                }
            }
        }
        if (move.contains("O-O-O")) {
            if (color.equals("W")) {
                board[7][2] = "K_W";
                board[7][3] = "R_W";
                board[7][0] = "000";
                board[7][4] = "000";
            } else {
                board[0][2] = "K_b";
                board[0][3] = "R_b";
                board[0][0] = "000";
                board[0][4] = "000";
            }
        } else if (move.contains("O-O")) {
            if (color.equals("W")) {
                board[7][6] = "K_W";
                board[7][5] = "R_W";
                board[7][4] = "000";
                board[7][7] = "000";
            } else {
                board[0][6] = "K_b";
                board[0][5] = "R_b";
                board[0][4] = "000";
                board[0][7] = "000";
            }
        } else if (move.contains("N")) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j].contains("N") && board[i][j].contains(
                            color)) {
                        String movePos = move.substring(move.length() - 2);
                        int x = numLetter(movePos.charAt(0));
                        int y = 8 - Character.getNumericValue(movePos.charAt(
                            1));
                        int distance = (i - y) * (i - y) + (j - x) * (j - x);
                        if (distance == 5) {
                            if (disambi) {
                                if (xGoal == j) {
                                    if (yGoal == i) {
                                        board[i][j] = "000";
                                        board[y][x] = "N_" + color;
                                    } else if (yGoal == 99999) {
                                        board[i][j] = "000";
                                        board[y][x] = "N_" + color;
                                    }
                                } else {
                                    if (xGoal == 99999) {
                                        if (yGoal == i) {
                                            board[i][j] = "000";
                                            board[y][x] = "N_" + color;
                                        }
                                    }
                                }
                            } else {
                                board[i][j] = "000";
                                board[y][x] = "N_" + color;
                            }
                        }
                    }
                }
            }
        } else if (move.contains("B")) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j].contains("B") && board[i][j].contains(
                            color)) {
                        String movePos = move.substring(move.length() - 2);
                        int x = numLetter(movePos.charAt(0));
                        int y = 8 - Character.getNumericValue(movePos.charAt(
                            1));
                        if (Math.abs(i - y) == Math.abs(j - x)) {
                            //board[6][4] = "000";
                            boolean block = false;
                            while (!block) {
                                boolean up = (x <= j);
                                boolean left = (y <= i);
                                int u = i;
                                int t = j;
                                while (!(t == x) || !(u == y)) {
                                    if (up) {
                                        t--;
                                    } else {
                                        t++;
                                    }
                                    if (left) {
                                        u--;
                                    } else {
                                        u++;
                                    }
                                    if (!board[u][t].equals("000")
                                        && !(t == x)
                                        && !(u == y)) {
                                        block = true;
                                    }
                                }
                                if (!block) {
                                    if (disambi) {
                                        if (xGoal == j) {
                                            if (yGoal == i) {
                                                board[i][j] = "000";
                                                board[y][x] = "B_" + color;
                                                block = true;
                                            } else if (yGoal == 99999) {
                                                board[i][j] = "000";
                                                board[y][x] = "B_" + color;
                                                block = true;
                                            }
                                        } else {
                                            if (xGoal == 99999) {
                                                if (yGoal == i) {
                                                    board[i][j] = "000";
                                                    board[y][x] = "B_" + color;
                                                    block = true;
                                                }
                                            }
                                        }
                                    } else {
                                        board[i][j] = "000";
                                        board[y][x] = "B_" + color;
                                        block = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (move.contains("R")) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j].contains("R") && board[i][j].contains(
                            color)) {
                        String movePos = move.substring(move.length() - 2);
                        int x = numLetter(movePos.charAt(0));
                        int y = 8 - Character.getNumericValue(movePos.charAt(
                            1));
                        // int distance = (i-y)*(i-y) + (j-x)*(j-x);
                        // System.out.println(" "+j+" "+i+" "+x+" "+y);
                        if ((i == y) || (j == x)) {
                            // board[6][4] = "000";
                            boolean block = false;
                            while (!block) {
                                boolean up = (x <= j);
                                boolean left = (y <= i);
                                int u = i;
                                int t = j;
                                if (j == x) {
                                    while (!(u == y)) {
                                        if (left) {
                                            u--;
                                        } else {
                                            u++;
                                        }
                                        if (!board[u][t].equals("000") && !
                                            (u == y)) {
                                            block = true;
                                        }
                                    }
                                }
                                if (i == y) {
                                    while (!(t == x)) {
                                        if (up) {
                                            t--;
                                        } else {
                                            t++;
                                        }
                                        if (!board[u][t].equals("000") && !
                                            (t == x)) {
                                            block = true;
                                        }
                                    }
                                }
                                // System.out.println(block);
                                if (!block) {
                                    if (disambi) {
                                        // System.out.println(xGoal+" "+yGoal);
                                        if (xGoal == j) {
                                            if (yGoal == i) {
                                                board[i][j] = "000";
                                                board[y][x] = "R_" + color;
                                                block = true;
                                            } else if (yGoal == 99999) {
                                                board[i][j] = "000";
                                                board[y][x] = "R_" + color;
                                                block = true;
                                            }
                                        } else {
                                            if (xGoal == 99999) {
                                                if (yGoal == i) {
                                                    board[i][j] = "000";
                                                    board[y][x] = "R_" + color;
                                                    block = true;
                                                }
                                            }
                                        }
                                    } else {
                                        board[i][j] = "000";
                                        board[y][x] = "R_" + color;
                                        block = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (move.contains("Q")) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j].contains("Q") && board[i][j].contains(
                            color)) {
                        String movePos = move.substring(move.length() - 2);
                        int x = numLetter(movePos.charAt(0));
                        int y = 8 - Character.getNumericValue(movePos.charAt(
                            1));
                        if (Math.abs(i - y) == Math.abs(j - x)) {
                            //board[6][4] = "000";
                            boolean block = false;
                            while (!block) {
                                boolean up = (x <= j);
                                boolean left = (y <= i);
                                int u = i;
                                int t = j;
                                while (!(t == x) || !(u == y)) {
                                    if (up) {
                                        t--;
                                    } else {
                                        t++;
                                    }
                                    if (left) {
                                        u--;
                                    } else {
                                        u++;
                                    }
                                    if (!board[u][t].equals("000")
                                        && !(t == x) && !(u == y)) {
                                        block = true;
                                    }
                                }
                                if (move.contains("x")) {
                                    block = false;
                                }
                                if (!block) {
                                    board[i][j] = "000";
                                    board[y][x] = "Q_" + color;
                                    block = true;
                                }
                            }
                        }
                        if ((i == y) || (j == x)) {
                            // board[6][4] = "000";
                            boolean block = false;
                            while (!block) {
                                boolean up = (x <= j);
                                boolean left = (y <= i);
                                int u = i;
                                int t = j;
                                if (j == x) {
                                    while (!(t == x) || !(u == y)) {
                                        if (left) {
                                            u--;
                                        } else {
                                            u++;
                                        }
                                        if (!board[u][t].equals("000")
                                            && !(t == x) && !(u == y)) {
                                            block = true;
                                        }
                                    }
                                }
                                if (i == y) {
                                    while (!(t == x) || !(u == y)) {
                                        if (up) {
                                            t--;
                                        } else {
                                            t++;
                                        }
                                        if (!board[u][t].equals("000")
                                            && !(t == x) && !(u == y)) {
                                            block = true;
                                        }
                                    }
                                }
                                // System.out.println(block);
                                if (!block) {
                                    board[i][j] = "000";
                                    board[y][x] = "Q_" + color;
                                    block = true;
                                }
                            }
                        }
                    }
                }
            }
        } else if (move.contains("K")) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j].contains("K") && board[i][j].contains(
                            color)) {
                        String movePos = move.substring(move.length() - 2);
                        int x = numLetter(movePos.charAt(0));
                        int y = 8 - Character.getNumericValue(movePos.charAt(
                            1));
                        board[i][j] = "000";
                        board[y][x] = "K_" + color;
                    }
                }
            }
        } else {
            // char endPos = 'j';
            // boolean promo = false;
            //System.out.println(endPos);
            String movePos = move.substring(move.length() - 2);
            int x = numLetter(movePos.charAt(0)); //4,5
            int y = 8 - Character.getNumericValue(movePos.charAt(1));
            // System.out.println(x+" "+y);
            if (move.contains("x")) {
                int j = numLetter(move.charAt(0));
                if (color.equals("b")) {
                    if (board[y][x].equals("000")) {
                        // System.out.println(y+" "+x+" "+j);
                        board[y - 1][j] = "000";
                        board[y - 1][x] = "000";
                        if (promo) {
                            board[y][x] = Character.toString(endPos) + "_"
                                + color;
                        } else {
                            board[y][x] = "P_" + color;
                        }
                    } else {
                        board[y - 1][j] = "000";
                        if (promo) {
                            board[y][x] = Character.toString(endPos) + "_"
                                + color;
                        } else {
                            board[y][x] = "P_" + color;
                        }
                    }
                } else {
                    if (board[y][x].equals("000")) {
                        // System.out.println(y+" "+x+" "+j);
                        board[y + 1][j] = "000";
                        board[y + 1][x] = "000";
                        if (promo) {
                            board[y][x] = Character.toString(endPos) + "_"
                                + color;
                        } else {
                            board[y][x] = "P_" + color;
                        }
                    } else {
                        board[y + 1][j] = "000";
                        if (promo) {
                            board[y][x] = Character.toString(endPos) + "_"
                                + color;
                        } else {
                            board[y][x] = "P_" + color;
                        }
                    }
                }
            } else {
                if (color.equals("b")) {
                    int j = x;
                    for (int i = 0; i < 8; i++) {
                        if (board[i][j].contains("P") && board[i][j].contains(
                                "b")) {
                            board[i][j] = "000";
                            //board[y][x] = "P_"+color;
                            //break;
                            if (promo) {
                                board[y][x] = Character.toString(endPos)
                                    + "_" + color;
                            } else {
                                board[y][x] = "P_" + color;
                            }
                        }
                    }
                } else {
                    int j = x;
                    for (int i = 7; i > -1; i--) {
                        if (board[i][j].contains("P") && board[i][j].contains(
                                "W")) {
                            board[i][j] = "000";
                            //board[y][x] = "P_"+color;
                            //break;
                            if (promo) {
                                board[y][x] = Character.toString(endPos)
                                    + "_" + color;
                            } else {
                                board[y][x] = "P_" + color;
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * initilizes beginning board position of a typical chess game
     * @return returns nothing
     */
    public static void startupBoard(String[][] board) {
        for (int i = 0; i < 8; i++) {
            board[1][i] = "P_b";
            board[6][i] = "P_W";
        }
        for (int i = 0; i < 8; i++) {
            board[2][i] = "000";
            board[3][i] = "000";
            board[4][i] = "000";
            board[5][i] = "000";
        }
        board[0][2] = "B_b";
        board[0][5] = "B_b";
        board[7][2] = "B_W";
        board[7][5] = "B_W";
        board[0][3] = "Q_b";
        board[7][3] = "Q_W";
        board[0][4] = "K_b";
        board[7][4] = "K_W";
        board[0][0] = "R_b";
        board[0][7] = "R_b";
        board[7][0] = "R_W";
        board[7][7] = "R_W";
        board[0][1] = "N_b";
        board[0][6] = "N_b";
        board[7][1] = "N_W";
        board[7][6] = "N_W";
    }
        /**
         * Reads the file named by path and returns its content as a String.
         *
         * @param path the relative or abolute path of the file to read
         * @return a String containing the content of the file
         */
    public static String fileContent(String path) {
        Path file = Paths.get(path);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                // Add the \n that's removed by readline()
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            System.exit(1);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String game = fileContent(args[0]);
        System.out.format("Event: %s%n", tagValue("Event", game));
        System.out.format("Site: %s%n", tagValue("Site", game));
        System.out.format("Date: %s%n", tagValue("Date", game));
        System.out.format("Round: %s%n", tagValue("Round", game));
        System.out.format("White: %s%n", tagValue("White", game));
        System.out.format("Black: %s%n", tagValue("Black", game));
        System.out.format("Result: %s%n", tagValue("Result", game));
        System.out.println("Final Position:");
        System.out.println(finalPosition(game));
    }
}
