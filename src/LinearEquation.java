public class LinearEquation {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double slope () {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public double yIntercept() {
        return y2 - (slope() * x2);
    }

    public String equation() {
        int top = y2 - y1;
        int bot = x2 - x1;
        if (top % bot == 0) {
            return "y = " + top / bot + "x " + yIntercept();
        } else if (top < 0 && bot < 0) {
            return "y = " + (top * -1) + "/" + (bot * -1) + "x + " + yIntercept();
        } else if (yIntercept() < 0) {
            return "y = " + top + "/" + bot + "x + " + yIntercept() * -1;
        }
        return "y = " + top + "/" + bot + "x + -" + yIntercept();
    }

    public String coordinateForX(double x) {
        return "(" + x + ", " + roundedToHundredth(x * slope() + yIntercept()) +") \n";
    }

    public String lineInfo() {
        if (x1 == x2) {
            return "These points are on a vertical line: x = " + x1;
        }
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                "The equation of the line between these points is " + equation() +"\n" +
                "The slope of this line is: " + slope() +"\n" +
                "The y-intercept of this line is: " + yIntercept() + "\n" +
                "The distance between these points is " + distance() + "\n";
    }
    private double roundedToHundredth(double toRound){
        return Math.round(toRound * 100) / 100.0;
    }

}
