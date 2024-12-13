package com.mkyong.examples.Chapter12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.Random;

class Port {
    private final int dockCount;
    private final Semaphore docks;
    private final int portCapacity;
    private int currentContainers;

    public Port(int dockCount, int portCapacity) {
        this.dockCount = dockCount;
        this.docks = new Semaphore(dockCount);
        this.portCapacity = portCapacity;
        this.currentContainers = 0;
    }

    public void loadContainers(int containers, Ship ship) throws InterruptedException {
        docks.acquire();
        try {
            System.out.println(ship.getName() + " загружается с " + containers + " контейнерами.");
            while (containers > 0) {
                if (currentContainers < portCapacity) {
                    currentContainers++;
                    containers--;
                    System.out.println(ship.getName() + " загружает контейнер. Текущие контейнеры в порту: " + currentContainers);
                } else {
                    System.out.println(ship.getName() + " ждет, пока не освободится место в порту.");
                }
                Thread.sleep(500);
            }
        } finally {
            System.out.println(ship.getName() + " завершил загрузку. Всего контейнеров в порту: " + currentContainers);
            docks.release();
        }
    }

    public void unloadContainers(int containers, Ship ship) throws InterruptedException {
        docks.acquire();
        try {
            System.out.println(ship.getName() + " разгружается с " + containers + " контейнерами.");
            while (containers > 0) {
                if (currentContainers > 0) {
                    currentContainers--;
                    containers--;
                    System.out.println(ship.getName() + " разгружает контейнер. Текущие контейнеры в порту: " + currentContainers);
                } else {
                    System.out.println(ship.getName() + " ждет, пока не появятся контейнеры для разгрузки.");
                }
                Thread.sleep(500);
            }
        } finally {
            System.out.println(ship.getName() + " завершил разгрузку. Всего контейнеров в порту: " + currentContainers);
            docks.release();
        }
    }

    public int getCurrentContainers() {
        return currentContainers;
    }
}


class Ship implements Runnable {
    private final String name;
    private final Port port;
    private final int containersToLoad;
    private final int containersToUnload;

    public Ship(String name, Port port, int containersToLoad, int containersToUnload) {
        this.name = name;
        this.port = port;
        this.containersToLoad = containersToLoad;
        this.containersToUnload = containersToUnload;
    }

    public String getName() {
        return name;
    }

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
        }
    }
}

public class PortSimulation {
    public static void main(String[] args) {
        final int DOCK_COUNT = 3;
        final int PORT_CAPACITY = 10;
        final int SHIP_COUNT = 5;

        Port port = new Port(DOCK_COUNT, PORT_CAPACITY);
        ExecutorService executor = Executors.newFixedThreadPool(SHIP_COUNT);
        Random random = new Random();

        for (int i = 1; i <= SHIP_COUNT; i++) {
            int containersToLoad = random.nextInt(5) + 1;
            int containersToUnload = random.nextInt(5) + 1;
            Ship ship = new Ship("Корабль " + i, port, containersToLoad, containersToUnload);
            executor.execute(ship);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
