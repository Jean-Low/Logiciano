package br.pro.hashi.ensino.desagil.lucianogic.model;

public class MuxGate extends Gate{
	private	NandGate nan1;
	private NandGate nan2;
	private NandGate nan3;
	private NandGate nan4;

		
	public MuxGate() {
		super(3);
		nan1 = new NandGate();
		nan2 = new NandGate();
		nan3 = new NandGate();
		nan4 = new NandGate();
		
		nan2.connect(nan1, 1);
		nan4.connect(nan2, 0);
		nan4.connect(nan3, 1);
		
	}

	@Override
	public boolean read() {
		return nan4.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index){
		case 0:
			nan2.connect(emitter, 0);
			break;
		case 1:
			nan3.connect(emitter, 0);
			break;
		case 2: 
			nan1.connect(emitter, 0);
			nan1.connect(emitter, 1);
			nan3.connect(emitter, 1);
		}
			
		
		
	}

}
