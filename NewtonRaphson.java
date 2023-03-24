import java.util.*;
public class NewtonRaphson {
    
    // Definimos la función que queremos encontrar su raíz
    public static double f(double x) {
        //return 1/2*Math.cos(x)-Math.pow(x,2);
    	return Math.exp(-x)-x;
    }
    
    // Definimos la derivada de la función
    public static double df(double x) {
       // return -(1/2*Math.sin(x))-(2*x);
    	return -(Math.exp(-x))-1;
    }

    public static void main(String[] args) {
        double x0 = 1; // Valor inicial
        double tol = 0.01; // Tolerancia
        int maxIter = 100; // Número máximo de iteraciones
        
        double x = x0;
        int iter = 0;
        double error = tol + 1;
        
        while (error > tol && iter < maxIter) {
            double fx = f(x);
            double dfx = df(x);
            double dx = -fx/dfx; // Calculamos la corrección
            x = x + dx; // Actualizamos el valor de x
            error = Math.abs(dx); // Calculamos el error
            iter++; // Incrementamos el contador de iteraciones
            
            System.out.printf("Iteración %d: x = %.6f, error = %.6f\n", iter, x, error);
        }
        
        if (iter == maxIter) {
            System.out.println("El método no converge en " + maxIter + " iteraciones.");
        } else {
            System.out.printf("La raíz es %.6f con un error de %.6f\n", x, error);
        }
    }

}