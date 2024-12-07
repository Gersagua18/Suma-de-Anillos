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
La notación Big O es una herramienta utilizada en la informática para describir la complejidad algorítmica de un algoritmo, es decir, cómo crece el tiempo de ejecución o el uso de recursos en función del tamaño de la entrada. En el caso de `sumarAnillo`, analizaremos cómo la complejidad temporal cambia según la dimensión de la matriz `d`.

### Análisis de Complejidad Temporal del Algoritmo `sumarAnillo`
La complejidad temporal de la función es **O(d)**. Esto se debe a que el algoritmo recorre los elementos de la capa específica, que tiene una longitud proporcional `d` (la dimensión de la matriz). No importa qué valor de `k` se pase, el número de elementos que se suman es siempre proporcional a `d`.

#### Detalles de la iteración:
- **Primera y última fila**: Se recorren `d - 2k` elementos en cada una.
- **Columnas laterales**: Se recorren `d - 2k - 2` elementos.

El número total de elementos en la capa es **4(d−2k−1)**, lo que es **O(d)**.

#### Complejidad Espacial
La complejidad espacial del algoritmo es **O(1)**, ya que no se utiliza memoria adicional que crezca con la entrada. La única memoria utilizada es para las variables `sum` y `i`.

## 📊 Evaluación y Resultados
La sección de Evaluación y Resultados se centra en la medición y análisis de la complejidad temporal del algoritmo `sumarAnillo`, junto con la verificación de su desempeño mediante pruebas empíricas en diferentes matrices de tamaño `d x d`. Este proceso permite validar que la complejidad temporal teórica **O(d)** se refleja en la práctica.

### Metodología de Evaluación:
1. **Pruebas de rendimiento**: Se implementaron matrices de diferentes tamaños (por ejemplo, 1000x1000, 5000x5000, 15000x15000, y 20000x20000) y se calculó la suma de anillos usando el algoritmo `sumarAnillo` para distintos valores de k (0 para el anillo externo, 1 para el siguiente anillo, etc.).
2. **Medición de tiempo de ejecución**: Se usó un temporizador de ejecución para registrar el tiempo que tarda el algoritmo en procesar cada anillo de la matriz. Estos tiempos se registraron y analizaron para determinar si la complejidad temporal calculada **O(d)** se mantenía consistente.
3. **Resultados comparativos**: Se compararon los tiempos de ejecución con el tamaño de la matriz `d` y con el índice `k` de cada anillo por medio de una grafica, verificando si la relación de tiempo se mantenía proporcional a `d`.

### Resultados de Prueba
Se construyó un gráfico que representa la relación entre el tamaño de la matriz d y el tiempo de ejecución. La gráfica muestra que el tiempo de ejecución crece de manera lineal conforme aumenta d, validando la evaluación de la complejidad temporal.
#### Gráfico de tiempo de ejecución vs. tamaño de la matriz:
-**Eje x**: Dimencion de la matriz `d`.
-**Eje y**: Tiempo de ejecución en segundos (s).

![Figure_1](https://github.com/user-attachments/assets/7aa588b8-d1df-4c75-b99a-84193790dc20)

## Conclusión
El algoritmo sumarAnillo ha sido validado empíricamente, confirmando que su complejidad temporal es **O(d)** y su complejidad espacial es **O(1)**. El análisis y las pruebas mostraron que el tiempo de ejecución crece de manera lineal con el tamaño de la matriz, demostrando su eficiencia y escalabilidad en matrices grandes de hasta `20,000 x 20,000`.

Este algoritmo es ideal para aplicaciones que requieren sumar elementos en capas específicas de matrices, como en análisis de datos. Las pruebas y el análisis sugieren que se puede usar eficazmente en entornos con limitaciones de memoria y que es adaptable para optimizar otras operaciones relacionadas con matrices.
