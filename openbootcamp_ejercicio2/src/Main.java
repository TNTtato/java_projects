public class Main {
    public static void main(String[] args) {

        int numeroIf = 0;
        if (numeroIf > 0) {
            System.out.println("El numero " + numeroIf + " es positivo");
        } else if (numeroIf < 0) {
            System.out.println("El numero " + numeroIf + " es negativo");
        } else {
            System.out.println("El numero " + numeroIf + " es cero");
        }

        int numeroWhile = 0;
        while(numeroWhile < 3) {
            System.out.println(numeroWhile);
            numeroWhile++;
        }

        numeroWhile = 0;
        do {
            System.out.println(numeroWhile);
            numeroWhile += 2;
        } while(numeroWhile < 3);

        for (int numeroFor = 0; numeroFor < 3; numeroFor++) {
            System.out.println(numeroFor);
        }

        String estacion = "inverno";
        switch (estacion) {
            case "verano":
                System.out.println("Es verano");
                break;
            case "otonio": //No tengo la enie en mi teclado :(
                System.out.println("Es otonio");
                break;
            case "invierno":
                System.out.println("Es invierno");
                break;
            case "primavera":
                System.out.println("Es primavera");
                break;
            default:
                System.out.println("No es una estacion");
        }
    }
}