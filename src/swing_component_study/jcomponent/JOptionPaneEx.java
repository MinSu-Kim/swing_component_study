package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class JOptionPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn01;

	/**
	 * Create the frame.
	 */
	public JOptionPaneEx() {
		initComponents();
	}
	private void initComponents() {
		setTitle("JOptionPaneEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "ShowInputDialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		
		btn01 = new JButton("input");
		btn01.addActionListener(this);
		panel.setLayout(new GridLayout(1, 1, 10, 10));
		panel.add(btn01);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "ShowConfirmDialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 3, 10, 0));
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_1.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "ShowMessageDialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 10, 0));
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel_2.add(btnNewButton_7);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			do_btn01_actionPerformed(e);
		}
	}
	protected void do_btn01_actionPerformed(ActionEvent e) {
		String[] selectionValues = {"가","나", "다"};
		Object res = JOptionPane.showInputDialog(null, "showInputDialog", "showInputDialog", JOptionPane.INFORMATION_MESSAGE, null, selectionValues, selectionValues[0]);
		JOptionPane.showMessageDialog(null, res);
	}
}
