package br.pro.hashi.ensino.desagil.lucianogic.UI;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import br.pro.hashi.ensino.desagil.lucianogic.model.*;

public class MainMain {


	public static void main(String[] args) {

		// Estrutura basica de um programa Swing. Nao precisa entender os detalhes por enquanto.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	// Cria o modelo.
            	List<Gate> model = new LinkedList<Gate>();
            	model.add(new NandGate());
            	model.add(new NotGate());
            	model.add(new OrGate());
            	model.add(new AndGate());
            	model.add(new XorGate());
            	model.add(new MuxGate());

            	// Cria a tela principal.
            	MainView mainView = new MainView(model);

            	// Cria a janela.
            	JFrame frame = new JFrame("Gate Tester");

            	// Coloca a tela principal na janela.
            	frame.setContentPane(mainView);

            	// Configura a janela para encerrar o programa quando for fechada.
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            	// Configura a janela para nao ser redimensionavel.
            	frame.setResizable(false);

            	// Redimensiona a janela de acordo com o tamanho do conteudo.
            	frame.pack();

            	// Mostra a janela.
            	frame.setVisible(true);
            	
            }
        });
    }
}
