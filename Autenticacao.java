package tradutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Autenticacao extends JFrame implements ActionListener{
	
	private JButton b1, b2;
	private JLabel label, label2, label3, label4, label5, label6;
	private	JTextField text;
	private	JPasswordField text2;
	private JPanel p1, p2;
	private FlowLayout lay;
	private GridLayout lay2;
	
	public Autenticacao(){
		
		setTitle("Syd Translation Autentication");
		setSize(400, 150);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(true);
		label = new JLabel("Utilizador");
		label2 = new JLabel("Senha");
		label3 = new JLabel("Autenticação");
		label4 = new JLabel(" ");
		label5 = new JLabel(" ");
		label6 = new JLabel(" ");
		lay2 = new GridLayout(4,2);
		lay = new FlowLayout();
		p1 = new JPanel();
		p2 = new JPanel();
		p1.setLayout(lay2);
		b1 = new JButton("Ir");
		b2 = new JButton("Cancelar");
		text = new JTextField(15);
		text2 = new JPasswordField(15);
		text2.setEchoChar('*');
		
		p2.setLayout(lay);
		p2.add(b1);
		p2.add(b2);
		p1.add(label3);
		p1.add(label4);
		p1.add(label);
		p1.add(text);
		p1.add(label2);
		p1.add(text2);
		p1.add(label5);
		p1.add(label6);
		add(BorderLayout.NORTH, p1);
		add(BorderLayout.SOUTH, p2);
		setResizable(false);
		setLocation(440, 250);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1) {
			if(text.getText().equalsIgnoreCase("Sydney Madope") && text2.getText().equalsIgnoreCase("1234")) {
				JOptionPane.showMessageDialog(null, "Sucesso");
				new Adicionar();
				setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "Fracasso");
			}
		}
		
		if(e.getSource() == b2) {
			text.setText("");
			text2.setText("");
		}
		
	}
}
