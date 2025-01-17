package com.unu.beans;

public class Productos {
	private int idproducto;
	private int capacidad_ml;
	private String color;
	private String material;

	public Productos(int idproducto, int capacidad_ml, String color, String material) {
		this.idproducto = idproducto;
		this.capacidad_ml = capacidad_ml;
		this.color = color;
		this.material = material;
	}

	public Productos() {
		this(0,0,"","");
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getCapacidad_ml() {
		return capacidad_ml;
	}

	public void setCapacidad_ml(int capacidad_ml) {
		this.capacidad_ml = capacidad_ml;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
