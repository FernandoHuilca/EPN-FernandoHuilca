#include <iostream>

#ifdef _WIN32
#include <windows.h> // Para Windows
#else
#define RESET   "\033[0m"
#define RED     "\033[31m"      /* Red */
#define GREEN   "\033[32m"      /* Green */
#define YELLOW  "\033[33m"      /* Yellow */
#define BLUE    "\033[34m"      /* Blue */
#endif

int main() {
#ifdef _WIN32
    // Configurar el color para Windows
    HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleTextAttribute(hConsole, FOREGROUND_RED | FOREGROUND_INTENSITY);
#else
    // Configurar el color para sistemas basados en ANSI (Linux, macOS, etc.)
    std::cout << GREEN; // Cambiar a texto verde
#endif

    std::cout << "Texto en color verde." << std::endl;




#ifdef _WIN32
    // Restaurar el color original para Windows
    SetConsoleTextAttribute(hConsole, FOREGROUND_RED | FOREGROUND_BLUE | FOREGROUND_GREEN);
#else
    // Restaurar el color original para sistemas basados en ANSI
    std::cout << RESET;
#endif

    std::cout << "Texto en color predeterminado." << std::endl;

    return 0;
}
