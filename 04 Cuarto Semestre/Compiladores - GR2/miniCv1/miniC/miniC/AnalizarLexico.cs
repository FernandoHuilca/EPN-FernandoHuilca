using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;

namespace MiniC
{
    public class AnalizarLexico
    {
        int Cont = 0; // variable global para contar la posición dentro del archivo me encuentro
        int Linea = 1; // variable global para identificar en qué línea estoy;
        readonly List<string> Lista = new List<string>(); // creamos lista donde se guardaran los tokens

        // Eliminar comentarios, tabuladores, espacios en blanco, saltos de línea y caracteres especiales.
        // Relacionar los errores con las líneas de programación.
        // Introducir los identificadores en las tablas de símbolos (Esta tarea es opcional, ya que también se puede realizar en el analizador sintáctico).

        // Funcion GetAlfanumerico, para reconocer en que columna de la tabla de trancisiones
        protected int GetAlfabetoAlfanumerico(char c) // reconocer si es letra, digito o subguion
        {
            if (char.IsLetter(c))
                return 0; // retorna un cero si es letra
            else if (char.IsDigit(c))
                return 1; // retorna un uno si es dígito
            else if (c == '_')
                return 2; // retorna el 2 si es subguion
            return -1; // retorna -1 si no es ninguna de las anteriores
        }

        protected int GetAlfabetoNumero(char c)
        {
            if (char.IsDigit(c))
                return 0; // si es dígito corresponde a la columna cero de la TT
            else if (c == '.')
                return 1; // si es punto columna uno
            else if (c == 'E')
                return 2;
            else if (c == 'e')
                return 3;
            else if (c == '+')
                return 4;
            else if (c == '-')
                return 5;
            return -1; // cuando no ingrese ninguno de los caracteres, rechazo
        }

        // Autómata de palabras reservadas
        protected void AutomataPalabras(string Archivo)
        {
            UnidadesLexicas UL = new UnidadesLexicas(); // crea un objeto mismo tipo del diccionario
            char c; // definimos para contener al caracter leemos en este momento
            int Estado = 0; // para el estado del diagrama de trancision
            int Simbolo; // el simbolo que recibe el automata
            string Lexema = string.Empty; // para que se vaya formando la palabra (append)
            int[,] TT =   // ingresamos la tabla de trancisión
            {
                { 1, -1, 1}, // primera fila para estado cero (ojo: empleamos -1 para rechazo)
                { 1,  1, 1} // segunda fila para estado uno
            };
            do
            {
                c = Archivo[Cont]; // leemos el archivo como un vector de caracteres
                Simbolo = GetAlfabetoAlfanumerico(c); // retorna la columna de la tabla de transición = símbolo

                if (Simbolo == -1)
                    break; // si no es letra, dígito o _ entonces rechazo

                Lexema += c; // si sí corresponde con entrada válida, append en string Lexema
                Estado = TT[Estado, Simbolo]; // automata deja pasando al siguiente estado
                Cont++; // incrementamos contador para recibir el siguiente caracter

            } while (true);
            // Para el estado de aceptación
            if (Estado == 1) // si el ultimo estado donde se detuvo fue el de aceptacion
            {
                Lista.Add("Linea: " + Linea + "\t\tLexema: " + Lexema + "\t\t\tToken: " + UL.GetTokenPalabra(Lexema));
            }
        }
        // Autómata de números
        protected void AutomataNumeros(string Archivo)
        {
            UnidadesLexicas UL = new UnidadesLexicas();
            char c;
            int Estado = 0;
            int Simbolo;
            string Lexema = string.Empty;
            int[,] TT =
            {
                {1,2,-1,-1,7,7}, // fila 1
                {1,2,4,4,-1,-1}, // fila 2
                {3,-1,-1,-1,-1,-1},
                {3,-1,4,4,-1,-1},
                {5,-1,-1,-1,6,6},
                {5,-1,-1,-1,-1,-1},
                {6,-1,-1,-1,-1,-1},
                {1,-1,-1,-1,-1,-1}
            };
            do
            {
                c = Archivo[Cont]; // recibimos el caracter en la posicion del contador
                Simbolo = GetAlfabetoNumero(c);

                if (Simbolo == -1)
                    break;

                Lexema += c;
                Estado = TT[Estado, Simbolo]; // función de transición
                Cont++; // 

            } while (true);
            // Para el estado de aceptación
            if (Estado == 1 || Estado == 3 || Estado == 5) // si el ultimo estado donde se detuvo fue el de aceptacion
            {
                if (Lexema.Contains(".")) // para el caso de los decimales = float, token 302
                    Lista.Add("Linea: " + Linea + "\t\tLexema: " + Lexema + "\t\t\tToken: " + 302);
                else // para el caso de los enteros = int, token 301
                    Lista.Add("Linea: " + Linea + "\t\tLexema: " + Lexema + "\t\t\tToken: " + 301);
            }
        }


        protected void AutomataComentarios(string Archivo)
        {
            char c;
            int Estado = 0; // Estado inicial
            string Lexema = "/"; // Empezamos con la primera '/'
            bool EsComentario = false;

            while (Cont < Archivo.Length)
            {
                c = Archivo[Cont];
                Lexema += c;
                Cont++;

                switch (Estado)
                {
                    case 0: // Estado inicial (primer '/')
                        if (c == '/') Estado = 1;   // Comentario de una línea
                        else if (c == '*') Estado = 2; // Comentario multilínea
                        else
                        {
                            // No es comentario, es división
                            Cont--; // Retroceder para reprocesar
                            Lexema = "/";
                            Lista.Add($"Linea: {Linea}\t\tLexema: {Lexema}\t\tToken: 41"); // Token 41 = /
                            return;
                        }
                        break;

                    case 1: // Comentario de una línea (después de "//")
                        if (c == '\n' || c == '\r')
                        {
                            Linea++;
                            return; // Fin del comentario
                        }
                        // Mantenerse en estado 1 hasta encontrar salto de línea
                        break;

                    case 2: // Comentario multilínea (después de "/*")
                        if (c == '*') Estado = 3; // Posible cierre
                        else if (c == '\n' || c == '\r') Linea++;
                        break;

                    case 3: // Asterisco dentro de multilínea
                        if (c == '/')
                        {
                            return; // Fin del comentario */
                        }
                        else if (c == '*')
                        {
                            // Mantenerse en estado 3 (***/ caso especial)
                        }
                        else
                        {
                            Estado = 2; // Vuelve a estado de comentario
                            if (c == '\n' || c == '\r') Linea++;
                        }
                        break;
                }
            }

            // Si llegamos aquí es fin de archivo
            if (Estado == 2 || Estado == 3)
            {
                Lista.Add($"Linea: {Linea}\t\tError: Comentario sin cerrar");
            }
        }

        public List<string> AnalisisLexico(string Archivo)
        {
            UnidadesLexicas UL = new UnidadesLexicas(); // creamos un objeto de tipo UnidadesLexica
            string Lexema = string.Empty;
            do
            {
                char c = Archivo[Cont]; // leemos el archivo letra por letra, acorde con el contador

                // para identificar las palabras reservadas
                if (c == '_' || char.IsLetter(c))
                {
                    AutomataPalabras(Archivo); // si empieza con _,L corremos automata palabras
                }
                else if (c == '.' || c == '+' || c == '-' || char.IsDigit(c))
                {
                    AutomataNumeros(Archivo); // si empieza con .,+,-,D corremos automata Numeros
                }
                else

                    // para identificar elementos sencillos sin automata
                    switch (c) // definimos casos particularmente para los especiales
                    {
                        case ' ':  // espacio en blanco 
                        case '\t': // tabulador
                        case '\0': Cont++; break; //caracter vacío; en 3 casos no hace nada y pasa
                        case '\n': // salto de línea
                        case '\r': Linea++; Cont++; break; // retorno de carro, no hace nada e incrementa el contador de línea
                                                           // cases adicionales para símbolos especiales



                        case '/': // Manejo de comentarios
                            AutomataComentarios(Archivo);
                            Lexema = string.Empty;
                            break;

                        case '(':
                        case ')':
                        case ';':
                        case '=':
                            Lexema += c;
                            Lista.Add("Linea: " + Linea + "\t\tLexema: " + Lexema + "\t\t\tToken: " + UL.GetTokenSimbolo(Lexema));
                            Cont++; Lexema = string.Empty; break;


                    }

            }
            while (Cont < Archivo.Length);
            return Lista;
        }

    }
}
/*using miniC;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;

namespace MiniC
{
    public class AnalizarLexico
    {
        int Cont = 0; // variable global para contar la posición dentro del archivo me encuentro
        int Linea = 1; // variable global para identificar en qué línea estoy;
        readonly List<string> Lista = new List<string>(); // creamos lista donde se guardaran los tokens

        // Eliminar comentarios, tabuladores, espacios en blanco, saltos de línea y caracteres especiales.
        // Relacionar los errores con las líneas de programación.
        // Introducir los identificadores en las tablas de símbolos (Esta tarea es opcional, ya que también se puede realizar en el analizador sintáctico).

        // Funcion GetAlfanumerico, para reconocer en que columna de la tabla de trancisiones
        protected int GetAlfabetoAlfanumerico(char c) // reconocer si es letra, digito o subguion
        {
            if (char.IsLetter(c))
                return 0; // retorna un cero si es letra
            else if (char.IsDigit(c))
                return 1; // retorna un uno si es dígito
            else if (c == '_')
                return 2; // retorna el 2 si es subguion
            return -1; // retorna -1 si no es ninguna de las anteriores
        }

        protected int GetAlfabetoNumero(char c) // reconocer si es letra, digito, subguion o punto
        {
            if (char.IsDigit(c))
                return 0; // retorna un cero si es letra
            else if (c == '.')
                return 1; // retorna un uno si es dígito
            else if (c == 'E')
                return 2; // retorna el 2 si es subguion
            else if (c == 'e')
                return 3; // retorna el 3 si es punto
            else if (c == '+')
                return 4; // retorna el 4 si es subguion
            else if (c == '-')
                return 5; // retorna el 4 si es subguion
            return -1; // retorna -1 si no es ninguna de las anteriores
        }


        // Autómata de palabras reservadas
        protected void AutomataPalabra(string Archivo)
        {
            UnidadesLexica UL = new UnidadesLexica(); // crea un objeto mismo tipo del diccionario
            char c; // definimos para contener al caracter leemos en este momento
            int Estado = 0; // para el estado del diagrama de trancision
            int Simbolo; // el simbolo que recibe el automata
            string Lexema = string.Empty; // para que se vaya formando la palabra (append)
            int[,] TT =   // ingresamos la tabla de trancisión
            {
                { 1, -1, 1}, // primera fila para estado cero (ojo: empleamos -1 para rechazo)
                { 1,  1, 1} // segunda fila para estado uno
            };
            do
            {
                c = Archivo[Cont]; // leemos el archivo como un vector de caracteres
                Simbolo = GetAlfabetoAlfanumerico(c); // retorna la columna de la tabla de transición = símbolo

                if (Simbolo == -1)
                    break; // si no es letra, dígito o _ entonces rechazo

                Lexema += c; // si sí corresponde con entrada válida, append en string Lexema
                Estado = TT[Estado, Simbolo]; // automata deja pasando al siguiente estado
                Cont++; // incrementamos contador para recibir el siguiente caracter

            } while (true);
            // Para el estado de aceptación
            if (Estado == 1) // si el ultimo estado donde se detuvo fue el de aceptacion
            {
                Lista.Add("Linea: " + Linea + "\t\tLexema: " + Lexema + "\t\t\tToken: " + UL.GetTokenPalabra(Lexema));
            }
        }

        //Automata de numeros
        protected void AutomataNumeros(string Archivo)
        {
            UnidadesLexica UL = new UnidadesLexica(); // crea un objeto mismo tipo del diccionario
            char c; // definimos para contener al caracter leemos en este momento
            int Estado = 0; // para el estado del diagrama de trancision
            int Simbolo; // el simbolo que recibe el automata
            string Lexema = string.Empty; // para que se vaya formando la palabra (append)
            int[,] TT =   // ingresamos la tabla de trancisión
            {
                { 1, 2, -1, -1, 7, 7}, // primera fila para estado cero (ojo: empleamos -1 para rechazo)
                { 1, 2,  4, 4, -1, -1}, // segunda fila para estado uno
                { 3, -1, -1, -1, -1, -1},
                { 3, -1, 4, 4, -1, -1},
                { 5, -1, -1, -1, 6, 6},
                { 5, -1, -1, -1, -1, -1},
                { 6, -1, -1, -1, -1, -1},
                { 1, -1, -1, -1, -1, -1}
            };
            do
            {
                c = Archivo[Cont]; // leemos el archivo como un vector de caracteres
                Simbolo = GetAlfabetoNumero(c); // retorna la columna de la tabla de transición = símbolo

                if (Simbolo == -1)
                    break; // si no es letra, dígito o _ entonces rechazo

                Lexema += c; // si sí corresponde con entrada válida, append en string Lexema
                Estado = TT[Estado, Simbolo]; // automata deja pasando al siguiente estado
                Cont++; // incrementamos contador para recibir el siguiente caracter

            } while (true);
            // Para el estado de aceptación
            if (Estado == 1 || Estado == 3 || Estado == 5) // si el ultimo estado donde se detuvo fue el de aceptacion
            {
                if(Lexema.Contains(".") //Para el caso de los decimales
                {
                    Lista.Add("Linea: " + Linea + "\t\tLexema: " + Lexema + "\t\t\tToken: " + 302);
                }else //
                {
                    Lista.Add("Linea: " + Linea + "\t\tLexema: " + Lexema + "\t\t\tToken: " + 301);
                }
                    
            }
        }

        public List<string> AnalisisLexico(string Archivo)
        {
            UnidadesLexica UL = new UnidadesLexica(); // creamos un objeto de tipo UnidadesLexica
            string Lexema = string.Empty; // para que se vaya formando la palabra (append)
            do
            {
                char c = Archivo[Cont]; // leemos el archivo letra por letra, acorde con el contador

                switch (c) // definimos casos particularmente para los especiales
                {
                    case ' ':  // espacio en blanco 
                    case '\t': // tabulador
                    case '\0': Cont++; break; //caracter vacío; en 3 casos no hace nada y pasa
                    case '\n': // saltode línea
                    case '\r': Linea++; Cont++; break; // retorno de carro, no hace nada e incrementa el contador de línea
                }
                // para identificar las palabras reservadas
                if (c == '_' || char.IsLetter(c))
                {
                    AutomataPalabra(Archivo); // corremos el automata de palabras si empieza con _ o letra
                }else if(c==','|| c=='+'||c=='-'||char.IsDigit(c))
                {
                    AutomataNumeros(Archivo); //si empezamos con un número, corremos el automata de números
                }
                else
                switch(c)
                    {
                        case ' ':  // espacio en blanco 
                        case '\t': // tabulador
                        case '\0': Cont++; break; //caracter vacío; en 3 casos no hace nada y pasa
                        case '\n': // saltode línea
                        case '\r': Linea++; Cont++; break; // retorno de carro, no hace nada e incrementa el contador de línea
                        case '(':
                        case ')':
                        case ';':
                        case '=':
                            Lexema += c;
                            Lista.Add("Linea: " + Linea + "\t\tLexema: " + c + "\t\t\tToken: " + UL.GetTokenSimbolo(c.ToString()));
                            Cont++; Lexema = string.Empty; break; // incrementamos el contador para recibir el siguiente caracter


                    }


            }
            while (Cont < Archivo.Length);
            return Lista;
        }

    }
}
*/