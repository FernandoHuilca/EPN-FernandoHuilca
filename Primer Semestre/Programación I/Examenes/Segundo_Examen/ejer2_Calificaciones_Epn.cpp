//Author Fernando Huilca
/*EPN Calificaciones. El actual reglamento de Régimen Académico de la EPN en sus artículos 80 y 81 establece el 
modo de calificaciones de las asignaturas para pregrado. Los artículos en lo pertinente a este problema establecen
lo siguiente:(mucho texto)
Se le solicita escribir un programa que presente un menú con 3 opciones. Primero Ingresar calificaciones, segundo Ver 
resultados totales y tercero salir, este menú debe seguirse presentando hasta que el usuario seleccione la opción de 
salir. La primera opción permita ingresar el nombre del estudiante y las dos o tres calificaciones dependiendo del caso
para saber si un estudiante aprobó o reprobó una asignatura. La segunda opción debe mostrar solo tres cosas el número 
de estudiantes aprobados, el número de estudiantes reprobados y el promedio. */

#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

const int DIM = 50;


typedef struct
{
    string nombre;
    double nota_1;
    double nota_2;
    double nota_3;
    double nota_aprobado;
    string estado;
}tEstudiante;

typedef struct
{
    tEstudiante  elementos[DIM];
    int contador;
}tlistaEstudiantes;




int menu_principal();
void Calculo_calificacion(tEstudiante& estudiante);
void Imgresar_Estsudiante(tlistaEstudiantes& lista);
void ver_resultados(tlistaEstudiantes lista);



int main()
{
    tlistaEstudiantes lista;
    tEstudiante estudiante;
    cout << "Biebenido al programa de calificaciones EPN" << endl;
    int opcion = 1;
    while (opcion != 0)
    {
        opcion = menu_principal();
        cout << endl;
        switch (opcion) {
        case 1:
            Imgresar_Estsudiante(lista);
            break;
        case 2:
            ver_resultados(lista);
            break;
        case 3:

            break;

        }
    }
    cout << "Adios. " << endl;
    return 0;
}


int menu_principal() {
    int opcion;
    do {
        cout << "MENU PRINCIPAL" << endl;
        cout << endl;
        cout << "1. Ingresar calificaciones" << endl;
        cout << "2. Ver resultados" << endl;
        cout << "0. Salir" << endl;
        cout << endl;
        cout << "Ingrese una opcion: ";

        cin >> opcion;
        if (opcion < 0 || opcion > 2) {
            cout << "Opcion seleccionada INCORRECTA." << endl;
            cout << "Por favor, digite un numero entero del 0 al 4" << endl;
        }
    } while (opcion < 0 || opcion > 2);
    return (opcion);
}



void Calculo_calificacion(tEstudiante& estudiante)
{
    estudiante.nota_aprobado = (estudiante.nota_1 + estudiante.nota_2);

    if (estudiante.nota_aprobado >= 28)
    {
        estudiante.estado = "aprobado";
    }
    else {
        estudiante.estado = "reprobado";
    }
}

void Imgresar_Estsudiante(tlistaEstudiantes& lista)
{
    char respuesta;
    double promedio;
    tEstudiante estudiante;

    if (lista.contador < DIM)
    {

        cout << "Ingrese el nombre del estudiante: ";
        //getline(cin, estudiante.nombre);
        cin >> estudiante.nombre;
        cout << "Ingrese la nota 1: ";
        cin >> estudiante.nota_1;
        cout << "Ingrese la nota 2: ";
        cin >> estudiante.nota_2;
        Calculo_calificacion(estudiante);
        cout << "El estudiante " << estudiante.nombre << " ha " << estudiante.estado
            << " con una nota equivalente a: " << estudiante.nota_aprobado << endl;



        if (estudiante.nota_aprobado >= 28)
        {
            cout << "Desea rendir el supletorio para mejorar su calificacion (y/n): ";

            cin >> respuesta;
            if (respuesta == 'y') {
                cout << "Ingrese la nota 3: ";
                cin >> estudiante.nota_3;
                estudiante.nota_aprobado = (estudiante.nota_3 + estudiante.nota_aprobado);
                cout << "La nueva calificación del estudiante " << estudiante.nombre << " es de: " << estudiante.nota_aprobado << endl;
            }
        }
        else if (estudiante.nota_aprobado < 18)
        {
            cout << "Usted ya no tiene derecho al examen de recuperacion porque su nota es menor que 18." << endl;
        }
        else
        {
            cout << "Su estado es " << estudiante.estado << " sin embargo tiene derecho al examen de recuperacion." << endl;
            cout << "Ingrese la nota 3: ";
            cin >> estudiante.nota_3;
            if (estudiante.nota_3 >= 24)
            {
                promedio = (estudiante.nota_3 + estudiante.nota_aprobado) / 2;
                if (promedio >= 24)
                {
                    cout << "Usted aprobo la materia " << endl;
                    estudiante.estado = "aprovado";
                }
            }
            else
            {
                cout << "Su nota no alcanza para ser considerada en su promedio" << endl;
            }


        }


        lista.elementos[lista.contador] = estudiante;
        lista.contador++;
    }
    else
    {
        cout << "ERROR: La lista de estudiantes se encuentra llena" << endl;
    }


}

void ver_resultados(tlistaEstudiantes lista)
{
    int aprobados = 0;
    int reprobados = 0;
    double promedio = 0;
    double sumaCalificaciones = 0;
    tEstudiante estudiante;

    for (int i = 0; i < lista.contador; i++) {
        sumaCalificaciones += lista.elementos[i].nota_aprobado;

        if (lista.elementos[i].estado == "Aprobado") {
            aprobados++;
        }
        else {
            reprobados++;
        }
    }
    promedio = sumaCalificaciones / lista.contador;

    cout << "Número de estudiantes aprobados: " << aprobados << endl;
    cout << "Número de estudiantes reprobados: " << reprobados << endl;
    cout << "Promedio de calificaciones: " << promedio << endl;
}
