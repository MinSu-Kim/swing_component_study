package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JComponentEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton b3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponentEx frame = new JComponentEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JComponentEx() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton b1 = new JButton("Mengenta/Yellow Button");
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		b1.setForeground(Color.MAGENTA);
		b1.setBackground(Color.YELLOW);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Disabled button");
		b2.setEnabled(false);
		contentPane.add(b2);
		
		b3 = new JButton("getX(), getY()");
		b3.addActionListener(this);
		contentPane.add(b3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b3) {
			do_b3_actionPerformed(e);
		}
	}
	protected void do_b3_actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		JComponentEx frame = (JComponentEx) b3.getTopLevelAncestor();
		frame.setTitle(b.getX() + ", " + b.getY());
	}
}
