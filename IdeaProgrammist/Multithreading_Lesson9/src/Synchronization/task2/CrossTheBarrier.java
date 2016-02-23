package Synchronization.task2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 23/2/2016.
 */
public class CrossTheBarrier extends JPanel{

    public static void main(String[] args) throws IOException {
        new CrossTheBarrier();
    }

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Car car;
    private Barrier barrier;

    Image image = ImageIO.read(new File("Car1.png").getAbsoluteFile());

    public CrossTheBarrier() throws IOException {
        JFrame frame = new JFrame("Cross the barrier");
        frame.setLocation(450, 150);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        car = new Car();
        barrier = new Barrier();

        barriersAction();

        carMove();

        while (carEndMove() || barrier.isOpen) {
            repaint();
        }
    }

    private void barriersAction() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    synchronized (barrier) {
                        System.out.println("Barrier: Waiting for the car.");
                        barrier.wait();
                    }
                    while (!barrier.isOpen) {
                        barriersRise();
                    }
                    while (barrier.isOpen) {
                        barriersClose();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void barriersRise() throws Exception{
        if(barrier.barrierEndX != barrier.open) {
            barrier.barrierEndX--;
            barrier.barrierEndY--;
        } else {
            barrier.barrierEndX = barrier.open;
            barrier.barrierEndY--;
            barrier.isOpen = true;

            synchronized (car) {
                System.out.println("Barrier: I am open.");
                car.notify();
            }synchronized (barrier) {
                barrier.wait();
            }
        }
        sleep(20);
    }

    private void barriersClose() {
        if(barrier.barrierEndX != barrier.close) {
            barrier.barrierEndX++;
            barrier.barrierEndY++;
        } else {
            barrier.barrierEndX = barrier.close;
            barrier.barrierEndY++;
            barrier.isOpen = false;
        }
        sleep(20);
    }

    private boolean carEndMove() {
        return car.y > car.endPoint;
    }
    private void carMove() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (carEndMove()) {
                        if(!barrier.isOpen && (car.y == barrier.y + barrier.thickness / 2)) {
                            synchronized (barrier) {
                                System.out.println("Car: i am here.");
                                barrier.notify();
                            }
                            synchronized (car) {
                                System.out.println("Car: waiting for barrier to rise.");
                                car.wait();
                            }
                        }
                        car.x += 1.5;
                        car.y -= 2;
                        car.width -= 0.25;
                        car.height -= 0.25;
                        sleep(70);
                    }
                    synchronized (barrier) {
                        barrier.notify();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(getBackground());

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, car.x, car.y, car.width, car.height, this);

        g2.setColor(barrier.color);
        g2.setStroke(new BasicStroke(barrier.thickness, BasicStroke.JOIN_ROUND, BasicStroke.JOIN_ROUND));

        g2.drawLine(barrier.x, barrier.y, barrier.barrierEndX, barrier.barrierEndY);
        g2.drawLine(barrier.x, barrier.y, barrier.x, barrier.bottomY);
        g2.drawLine(barrier.close, barrier.y, barrier.close, barrier.bottomY);
    }
}
