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

        if (top == 0) {
            return "y = " + y2 + "x + " + yIntercept();
        }
        else if (bot == 0) {
            return "x = " + x2;
        }
        return "y = " + top + "/" + bot + "x + " + yIntercept();
    }

    public double coordinateForX(double x) {
        return roundedToHundredth(x * slope() + yIntercept());
    }

    private double roundedToHundredth(double toRound){
        return Math.round(toRound * 100) / 100.0;
    }

}
