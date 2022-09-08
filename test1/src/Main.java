public class Main {
    public static void main(String[] args) {
        // primer parte
        int result = suma(10, 20, 30);
        System.out.println(result);

        // segunda parte
        Coche miCoche = new Coche();
        miCoche.aumentarPuertas();
        System.out.println(miCoche.puertas);
    }

    public static int suma(int a, int b, int c) {
        return a + b + c;
    }
}

class Coche {
    public int puertas = 4;

    public void aumentarPuertas() {
        this.puertas++;
    }
}

