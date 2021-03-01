import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Main extends Canvas {
    Window w;
    ObjectHandler h;
    Mouse m;
    boolean running = true;

    public Main() {
        w = new Window();
        h = new ObjectHandler();
        m = new Mouse();
        w.getFrame().addMouseListener(m);
        w.getFrame().addMouseMotionListener(m);
        h.addCircle(new Circle(200, 200, 10, 10));
        run();
    }

    public void run() {
        while (running) {
            update();
            draw();
        }
    }

    public void update() {
        String mouseState = m.getMouseState();
        h.update(m.getX(), m.getY());

        /*
        if (mouseState.equals("Pressed")) {
            h.addCircle(new Circle(m.getX() - 5, m.getY() - 5, 10, 10));
        }
        */
    }

    public void draw() {
        BufferStrategy bs = w.getFrame().getBufferStrategy();
        if (bs == null) {
            w.getFrame().createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, w.WIDTH, w.HEIGHT);
        h.draw(g);
        g.dispose();
        bs.show();
    }
    public static void main(String[] args) {
        System.out.println("Try to touch the ball!");
        new Main();
    }
}
