#include <glad/glad.h>
#include <GLFW/glfw3.h>
#include <learnopengl/shader_s.h>

//Texturas:

#define STB_IMAGE_IMPLEMENTATION 
#include <learnopengl/stb_image.h>
//______

#include <iostream>

void framebuffer_size_callback(GLFWwindow* window, int width, int height);
void processInput(GLFWwindow* window);

const unsigned int SCR_WIDTH = 800;
const unsigned int SCR_HEIGHT = 700;
float posX = 0.0f;
float posY = 0.0f;
const float velocidad = 0.001f;
//Cambio de texturas____________
int currentTextureSet = 0; // 0: texture1+texture2, 1: texture3+texture4
//_______________________________

int main()
{
    glfwInit();
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);


    GLFWwindow* window = glfwCreateWindow(SCR_WIDTH, SCR_HEIGHT, "FernandoHuilca 1755534532Tarea4", NULL, NULL);
    if (window == NULL)
    {
        std::cout << "Failed to create GLFW window" << std::endl;
        glfwTerminate();
        return -1;
    }
    glfwMakeContextCurrent(window);
    glfwSetFramebufferSizeCallback(window, framebuffer_size_callback);

    if (!gladLoadGLLoader((GLADloadproc)glfwGetProcAddress))
    {
        std::cout << "Failed to initialize GLAD" << std::endl;
        return -1;
    }

    Shader ourShader("shaders/Tarea_B2T1_vertex.vs", "shaders/Tarea_B2T1_fragment.fs");

    float vertices[] = {
        // positions          // colors           // texture coords
        // Triángulo 1 
        -0.6f, 0.2f,      1.0f, 0.6f, 0.2f,   0.2f, 0.6f,  // D
        -0.6f, -0.2f,     1.0f, 0.6f, 0.2f,   0.2f, 0.4f,  // E
        -0.4f, 0.0f,      1.0f, 0.6f, 0.2f,   0.3f, 0.5f, // F

        // Cuadrado rojo
        -0.6f, -0.2f,     1.0f, 0.6f, 0.2f,   0.2f, 0.4f,  // E
        -0.4f, -0.4f,     1.0f, 0.4f, 0.4f,   0.3f, 0.3f,  // G
        -0.4f, 0.0f,      1.0f, 0.6f, 0.2f,   0.3f, 0.5f, // F

        -0.4f, 0.0f,      1.0f, 0.6f, 0.2f,   0.3f, 0.5f, // F
        -0.4f, -0.4f,     1.0f, 0.4f, 0.4f,   0.3f, 0.3f,  // G
        -0.2f, -0.2f,     1.0f, 0.4f, 0.4f,   0.4f, 0.4f,  // H

        // Triangulo superior
        -0.4f, 0.0f,      1.0f, 0.6f, 0.2f,   0.3f, 0.5f, // F
        -0.2f, -0.2f,     1.0f, 0.4f, 0.4f,   0.4f, 0.4f,  // H
        0.0f, 0.0f,       0.2f, 0.6f, 1.0f,   0.5f, 0.5f, // C

        // Triangulo verde 
        -0.4f, -0.4f,     1.0f, 0.4f, 0.4f,   0.3f, 0.3f,  // G
        0.37f, -0.4f,      0.2f, 0.8f, 0.4f,   0.685f, 0.3f,  // I
        0.0f, 0.0f,       0.2f, 0.6f, 1.0f,   0.5f, 0.5f, // C

    };
    float vertices2[] = {
       
        // Triangulo amarillo
        0.0f, 0.0f,       1.0f, 0.8f, 0.0f,   0.5f, 0.5f, // C
        0.37f, -0.4f,      0.2f, 0.8f, 0.4f,   0.685f, 0.3f,  // I
        0.37f, 0.38f,     1.0f, 0.8f, 0.0f,   0.685f, 0.69f,  // K

        // Rombo 
        0.1f, 0.1f,       0.4f, 0.4f, 0.8f,   0.55f, 0.55f,  // M
        0.37f, 0.38f,     1.0f, 0.8f, 0.0f,   0.685f, 0.69f,  // K
        0.1f, 0.38f,      0.4f, 0.4f, 0.8f,   0.55f, 0.69f,  // L

        0.1f, 0.38f,      0.4f, 0.4f, 0.8f,   0.55f, 0.69f,  // L
        0.37f, 0.38f,     1.0f, 0.8f, 0.0f,   0.685f, 0.69f,  // K
        0.37f, 0.65f,     0.4f, 0.4f, 0.8f,   0.685f, 0.825f,  // O

        // Pico
        0.37f, 0.27f,     0.6f, 0.8f, 0.2f,   0.685f, 0.635f,  // J
        0.76f, 0.27f,     0.6f, 0.8f, 0.2f,   0.88f, 0.635f,   // N
        0.37f, 0.65f,     0.4f, 0.4f, 0.8f,   0.685f, 0.825f,  // O

    };

    unsigned int VBOs[2], VAOs[2];
    glGenVertexArrays(2, VAOs);
    glGenBuffers(2, VBOs);
    //Configuracion 0 
    glBindVertexArray(VAOs[0]);
    glBindBuffer(GL_ARRAY_BUFFER, VBOs[0]);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);

    glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 7 * sizeof(float), (void*)0);
    glEnableVertexAttribArray(0);
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 7 * sizeof(float), (void*)(2 * sizeof(float)));
    glEnableVertexAttribArray(1);
    glVertexAttribPointer(2, 2, GL_FLOAT, GL_FALSE, 7 * sizeof(float), (void*)(5 * sizeof(float)));
    glEnableVertexAttribArray(2);


    //Configuracion 1
    glBindVertexArray(VAOs[1]);
    glBindBuffer(GL_ARRAY_BUFFER, VBOs[1]);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices2), vertices2, GL_STATIC_DRAW);

    glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 7 * sizeof(float), (void*)0);
    glEnableVertexAttribArray(0);
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 7 * sizeof(float), (void*)(2 * sizeof(float)));
    glEnableVertexAttribArray(1);
    glVertexAttribPointer(2, 2, GL_FLOAT, GL_FALSE, 7 * sizeof(float), (void*)(5 * sizeof(float)));
    glEnableVertexAttribArray(2);


    //Cargar Imagen con stb_image
    int width, height, nrChannels; 
    //Girar la imagen____________________
    stbi_set_flip_vertically_on_load(true);
    //___________________________________

    // Cargar primera textura
    unsigned int texture1;
    glGenTextures(1, &texture1);
    glBindTexture(GL_TEXTURE_2D, texture1);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    // ... configuración de parámetros ...
    unsigned char* data1 = stbi_load("textures/Texture1.jpg", &width, &height, &nrChannels, 0);
    if (data1) {
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0,
            (nrChannels == 4) ? GL_RGBA : GL_RGB, GL_UNSIGNED_BYTE, data1);
        glGenerateMipmap(GL_TEXTURE_2D);
    }
    stbi_image_free(data1);

    // Cargar segunda textura
    unsigned int texture2;
    glGenTextures(1, &texture2);
    glBindTexture(GL_TEXTURE_2D, texture2);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    // ... configuración de parámetros (puede ser diferente) ...
    unsigned char* data2 = stbi_load("textures/Texture2.jpg", &width, &height, &nrChannels, 0);
    if (data2) {
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0,
            (nrChannels == 4) ? GL_RGBA : GL_RGB, GL_UNSIGNED_BYTE, data2);
        glGenerateMipmap(GL_TEXTURE_2D);
    }
    stbi_image_free(data2);

    // Cargar tercera textura
    unsigned int texture3;
    glGenTextures(1, &texture3);
    glBindTexture(GL_TEXTURE_2D, texture3);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    // ... configuración de parámetros 
    unsigned char* data3 = stbi_load("textures/Texture3.jpg", &width, &height, &nrChannels, 0);
    if (data3) {
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0,
            (nrChannels == 4) ? GL_RGBA : GL_RGB, GL_UNSIGNED_BYTE, data3);
        glGenerateMipmap(GL_TEXTURE_2D);
    }
    stbi_image_free(data3);
    // Cargar cuarta textura
    unsigned int texture4;
    glGenTextures(1, &texture4);
    glBindTexture(GL_TEXTURE_2D, texture4);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    // ... configuración de parámetros 
    unsigned char* data4 = stbi_load("textures/Texture4.jpg", &width, &height, &nrChannels, 0);
    if (data4) {
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0,
            (nrChannels == 4) ? GL_RGBA : GL_RGB, GL_UNSIGNED_BYTE, data4);
        glGenerateMipmap(GL_TEXTURE_2D);
    }
    stbi_image_free(data4);


    while (!glfwWindowShouldClose(window))
    {
        processInput(window);

        glClearColor(1.0f, 0.90f, 0.80f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT);
        
        float tiempoActual = glfwGetTime();

        // Enviar posición de offset al shader
        int offsetLoc = glGetUniformLocation(ourShader.ID, "offset");
        glUniform2f(offsetLoc, posX, posY);
        // Enviar posición del moviemiento vertical constante
        float valorMovimientoVertical = 0.0f;
        valorMovimientoVertical = (sin(tiempoActual)); // Ejemplo dinámico
        int movimientoVertical = glGetUniformLocation(ourShader.ID, "movimientoVertical");
        glUniform2f(movimientoVertical, 0.0f, valorMovimientoVertical);
        
        // En el bucle while 
        ourShader.use();

        //Cargar texturas
        if (currentTextureSet == 0) {
            glActiveTexture(GL_TEXTURE0);
            glBindTexture(GL_TEXTURE_2D, texture1);
            ourShader.setInt("texture1", 0);

            glActiveTexture(GL_TEXTURE1);
            glBindTexture(GL_TEXTURE_2D, texture2);
            ourShader.setInt("texture2", 1);
        }
        else if (currentTextureSet == 1) {
            glActiveTexture(GL_TEXTURE0);
            glBindTexture(GL_TEXTURE_2D, texture3);
            ourShader.setInt("texture1", 0);

            glActiveTexture(GL_TEXTURE1);
            glBindTexture(GL_TEXTURE_2D, texture4);
            ourShader.setInt("texture2", 1);
        }


        // Dibuja primera parte (usa textura1)
        ourShader.setInt("useTexture2", 0);  // 0 = textura1
        glBindVertexArray(VAOs[0]);
        glDrawArrays(GL_TRIANGLES, 0, 15);

        // Dibuja segunda parte (usa textura2)
        ourShader.setInt("useTexture2", 1);  // 1 = textura2
        glBindVertexArray(VAOs[1]);
        glDrawArrays(GL_TRIANGLES, 0, 12);

        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    glDeleteVertexArrays(2, VAOs);
    glDeleteBuffers(2, VBOs);

    glfwTerminate();
    return 0;
}

void processInput(GLFWwindow* window)
{

    if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS) {
        glfwSetWindowShouldClose(window, true);
    }
    // Cambiar a texturas 3 y 4 con J
    if (glfwGetKey(window, GLFW_KEY_J) == GLFW_PRESS)
        currentTextureSet = 1;

    // Cambiar a texturas 1 y 2 con K
    if (glfwGetKey(window, GLFW_KEY_K) == GLFW_PRESS)
        currentTextureSet = 0;

    // Movimiento con WASD
    if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS)
        posY += velocidad;
    if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS)
        posY -= velocidad;
    if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS)
        posX -= velocidad;
    if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS)
        posX += velocidad;
}

void framebuffer_size_callback(GLFWwindow* window, int width, int height)
{
    glViewport(0, 0, width, height);
}