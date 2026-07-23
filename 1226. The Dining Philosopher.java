import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    // Allow at most 4 philosophers to try picking forks at the same time.
    // This prevents deadlock.
    private final Semaphore semaphore = new Semaphore(4);

    // One lock for each fork
    private final Object[] forks = new Object[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Object();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Only 4 philosophers can try to acquire forks.
        semaphore.acquire();

        // Lock both forks
        synchronized (forks[leftFork]) {
            synchronized (forks[rightFork]) {

                // Pick left fork
                pickLeftFork.run();

                // Pick right fork
                pickRightFork.run();

                // Eat
                eat.run();

                // Put down left fork
                putLeftFork.run();

                // Put down right fork
                putRightFork.run();
            }
        }

        // Allow another philosopher to try
        semaphore.release();
    }
}
