#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>  // Incluir la biblioteca para la función wait

int main() {
    int pid;
    pid = fork();
    switch (pid) {
    case -1:
        printf("\nNo he podido crear el proceso hijo");
        break;
    case 0:
        printf("\nSoy el hijo, mi PID es %d y mi PPID es %d", getpid(), getppid());
        sleep(10);
        break;
    default:
        // Esperar a que el proceso hijo termine
        wait(0);
        sleep(10);  // Dormir 10 segundos más después de que el hijo termine
        printf("Soy el padre, mi PID es %d y el PID de mi hijo es %d", getpid(), pid);
        printf("\nFinal de ejecución de padre");
        exit(0);
        return 0;
    }
}
