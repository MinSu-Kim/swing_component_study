package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class RadioBtnItemEventEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbApple;
	private JRadioButton rdbPear;
	private JRadioButton rdbCherry;
	private String imgPath;
	private ImageIcon appleIcon;
	private ImageIcon pearIcon;
	private ImageIcon cherryIcon;
	private JLabel lblImg;

	public RadioBtnItemEventEx() {
		initComponents();
	}
	private void initComponents() {
		setTitle("ItemEvent 활용한 라디오 버튼");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 212, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		rdbApple = new JRadioButton("사과");
		rdbApple.setSelected(true);
		rdbApple.addItemListener(this);
		buttonGroup.add(rdbApple);
		panel.add(rdbApple);
		
		rdbPear = new JRadioButton("배");
		rdbPear.addItemListener(this);
		buttonGroup.add(rdbPear);
		panel.add(rdbPear);
		
		rdbCherry = new JRadioButton("체리");
		rdbCherry.addItemListener(this);
		buttonGroup.add(rdbCherry);
		panel.add(rdbCherry);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		
		imgPath = System.getProperty("user.dir") + "\\images\\fruits\\";
		appleIcon = new ImageIcon(imgPath + "apple.jpg");
		pearIcon = new ImageIcon(imgPath + "pear.jpg");
		cherryIcon = new ImageIcon(imgPath + "cherry.jpg");
		
		lblImg.setIcon(appleIcon);
		contentPane.add(lblImg, BorderLayout.CENTER);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rdbCherry) {
			do_rdbCherry_itemStateChanged(e);
		}
		if (e.getSource() == rdbPear) {
			do_rdbPear_itemStateChanged(e);
		}
		if (e.getSource() == rdbApple) {
			do_rdbApple_itemStateChanged(e);
		}
		
	}
	
	protected void do_rdbApple_itemStateChanged(ItemEvent e) {
		lblImg.setIcon(appleIcon);
	}
	
	protected void do_rdbPear_itemStateChanged(ItemEvent e) {
		lblImg.setIcon(pearIcon);
	}
	
	protected void do_rdbCherry_itemStateChanged(ItemEvent e) {
		lblImg.setIcon(cherryIcon);
	}
}
