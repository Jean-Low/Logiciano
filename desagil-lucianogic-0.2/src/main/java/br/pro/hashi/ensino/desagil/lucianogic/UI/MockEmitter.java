package br.pro.hashi.ensino.desagil.lucianogic.UI;

import br.pro.hashi.ensino.desagil.lucianogic.model.Emitter;

public class MockEmitter implements Emitter {
	private boolean signal;

	public MockEmitter(boolean signal) {
		this.signal = signal;
	}

	@Override
	public boolean read() {
		return signal;
	}
}
