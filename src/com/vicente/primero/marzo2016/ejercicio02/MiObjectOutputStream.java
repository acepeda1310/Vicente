package com.vicente.primero.marzo2016.ejercicio02;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 
 * @author Adrian Cepeda Avila
 *
 */
public class MiObjectOutputStream extends ObjectOutputStream {

	MiObjectOutputStream() throws IOException {
		super();
	}
	
	public MiObjectOutputStream(OutputStream out) throws IOException {
		super(out);
		// TODO Ap�ndice de constructor generado autom�ticamente
	}

	/**
	 * Con esto sustituimos el metodo original writeStreamHeader
	 * @throws java.io.IOException No se puede escribir en el fichero
	 */
	protected void writeStreamHeader() throws IOException {
	}

}
