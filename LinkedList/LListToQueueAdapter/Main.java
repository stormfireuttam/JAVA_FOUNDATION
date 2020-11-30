package LinkedList.LListToQueueAdapter;

import java.util.LinkedList;

public class Main {
    public static class LListToQueue {
        LinkedList<Integer> queue;
        public LListToQueue() {
            queue = new LinkedList<>();
        }
        int size() {
            return queue.size();
        }
        void add(int val) {
            queue.addLast(val);
        }
        int peek() {
            if (queue.size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return queue.getFirst();
        }
        int remove() {
            if (queue.size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return queue.removeFirst();
        }
    }
}
