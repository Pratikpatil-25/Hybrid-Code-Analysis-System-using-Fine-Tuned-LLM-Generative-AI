import java.util.List;

interface Pollable {
    void poll();
}

class InterleavedPollingAdaptive implements Runnable {
    private final List<Pollable> pollables;
    private long cycleTimeNs;
    private volatile boolean running = true;

    public InterleavedPollingAdaptive(List<Pollable> pollables, long targetFrequencyHz) {
        this.pollables = pollables;
        this.cycleTimeNs = 1_000_000_000L / targetFrequencyHz;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            long start = System.nanoTime();
            for (Pollable p : pollables) {
                p.poll();
            }
            long end = System.nanoTime();
            long elapsed = end - start;

                        if (elapsed > cycleTimeNs) {
                cycleTimeNs = (long) (cycleTimeNs * 1.1);
            } else {
                cycleTimeNs = (long) (cycleTimeNs * 0.9);
            }

            try {R1
                Thread.sleep(cycleTimeNs / 1_000_000L, (int) (cycleTimeNs % 1_000_000L));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}