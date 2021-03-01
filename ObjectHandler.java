import java.util.ArrayList;
import java.awt.Graphics;

public class ObjectHandler {
    public ArrayList<Circle> circles = new ArrayList<Circle>();
    boolean won = false;

    public void addCircle(Circle c) {
        circles.add(c);
    }

    public void update() {
        for (Circle circle: circles) {
            circle.setX(circle.getX() - 1);
        }
    }

    public void update(int x, int y) {
        if (!won) {
            for (Circle circle: circles) {
                if (x <= circle.getX() + 20 && x > circle.getX() && y <= circle.getY() + 20 && y >= circle.getY() - 20) {
                    circle.setX(circle.getX() - 1);
                }
                if (x >= circle.getX() - 20 && x < circle.getX() && y <= circle.getY() + 20 && y >= circle.getY() - 20) {
                    circle.setX(circle.getX() + 1);
                }
                if (y <= circle.getY() + 20 && y > circle.getY() && x <= circle.getX() + 20 && x >= circle.getX() - 20) {
                    circle.setY(circle.getY() - 1);
                }
                if (y >= circle.getY() - 20 && y < circle.getY() && x <= circle.getX() + 20 && x >= circle.getX() - 20) {
                    circle.setY(circle.getY() + 1);
                }
                if (x == circle.getX() && y == circle.getY()) {
                    won = true;
                    System.out.println("You Somehow Won!");
                }
            }
        }
    }

    public void draw(Graphics g) {
        for (Circle circle: circles) {
            circle.draw(g);
        }
    }
}