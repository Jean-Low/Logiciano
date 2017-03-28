package br.pro.hashi.ensino.desagil.lucianogic.model;

public class OrGate extends Gate {
	NandGate nan1;
	NandGate nan2;
	NandGate nan3;
	
	public OrGate() {
		super(2,"Or");
		 nan1 = new NandGate();
		 nan2 = new NandGate();
		 nan3 = new NandGate();
		 
		 nan3.connect(nan1, 0);
		 nan3.connect(nan2, 1);
	}

	@Override
	public boolean read() {
		return nan3.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		if(index == 0){
			nan1.connect(emitter, 0);
			nan1.connect(emitter, 1);
		}else{
			nan2.connect(emitter, 0);
			nan2.connect(emitter, 1);
		}
		}
}
