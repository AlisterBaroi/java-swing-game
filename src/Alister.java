import java.awt.Color;
import java.awt.Graphics;

public class Alister extends Item {

    public Alister(int sx, int sy, int s) {
        super(sx, sy, s);
    }

    public void draw(Graphics g) {
        int x = super.getX();
        int y = super.getY();
        g.setColor(Color.YELLOW);
        int x2 = x + 8;
        int x3 = x + 16;
        int y6 = y + 6;
        int x7 = x + 8;
        int y7 = y + 6;
        int x8 = x + 16;
        int y8 = y + 6;
        int x9 = x + 24;
        int y9 = y + 6;
        int y11 = y + 12;
        int x12 = x + 8;
        int y12 = y + 12;
        int x13 = x + 16;
        int y13 = y + 12;
        int x14 = x + 24;
        int y14 = y + 12;
        int y16 = y + 18;
        int x17 = x + 8;
        int y17 = y + 18;
        int x18 = x + 16;
        int y18 = y + 18;
        int x19 = x + 24;
        int y19 = y + 18;
        int y21 = y + 24;
        int x22 = x + 8;
        int y22 = y + 24;
        int x23 = x + 16;
        int y23 = y + 24;
        int x24 = x + 24;
        int y24 = y + 24;
        int y26 = y + 30;
        int x27 = x + 8;
        int y27 = y + 30;
        int x28 = x + 16;
        int y28 = y + 30;
        int x29 = x + 24;
        int y29 = y + 30;
        int[] xpts = new int[] { x2, x3, x8, x9, x14, x13, x18, x19, x24, x29, x28, x23, x22, x27, x, x, x, x17, x12, x,
                x, x7 };
        int[] ypts = new int[] { y, y, y8, y9, y14, y13, y18, y19, y24, y29, y28, y23, y22, y27, y26, y21, y16, y17,
                y12, y11, y6, y7 };
        g.fillPolygon(xpts, ypts, 22);
    }

    public boolean collideBorder() {
        int x = super.getX();
        int y = super.getY();
        boolean collide = false;
        if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
            collide = true;
        }
        return collide;
    }

    public boolean collideWithMonster(Monster v) {
        boolean collide = false;
        int px = super.getX();
        int py = super.getY();
        int vx = v.getX();
        int vy = v.getY();
        int sz = 30;
        if ((vx >= (px - sz)) & (vx <= (px + sz)) & (vy >= (py - sz)) & (vy <= (py + sz))) {
            collide = true;
        }
        return collide;
    }
}
