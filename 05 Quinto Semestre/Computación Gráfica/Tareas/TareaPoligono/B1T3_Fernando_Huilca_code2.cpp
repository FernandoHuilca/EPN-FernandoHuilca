#include <glad/glad.h>  //GLAD es un cargador de funciones para OpenGl
#include <GLFW/glfw3.h> //GLFW para crear ventanas, manejar input y el contexto de OpenGL

#include <iostream>
//Funciones Auxiliares, se las define posteriormente 
void framebuffer_size_callback(GLFWwindow* window, int width, int height);
void processInput(GLFWwindow* window);
//Constantes para el tamaño de las ventanas
const unsigned int SCR_WIDTH = 800;
const unsigned int SCR_HEIGHT = 800;
//código fuente en GLSL (OpenGL Shading Language) de un vertex shader.
const char* vertexShaderSource = "#version 330 core\n"
//Recibirá un atributo de entrada en la ubicacion 0 
"layout (location = 0) in vec3 aPos;\n"
"void main()\n"
"{\n"
"   gl_Position = vec4(aPos.x, aPos.y, aPos.z, 1.0);\n"
"}\0";
//FragmentShader
const char* fragmentShaderSource = "#version 330 core\n"
//Define una salida para el color del fragmento 
"out vec4 FragColor;\n"
"void main()\n"
"{\n"
// Asigna un color RGBA al fragmento. 
"   FragColor = vec4(1.0f, 1.0f, 0.2f, 1.0f);\n"
"}\n\0";

int main() //Punto de entrada del programa.
{

    glfwInit(); //Inicializa la biblioteca 
    //Define el uso de OpenGL 3.3 y el perfil core excluyendo funciones obsoletas de versiones anteriores
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

    //En macOS es obligatorio habilitar el modo "forward compatible" para usar OpenGL core.
#ifdef __APPLE__
    glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE); // uncomment this statement to fix compilation on OS X
#endif

    //Crea la ventana. Devuelve un puntero a una estructura GLFWwindow.
    GLFWwindow* window = glfwCreateWindow(SCR_WIDTH, SCR_HEIGHT, "FernandoHuilca 1755534532", NULL, NULL);
    if (window == NULL)
    {
        std::cout << "Failed to create GLFW window" << std::endl;
        glfwTerminate();
        return -1;
    }
    //Asocia el contexto de OpenGL a la ventana actual.Necesario antes de llamar a cualquier función GLAD.
    glfwMakeContextCurrent(window);
    //Asocia la función framebuffer_size_callback para que se llame cada vez que se cambia el tamaño de la ventana
    glfwSetFramebufferSizeCallback(window, framebuffer_size_callback);

    //obtener las direcciones de las funciones OpenGL desde los drivers.
    if (!gladLoadGLLoader((GLADloadproc)glfwGetProcAddress))
    {
        std::cout << "Failed to initialize GLAD" << std::endl;
        return -1;
    }


    int vertexShader = glCreateShader(GL_VERTEX_SHADER); //Crea un objeto shader vacío de tipo vertex shader
    glShaderSource(vertexShader, 1, &vertexShaderSource, NULL); //Asocia el código fuente
    glCompileShader(vertexShader);// Compila el shader

    int success;
    char infoLog[512];

    glGetShaderiv(vertexShader, GL_COMPILE_STATUS, &success); //Pregunta si todo salio bien.
    if (!success)
    {
        glGetShaderInfoLog(vertexShader, 512, NULL, infoLog);
        std::cout << "ERROR::SHADER::VERTEX::COMPILATION_FAILED\n" << infoLog << std::endl;
    }
    //Lo mismo que hicimkos con el vertex shader
    int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
    glShaderSource(fragmentShader, 1, &fragmentShaderSource, NULL);
    glCompileShader(fragmentShader);

    glGetShaderiv(fragmentShader, GL_COMPILE_STATUS, &success); //Verifica si todo ok jeje 
    if (!success)
    {
        glGetShaderInfoLog(fragmentShader, 512, NULL, infoLog);
        std::cout << "ERROR::SHADER::FRAGMENT::COMPILATION_FAILED\n" << infoLog << std::endl;
    }

    int shaderProgram = glCreateProgram(); //Se crea un programa de shader, que encapsula los shaders compilados.
    glAttachShader(shaderProgram, vertexShader); //Asocia cada shader al programa.
    glAttachShader(shaderProgram, fragmentShader);
    glLinkProgram(shaderProgram); // Realiza el linking final

    glGetProgramiv(shaderProgram, GL_LINK_STATUS, &success);
    if (!success) {
        glGetProgramInfoLog(shaderProgram, 512, NULL, infoLog);
        std::cout << "ERROR::SHADER::PROGRAM::LINKING_FAILED\n" << infoLog << std::endl;
    }
    //Una vez linkeado el programa, los objetos shader individuales pueden eliminarse;
    glDeleteShader(vertexShader);
    glDeleteShader(fragmentShader);

    //Arreglo de tipo float que representa las coordenadas 3D
    float vertices[] = {
        // Triángulo 1
        0.0f,  0.0f, 0.0f,
        0.7f,  0.0f, 0.0f,
        0.54f,  0.45f, 0.0f,
        //Triángulo 2
        0.0f,  0.0f, 0.0f,
        0.54f,  0.45f, 0.0f,
        0.12f,  0.69f, 0.0f,
        //Triángulo 3
        0.0f,  0.0f, 0.0f,
        0.12f,  0.69f, 0.0f,
        -0.35f,  0.61f, 0.0f,
        //Triángulo 4
        0.0f,  0.0f, 0.0f,
        -0.35f,  0.61f, 0.0f,
        -0.66f,  0.24f, 0.0f,
        //Triángulo 5
        0.0f,  0.0f, 0.0f,
        -0.66f,  0.24f, 0.0f,
        -0.66f,  -0.24f, 0.0f,
        //Triángulo 6
        0.0f,  0.0f, 0.0f,
        -0.66f,  -0.24f, 0.0f,
        -0.35f,  -0.61f, 0.0f,
        //Triángulo 7
         0.0f,  0.0f, 0.0f,
        -0.35f,  -0.61f, 0.0f,
        0.12f,  -0.69f, 0.0f,
        //Triángulo 8
         0.0f,  0.0f, 0.0f,
         0.12f,  -0.69f, 0.0f,
         0.54f,  -0.45f, 0.0f,
         //Triángulo 9
          0.0f,  0.0f, 0.0f,
          0.54f,  -0.45f, 0.0f,
          0.7f,  0.0f, 0.0f


    };
    //VAO: Vertex Array Object
    unsigned int VBO, VAO;
    glGenVertexArrays(1, &VAO);//Guarda el estado de configuración de los atributos de los vértices
    glGenBuffers(1, &VBO);
    glBindVertexArray(VAO);

    glBindBuffer(GL_ARRAY_BUFFER, VBO);  //Enlaza el buffer para que OpenGL sepa a cual referirse
    //Copia los datos al buffer en la GPU. GL_STATIC_DRAW indica que no se modificará.
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);
    //Define cómo interpretar los datos del VBO para enviarlos al shader:
    //Atributos en orden : Localizacion del shader, numero de componentes xyz, tipo de datos, no normalizar, como saltar, comienzo de datos
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 3 * sizeof(float), (void*)0);
    glEnableVertexAttribArray(0);

    glBindBuffer(GL_ARRAY_BUFFER, 0);

    glBindVertexArray(0);


    // render loop
    // -----------
    while (!glfwWindowShouldClose(window)) //Revisa si el usuario ha cerrado la ventana.
    {

        processInput(window);


        glClearColor(0.2f, 0.5f, 0.3f, 1.0f);// Define el color de fondo
        glClear(GL_COLOR_BUFFER_BIT); //Limpia el framebuffer

        glUseProgram(shaderProgram); // Activa el programa shader
        glBindVertexArray(VAO); //Usa el VAO para renderizar.
        glDrawArrays(GL_TRIANGLES, 0, 27); //Dibuja el poligono con 27 vértices 

        glfwSwapBuffers(window); //Muestra el resultado en pantalla.
        glfwPollEvents();     //Procesa inputs y eventos.
    }

    //Libera los recursos de GPU y cierra correctamente GLFW
    glDeleteVertexArrays(1, &VAO);
    glDeleteBuffers(1, &VBO);

    glfwTerminate();
    return 0;
}


void processInput(GLFWwindow* window) //Verifica si el usuario presionó ESC para cerrar la ventana
{
    if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
        glfwSetWindowShouldClose(window, true);
}


void framebuffer_size_callback(GLFWwindow* window, int width, int height) //Ajusta el viewport de OpenGL cuando cambia el tamaño de la ventana.
{

    glViewport(0, 0, width, height);
}