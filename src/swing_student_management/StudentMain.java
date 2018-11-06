package swing_student_management;

import java.awt.EventQueue;

import swing_student_management.ui.StudentManagementUI;

public class StudentMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagementUI frame = new StudentManagementUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}