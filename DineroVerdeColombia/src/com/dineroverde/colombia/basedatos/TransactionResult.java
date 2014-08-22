package com.dineroverde.colombia.basedatos;

public class TransactionResult<T> {

	private T contenido;
	private String mensaje;

	public TransactionResult(T contenido, String mensaje) {
		super();
		this.contenido = contenido;
		this.mensaje = mensaje;
	}

	public T getContenido() {
		return contenido;
	}

	public String getMensaje(){
		return mensaje;
	}
}
