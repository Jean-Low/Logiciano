package br.pro.hashi.ensino.desagil.lucianogic.model;

public class XorGate extends Gate{
	private NandGate nan1; //HASHI LINDO!
	private NandGate nan2;
	private NandGate nan3;
	private NandGate nan4;

	public XorGate() {
		super(2,"Xor");
		nan1 = new NandGate();
		nan2 = new NandGate();
		nan3 = new NandGate();
		nan4 = new NandGate();
		
		nan4.connect(nan2, 0);
		nan4.connect(nan3, 1);
		nan3.connect(nan1, 0);
		nan2.connect(nan1, 1);
	}

	@Override
	public boolean read() {
		return nan4.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		if(index == 0){
			nan1.connect(emitter, index);
			nan2.connect(emitter, index);			
		} else{
			nan1.connect(emitter, index);
			nan3.connect(emitter, index);
		}
	}
}
