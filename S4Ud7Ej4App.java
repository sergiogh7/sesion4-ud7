import java.util.Hashtable;

import javax.swing.JOptionPane;

/**
 * App 
 * Version 1.0
 * @author Sergio Galimany Hoyo
 */
public class S4Ud7Ej4App {

	public static void main(String[] args) {
		
		int cantidadProducto = 0;
		String nombreArticulo = "";
		int menu = 0;
		
		// Declara la Hashtable.
		Hashtable<Integer, String> listadoNombre = new Hashtable<Integer, String>();
		Hashtable<Integer, Double> listadoPrecio = new Hashtable<Integer, Double>();
		Hashtable<Integer, Integer> listadoCantidad = new Hashtable<Integer, Integer>();
		Hashtable<Integer, Double> listadoIva = new Hashtable<Integer, Double>();
		
		// Nombres
		listadoNombre.put(1, "Red Bull");
		listadoNombre.put(2, "Monster");
		listadoNombre.put(3, "Pizza");
		listadoNombre.put(4, "Pan");
		listadoNombre.put(5, "Huevos de 12 uds");
		listadoNombre.put(6, "Flan de 6 uds");
		listadoNombre.put(7, "Lechuga");
		listadoNombre.put(8, "Cafe");
		listadoNombre.put(9, "Donettes de 8 uds");
		listadoNombre.put(10, "Queso rallado");
		// Precios
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
		// Cantidades
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
		// IVA
		listadoIva.put(1, 0.21);
		listadoIva.put(2, 0.21);
		listadoIva.put(3, 0.04);
		listadoIva.put(4, 0.04);
		listadoIva.put(5, 0.21);
		listadoIva.put(6, 0.21);
		listadoIva.put(7, 0.04);
		listadoIva.put(8, 0.21);
		listadoIva.put(9, 0.04);
		listadoIva.put(10, 0.21);
		
		// Menu principal parte 1.
		do{
			String inputMenu = JOptionPane.showInputDialog("Seleccione con numeros:\n1- Ver listado de productos."
					+ "\n2- Ver un producto concreto.\n3- Añadir producto nuevo.\n4- Comprar producto.");
			// Parsea.
			menu = Integer.parseInt(inputMenu);
		
		}while(menu != 1 && menu != 2 && menu != 3 && menu != 4);
		
		// Menu parte 2.
		switch (menu) {
		
		case 1:
			verListadoProductos(listadoNombre, listadoPrecio, listadoCantidad, listadoIva);
			break;
			
		case 2:
			verProducto(listadoNombre, listadoPrecio, listadoCantidad, listadoIva);
			break;
			
		case 3:
			crearProducto(listadoNombre, listadoPrecio, listadoCantidad, listadoIva);
			break;
		
		case 4:
			comprarProducto(listadoNombre, listadoPrecio, listadoCantidad, listadoIva);
			break;
			
		default:
			break;
		}
		

	}
	
	// Funcion que recibe 4 hashtables y muestra los datos de todos los productos.
	public static void verListadoProductos(Hashtable<Integer, String> listadoNombre, 
											Hashtable<Integer, Double> listadoPrecio, 
											Hashtable<Integer, Integer> listadoCantidad,
											Hashtable<Integer, Double> listadoIva) {
		
		// Recorre una hashtable.
		for (int i = 1; i <= listadoNombre.size(); i++) {
			// Muestra info.
			System.out.println((i)+": "+listadoNombre.get(i)+
								"\nPrecio: "+listadoPrecio.get(i)+
								"€\nCantidad: "+listadoCantidad.get(i)+
								" Unidades.\nIVA: " + (int)(listadoIva.get(i)*100)+"%.\n");
			
		}
		
	}
	
	// Funcion que recibe una 4 hashtables.
	// Pide numero de producto a elegir.
	// Muestra los datos del producto elegido.
	public static void verProducto(Hashtable<Integer, String> listadoNombre, 
									Hashtable<Integer, Double> listadoPrecio, 
									Hashtable<Integer, Integer> listadoCantidad,
									Hashtable<Integer, Double> listadoIva) {
		
		String inputNumeroProducto="";
		int numeroProducto=0;
		
		// Muestra id y nombre de todos los productos.
		for (int i = 1; i <= listadoNombre.size(); i++) {
			System.out.println(i+": "+listadoNombre.get(i)+".");
		}
		//Salto de linea.
		System.out.println("");
		
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
				"€.\nCantidad: "+listadoCantidad.get(numeroProducto)+" Unidades."
						+ "\nIVA: " + (int)(listadoIva.get(numeroProducto)*100)+"%.\n");
			
	}
	
	// Funcion que recibe 4 hashtables.
	// Pide los datos del producto a insertar.
	// Guarda los datos.
	public static void crearProducto(Hashtable<Integer, String> listadoNombre, 
									Hashtable<Integer, Double> listadoPrecio, 
									Hashtable<Integer, Integer> listadoCantidad,
									Hashtable<Integer, Double> listadoIva) {
		
		String nombre = "";
		String inputPrecio = "";
		double precio = 0;
		String inputCantidad="";
		int cantidad=0;
		String inputIva="";
		double iva;
		double ivaInsertar = 0;

		// Pide el nombre del producto.
		nombre = JOptionPane.showInputDialog("Escriba el nombre del producto nuevo:");
		
		// Pide el precio del producto.
		inputPrecio = JOptionPane.showInputDialog("Escriba el precio:");
		// Parsea.
		precio = Double.parseDouble(inputPrecio);
		
		// Pide la cantidad del producto.
		inputCantidad = JOptionPane.showInputDialog("Escriba la cantidad:");
		// Parsea.
		cantidad = Integer.parseInt(inputCantidad);
		
		// Pide la cantidad del producto.
		inputIva = JOptionPane.showInputDialog("Escriba el IVA\nInserte:\n21 para 21%\n4 para 4%");
		// Parsea.
		iva = Integer.parseInt(inputIva);
		ivaInsertar = iva / 100;
		
		// Lo añade a las listas.
		listadoNombre.put( (listadoNombre.size()+1) , nombre);
		listadoPrecio.put( (listadoPrecio.size()+1) , precio);
		listadoCantidad.put( (listadoCantidad.size()+1) , cantidad);
		listadoIva.put( (listadoIva.size()+1) , ivaInsertar);
		
		// Muestra todos los productos otra vez.
		verListadoProductos(listadoNombre, listadoPrecio, listadoCantidad, listadoIva);
			
	}
	
	// Funcion que recibe 4 hashtables.
	public static void comprarProducto(Hashtable<Integer, String> listadoNombre, 
										Hashtable<Integer, Double> listadoPrecio, 
										Hashtable<Integer, Integer> listadoCantidad,
										Hashtable<Integer, Double> listadoIva) {
		double iva;
		double cantidadPagada = 0;
		double cambioDevolver = 0;
		double precioProducto = 0;
		int numeroProducto = 0;
		double total = 0;
		double totalCompraConIva = 0;
		int numeroProductosComprados=0;
		double precioDelIva = 0;
		String seguir = "";
		int productosComprados = 0;
		int unidadesVendidas = 0;
		
		// Muestra id y nombre de todos los productos.
		for (int i = 1; i <= listadoNombre.size(); i++) {
			System.out.println(i+": "+listadoNombre.get(i)+" - Precio: "+listadoPrecio.get(i)+"€.");
		}
		//Salto de linea.
		System.out.println("");
		
		do {
			
			// Mientras haya existencias o no reclame un producto inexistente...
			do {
				// Pregunta al usuario el numero del producto comprado.
				String inputNumeroProducto = JOptionPane.showInputDialog("Escriba el numero del producto que quiere comprar.");
				// Parsea.
				numeroProducto = Integer.parseInt(inputNumeroProducto);
				
				// Si el stock es de 0 unidades muestra una alerta.
				if(listadoCantidad.get(numeroProducto) == 0) {
					JOptionPane.showMessageDialog(null, "No queda stock de " + listadoNombre.get(numeroProducto) + ".");
				}
				
			}while(numeroProducto <= 0 || numeroProducto > listadoNombre.size() || listadoCantidad.get(numeroProducto) == 0);
			
			// Pide una y otra vez la cantidad del producto a comprar siempre y cuando haya existencias.
			do {
				// Pide la cantidad comprada del producto.
				 String inputNumeroProductosComprados =JOptionPane.showInputDialog("Escriba la cantidad de " +listadoNombre.get(numeroProducto)
													+ " que quiere comprar.\nHay " +listadoCantidad.get(numeroProducto)+ " unidades disponibles.");
				// Parsea.
				numeroProductosComprados = Integer.parseInt(inputNumeroProductosComprados);

			}while(numeroProductosComprados > listadoCantidad.get(numeroProducto));
				
			// Cambia de la lista el numero de productos.
			listadoCantidad.replace(numeroProducto, (listadoCantidad.get(numeroProducto) - numeroProductosComprados) );
				
			// Coge el precio del producto.
			precioProducto = listadoPrecio.get(numeroProducto);
				
			// Suma el total bruto(sin IVA)
			total += (precioProducto*numeroProductosComprados);
			
			// Coge el IVA.
			iva = listadoIva.get(numeroProducto);
			
			// Calcula el IVA del producto.
			precioDelIva = (precioProducto * numeroProductosComprados) * iva;
			
			// Calcula el total con IVA
			totalCompraConIva = (total + precioDelIva);
			
			seguir = JOptionPane.showInputDialog("Ha comprado " +numeroProductosComprados+ " unidades de " +listadoNombre.get(numeroProducto)+ 
													"\n¿Comprar otro producto?\nS/N");
			
			// Total de productos comprados
			productosComprados++;
			
			// Total de unidades vendidas.
			unidadesVendidas+= numeroProductosComprados;
		
		}while(seguir.equalsIgnoreCase("s"));
		
		do {
		// Pago.
		String pago = JOptionPane.showInputDialog("Total a pagar : " + totalCompraConIva + "€.\nEscriba importe de abono.");
		// Parsea.
		cantidadPagada = Integer.parseInt(pago);
		
		}while(cantidadPagada < totalCompraConIva);
		
		// Cambio al cliente.
		cambioDevolver = ( cantidadPagada - totalCompraConIva);
		
		// Info final.
		System.out.println("* * * T I C K E T * * *"
				+ "\nNumero de unidades: " +unidadesVendidas+ "\nNumero de productos comprados: " +productosComprados+"\nTotal en bruto: " + total + "€.\n"
							+ "Total con IVA: " + totalCompraConIva + "€."
									+ "\nPagado: " + cantidadPagada + "€."
											+ "\nCambio devuelto: " + cambioDevolver+ "€."
													+ "\n* * * * * * * * * * * *");
		
	}

}
