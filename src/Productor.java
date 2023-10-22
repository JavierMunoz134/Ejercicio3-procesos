import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Productor {
    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);

        Thread productor = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int elemento = i;
                    buffer.put(elemento); // Coloca el elemento en el buffer
                    System.out.println("Productor: Colocado " + elemento);
                    Thread.sleep(1000); // Simula la producción de un elemento
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        productor.start();
    }
}

