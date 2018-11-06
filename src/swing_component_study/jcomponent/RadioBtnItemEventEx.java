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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioBtnItemEventEx frame = new RadioBtnItemEventEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RadioBtnItemEventEx() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		ImageIcon icon = null;
		if (e.getSource() == rdbCherry) {
			icon = cherryIcon;
		}
		if (e.getSource() == rdbPear) {
			icon = pearIcon;
		}
		if (e.getSource() == rdbApple) {
			icon = appleIcon;
		}
		lblImg.setIcon(icon);
	}

}
