import java.awt.Color;
import java.awt.Robot;
import java.awt.AWTException;
import java.util.Scanner;
public class color{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Robot robot = new Robot();
        Thread.sleep(5000);
        Color color = robot.getPixelColor(1024, 1423);
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        System.out.println(String.format("%d, %d, %d", r, g, b));
        in.nextLine();
    }
}