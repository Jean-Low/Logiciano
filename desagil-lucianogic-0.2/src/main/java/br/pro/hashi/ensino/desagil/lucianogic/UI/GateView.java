package br.pro.hashi.ensino.desagil.lucianogic.UI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.lucianogic.model.*;

public class GateView extends JPanel implements ItemListener {
	private static final long serialVersionUID = 1L;
	
	private	JCheckBox in1;
	private	JCheckBox in2;
	private JCheckBox sel;
	private JCheckBox out;
	
	private Gate gate;
	private Switch switch1, switch2, switch3;
	
	public GateView(Gate gate){
		this.gate = gate;
		

		in1 = new JCheckBox("Input 1");
		in2 = new JCheckBox("Input 2");
		sel = new JCheckBox("Selector");
		out = new JCheckBox("Output");
		
		switch1 = new Switch();
		switch2 = new Switch();
		switch3 = new Switch();

		in1.addItemListener(this);
		in2.addItemListener(this);
		sel.addItemListener(this);
		out.setEnabled(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		

		JCheckBox[] Checkboxes = new JCheckBox[]{in1,in2,sel}; 
		for (int i = 0; i < gate.GetSize();i++){
			add(Checkboxes[i]);
		}
		add(out);
		
		out.setSelected(false);
	}
	
	public void UpdateAll(){
		try {
			switch1.setOn(in1.isSelected());
			switch2.setOn(in2.isSelected());
			switch3.setOn(sel.isSelected());
			
			List<Switch> switchlist = new LinkedList<>();
			switchlist.add(switch1);
			switchlist.add(switch2);
			switchlist.add(switch3);
			for (int i = 0; i < gate.GetSize();i++){
				gate.connect(switchlist.get(i), i);
			}
			
			out.setSelected(gate.read());
			System.out.println(gate.read());
			
		}
		
		catch(NumberFormatException exception) {
			System.out.println("batata");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		
	UpdateAll();

	}
}
