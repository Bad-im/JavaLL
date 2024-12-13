package com.mkyong.examples.Chapter12;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PortTest {

    @Test
    void testLoadAndUnloadContainers() throws InterruptedException {
        final int DOCK_COUNT = 3;
        final int PORT_CAPACITY = 10;
        final int SHIP_COUNT = 5;

        Port port = new Port(DOCK_COUNT, PORT_CAPACITY);
        ExecutorService executor = Executors.newFixedThreadPool(SHIP_COUNT);
        CountDownLatch latch = new CountDownLatch(SHIP_COUNT);
        int totalContainersToLoad = 0;
        int totalContainersToUnload = 0;

        for (int i = 1; i <= SHIP_COUNT; i++) {
            int containersToLoad = (i % 2 == 0) ? 2 : 3;
            int containersToUnload = (i % 2 == 0) ? 1 : 2;
            totalContainersToLoad += containersToLoad;
            totalContainersToUnload += containersToUnload;

            Ship ship = new Ship("Корабль " + i, port, containersToLoad, containersToUnload) {
                @Override
                public void run() {
                    try {
                        if (containersToUnload > 0) {
                            port.unloadContainers(containersToUnload, this);
                        }
                        if (containersToLoad > 0) {
                            port.loadContainers(containersToLoad, this);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        latch.countDown();
                    }
                }
            };
            executor.execute(ship);
        }

        latch.await();
        executor.shutdown();

        assertEquals(totalContainersToLoad - totalContainersToUnload, port.getCurrentContainers());
    }
}
