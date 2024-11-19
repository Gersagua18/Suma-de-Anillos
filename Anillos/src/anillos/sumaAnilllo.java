package anillos;
import java.util.Random;
public class sumaAnilllo {
    public static void main(String[] args) {
        int[] dimenciones={20,40,60,80,100};
        Random rd=new Random();
        for(int i=0;i<dimenciones.length;i++){
            int n=dimenciones[i];
            int [][] matriz=new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    matriz[j][k]=rd.nextInt(0,100);
                }
            }/*
            System.out.println("Matriz de "+n+"x"+n+":");
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    System.out.print(matriz[j][k]+" ");
                }
                System.out.println();
            }*/
            double[] tiempos=Calculartiempos(matriz,n);
            System.out.println("Tiempos calculados para la matriz de "+n+":");
            for(double tiempo : tiempos) {
                System.out.print(tiempo/1_000_000_000.0+" ");
            }
            System.out.println();
        }       
       
    }
    public static int sumarAnillo(int[][] matriz, int d, int k){
        k--;
        if (d<=0 || k<0 || k>=d) return 0;
        int sum=0;
        if(k==d/2 && d%2!=0) return matriz[k][k];
        for(int i=k;i<d-k;i++){
            sum+=matriz[k][i]+matriz[d-k-1][i];
        }
        for(int i=k+1;i<d-k-1;i++){
            sum+=matriz[i][k]+matriz[i][d-k-1];
        }
        return sum;
    }
    public static double[] Calculartiempos(int[][] matriz, int d){
        double []tiempos=new double[d/2+(d%2==0 ? 0: 1)];
        for(int i=0;i<(d/2+(d%2==0 ? 0: 1));i++){
            //calculamos el tiempo de la funcion
            long inicio=System.nanoTime();
            int resultado=sumarAnillo(matriz,d,i);
            long fin=System.nanoTime();
            tiempos[i]=fin-inicio;            
        }
        return tiempos;
    }
}