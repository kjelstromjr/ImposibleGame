import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Window {

    private JFrame frame;
    private JPanel panel;

    private double screenWidth = 1.5;
    private double screenHeight = 1.5;
    private int screenX;
    private int screenY;

    public final int WIDTH;
    public final int HEIGHT;

    public Window() {
        frame = new JFrame();
        panel = new JPanel();

        //panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int) (screenSize.getWidth() / screenWidth);
        HEIGHT = (int) (screenSize.getHeight() / screenHeight);

        frame.add(panel);
		//frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        screenX = (int) ((screenSize.getWidth() / 2) - (screenSize.getWidth() / (screenWidth * 2)));
        screenY = (int) ((screenSize.getHeight() / 2) - (screenSize.getHeight() / (screenHeight * 2)));
        frame.setLocation(screenX, screenY);
		frame.setVisible(true);
        frame.setTitle("Impossible Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void addLabel(JLabel l) {
        panel.add(l);
    }
}
