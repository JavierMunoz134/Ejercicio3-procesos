import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumidor {
    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(1); // Tamaño del buffer: 1

        Thread consumidor = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int elemento = buffer.take(); // Toma un elemento del buffer
                    System.out.println("Consumidor: Tomado " + elemento);
                    Thread.sleep(2000); // Simula el procesamiento del elemento
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        consumidor.start();
    }
}
