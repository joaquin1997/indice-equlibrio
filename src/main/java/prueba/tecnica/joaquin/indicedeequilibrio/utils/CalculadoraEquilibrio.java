package prueba.tecnica.joaquin.indicedeequilibrio.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CalculadoraEquilibrio {

	public int calcularEquilibrio(List<Integer> enteros) {
	    
		if(enteros==null) {
			return -1;
		}
		
        int n = enteros.size();
    	int sum = 0; // Inicializa la suma del array
        int leftsum = 0; // Inicializa la suma del la parte izquierda del array
        
        // Suma del array
        for (int i = 0; i < n; ++i){
            sum += enteros.get(i);
        }
        
        
        for (int i = 0; i < n; ++i) {
        	// A la suma se le va restando los enteros del array de tal forma que se va dejando la suma de la parte derecha
        	sum -= enteros.get(i); 
        	
        	// si se encuentra el indice de equilibrio se devuelve
            if (leftsum == sum) {
                return i;
            }
            // si no se incrementa la suma de la izquierda con los valores del array
            leftsum += enteros.get(i);
        }
  
        /* If no equilibrium index found, then return 0 */
        return -1;
}
}
