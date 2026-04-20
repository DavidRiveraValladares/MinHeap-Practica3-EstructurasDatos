public class MinHeap {

    // Atributos
    private int[] monticulo;
    private int siguienteCasilla;

    // Constructor
    public MinHeap(int tamanio) {
        monticulo = new int[tamanio];
        siguienteCasilla = 0;
    }

    // Inserta un nuevo elemento al final del arreglo y restaura el orden
    public void insertar(int llave) {
        if (siguienteCasilla == monticulo.length) {
            System.out.println("El monticulo ya esta lleno.");
            return;
        }
        monticulo[siguienteCasilla] = llave;
        upHeapify(siguienteCasilla);
        siguienteCasilla++;
    }

    // Sube el elemento en la casilla dada hasta su posicion correcta
    private void upHeapify(int casilla) {
        int i = casilla;
        boolean desordenado = true;
        while (desordenado) {
            if (i > 0 && monticulo[i] < monticulo[(i - 1) / 2]) {
                int temp = monticulo[i];
                monticulo[i] = monticulo[(i - 1) / 2];
                monticulo[(i - 1) / 2] = temp;
                i = (i - 1) / 2;
                continue;
            }
            desordenado = false;
        }
    }

    // Retorna y elimina la raiz (el elemento minimo), luego restaura el orden
    public int eliminarMin() {
        if (siguienteCasilla == 0) {
            System.out.println("El monticulo esta vacio.");
            return -1;
        }
        int minimo = monticulo[0];
        siguienteCasilla--;
        monticulo[0] = monticulo[siguienteCasilla];
        downHeapify(0);
        return minimo;
    }

    // Baja el elemento en la casilla dada hasta su posicion correcta
    private void downHeapify(int casilla) {
        int i = casilla;
        boolean desordenado = true;
        while (desordenado) {
            int hijoIzquierdo = 2 * i + 1;
            int hijoDerecho = 2 * i + 2;
            int menorHijo = i;

            if (hijoIzquierdo < siguienteCasilla && monticulo[hijoIzquierdo] < monticulo[menorHijo]) {
                menorHijo = hijoIzquierdo;
            }
            if (hijoDerecho < siguienteCasilla && monticulo[hijoDerecho] < monticulo[menorHijo]) {
                menorHijo = hijoDerecho;
            }

            if (menorHijo != i) {
                int temp = monticulo[i];
                monticulo[i] = monticulo[menorHijo];
                monticulo[menorHijo] = temp;
                i = menorHijo;
                continue;
            }
            desordenado = false;
        }
    }

    // Retorna el elemento minimo sin eliminarlo
    public int peek() {
        if (siguienteCasilla == 0) {
            System.out.println("El monticulo esta vacio.");
            return -1;
        }
        return monticulo[0];
    }

    // Convierte un arreglo desordenado en un monticulo minimo valido
    public void heapify(int[] arreglo) {
        if (arreglo.length > monticulo.length) {
            System.out.println("El arreglo es demasiado grande para el monticulo.");
            return;
        }
        siguienteCasilla = 0;
        for (int i = 0; i < arreglo.length; i++) {
            monticulo[i] = arreglo[i];
            siguienteCasilla++;
        }
        // Se aplica downHeapify desde el ultimo nodo padre hacia la raiz
        for (int i = (siguienteCasilla / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    // Muestra el contenido actual del monticulo
    public void mostrar() {
        if (siguienteCasilla == 0) {
            System.out.println("El monticulo esta vacio.");
            return;
        }
        System.out.print("Monticulo: ");
        for (int i = 0; i < siguienteCasilla; i++) {
            System.out.print(monticulo[i] + " ");
        }
        System.out.println();
    }

    // Retorna la cantidad de elementos actuales en el monticulo
    public int getTamanio() {
        return siguienteCasilla;
    }

}