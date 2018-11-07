package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

public class JListAndJComboEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JList<String> listJListName;
	private List<String> listArrayListNames;

	public JListAndJComboEx() {
		listArrayListNames = new ArrayList<>();
		listArrayListNames.add("김보민");
		listArrayListNames.add("황경수");
		listArrayListNames.add("우선미");
		
		initComponents();
	}
	private void initComponents() {
		setTitle("JList And JComboEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 836, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 0));
		
		JPanel pJList = new JPanel();
		pJList.setBorder(new TitledBorder(null, "JList", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJList);
		pJList.setLayout(new GridLayout(0, 3, 10, 0));
		
		JList<String> list = new JList<>();
		list.setListData(getStringData());
		pJList.add(list);
		
		JList<ImageIcon> listImg = new JList<>();
		listImg.setListData(getImgIcons());
		pJList.add(listImg);
		
		JPanel pInputList = new JPanel();
		pJList.add(pInputList);
		pInputList.setLayout(new BorderLayout(0, 0));
		
		JPanel pInputName = new JPanel();
		pInputList.add(pInputName, BorderLayout.NORTH);
		
		JLabel lblName = new JLabel("이름 입력 후 <Enter>키");
		lblName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = listJListName.getSelectedValue();
				int selectIndex = listJListName.getSelectedIndex();
				JOptionPane.showMessageDialog(null, "선택한 이름은 " + name + "\n선택한 이름의 위치 : " + selectIndex);
			}
			
		});
		pInputName.add(lblName);
		
		tfName = new JTextField();
		tfName.addActionListener(this);
		pInputName.add(tfName);
		tfName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		pInputList.add(scrollPane, BorderLayout.CENTER);
		
	
		listJListName = new JList<>();
		listJListName.setListData(new Vector<>(listArrayListNames));
		listJListName.setVisibleRowCount(5);
		listJListName.setFixedCellWidth(100);
		scrollPane.setViewportView(listJListName);
		
		JPanel pJCombo = new JPanel();
		pJCombo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JComboBox", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pJCombo);
		pJCombo.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel subPjcombo1 = new JPanel();
		pJCombo.add(subPjcombo1);
		
		String[] strArr1 = {"apple", "banana", "charrry"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(strArr1);
		JComboBox<String> cmb1 = new JComboBox<>(model);
		subPjcombo1.add(cmb1);
		
		String[] strArr2 = {"김보민", "우선미", "황경수", "이준민"};
		JComboBox<String> cmb2 = new JComboBox<>();
		
		for(int i=0; i<strArr2.length; i++) {
			cmb2.addItem(strArr2[i]);
		}
		
		cmb2.setSelectedIndex(-1);

		cmb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = (String) cmb2.getSelectedItem();
				int index = cmb2.getSelectedIndex();
				JOptionPane.showMessageDialog(null, index + "번째 선택된 이름 " + name);
				
			}
		});
		
		subPjcombo1.add(cmb2);
		
		
		JPanel subPjcombo2 = new JPanel();
		pJCombo.add(subPjcombo2);
	}

	private ImageIcon[] getImgIcons() {
		String imgPath = System.getProperty("user.dir") + "\\images\\";
		ImageIcon[] icons = new ImageIcon[] {
				new ImageIcon(imgPath + "icon1.png"),
				new ImageIcon(imgPath + "icon2.png"),
				new ImageIcon(imgPath + "icon3.png"),
				new ImageIcon(imgPath + "icon4.png")
		};
		return icons;
	}

	private String[] getStringData() {
		return new String[] {"apple", "banaa", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackverry"};
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfName) {
			do_tfName_actionPerformed(e);
		}
	}
	protected void do_tfName_actionPerformed(ActionEvent e) {
		listArrayListNames.add(tfName.getText().trim());//tfname에 있는 값을 List<String>에 추가
		listJListName.setListData(new Vector<>(listArrayListNames));
		tfName.setText("");
		tfName.requestFocus();
	}
}
