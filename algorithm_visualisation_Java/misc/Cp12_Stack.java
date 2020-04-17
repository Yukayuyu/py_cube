import java.util.LinkedList;

public class Cp12_Stack {

    public class Stack<T> { // parameterized type
        private LinkedList<T> storage = new LinkedList<T>();

        public void push(T v) {
            storage.addFirst(v);
        }

        public T peek() {
            return storage.getFirst();
        }

        public T pop() {
            return storage.removeFirst();
        }

        public boolean empty() {
            return storage.isEmpty();
        }

        public String toString() {
            return storage.toString();
        }
    }

    void test() {
        Stack<String> stack = new Stack<String>();
        for (String s : "My dog has fleas".split(" "))
            stack.push(s);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
        Cp12_Stack x = new Cp12_Stack();
        x.test();
    }
}
