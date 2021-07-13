import java.util.Hashtable;
import javax.swing.JOptionPane;

/**
 * App 
 * Version 1.0
 * @author Sergio Galimany Hoyo
 */
public class S4Ud7Ej3App {

	public static void main(String[] args) {
		
		int cantidadProducto = 0;
		String nombreArticulo = "";
		int menu = 0;
		
		// Declara la Hashtable.
		Hashtable<Integer, String> listadoNombre = new Hashtable<Integer, String>();
		Hashtable<Integer, Double> listadoPrecio = new Hashtable<Integer, Double>();
		Hashtable<Integer, Integer> listadoCantidad = new Hashtable<Integer, Integer>();
		
		// Añade productos con precio a la lista de precios.
		listadoNombre.put(1, "Red Bull");
		listadoNombre.put(2, "Monster");
		listadoNombre.put(3, "Pizza");
		listadoNombre.put(4, "Pan");
		listadoNombre.put(5, "Huevos 12 uds");
		listadoNombre.put(6, "Flan 6 uds");
		listadoNombre.put(7, "Lechuga");
		listadoNombre.put(8, "Cafe");
		listadoNombre.put(9, "Donettes 8 uds");
		listadoNombre.put(10, "Queso rallado");
		
		listadoPrecio.put(1, 1.14);
		listadoPrecio.put(2, 1.0);
		listadoPrecio.put(3, 2.63);
		listadoPrecio.put(4, 0.95);
		listadoPrecio.put(5, 2.78);
		listadoPrecio.put(6, 1.75);
		listadoPrecio.put(7, 0.65);
		listadoPrecio.put(8, 2.50);
		listadoPrecio.put(9, 1.74);
		listadoPrecio.put(10, 1.91);
		
		// Añade productos con precio a la lista de precios.
		listadoCantidad.put(1, 22);
		listadoCantidad.put(2, 10);
		listadoCantidad.put(3, 26);
		listadoCantidad.put(4, 9);
		listadoCantidad.put(5, 28);
		listadoCantidad.put(6, 17);
		listadoCantidad.put(7, 6);
		listadoCantidad.put(8, 25);
		listadoCantidad.put(9, 17);
		listadoCantidad.put(10, 19);
		
		// Menu principal.
		do{
			String inputMenu = JOptionPane.showInputDialog("Seleccione con numeros:\n1- Ver listado de productos."
					+ "\n2- Ver producto concreto.\n3- Añadir producto nuevo.");
			// Parsea.
			menu = Integer.parseInt(inputMenu);
		
		}while(menu != 1 && menu != 2 && menu != 3);
		
		switch (menu) {
		
		case 1:
			verListadoProductos(listadoNombre, listadoPrecio, listadoCantidad);
			break;
			
		case 2:
			verProducto(listadoNombre, listadoPrecio, listadoCantidad);
			break;
			
		case 3:
			crearProducto(listadoNombre, listadoPrecio, listadoCantidad);
			break;
			
		default:
			break;
		}
		

	}
	
	// Funcion que recibe 3 hashtables y muestra los datos de todos los productos.
	public static void verListadoProductos(Hashtable<Integer, String> listadoNombre, 
											Hashtable<Integer, Double> listadoPrecio, 
											Hashtable<Integer, Integer> listadoCantidad) {
		
		// Recorre una hashtable.
		for (int i = 1; i <= listadoNombre.size(); i++) {
			// Muestra info.
			System.out.println((i)+": "+listadoNombre.get(i)+
								"\nPrecio: "+listadoPrecio.get(i)+
								"€\nCantidad: "+listadoCantidad.get(i)+" Unidades.\n");
			
		}
		
	}
	
	
	// Funcion que recibe 3 hashtables.
	// Pide numero de producto a elegir.
	// Muestra los datos del producto elegido.
	public static void verProducto(Hashtable<Integer, String> listadoNombre, 
									Hashtable<Integer, Double> listadoPrecio, 
									Hashtable<Integer, Integer> listadoCantidad) {
		
		String inputNumeroProducto="";
		int numeroProducto=0;
		
		// Pide numero de producto mientras sea igual o inferior a 0, 
		// o superior al maximo de disponibles.
		do {
			// Pide numero de producto.
			inputNumeroProducto = JOptionPane.showInputDialog("Hay "+listadoNombre.size()+" productos disponibles.\nEscriba el numero del producto:");
			// Parsea.
			numeroProducto = Integer.parseInt(inputNumeroProducto);
			
		}while(numeroProducto <= 0 || numeroProducto > listadoNombre.size());
		
		// Muestra info.
		System.out.println(numeroProducto+": "+listadoNombre.get(numeroProducto)+
				"\nPrecio: "+listadoPrecio.get(numeroProducto)+
				"€.\nCantidad: "+listadoCantidad.get(numeroProducto)+" Unidades.\n");
			
	}
	
	// Funcion que recibe 3 hashtables.
	// Pide los datos del producto a insertar.
	// Guarda los datos.
	public static void crearProducto(Hashtable<Integer, String> listadoNombre, 
									Hashtable<Integer, Double> listadoPrecio, 
									Hashtable<Integer, Integer> listadoCantidad) {
		
		String nombre = "";
		String inputPrecio = "";
		double precio = 0;
		String inputCantidad="";
		int cantidad=0;

		// Pide el nombre del producto.
		nombre = JOptionPane.showInputDialog("Escriba el nombre del producto nuevo:");
		
		// Pide el precio del producto.
		inputPrecio = JOptionPane.showInputDialog("Escriba el precio:");
		// Parsea.
		precio = Integer.parseInt(inputPrecio);
		
		// Pide la cantidad del producto.
		inputCantidad = JOptionPane.showInputDialog("Escriba la cantidad:");
		// Parsea.
		cantidad = Integer.parseInt(inputCantidad);

		// Lo añade a las listas.
		listadoNombre.put( (listadoNombre.size()+1) , nombre);
		listadoPrecio.put( (listadoPrecio.size()+1) , precio);
		listadoCantidad.put( (listadoCantidad.size()+1) , cantidad);
		
		// Muestra todos los productos otra vez.
		verListadoProductos(listadoNombre, listadoPrecio, listadoCantidad);
			
	}

}
