package swing_student_management.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import swing_student_management.dto.Student;

@SuppressWarnings("serial")
public class StudentListPanel extends JPanel {
	private JTable table;
	private List<Student> lists;
	private NonEditableModel model;
	private JScrollPane scrollPane;

	public StudentListPanel() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한 row만 선택가능
		table.setPreferredScrollableViewportSize(table.getPreferredSize());

		scrollPane.setViewportView(table);	
	}

	public void loadDatas() {
		model = new NonEditableModel(getDatas(), getColumnNames());
		table.setModel(model);
		setAlignWith();
	}

	public void setLists(List<Student> lists) {
		this.lists = lists;
	}

	public Object[][] getDatas() {
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getStudentArray(lists.get(i));
		}
		return datas;
		
	}

	private Object[] getStudentArray(Student std) {
		return new Object[] { std.getStdNo(), std.getStdName(), std.getKorScore(), std.getEngScore(),
				std.getMathScore(), std.getSum(), String.format("%6.2f", std.getAvg()) };
	}

	public String[] getColumnNames() {
		return new String[] { "학생 번호", "학생명", "국어", "영어", "수학", "총점", "평균" };
	}

	public void setPopMenu(JPopupMenu popup) {
		scrollPane.setComponentPopupMenu(popup);
		table.setComponentPopupMenu(popup);
	}

	public Student getSelectedStudent() throws Exception{
		int selectedIndex = table.getSelectedRow();
		String stdNo = (String) table.getValueAt(selectedIndex, 0);
		return new Student(stdNo);
	}

	public JTable getTable() {
		return table;
	}

	// ---컬럼 설정
	protected void setAlignWith() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableCellAlignment(SwingConstants.RIGHT, 2, 3, 4, 5, 6);
		tableSetWidth(150, 200, 100, 100, 100, 100, 100);
	}

	// 각 컬럼별 정렬설정
	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 각 컬럼별 사이즈 설정
	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

}
