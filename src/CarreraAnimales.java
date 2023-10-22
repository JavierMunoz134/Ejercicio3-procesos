import java.util.Random;

class Animal implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private int probabilidadResbalar;

    public Animal(String nombre, int probabilidadResbalar) {
        this.nombre = nombre;
        this.probabilidadResbalar = probabilidadResbalar;
    }

    public void correr() {
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            // Simular resbalón
            if (rand.nextInt(100) < probabilidadResbalar) {
                System.out.println(nombre + " resbaló en la pista.");
                try {
                    Thread.sleep(1000); // Pausa de 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // Avanzar
                distanciaRecorrida++;
            }
        }
        System.out.println(nombre + " ha terminado la carrera.");
    }

    @Override
    public void run() {
        correr();
    }
}

public class CarreraAnimales {
    public static void main(String[] args) {
        Animal liebre = new Animal("Liebre", 20);
        Animal tortuga = new Animal("Tortuga", 5);
        Animal caballo = new Animal("Caballo", 10);
        Animal perro = new Animal("Perro", 15);

        Thread hiloLiebre = new Thread(liebre);
        Thread hiloTortuga = new Thread(tortuga);
        Thread hiloCaballo = new Thread(caballo);
        Thread hiloPerro = new Thread(perro);

        // Asignar prioridades
        hiloLiebre.setPriority(Thread.MAX_PRIORITY);
        hiloTortuga.setPriority(Thread.NORM_PRIORITY);
        hiloCaballo.setPriority(Thread.NORM_PRIORITY);
        hiloPerro.setPriority(Thread.MIN_PRIORITY);

        // Iniciar la carrera
        hiloLiebre.start();
        hiloTortuga.start();
        hiloCaballo.start();
        hiloPerro.start();
    }
}

