package br.pro.hashi.ensino.desagil.lucianogic.model;

public class AndGate extends Gate{
	private NandGate nan1;
	private NandGate nan2;

		
	public AndGate() {
		super(2,"And");
		nan1 = new NandGate();
		nan2 = new NandGate();
		
		nan2.connect(nan1, 0);
		nan2.connect(nan1, 1);
		
	}

	@Override
	public boolean read() {
		return nan2.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		nan1.connect(emitter, index);
	}
}

