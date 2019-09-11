package tradutor;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Adicionar extends JFrame implements ActionListener{
		
	static Vector <String> PT = new Vector<>();
	static Vector <String> IN = new Vector<>();
	
	private JTextField tf1, tf2;
	private JButton b1;
	private JPanel p1, p2, p3;
	
	public Adicionar(){
		
		setSize(300, 200);
		setTitle("Syd Translations");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setLocation(450, 220);
		setLayout(new GridLayout(3,1));
		
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		tf1 = new JTextField(10);
		p1.add(new JLabel("Português: "));
		p1.add(tf1);
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		tf2 = new JTextField(10);
		p2.add(new JLabel("Inglês: "));
		p2.add(tf2);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		b1 = new JButton("Gravar");
		p3.add(b1);
		
		add(p1);
		add(p2);
		add(p3);
		
		b1.addActionListener(this);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			if(tf1.getText().equalsIgnoreCase("") || tf2.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Prencheencha ambos os campos");
			}
			
			else {
				PT.add(tf1.getText());
				IN.add(tf2.getText());
				
				tf1.setText("");
				tf2.setText("");
				
				try {
					BaseDeDados.escreverPT(PT);
					BaseDeDados.escreverIN(IN);
				} catch (IOException e1) {
					
					
					e1.printStackTrace();
				}
			}
		}
		
	}
		
}
