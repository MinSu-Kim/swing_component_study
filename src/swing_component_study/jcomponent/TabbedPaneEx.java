package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class TabbedPaneEx extends JFrame {

	private JPanel contentPane;
	private String imgPath;
	
	public TabbedPaneEx() {
		imgPath = System.getProperty("user.dir") + "\\images\\";
		initComponents();
	}
	
	private void initComponents() {
		setTitle("TabbedPaneEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JLabel lblTab1 = new JLabel(new ImageIcon(imgPath+"lyu.jpg") );
		tabbedPane.addTab("tab1", null, lblTab1, "이유영");
		
		JLabel lblTab2 = new JLabel(new ImageIcon(imgPath+"img1.jpg"));
		tabbedPane.addTab("tab2", null, lblTab2, "슈퍼맨");
		
		TblPanel panel = new TblPanel();
		tabbedPane.addTab("tab3", null, panel, "테이블");
	}

}
