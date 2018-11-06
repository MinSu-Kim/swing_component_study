package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class CheckBoxItemEventEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JCheckBox chkApple;
	private JCheckBox chkPear;
	private JCheckBox chkCherry;
	private int sum;
	private JLabel lblSum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxItemEventEx frame = new CheckBoxItemEventEx();
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
	public CheckBoxItemEventEx() {
		initComponents();
	}

	private void initComponents() {
		setTitle("ItemEvent 활용한 체크박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 157);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 10));

		JLabel lblTitle = new JLabel("사과 100원, 배 500원, 체리 2000원");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle);

		JPanel pChkBoxes = new JPanel();
		contentPane.add(pChkBoxes);

		chkApple = new JCheckBox("사과");
		chkApple.addItemListener(this);
		pChkBoxes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pChkBoxes.add(chkApple);

		chkPear = new JCheckBox("배");
		chkPear.addItemListener(this);
		pChkBoxes.add(chkPear);

		chkCherry = new JCheckBox("체리");
		chkCherry.addItemListener(this);
		pChkBoxes.add(chkCherry);

		lblSum = new JLabel("현재 0원 입니다");
		lblSum.setFont(new Font("굴림", Font.BOLD, 20));
		lblSum.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSum);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == chkCherry) {
			do_chkCherry_itemStateChanged(e);
		}
		if (e.getSource() == chkPear) {
			do_chkPear_itemStateChanged(e);
		}
		if (e.getSource() == chkApple) {
			do_chkApple_itemStateChanged(e);
		}
		lblSum.setText("현재 " + sum + "원 입니다");
	}

	protected void do_chkApple_itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			sum += 100;
		} else {
			sum -= 100;
		}
	}

	protected void do_chkPear_itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			sum += 500;
		} else {
			sum -= 500;
		}
	}

	protected void do_chkCherry_itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			sum += 2000;
		} else {
			sum -= 2000;
		}
	}
}
