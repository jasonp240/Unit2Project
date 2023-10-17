import java.util.Scanner;

public class LinearEquationLogic {
    private LinearEquation linear;
    private Scanner myScanner;

    public LinearEquationLogic() {
        linear = null;
        myScanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        getCoordinateInfo();
        getData();
    }

    private void getCoordinateInfo() {
        int x1;
        int y1;
        int x2;
        int y2;
        int indexOfComma;
        int indexOfLastParentheses;

        System.out.print("Enter coordinate 1: ");
        String coord1 = myScanner.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = myScanner.nextLine();

        indexOfComma = coord1.indexOf(",");
        indexOfLastParentheses = coord1.substring(1).indexOf(")") + 1;

        if (coord1.substring(1,2).equals("-")) {
            x1 = Integer.parseInt(coord1.substring(2, indexOfComma));
            x1 *= -1;
        } else {
            x1 = Integer.parseInt(coord1.substring(1, indexOfComma));
        }

        if (coord1.substring(indexOfComma + 2, indexOfComma + 3).equals("-")) {
            y1 = Integer.parseInt(coord1.substring(indexOfComma + 3, indexOfLastParentheses));
            y1 *= -1;
        } else {
            y1 = Integer.parseInt(coord1.substring(indexOfComma + 2, indexOfLastParentheses));
        }

        indexOfComma = coord2.indexOf(",");
        indexOfLastParentheses = coord2.substring(1).indexOf(")") + 1;

        if (coord2.substring(1,2).equals("-")) {
            x2 = Integer.parseInt(coord2.substring(2, indexOfComma));
            x2 *= -1;
        } else {
            x2 = Integer.parseInt(coord2.substring(1, indexOfComma));
        }

        if (coord2.substring(indexOfComma + 2, indexOfComma + 3).equals("-")) {
            y2 = Integer.parseInt(coord2.substring(indexOfComma + 3, indexOfLastParentheses));
            y2 *= -1;
        } else {
            y2 = Integer.parseInt(coord2.substring(indexOfComma + 2, indexOfLastParentheses));
        }

        linear = new LinearEquation(x1, y1, x2, y2);
        System.out.println();
        printInfo();
        findY();
    }

    private void printInfo() {
        System.out.println(linear.lineInfo());
    }


    private void findY() {
        System.out.print("Enter a value for x: ");
        System.out.println("\nThe point on the line is " + linear.coordinateForX(myScanner.nextDouble()));
        myScanner.nextLine();
        System.out.println();
    }

    private void getData() {
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String userResponse = myScanner.nextLine();
        while (userResponse.equals("y")) {
            getCoordinateInfo();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            userResponse = myScanner.nextLine();
        }
    }


}
