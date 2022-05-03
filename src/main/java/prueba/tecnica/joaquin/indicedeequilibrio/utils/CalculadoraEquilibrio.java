package prueba.tecnica.joaquin.indicedeequilibrio.utils;

public class CalculadoraEquilibrio {

	public static int calcularEquilibrio(Integer[] enteros) {
	    
        int n = enteros.length;
    	int sum = 0; // Inicializa la suma del array
        int leftsum = 0; // Inicializa la suma del la parte izquierda del array
        
        // Suma del array
        for (int i = 0; i < n; ++i){
            sum += enteros[i];
        }
        
        
        for (int i = 0; i < n; ++i) {
        	// A la suma se le va restando los enteros del array de tal forma que se va dejando la suma de la parte derecha
        	sum -= enteros[i]; 
        	
        	// si se encuentra el indice de equilibrio se devuelve
            if (leftsum == sum) {
                return i;
            }
            // si no se incrementa la suma de la izquierda con los valores del array
            leftsum += enteros[i];
        }
  
        /* If no equilibrium index found, then return 0 */
        return -1;
}
}
