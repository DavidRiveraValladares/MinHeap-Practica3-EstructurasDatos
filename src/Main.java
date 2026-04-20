import java.util.Scanner;

public class Main {

    // Muestra el menu de opciones al usuario
    public static void menu() {
        System.out.println("=============================");
        System.out.println("       MONTICULO MINIMO      ");
        System.out.println("=============================");
        System.out.println("1. Insertar elemento");
        System.out.println("2. Eliminar minimo");
        System.out.println("3. Ver minimo (peek)");
        System.out.println("4. Mostrar monticulo");
        System.out.println("5. Heapify (cargar arreglo)");
        System.out.println("6. Salir");
        System.out.println("=============================");
        System.out.print("Seleccione una opcion: ");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MinHeap monticulo = new MinHeap(20);
        int opcion;

        do {
            menu();
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese el valor a insertar: ");
                int valor = scanner.nextInt();
                monticulo.insertar(valor);
                System.out.println("Elemento insertado.");

            } else if (opcion == 2) {
                int minimo = monticulo.eliminarMin();
                if (minimo != -1) {
                    System.out.println("Elemento minimo eliminado: " + minimo);
                }

            } else if (opcion == 3) {
                int minimo = monticulo.peek();
                if (minimo != -1) {
                    System.out.println("Elemento minimo actual: " + minimo);
                }

            } else if (opcion == 4) {
                monticulo.mostrar();

            } else if (opcion == 5) {
                System.out.print("Ingrese la cantidad de elementos del arreglo: ");
                int cantidad = scanner.nextInt();
                int[] arreglo = new int[cantidad];
                System.out.println("Ingrese los elementos:");
                for (int i = 0; i < cantidad; i++) {
                    System.out.print("  Elemento " + (i + 1) + ": ");
                    arreglo[i] = scanner.nextInt();
                }
                monticulo.heapify(arreglo);
                System.out.println("Heapify aplicado correctamente.");
                monticulo.mostrar();

            } else if (opcion == 6) {
                System.out.println("Saliendo del programa.");

            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }

            System.out.println();

        } while (opcion != 6);

        scanner.close();

    }

}