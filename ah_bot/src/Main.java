import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener {
    private static final int CLICK_X = 500;
    private static final int CLICK_Y = 500;
    private static final int MOVE_X = 250; 
    private static final int MOVE_Y = 500;

    private final Robot robot;

    public Main() throws AWTException {
        robot = new Robot();
        System.out.println("Скрипт запущен. Нажмите Z для клика в (" + CLICK_X + ", " + CLICK_Y + ")");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            robot.mouseMove(CLICK_X, CLICK_Y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            robot.mouseMove(MOVE_X, MOVE_Y);

            System.out.println("Клик в (" + CLICK_X + ", " + CLICK_Y + "), курсор перемещён в (" + MOVE_X + ", " + MOVE_Y + ")");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) throws AWTException {
        Main clicker = new Main();
        try {
            java.awt.GlobalScreen.addKeyListener(clicker);
        } catch (Exception e) {
            System.err.println("Ошибка!");
            System.exit(1);
        }
    }
}
