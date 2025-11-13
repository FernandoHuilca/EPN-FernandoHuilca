#version 330 core
layout (location = 0) in vec2 aPos;
layout (location = 1) in vec3 aColor;
layout (location = 2) in vec2 aTexCoord; //Texturas


out vec3 ourColor;
out vec2 TexCoord;
uniform vec2 offset;  // Para controlar la posicion en los dos ejes
uniform vec2 movimientoVertical; //Para el movimiento constante vertical

void main()
{
    gl_Position = vec4(aPos+offset+movimientoVertical,0.0, 1.0); 
    ourColor = aColor;
    TexCoord = aTexCoord; //Pasar Coordenadas de textura al fs 
}