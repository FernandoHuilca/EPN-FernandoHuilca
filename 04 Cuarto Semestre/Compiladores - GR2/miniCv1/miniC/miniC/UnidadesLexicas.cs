using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MiniC
{
    public class UnidadesLexicas
    {
        readonly Dictionary<String, int> Palabra = new Dictionary<String, int>();
        public int GetTokenPalabra(String Lexema) //Creamos la función cpaaz de retornar el numero entero capaz de reotrnar a un experado Lexema
        {
            #region Palabras reservadas ANSI C
            Palabra.Add("auto", 1);
            Palabra.Add("break", 2);
            Palabra.Add("case", 3);
            Palabra.Add("char", 4);
            Palabra.Add("const", 5);
            Palabra.Add("continue", 6);
            Palabra.Add("default", 7);
            Palabra.Add("do", 8);
            Palabra.Add("double", 9);
            Palabra.Add("else", 10);
            Palabra.Add("enum", 11);
            Palabra.Add("extern", 12);
            Palabra.Add("float", 13);
            Palabra.Add("for", 14);
            Palabra.Add("goto", 15);
            Palabra.Add("if", 16);
            Palabra.Add("int", 17);
            Palabra.Add("long", 18);
            Palabra.Add("register", 19);
            Palabra.Add("return", 20);
            Palabra.Add("short", 21);
            Palabra.Add("signed", 22);
            Palabra.Add("sizeof", 23);
            Palabra.Add("static", 24);
            Palabra.Add("struct", 25);
            Palabra.Add("switch", 26);
            Palabra.Add("typedef", 27);
            Palabra.Add("union", 28);
            Palabra.Add("unsigned", 29);
            Palabra.Add("void", 30);
            Palabra.Add("volatile", 31);
            Palabra.Add("while", 32);
            #endregion

            #region Directivas preprocesador
            Palabra.Add("define", 110);
            Palabra.Add("elif", 111);
            Palabra.Add("endif", 112);
            Palabra.Add("error", 113);
            Palabra.Add("ifdef", 114);
            Palabra.Add("ifndef", 115);
            Palabra.Add("include", 116);
            Palabra.Add("line", 117);
            Palabra.Add("pragma", 118);
            Palabra.Add("undef", 119);
            #endregion

            #region Funciones stdio.h
            Palabra.Add("fclose", 120);
            Palabra.Add("feof", 121);
            Palabra.Add("fgetc", 122);
            Palabra.Add("fgets", 123);
            Palabra.Add("flushall", 124);
            Palabra.Add("fopen", 125);
            Palabra.Add("fprintf", 126);
            Palabra.Add("fputc", 127);
            Palabra.Add("fputs", 128);
            Palabra.Add("fread", 129);
            Palabra.Add("fscanf", 130);
            Palabra.Add("fseek", 131);
            Palabra.Add("getc", 132);
            Palabra.Add("getchar", 133);
            Palabra.Add("gets", 134);
            Palabra.Add("printf", 135);
            Palabra.Add("putc", 136);
            Palabra.Add("putchar", 137);
            Palabra.Add("puts", 138);
            Palabra.Add("scanf", 139);
            Palabra.Add("sprintf", 140);
            Palabra.Add("rewind", 141);
            Palabra.Add("FILE", 142);
            #endregion

            #region Funciones stdlib.h
            Palabra.Add("atof", 150);
            Palabra.Add("atoi", 151);
            Palabra.Add("atol", 152);
            Palabra.Add("exit", 153);
            Palabra.Add("free", 154);
            Palabra.Add("malloc", 155);
            Palabra.Add("rand", 156);
            Palabra.Add("random", 157);
            Palabra.Add("randomize", 158);
            Palabra.Add("itoa", 159);
            Palabra.Add("system", 160);
            Palabra.Add("ltoa", 161);
            #endregion

            #region Funciones string.h
            Palabra.Add("strcat", 170);
            Palabra.Add("strcmp", 171);
            Palabra.Add("strcpy", 172);
            Palabra.Add("strlen", 173);
            Palabra.Add("strncat", 174);
            Palabra.Add("strncmp", 175);
            Palabra.Add("strncpy", 176);
            Palabra.Add("strncmpi", 177);
            #endregion

            #region Funciones conio.h
            Palabra.Add("clrscr", 180);
            Palabra.Add("getch", 181);
            Palabra.Add("getche", 182);
            Palabra.Add("gotoxy", 183);
            Palabra.Add("inport", 184);
            Palabra.Add("kbhit", 185);
            Palabra.Add("outport", 186);
            Palabra.Add("textcolor", 187);
            Palabra.Add("cprintf", 188);
            Palabra.Add("cscanf", 189);
            Palabra.Add("textbackground", 190);
            Palabra.Add("cgets", 191);
            Palabra.Add("cputs", 192);
            Palabra.Add("putch", 193);
            Palabra.Add("wherex", 194);
            Palabra.Add("wherey", 195);
            #endregion

            #region Funciones math.h
            Palabra.Add("abs", 200);
            Palabra.Add("asin", 201);
            Palabra.Add("cos", 202);
            Palabra.Add("floor", 203);
            Palabra.Add("log10", 204);
            Palabra.Add("sin", 205);
            Palabra.Add("tan", 206);
            Palabra.Add("acos", 207);
            Palabra.Add("atan", 208);
            Palabra.Add("ceil", 209);
            Palabra.Add("exp", 210);
            Palabra.Add("log", 211);
            Palabra.Add("pow", 212);
            Palabra.Add("sqrt", 213);
            #endregion

            Palabra.Add("main", 220);
            Palabra.Add("NULL", 227);
            Palabra.Add("EOG", 229);

            foreach (KeyValuePair<String, int> Lex in Palabra)
            {
                if (Lexema == Lex.Key)
                    return Lex.Value; //Si el lexema coincide con una palabra recervada, devuelva su respectivo int
            }
            return 300; //si no coincide con ninguna palabra reservada devuelve 300 = identificador
        }
        public int GetTokenSimbolo(string Lexema) // para todos los lexemas que no son palabras - Token simbolo
        {
            Palabra.Clear(); // vaciamos el contenedor palabra
            #region Aritméticos
            Palabra.Add("+", 40);
            Palabra.Add("-", 41);
            Palabra.Add("*", 42);
            Palabra.Add("/", 43);
            Palabra.Add("%", 44);
            Palabra.Add("^", 45);
            #endregion

            #region Asignación, Incrementales, Decrementales
            Palabra.Add("=", 50);
            Palabra.Add("++", 51);
            Palabra.Add("--", 52);
            Palabra.Add("+=", 53);
            Palabra.Add("-=", 54);
            Palabra.Add("*=", 55);
            Palabra.Add("%=", 56);
            Palabra.Add("/=", 57);
            Palabra.Add("^=", 58);
            #endregion

            #region Operadores relacionales
            Palabra.Add("<", 60);
            Palabra.Add(">", 61);
            Palabra.Add("<=", 62);
            Palabra.Add(">=", 63);
            Palabra.Add("==", 64);
            Palabra.Add("!=", 65);
            #endregion

            #region Operadores lógicos
            Palabra.Add("&&", 70);
            Palabra.Add("||", 71);
            Palabra.Add("!", 72);
            #endregion

            #region Agrupación
            Palabra.Add("(", 75);
            Palabra.Add(")", 76);
            Palabra.Add("[", 77);
            Palabra.Add("]", 78);
            Palabra.Add("{", 79);
            Palabra.Add("}", 80);
            #endregion

            #region Miscelaneos
            Palabra.Add(".", 90);
            Palabra.Add(",", 91);
            Palabra.Add(":", 92);
            Palabra.Add(";", 93);
            Palabra.Add("&", 94);
            Palabra.Add("#", 95);
            Palabra.Add("->", 96);
            Palabra.Add("<<", 97);
            Palabra.Add(">>", 98);
            #endregion

            #region Caracteres de escape
            Palabra.Add("\a", 100);
            Palabra.Add("\b", 101);
            Palabra.Add("\f", 102);
            Palabra.Add("\n", 103);
            Palabra.Add("\r", 104);
            Palabra.Add("\t", 105);
            Palabra.Add("\v", 106);
            Palabra.Add("\'", 107);
            Palabra.Add("\"", 108);
            Palabra.Add("\\", 109);
            #endregion

            #region Generales
            Palabra.Add("...", 221);
            Palabra.Add("?", 222);
            Palabra.Add("|", 223);
            Palabra.Add("|=", 224);
            Palabra.Add("<<=", 225);
            Palabra.Add(">>=", 226);
            Palabra.Add("&=", 226);
            #endregion

            foreach (KeyValuePair<string, int> Lex in Palabra)
            {
                if (Lexema == Lex.Key)
                    return Lex.Value;
            }

            return -1;// cuando hay un simbolo que no se encuentra
        }
    }
}
