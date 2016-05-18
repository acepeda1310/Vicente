package com.vicente.primero.marzo2016.ejercicio02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	/*
	 * En este programa se ha usado mucho el throw new Exception. Puedes omitirlos todos, es sólo para dejar mensajes aclaratorios.
	 */

	private final static Scanner TECLADO = new Scanner(System.in);
	private final static String FICHERO = "productos.dat";

	private static boolean seguimos = true;

	private static void insertar() throws Exception {
		Producto producto = new Producto();
		System.out.print("Nombre del producto: ");
		producto.setNombre(TECLADO.nextLine());
		System.out.print("Precio del producto: ");
		producto.setPrecio(TECLADO.nextFloat());
		System.out.print("Stock del producto: ");
		producto.setStock(TECLADO.nextInt());
		if (producto.getPrecio() <= 0 || producto.getStock() < 0)
			throw new Exception("Datos del producto no válidos");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			File fichero = new File(FICHERO);
			if (fichero.exists()) {
				fos = new FileOutputStream(fichero, true);
				oos = new MiObjectOutputStream(fos);
			} else {
				fos = new FileOutputStream(fichero);
				oos = new ObjectOutputStream(fos);
			}
			oos.writeObject(producto);
			oos.close();
			System.out.println("Fichero actualizado con éxito.");
		} catch (Exception e) {
			throw new Exception("Error al guardar el fichero");
		}
	}

	private static void visualizar() throws Exception {
		Producto producto = null;
		ObjectInputStream ois = null;
		try {
			File fichero = new File(FICHERO);
			FileInputStream fis = new FileInputStream(fichero);
			ois = new ObjectInputStream(fis);
			while (true) {
				producto = (Producto) ois.readObject();
				System.out.println("Producto: " + producto.getNombre() + " - Precio: " + producto.getPrecio()
						+ " euros - Stock: " + producto.getStock() + " unidades.");
			}
		} catch (IOException ioe) {
			// TODO: handle exception
		} catch (ClassNotFoundException cnfe) {
			throw new Exception("No se pudo leer del fichero.");
		} finally {
		}
	}

	private static float comprar(float totalHastaAhora) throws Exception {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ObjectInputStream ois = null;
		try {
			File fichero = new File(FICHERO);
			FileInputStream fis = new FileInputStream(fichero);
			ois = new ObjectInputStream(fis);
			while (true) {
				Producto producto = (Producto) ois.readObject();
				if (producto.getStock() > 0)
					productos.add(producto);
			}
		} catch (IOException ioe) {

		} catch (ClassNotFoundException cnfe) {
			throw new Exception("No se pudo leer el fichero");
		} finally {
			ois.close();
		}
		for (int i = 0; i < productos.size(); i++) {
			System.out.println("Pulse " + (i + 1) + " para comprar " + productos.get(i).getNombre()
					+ " cuyo precio es de " + productos.get(i).getPrecio() + " euros y el stock es de "
					+ productos.get(i).getStock() + " unidades.");
		}
		int opcion = 0, unidades = 0;
		try {
			opcion = TECLADO.nextInt() - 1; // Resto uno para que realmente
			// comience por el cero.
			if (opcion < 0 || opcion >= productos.size())
				throw new Exception();
			System.out.println("Ha elegido comprar " + productos.get(opcion).getNombre());
			System.out.println("¿Cuántas unidades desea?");
			unidades = TECLADO.nextInt();
		} catch (Exception e) {
			throw new Exception("Error, vuelva a probar");
		}
		if (unidades <= 0)
			throw new Exception("Error, vuelva a probar");
		else if (unidades > productos.get(opcion).getStock())
			throw new Exception(
					"Lo sentimos, sólo tenemos disponibles " + productos.get(opcion).getStock() + " unidades.");
		totalHastaAhora += (productos.get(opcion).getPrecio() * unidades);
		productos.get(opcion).setStock(productos.get(opcion).getStock() - unidades);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			File fichero = new File(FICHERO);
			fos = new FileOutputStream(fichero);
			oos = new ObjectOutputStream(fos);
			for (int i = 0; i < productos.size(); i++) {
				oos.writeObject(productos.get(i));
			}
			oos.close();
			System.out.println("Fichero actualizado con éxito.");
		} catch (Exception e) {
			throw new Exception("Error al guardar el fichero");
		}
		System.out.println("¿Desea comprar otro producto?");
		String respuesta = TECLADO.nextLine();
		if (!(respuesta.toLowerCase().equals("si") || respuesta.toLowerCase().equals("sí")
				|| respuesta.toLowerCase().equals("no") || respuesta.equals("No")))
			throw new Exception("Respuesta no válida");
		if (respuesta.toLowerCase().equals("no"))
			throw new Exception("");
		try {
			totalHastaAhora = comprar(totalHastaAhora);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return totalHastaAhora;
	}

	private static void menu() {
		try {
			System.out.println("Pulse 1 para introducir productos en el fichero.");
			System.out.println("Pulse 2 para visualizar el fichero.");
			System.out.println("Pulse 3 para realizar una compra.");
			System.out.println("Pulse 4 para salir.");
			int opcion = TECLADO.nextInt();
			switch (opcion) {
			case 1:
				insertar();
				break;
			case 2:
				visualizar();
				break;
			case 3:
				System.out.println("El total de su compra asciende a " + comprar(0) + " euros.");
				break;
			case 4:
				seguimos = false;
				break;

			default:
				throw new Exception("Operación no válida");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// TODO: handle finally clause
			if (seguimos)
				menu();
		}
	}

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		System.out.println("-- Bienvenido a la Tienda de Deportes Decartón --");
		menu();
	}

}
