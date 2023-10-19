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
        int indexOfComma1;
        int indexOfComma2;

        System.out.print("Enter coordinate 1: ");
        String coord1 = myScanner.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = myScanner.nextLine();

        indexOfComma1 = coord1.indexOf(",");
        indexOfComma2 = coord2.indexOf(",");

        x1 = Integer.parseInt(coord1.substring(1, indexOfComma1));
        y1 = Integer.parseInt(coord1.substring(indexOfComma1 + 2, coord1.length() - 1));
        x2 = Integer.parseInt(coord2.substring(1, indexOfComma2));
        y2 = Integer.parseInt(coord2.substring(indexOfComma2 + 2, coord2.length() - 1));


        linear = new LinearEquation(x1, y1, x2, y2);
        System.out.println();
        printInfo();
        if (x1 != x2) {
            findY();
        }
    }

    private void printInfo() {
        System.out.println(linear.lineInfo());
    }


    private void findY() {
        System.out.print("Enter a value for x: ");
        System.out.println("\nThe point on the line is " + linear.coordinateForX(myScanner.nextDouble()));
        myScanner.nextLine();
    }

    private void getData() {
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String userResponse = myScanner.nextLine();
        while (userResponse.equals("y")) {
            getCoordinateInfo();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            userResponse = myScanner.nextLine();
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }


}
