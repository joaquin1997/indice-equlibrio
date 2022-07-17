package prueba.tecnica.joaquin.indicedeequilibrio.utils;

import java.util.List;



public class CalculadoraEquilibrio {

	public static int calcularEquilibrio(List<Integer> enteros) {
	    
		if(enteros==null) {
			return -1;
		}
		
        int n = enteros.size();
    	int suma = 0; // Inicializa la suma del array
        int sumaIzda = 0; // Inicializa la suma del la parte izquierda del array
        
        // Suma del array
        for (int i = 0; i < n; ++i){
            suma += enteros.get(i);
        }
        
        
        for (int i = 0; i < n; ++i) {
        	// A la suma se le va restando los enteros del array de tal forma que se va dejando la suma de la parte derecha
        	suma -= enteros.get(i); 
        	
        	// si se encuentra el indice de equilibrio se devuelve
            if (sumaIzda == suma) {
                return i;
            }
            // si no se incrementa la suma de la izquierda con los valores del array
            sumaIzda += enteros.get(i);
        }
  
        /* Si no se ha encontrado el índice de equilibrio devolvemos 0 */
        return -1;
}
}
