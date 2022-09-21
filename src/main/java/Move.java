

import java.awt.*;

public class Move {
    public static void main(String[] args)  {

        try {
            moving();
        } catch (Exception ex) {
            System.out.println("ai");
            try {
                moving();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }

    }

    public static void moving() throws AWTException {
        Robot robot = new Robot();
        while (true) {
            robot.mouseMove(0,0);
            wait5();
            robot.mouseMove(100, 100);
            wait5();
        }
    }

    public static void wait5(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
