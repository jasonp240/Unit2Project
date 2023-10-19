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
        return roundedToHundredth(y2 - (slope() * x2));
    }

    public String equation() {
        String yInter;
        if (yIntercept() > 0) {
            yInter = "+ " + String.valueOf(yIntercept());
        } else if (yIntercept() < 0){
            yInter = "- " + String.valueOf(Math.abs(yIntercept()));
        } else {
            yInter = "";
        }
        int top = y2 - y1;
        int bot = x2 - x1;
        if (top % bot == 0) {
            if (top / bot == 1) {
                return "y = x " + yInter;
            } else if (top / bot == -1){
                return "y = -x " + yInter;
            } else if (top / bot == 0){
                return "y = " + y1;
            }
            return "y = " + top / bot + "x " + yInter;
        } else if (top < 0 && bot < 0) {
            return "y = " + Math.abs(top) + "/" + Math.abs(bot) + "x " + yInter;
        } else if (bot < 0) {
            return "y = -" + top + "/" + Math.abs(bot) + "x " + yInter;
        } else if (top / bot == 1 && yIntercept() == 0) {
            return "y = x";
        }
        return "y = " + top + "/" + bot + "x " + yInter;
    }

    public String coordinateForX(double x) {
        return "(" + x + ", " + roundedToHundredth(x * slope() + yIntercept()) +") \n";
    }

    public String lineInfo() {
        if (x1 == x2) {
            return "These points are on a vertical line: x = " + x1 +"\n";
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
