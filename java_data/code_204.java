package gh2;

import deque.Deque;
import deque.LinkedListDeque;

public class GuitarString {
    
    private static final int SR = 44100;          private static final double DECAY = .996; 
    
    private Deque<Double> buffer;

    
    public GuitarString(double frequency) {
        buffer = new LinkedListDeque<>();
        int capacity = (int) Math.round(SR / frequency);
        for (int i = 0; i < capacity; i += 1) {
            buffer.addFirst(.0);
        }
    }


    
    public void pluck() {
                                        for (int i = 0; i < buffer.size(); i += 1) {
            buffer.removeFirst();
            buffer.addLast(Math.random() - 0.5);
        }
    }

    
    public void tic() {
        double front = buffer.removeFirst();
        double next = buffer.get(0);
        buffer.addLast(DECAY * (front + next) / 2);
    }

    
    public double sample() {
        return buffer.get(0);
    }
}