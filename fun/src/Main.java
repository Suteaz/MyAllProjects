import java.awt.*;
import java.awt.MouseInfo;
import java.awt.Point;

public class Main {
    public static void main(String[] args) {
        try{
            Robot robot = new Robot();
            /*try{
                Thread.sleep(5000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }*/
            while(true){
                Point mouseloc = MouseInfo.getPointerInfo().getLocation();
                int x = mouseloc.x;
                int y = mouseloc.y;
                Color color = robot.getPixelColor(x, y);
                //System.out.println(String.format("%d,%d", x, y));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                System.out.println(String.format("%d, %d, %d", r, g, b));
                try{
                    Thread.sleep(50);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        } catch(AWTException e){
            e.printStackTrace();
        }
    }
}