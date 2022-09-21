package utils;

import org.openqa.selenium.Keys;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CustomThread implements Runnable {
    private final CountDownLatch latch;

    //Конструктор класса
    public CustomThread(CountDownLatch latch) {
        this.latch = latch;
        //Запуск потока
        new Thread(this).start();
    }

    //Метод выполнение потока
    @Override
    public void run() {
        while (true) {
            String insert = null;
            try {
                insert = String.valueOf(System.in.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(insert);
            //Уменьшение счетчика срабатывания блокировки
            latch.countDown();
        }
    }
}
