package miniUndertaleGame.logic;

public class Coordinates {
    private int x;  // The x-coordinate (horizontal position)
    private int y;  // The y-coordinate (vertical position)

    /*
     * Constructor: Initializes the Coordinates object with specified x and y values.
     * @param x  Initial x-coordinate value.
     * @param y  Initial y-coordinate value.
     */
    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /*
     * Sets the x-coordinate to a new value.
     * @param x  New x-coordinate value.
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /*
     * Sets the y-coordinate to a new value.
     * @param y  New y-coordinate value.
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /*
     * Retrieves the current x-coordinate value.
     * @return The x-coordinate.
     */
    public int getX()
    {
        return x;
    }

    /*
     * Retrieves the current y-coordinate value.
     * @return The y-coordinate.
     */
    public int getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coordinates other = (Coordinates) obj;
        return this.x == other.x && this.y == other.y;
    }
}
