package com.desafio.previred.dto;

public class ErrorResponse {
	private int codigoEstatus;
	private String mensaje;
	
    public ErrorResponse(int codigoEstatus, String mensaje) {
		super();
		this.codigoEstatus = codigoEstatus;
		this.mensaje = mensaje;
	}

    public ErrorResponse(String mensaje)
    {
        super();
        this.mensaje = mensaje;
    }

	public int getCodigoEstatus() {
		return codigoEstatus;
	}

	public void setCodigoEstatus(int codigoEstatus) {
		this.codigoEstatus = codigoEstatus;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
