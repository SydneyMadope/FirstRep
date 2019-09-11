package tradutor;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class JanelaTraducao extends JFrame implements ActionListener{
	
	static int posicao = 0;
	static Vector <String> PT = new Vector<>();
	static Vector <String> IN = new Vector<>();
	private JMenuBar mb;
	private JMenu menu;
	private JMenuItem item1, item2, item3, item4;
	private JTextField tf1;
	private JButton b1;
	private JLabel lb1;
	private JPanel p1, p2;
	
	public JanelaTraducao(){
		
		setSize(480, 200);
		setTitle("Syd Translations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(410, 220);
		setLayout(new GridLayout(2,1));
		
		//Barra de Menu:
		mb = new JMenuBar();
		menu = new JMenu("Menu");
		item1 = new JMenuItem("Adicionar");
		item2 = new JMenuItem("Sair");
		item3 = new JMenuItem("Português - Inglês");
		item4 = new JMenuItem("Inglês - Português");
		mb.add(menu);
		
		
		menu.add(item3);
		menu.add(item4);
		menu.addSeparator();
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		
		//Componentes da Janela:
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		tf1 = new JTextField(10);
		b1 = new JButton("Traduzir");
		p1.add(tf1);
		p1.add(b1);
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		lb1 = new JLabel("");
		p2.add(lb1);
		
		add(p1);
		add(p2);
		
		b1.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		setJMenuBar(mb);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
			if(tf1.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Preencha o campo de texto");
			}
			
			else {
				for(int i = 0; PT.size() > i; i++) {
					if(!tf1.getText().equalsIgnoreCase(PT.elementAt(i).toString())) {
						posicao = i;
						for(int j = 0; IN.size() > j; j++) {
							lb1.setText(IN.elementAt(posicao).toString());
						}
					}
				
				}
			}
		}

		
		if(e.getSource() == item1) {
			new Autenticacao();
		}
		
		if(e.getSource() == item2) {
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			for(LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
				UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
				break;
			}
		}
		catch(Exception e) {
			
		}
		
		BaseDeDados.lerPT(PT);
		BaseDeDados.lerIN(IN);
		new JanelaTraducao();
		
	}
}
