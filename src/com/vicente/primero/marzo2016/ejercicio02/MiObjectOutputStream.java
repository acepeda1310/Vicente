package com.vicente.primero.marzo2016.ejercicio02;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {

	MiObjectOutputStream() throws IOException {
		super();
	}

	public MiObjectOutputStream(OutputStream out) throws IOException {
		super(out);
		// TODO Apéndice de constructor generado automáticamente
	}

	protected void writeStreamHeader() throws IOException {
	}

}
