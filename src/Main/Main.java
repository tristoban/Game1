package Main;
import javax.swing.JFrame;

public class Main{

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("DGLand - Pueblo Cuacktro");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();//pack es para ver el gamepanel

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
