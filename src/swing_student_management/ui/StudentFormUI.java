package swing_student_management.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import swing_student_management.dto.Student;

@SuppressWarnings("serial")
public class StudentFormUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMath;
	private JButton btnOk;
	private JButton btnCancel;
	
	private StudentManagementUI mainUI;
	
	public StudentFormUI() {
		initComponents();
	}

	private void initComponents() {
		setTitle("학생 정보");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblNo = new JLabel("학생 번호");
		contentPane.add(lblNo);

		tfNo = new JTextField();
		contentPane.add(tfNo);
		tfNo.setColumns(10);

		JLabel lblName = new JLabel("학생명");
		contentPane.add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		contentPane.add(tfName);

		JLabel lblKor = new JLabel("국어점수");
		contentPane.add(lblKor);

		tfKor = new JTextField();
		tfKor.setColumns(10);
		contentPane.add(tfKor);

		JLabel lblEng = new JLabel("영어점수");
		contentPane.add(lblEng);

		tfEng = new JTextField();
		tfEng.setColumns(10);
		contentPane.add(tfEng);

		JLabel lblMath = new JLabel("수학점수");
		contentPane.add(lblMath);

		tfMath = new JTextField();
		tfMath.setColumns(10);
		contentPane.add(tfMath);

		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		contentPane.add(btnOk);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			if (btnOk.getText().equals(StudentManagementUI.ADD)) {
				do_btnOk_Add_actionPerformed(e);
			}
			if (btnOk.getText().equals(StudentManagementUI.UPDATE)) {
				do_btnOk_Update_actionPerformed(e);
			}
		}
	}

	private void do_btnOk_Update_actionPerformed(ActionEvent e) {
		Student newStd = getStudent();
		mainUI.updateStudent(newStd);
		dispose();		
	}

	private void do_btnOk_Add_actionPerformed(ActionEvent e) {
		Student newStd = getStudent();
		mainUI.addStudent(newStd);
		dispose();
	}

	private Student getStudent() {
		String stdNo = tfNo.getText().trim();
		String stdName = tfName.getText().trim();
		double korScore = Double.parseDouble(tfKor.getText().trim());
		double engScore = Double.parseDouble(tfEng.getText().trim());
		double mathScore = Double.parseDouble(tfMath.getText().trim());
		return new Student(stdNo, stdName, korScore, engScore, mathScore);
	}
	
	public void setStudent(Student std) {
		tfNo.setText(std.getStdNo());
		tfName.setText(std.getStdName());
		tfKor.setText(String.valueOf(std.getKorScore()));
		tfEng.setText(String.valueOf(std.getEngScore()));
		tfMath.setText(String.valueOf(std.getMathScore()));
	}

	private void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		tfKor.setText("");
		tfEng.setText("");
		tfMath.setText("");
	}
	
	private void do_btnCancel_actionPerformed(ActionEvent e) {
		clearTf();
	}

	public void setStdNoEditable(boolean isEditable) {
		tfNo.setEditable(isEditable);
	}

	public void setBtnOkText(String text) {
		btnOk.setText(text);
	}

	public void setMainUI(StudentManagementUI studentManagementUI) {
		this.mainUI = studentManagementUI;
	}
}
