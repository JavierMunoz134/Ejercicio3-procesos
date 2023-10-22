public class ContadorThreads implements Runnable {
    private static int contador = 0;
    private static final int ITERACIONES = 500;

    @Override
    public void run() {
        for (int i = 0; i < ITERACIONES; i++) {
            incrementarContador();
        }
    }

    private void incrementarContador() {
        contador++;
    }

    public static void main(String[] args) {
        int NUM_HILOS = 4;
        Thread[] hilos = new Thread[NUM_HILOS];

        for (int i = 0; i < NUM_HILOS; i++) {
            hilos[i] = new Thread(new ContadorThreads());
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (int i = 0; i < NUM_HILOS; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Valor final del contador: " + contador);
    }
}
