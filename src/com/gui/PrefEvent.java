package com.gui;

import java.awt.Color;
import java.awt.Font;

import java.util.EventObject;

public class PrefEvent extends EventObject{

	private static final long serialVersionUID = -3030051231757619530L;
	private Font font;
	private Color color;
	private String tema;

	public PrefEvent(Object source, Font d, Color color,
			String tema) {
		super(source);
		this.font = d;
		this.color = color;
		this.tema = tema;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
}
