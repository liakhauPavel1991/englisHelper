package steps;

import utils.CustomThread;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Manager {
    static boolean aBoolean = true;

    public static void readIn(){
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sleep5(){
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void waitForSpace(){
        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("Запуск отдельного потока");
        new CustomThread(latch);
        try {
            latch.await();
        } catch (InterruptedException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
        System.out.println("Завершение отдельного потока");
    }

    public static void waitForSpace2() {
        final CountDownLatch latch = new CountDownLatch(1);
        System.out.println(1);
        KeyEventDispatcher dispatcher = new KeyEventDispatcher() {
            // Anonymous class invoked from EDT
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
                    latch.countDown();
                return false;
            }
        };
        System.out.println(2);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
        System.out.println(3);
        try {
            latch.await();  // current thread waits here until countDown() is called
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(4);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);
        System.out.println(5);
    }
}
