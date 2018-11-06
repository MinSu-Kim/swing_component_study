package swing_student_management.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.TitledBorder;

import javafx.application.Platform;
import swing_student_management.dao.StudentDao;
import swing_student_management.dao.StudentDaoImpl;
import swing_student_management.dto.Student;

@SuppressWarnings("serial")
public class StudentManagementUI extends JFrame implements ActionListener{
	public static final String ADD = "추가";
	public static final String DEL = "삭제";
	public static final String UPDATE = "수정";
	
	public static final String KOR = "국어";
	public static final String ENG = "영어";
	public static final String MATH = "수학";
	
	private JPanel contentPane;
	private StudentDao dao;
	private StudentListPanel stdListPanel;
	
	private List<Student> stdLists;
	private ChartPanel chartPanel;
	
	public StudentManagementUI() {
		dao = new StudentDaoImpl();
		
		// 테스트
		stdLists = new ArrayList<>();
		/*		Random rnd = new Random(20181103);
		lists.add(new Student("S001", "김보민", rnd.nextInt(100)+1, rnd.nextInt(100)+1, rnd.nextInt(100)+1));
		lists.add(new Student("S002", "우선미", rnd.nextInt(100)+1, rnd.nextInt(100)+1, rnd.nextInt(100)+1));
		lists.add(new Student("S003", "이준민", rnd.nextInt(100)+1, rnd.nextInt(100)+1, rnd.nextInt(100)+1));
		lists.add(new Student("S004", "이천희", rnd.nextInt(100)+1, rnd.nextInt(100)+1, rnd.nextInt(100)+1));
		((StudentDaoImpl)dao).setLists(lists);*/
		//
		
//		stdLists = dao.getStudentList();
		
		dao.setStdudentList(stdLists);
		initComponents();
		reLoadDatas();
	}
	
	private void initComponents() {
		setTitle("학생 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new TitledBorder(null, "\uD559\uC0DD \uB9AC\uC2A4\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		
		stdListPanel = new StudentListPanel();
		stdListPanel.setLists(stdLists);
		stdListPanel.loadDatas();
		
		stdListPanel.setPopMenu(getPopupMenu());
		contentPane.add(stdListPanel, BorderLayout.CENTER);
		
		stdListPanel.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Platform.runLater(() -> {
					try {
						Student std = stdListPanel.getSelectedStudent();
						std = dao.searchStudent(std);
						chartPanel.changeChartData(std);
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "학생을 선택하세요");
					}
				});
			}
		});
	
		chartPanel = new ChartPanel();
		chartPanel.setStdLists(stdLists);
		contentPane.add(chartPanel, BorderLayout.SOUTH);
	}
	
	public JPopupMenu getPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem mntmAdd = new JMenuItem(ADD);
		mntmAdd.addActionListener(this);
		popupMenu.add(mntmAdd);
		
		JMenuItem mntmDel = new JMenuItem(DEL);
		mntmDel.addActionListener(this);
		popupMenu.add(mntmDel);
		
		JMenuItem mntmUpdate = new JMenuItem(UPDATE);
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);
		return popupMenu;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(UPDATE)) {
			do_mntmUpdate_actionPerformed(e);
		}
		if (e.getActionCommand().equals(DEL)) {
			do_mntmDel_actionPerformed(e);
		}
		if (e.getActionCommand().equals(ADD)) {
			do_mntmAdd_actionPerformed(e);
		}
	}
	
	protected void do_mntmAdd_actionPerformed(ActionEvent e) {
		StudentFormUI newForm = new StudentFormUI();
		newForm.setMainUI(this);
		newForm.setVisible(true);
	}
	
	protected void do_mntmDel_actionPerformed(ActionEvent e) {
		try {
			Student selectedStd = stdListPanel.getSelectedStudent();
			dao.deleteStudent(selectedStd);
			reLoadDatas();
		}catch (Exception e1) {
			if (stdLists.size()==0) {
				JOptionPane.showMessageDialog(null, "학생정보가 없습니다.");
				return;
			}
			JOptionPane.showMessageDialog(null, "삭제하고자하는 학생을 선택하세요.");
		}
	}
	
	protected void do_mntmUpdate_actionPerformed(ActionEvent e) {
		try {
			Student selectedStd = stdListPanel.getSelectedStudent();
			Student searchStd = dao.searchStudent(selectedStd);
			
			StudentFormUI updateForm = new StudentFormUI();
			updateForm.setMainUI(this);
			updateForm.setStudent(searchStd);
			updateForm.setStdNoEditable(false);
			updateForm.setBtnOkText(UPDATE);
			updateForm.setVisible(true);
		}catch (Exception e1) {
			if (stdLists.size()==0) {
				JOptionPane.showMessageDialog(null, "학생정보가 없습니다.");
				return;
			}
			JOptionPane.showMessageDialog(null, "수정하고자하는 학생을 선택하세요");
		}
	}

	public void addStudent(Student newStd) {
		dao.addStudent(newStd);
		reLoadDatas();
	}
	
	public void updateStudent(Student newStd) {
		dao.updateStudent(newStd);
		reLoadDatas();
	}
	
	public void reLoadDatas() {
		stdListPanel.loadDatas();
		chartPanel.loadAllChartData();
	}
}
