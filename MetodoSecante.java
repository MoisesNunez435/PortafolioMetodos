import java.util.*;
public class MetodoSecante {
    
    // Definimos la función que queremos encontrar su raíz
    public static double f(double x) {
    	return Math.exp(-x)-x;
    }

    public static void main(String[] args) {
        double x0 = 0; // Valor inicial x0
        double x1 = 1; // Valor inicial x1
        double tol = 0.01; // Tolerancia
        int maxIter = 100; // Número máximo de iteraciones
        
        double fx0 = f(x0);
        double fx1 = f(x1);
        double x = x1;
        int iter = 0;
        double error = tol + 1;
        
        while (error > tol && iter < maxIter) {
            double dx = (x1 - x0)/(fx1 - fx0)*fx1; // Calculamos la corrección
            
            x = x1 - dx; // Actualizamos el valor de x
            double fx = f(x);
            
            x0 = x1; // Actualizamos los valores de x0 y x1
            fx0 = fx1;
            x1 = x;
            fx1 = fx;
            
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