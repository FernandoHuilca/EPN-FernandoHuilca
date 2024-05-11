# Inicializar variables
limite = 100
suma = 0
contador = 0

# Bucle para iterar desde 1 hasta 100
for i in range(1, limite + 1):
    # Verificar si el número es par usando el operador % (módulo)
    if i % 2 == 0:
        # Si el número es par, agregarlo a la suma
        suma += i
        # Incrementar el contador de números pares
        contador += 1

# Calcular el promedio dividiendo la suma entre la cantidad de números pares
promedio = suma / contador

# Imprimir el resultado
print("La suma de los pares (1 al 100) es:", suma)
print("El promedio de dicha suma es:", promedio)
