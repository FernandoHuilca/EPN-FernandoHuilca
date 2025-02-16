# Solicitar al usuario que ingrese el número base
base <- as.integer(readline("Ingresa el número base: "))

# Solicitar al usuario que ingrese el exponente
exponente <- as.integer(readline("Ingresa el exponente: "))

# Calcular el potencial
potencial <- base ^ exponente

# Mostrar el resultado
cat("El potencial de", base, "elevado a la potencia", exponente, "es:", potencial, "\n")

