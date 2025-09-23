import java.awt.*;
import java.awt.event.KeyEvent;

public class bot{
    public static void main(String[] args) throws Exception{
        Color bad_item_str = new Color(60, 51, 13);
        System.out.println("\u001B[1;37mMinecraft Anti-AFK Bot");
        System.out.println("\u001B[38;2;150;0;255mBy 214\u001B[1;37m | Made in Ru\u001B[38;2;50;50;255mss\u001B[38;2;255;50;50mia");
        Robot robot = null;
        try{
            robot = new Robot();
        } catch (AWTException e){
            e.printStackTrace();
        }
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        while (true){
            /*PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            Point point = pointerInfo.getLocation();
            int x = (int) point.x;
            int y = (int) point.y;
            robot.mouseMove(x, y);
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            robot.mouseMove(x, y);*/
            robot.keyPress(KeyEvent.VK_A);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_D);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            robot.keyRelease(KeyEvent.VK_D);//отпускание "D"
            /*
            Color user_item_str = robot.getPixelColor(1024, 1423);
            if (user_item_str.equals(bad_item_str)){
                robot.keyPress(KeyEvent.VK_SLASH);
                Thread.sleep(200);
                robot.keyRelease(KeyEvent.VK_SLASH);

                robot.keyPress(KeyEvent.VK_R);
                Thread.sleep(200);
                robot.keyRelease(KeyEvent.VK_R);

                robot.keyPress(KeyEvent.VK_E);
                Thread.sleep(200);
                robot.keyRelease(KeyEvent.VK_E);

                robot.keyPress(KeyEvent.VK_TAB);
                Thread.sleep(200);
                robot.keyRelease(KeyEvent.VK_TAB);

                robot.keyPress(KeyEvent.VK_ENTER);
                Thread.sleep(200);
                robot.keyRelease(KeyEvent.VK_ENTER);

                try{
                    Thread.sleep(10000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }*/
            try{
                Thread.sleep(10000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}