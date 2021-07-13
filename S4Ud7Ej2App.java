import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Version 1.0
 * @author Sergio Galimany Hoyo
 */
public class S4Ud7Ej2App {

	public static void main(String[] args) {
		
		// Crea el ArrayList.
		ArrayList<String> listaSuper = new ArrayList<>();
		
		// Llama a la funcion.
		listaVenta(listaSuper);

	}
	
	public static void listaVenta(ArrayList<String> listaSuper) {
		
		double iva;
		double cantidadPagada = 0;
		double cambioDevolver = 0;
		double precioProducto = 0;
		int numeroProductos = 0;
		double total = 0;
		double totalIva = 0;
		double totalCompraConIva;
		
		// Pregunta al usuario cuantos productos quiere comprar.
		String inputNumeroProductos = JOptionPane.showInputDialog("Escriba el numero de articulos que ha comprado.");
		
		// Parsea.
		numeroProductos = Integer.parseInt(inputNumeroProductos);
		
		// Añade a la lista el numero de productos comprados.
		listaSuper.add("Numero de productos comprados: " + numeroProductos);
		
		// Va pidiendo precios de todos los productos.
		for (int i = 0; i < numeroProductos; i++) {
			
			String inputPrecioProducto = JOptionPane.showInputDialog("Escriba el precio del producto " +(i+1)+ " de " +numeroProductos+ ".");
			
			// Parsea.
			precioProducto = Double.parseDouble(inputPrecioProducto);
			
			// Suma el total.
			total += precioProducto;
			
		}
		
		// Pregunta mientras pongan un iva que no sea 21 o 4
		do {
		
		String inputIva = JOptionPane.showInputDialog("Seleccione IVA: \n21% IVA\n4% IVA");
		
		// Parsea.
		iva = Double.parseDouble(inputIva);
		
		}while(iva != 21 && iva != 4);
		
		// Añade a la lista el iva.
		listaSuper.add("IVA: " + (int)iva+ "%.");
		
		// Asigna el iva segun seleccion.
		if(iva == 21) {
			iva = 0.21;
			
		}else if(iva == 4) {
			iva = 0.04;
		}
		
		// Calcula el IVA del total de la compra
		totalIva = total * iva;
		
		// Calcula el total de la compra + iva.
		totalCompraConIva = totalIva + total;
		
		// Añade a la lista el total bruto.
		listaSuper.add("Total bruto: " + total);
		
		// Añade a la lista el total con iva.
		listaSuper.add("Total + IVA: " + totalCompraConIva);
		
		// Pregunta por la cantidad pagada mientras sea inferior al de la compra.
		do {
		
		String inputCantidadPagada = JOptionPane.showInputDialog("¿Cuanto ha pagado el cliente?");
		
		// Parsea.
		cantidadPagada = Integer.parseInt(inputCantidadPagada);
		
		}while(cantidadPagada < totalCompraConIva);
		
		// Añade a la lista la cantidad pagada.
		listaSuper.add("Cantidad pagada: " + cantidadPagada + "€.");
		
		// Calcula el cambio a devolver.
		cambioDevolver = cantidadPagada - totalCompraConIva;
		
		// Añade a la lista el cambio a devolver.
		listaSuper.add("Cambio a devolver: " + cambioDevolver+ "€.");
		
		// Llama a la funcion que printa el listado.
		printaListado(listaSuper);
		
	}
	
	public static void printaListado(ArrayList<String> listado) {
		
		String lista="";
		
		// Recorre el ArrayList y printa los valores que hay en cada posicion.
		for (int i = 0; i < listado.size(); i++) {
			System.out.println(listado.get(i));
			
		}
		
	}

}
