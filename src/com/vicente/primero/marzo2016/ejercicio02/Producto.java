package com.vicente.primero.marzo2016.ejercicio02;

import java.io.Serializable;

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Declaración de atributos. Son privados para tener que usar getter y
	 * setter
	 */
	private String nombre;
	private float precio;
	private int stock;

	public Producto() {

	}

	public Producto(String nombre, float precio, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock() {
		return this.stock;
	}

}
