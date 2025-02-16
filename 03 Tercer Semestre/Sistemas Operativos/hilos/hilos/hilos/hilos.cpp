#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <sys/time.h>

// Función que será ejecutada por los hilos (sin operación)
void* thread_function(void* arg) {
    return NULL;
}

// Función para medir el tiempo de ejecución de la creación de hilos
void measure_thread_creation_time(int num_threads) {
    struct timeval start, end;
    pthread_t* threads = (pthread_t*)malloc(num_threads * sizeof(pthread_t));

    if (threads == NULL) {
        fprintf(stderr, "Error al asignar memoria para los hilos\n");
        exit(EXIT_FAILURE);
    }

    // Tomar el tiempo de inicio
    gettimeofday(&start, NULL);

    // Crear los hilos
    for (int i = 0; i < num_threads; i++) {
        if (pthread_create(&threads[i], NULL, thread_function, NULL) != 0) {
            fprintf(stderr, "Error al crear el hilo %d\n", i);
            exit(EXIT_FAILURE);
        }
    }

    // Esperar a que todos los hilos terminen su ejecución
    for (int i = 0; i < num_threads; i++) {
        pthread_join(threads[i], NULL);
    }

    // Tomar el tiempo de finalización
    gettimeofday(&end, NULL);

    // Calcular el tiempo de ejecución en microsegundos
    long seconds = end.tv_sec - start.tv_sec;
    long microseconds = end.tv_usec - start.tv_usec;
    long elapsed = seconds * 1000000 + microseconds;

    printf("Tiempo de ejecución para %d hilos: %ld microsegundos\n", num_threads, elapsed);

    free(threads);
}

int main() {
    measure_thread_creation_time(1000000); // 1 millón de hilos
    measure_thread_creation_time(2000000); // 2 millones de hilos
    measure_thread_creation_time(3000000); // 3 millones de hilos

    return 0;
}
