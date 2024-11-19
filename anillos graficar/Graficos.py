import matplotlib.pyplot as plt  
import numpy as np

tiempos=[1.0E-6,2.3E-6,3.5E-6,3.6E-6,6.2E-6]
dimenciones=[20,40,60,80,100    ]
tiempos=np.array(tiempos)

indices = np.arange(len(dimenciones))
plt.figure()
plt.plot(indices, tiempos, label='Tiempos de Ejecucion', color='blue', linewidth=2)

plt.xlabel('Dimencion de la matriz', fontsize=10)
plt.ylabel('Tiempo de ejecución (s)', fontsize=10)
plt.title(f'Comparacion de los tiempos de ejecucion de Suma de anillo 1', fontsize=12)

plt.xticks(indices,dimenciones)

plt.legend(loc='best', fontsize=10)

plt.xticks(fontsize=8)
plt.yticks(fontsize=8)

plt.tight_layout()
plt.show()