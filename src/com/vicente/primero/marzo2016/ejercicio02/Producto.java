package com.vicente.primero.marzo2016.ejercicio02;

import java.io.Serializable;

/**
 * 
 * @author Adrian Cepeda Avila
 *
 */
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Declaracion de atributos. Son privados para tener que usar getter y
	 * setter
	 */
	private String nombre;
	private float precio;
	private int stock;

	public Producto() {

	}

	/**
	 * Constructor parametrizado
	 * @param nombre Nombre del producto
	 * @param precio Precio del producto
	 * @param stock Stock del producto
	 */
	public Producto(String nombre, float precio, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	/**
	 * Set del nombre
	 * @param nombre Nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Get del nombre
	 * @return Nombre del producto
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Set del precio
	 * @param precio Precio del producto
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Get del precio
	 * @return Precio del producto
	 */
	public float getPrecio() {
		return this.precio;
	}

	/**
	 * Set del stock
	 * @param stock Stock del producto
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Get del stock
	 * @return Stock del producto
	 */
	public int getStock() {
		return this.stock;
	}

}
