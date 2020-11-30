package LinkedList.LListToStackAdapter;

import java.util.LinkedList;

public class Main {
    public static class LListToStack {
        LinkedList<Integer> list;
        public LListToStack() {
            list = new LinkedList<>();
        }
        int size() {
            return list.size();
        }
        int pop() {
            if (size() == 0)
            {
                System.out.println("Stack Underflow");
                return  -1;
            }
            return list.removeFirst();
        }
        int top() {
            if (size() == 0)
            {
                System.out.println("Stack Underflow");
                return  -1;
            }
            return list.getFirst();
        }
        void push(int val) {
            list.addFirst(val);
        }

    }
}
