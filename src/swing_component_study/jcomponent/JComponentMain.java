package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class JComponentMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn5;
	private JButton btn7;
	private JButton btn6;
	private JButton btn3;
	private JButton btn2;
	private JButton btn4;
	private JButton btn8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponentMain frame = new JComponentMain();
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
	public JComponentMain() {
		initComponents();
	}

	private void initComponents() {
		setTitle("모든 JComponent예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));

		btn1 = new JButton("CheckBoxItemEvent");
		btn1.addActionListener(this);
		contentPane.add(btn1);

		btn2 = new JButton("JButtonEx");
		btn2.addActionListener(this);
		contentPane.add(btn2);

		btn3 = new JButton("JComponentEx");
		btn3.addActionListener(this);
		contentPane.add(btn3);

		btn4 = new JButton("JLabelEx");
		btn4.addActionListener(this);
		contentPane.add(btn4);

		btn5 = new JButton("JListAndJComboEx");
		btn5.addActionListener(this);
		contentPane.add(btn5);

		btn6 = new JButton("JTextFieldOtherEx");
		btn6.addActionListener(this);
		contentPane.add(btn6);

		btn7 = new JButton("RadioBtnItemEventEx");
		btn7.addActionListener(this);
		contentPane.add(btn7);
		
		btn8 = new JButton("JSliderEx");
		btn8.addActionListener(this);
		contentPane.add(btn8);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn8) {
			showFrame(new JSliderChangeEventEx());
		}

		if (e.getSource() == btn1) {
			showFrame(new CheckBoxItemEventEx());
		}
		if (e.getSource() == btn2) {
			showFrame(new JButtonEx());
		}
		if (e.getSource() == btn3) {
			showFrame(new JComponentEx());
		}
		if (e.getSource() == btn4) {
			showFrame(new JLabelEx());
		}
		if (e.getSource() == btn5) {
			showFrame(new JListAndJComboEx());
		}
		if (e.getSource() == btn6) {
			try {
				showFrame(new JTextFieldOtherEx());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btn7) {
			showFrame(new RadioBtnItemEventEx());
		}


	}

	private void showFrame(JFrame frame) {
		frame.setVisible(true);
	}

}
