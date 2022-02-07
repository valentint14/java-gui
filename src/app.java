import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Label;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class app {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public app() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		Vector<String> lista_nume = new Vector<String>();
		Vector<JButton> lista_butoane = new Vector<JButton>();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNull = new JButton("null");
		btnNull.setBounds(242, 27, 130, 25);
		frame.getContentPane().add(btnNull);
		
		JButton btnNull_1 = new JButton("null");
		btnNull_1.setBounds(242, 65, 130, 25);
		frame.getContentPane().add(btnNull_1);
		
		JButton btnNull_2 = new JButton("null");
		btnNull_2.setBounds(242, 103, 130, 25);
		frame.getContentPane().add(btnNull_2);
		
		JButton btnNull_3 = new JButton("null");
		btnNull_3.setBounds(242, 141, 130, 25);
		frame.getContentPane().add(btnNull_3);
		
		JButton btnNull_4 = new JButton("null");
		btnNull_4.setBounds(242, 179, 130, 25);
		frame.getContentPane().add(btnNull_4);
		
		textField = new JTextField();
		textField.setBounds(35, 180, 122, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		Label label = new Label("Prefix");
		label.setBounds(35, 150, 70, 24);
		frame.getContentPane().add(label);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnOptiune = new JMenu("Optiune");
		menuBar.add(mnOptiune);
		
		lista_butoane.add(btnNull);
		lista_butoane.add(btnNull_1);
		lista_butoane.add(btnNull_2);
		lista_butoane.add(btnNull_3);
		lista_butoane.add(btnNull_4);
		
		JMenuItem mntmInit = new JMenuItem("Init");
		mntmInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					FileReader fr = new FileReader(new File(".\\src\\in.txt"));
					BufferedReader br = new BufferedReader(fr);
					while(true){
						String linie = br.readLine();
						if (linie == null)
							break;
						lista_nume.add(linie);
					}
					br.close();
					for(int i = 0; i < lista_butoane.size(); i++){
						for(i = 0; i < lista_nume.size(); i++){
							lista_butoane.get(i).setText(lista_nume.get(i));
							frame.revalidate();
						}
					}
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		});
		mnOptiune.add(mntmInit);
		
		JMenuItem mntmModificare = new JMenuItem("Modificare");
		mntmModificare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = textField.getText();
				for(int i = 0; i < lista_butoane.size(); i++){
					for(i = 0; i < lista_nume.size(); i++){
						lista_butoane.get(i).setText(text + lista_nume.get(i));
						frame.revalidate();
					}
				}
			}
		});
		mnOptiune.add(mntmModificare);
	}
}