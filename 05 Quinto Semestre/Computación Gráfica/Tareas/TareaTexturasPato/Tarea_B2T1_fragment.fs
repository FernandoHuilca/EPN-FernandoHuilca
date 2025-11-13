#version 330 core
out vec4 FragColor;
in vec3 ourColor;
in vec2 TexCoord;
uniform sampler2D texture1;  // Textura 1
uniform sampler2D texture2;  // Textura 2
uniform int useTexture2;     // Selector de textura

void main()
{
    if (useTexture2 == 1) {
        FragColor = texture(texture2, TexCoord);
    } else {
        FragColor = texture(texture1, TexCoord);
    }
}

