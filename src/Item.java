public class Item {
    private int x;
    private int dx = 0;
    private int y;
    private int dy = 0;
    private int speed;

    public Item(int sx, int sy, int s) {
        x = sx;
        y = sy;
        speed = s;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void reverseDirection() {
        dx = -dx;
        dy = -dy;
    }

    public void updatePosition() {
        x = x + dx;
        y = y + dy;
    }

    public void moveLeft() {
        dx = -speed;
        dy = 0;
    }

    public void moveRight() {
        dx = speed;
        dy = 0;
    }

    public void moveUp() {
        dx = 0;
        dy = -speed;
    }

    public void moveDown() {
        dx = 0;
        dy = speed;
    }
}
