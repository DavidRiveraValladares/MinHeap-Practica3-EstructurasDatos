# Practica 3 - Monticulo Minimo (Min-Heap)

**Curso:** Estructuras de Datos (SOFT-10)  
**Estudiante:** David Rivera Valladares  
**Docente:** Romario Salas Cerdas  
**Periodo:** C1-2026

---

## Descripcion

Implementacion de un monticulo minimo en Java mediante un arreglo. La raiz siempre contiene el elemento de menor valor.

## Archivos

- `MinHeap.java` — clase principal con la estructura y sus metodos
- `Main.java` — menu de consola para interactuar con el monticulo

## Como ejecutar

```bash
javac MinHeap.java Main.java
java Main
```

## Metodos implementados

| Metodo | Descripcion |
|---|---|
| `insertar(int llave)` | Agrega un elemento y restaura el orden con upHeapify |
| `eliminarMin()` | Retorna y elimina el elemento minimo, restaura el orden con downHeapify |
| `peek()` | Retorna el elemento minimo sin eliminarlo |
| `heapify(int[] arreglo)` | Convierte un arreglo desordenado en un monticulo valido |
| `mostrar()` | Imprime el contenido actual del monticulo |
