package br.pro.hashi.ensino.desagil.lucianogic.UI;

public abstract class PortaLogica {

	protected String name;
	public String toString() {
		return name;
	}

	public abstract boolean test( boolean in1, boolean in2, boolean sel);
}
