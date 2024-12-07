import matplotlib.pyplot as plt  
import numpy as np

tiempos=[1.57E-5  ,2.16E-5 ,3.37E-5 ,4.78E-5 ,1.057E-4   ]  
dimenciones=[1000,5000,10000,15000,20000]
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