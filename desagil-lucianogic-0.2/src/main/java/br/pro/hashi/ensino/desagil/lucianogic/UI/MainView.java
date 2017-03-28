package br.pro.hashi.ensino.desagil.lucianogic.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.pro.hashi.ensino.desagil.lucianogic.model.*;

// Esta classe representa a interface principal, que permite
// selecionar uma calculadora de densidade a partir de um menu.
public class MainView extends JPanel implements ActionListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;


	// A componente JComboBox representa um menu.
	// https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
	private JComboBox<Gate> comboBox;

	private GateView gateView;

	public MainView(List<Gate> model) {
		comboBox = new JComboBox<>();

		for(Gate gate: model) {
			comboBox.addItem(gate);
		}
		comboBox.addActionListener(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(comboBox);

		// A descricao do metodo addCalculatorView esta logo abaixo.
		addGateView(comboBox.getItemAt(0));
		
		gateView.UpdateAll();
	}


	// Este metodo constroi uma nova interface para uma
	// calculadora e coloca essa interface abaixo do menu.
	private void addGateView(Gate gate) {
		gateView = new GateView(gate);
		add(gateView);
	}


	/* A PARTIR DESTE PONTO VOCE DEVE ENTENDER SOZINHO */


	@Override
	public void actionPerformed(ActionEvent event) {
		remove(gateView);

		int index = comboBox.getSelectedIndex();
		Gate gate = comboBox.getItemAt(index);
		addGateView(gate);
		gateView.UpdateAll();

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		frame.pack();
	}
}
