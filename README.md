# Evaluación de la Complejidad Temporal del Algoritmo "`sumarAnillo`"(Avance)

Este proyecto analiza el algoritmo `sumarAnillo`, diseñado para calcular la suma de los elementos de un "anillo" dentro de una matriz cuadrada. Se mide la complejidad temporal del algoritmo y se evalúa su desempeño con diferentes tamaños de matrices, utilizando la notación Big O para analizar su escalabilidad.

---

## 📋 Tabla de Contenidos

1. [Descripción](#descripción)
2. [Requisitos](#requisitos)
3. [Código Principal](#código-principal)
4. [Notacion big O](#código-principal)
5. [Evaluación y Resultados](#evaluación-y-resultados)
6. [Conclusión](#conclusión)
7. [Referencias](#referencias)

---

## 📝 Descripción

El algoritmo `sumarAnillo` toma como entrada una matriz cuadrada `n x n` y calcula la suma de los elementos de un anillo específico dentro de la matriz. Un **anillo** se define como los elementos que forman una "capa" alrededor del borde exterior de la matriz, reduciendo progresivamente el tamaño hasta llegar al centro.

### Objetivo del Proyecto

1. Implementar y analizar el algoritmo `sumarAnillo`.
2. Calcular la complejidad temporal del algoritmo y validarla empíricamente.
3. Representar gráficamente los resultados del análisis de desempeño.

---

## 📦 Requisitos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Java JDK 11** o superior.
- **IDE** (NetBeans, IntelliJ IDEA, Eclipse, o cualquier editor de texto que prefieras).
- **Git** (para clonar este repositorio).

---

## 💻 Código Principal
El núcleo del proyecto es la funcion sumaAnilllo.java, que contiene la implementación del algoritmo de suma de anillos:
### Función `sumarAnillo`
```Java
public static int sumarAnillo(int[][] matriz, int d, int k) {
    k--;
    if (d <= 0 || k < 0 || k >= d) return 0;
    int sum = 0;
    if (k == d / 2 && d % 2 != 0) return matriz[k][k];
    for (int i = k; i < d - k; i++) {
        sum += matriz[k][i] + matriz[d - k - 1][i];
    }
    for (int i = k + 1; i < d - k - 1; i++) {
        sum += matriz[i][k] + matriz[i][d - k - 1];
    }
    return sum;
}
```
---

>[!IMPORTANT]
El parámetro `k` debe ser entendido como el índice del anillo (comenzando desde el borde exterior como `k = 0` empezando a contar desde 0), y `d` define la dimensión de la matriz.  
Asegúrate de utilizar estos valores correctamente para evitar errores en el cálculo. 

### Ejemplo Desarollado:
Consideramos la siguiente matriz cuadrada 6x6.

![image](https://github.com/user-attachments/assets/adf57269-cca0-44c7-87d2-feca90a56c03)

#### Parametros:
- **`k = 0`**: Corresponde al anillo más externo.
- **`d = 6`***: Dimensión de la matriz.

#### Paso a Paso:
Para `k = 0`, el algoritmo incluye todos los elementos del borde exterior:
- **Primera fila**:`1,-8,0,-1,1,2`
- **Última fial**:`7,-3,-1,0,1,4`
- **Elementos verticales de las columnas**:
  - Primera columna: `2,0,4,4`
  - Última columna: `3,-1,6,0`

#### Resultado: 
La suma de los elementos del anillo externo (`k=0`) es `377`.

## 🌀 Notacion big O
