package br.pro.hashi.ensino.desagil.lucianogic.model;

public abstract class Gate implements Receiver, Emitter {
	private int size;
	private String name;

	protected Gate(int size,String name) {
		this.size = size;
		this.name = name;
	}
	@Override
	public String toString(){
		return name;
	}

	@Override
	public void connect(Emitter emitter, int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		doConnect(emitter, index);
	}
	
	public int GetSize(){
		return size;
	}

	protected abstract void doConnect(Emitter emitter, int index);
}
