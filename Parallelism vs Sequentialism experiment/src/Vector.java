public class Vector {
    double y;
    double x;
    double u;

    /**
     * empty constructor
     */
    public Vector (){}

    /**
     * constructor without uplift value, specifically used to calculate averages
     * @param x x-value
     * @param y y-value
     */
    public Vector (double x, double y){
        this.x = x;
        this.y = y;

    }

    /**
     * Constructor with uplift value to store elements during reading
     * @param x x-value
     * @param y y-value
     * @param u uplift-value
     */
    public Vector (double x, double y, double u){
        this.x = x;
        this.y = y;
        this.u = u;
    }
}
