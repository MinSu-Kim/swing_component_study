package swing_component_study.jcomponent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TblPanel extends JPanel {
	private JTable table;

	public TblPanel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1, "김보민", 90, 90, 90, 270, 90},
				{2, "우선미", 90, 90, 90, 270, 90},
				{3, "박수완", 90, 90, 90, 270, 90},
			},
			new String[] {
				"학번", "성명", "국어", "영어", "수학", "총점", "평균"
			}
		));
		scrollPane.setViewportView(table);
		setAlignWidth();
	}
	
	private void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableCellAlignment(SwingConstants.RIGHT, 2,3,4,5,6);
		tableSetWidth(100, 200, 100, 100, 100, 150, 150);
	}

	private void tableCellAlignment(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
/*		
		System.out.println(Arrays.toString(idx)); // 0, 1  : 2,3,4,5,6
*/		
		TableColumnModel tcm = table.getColumnModel();
		for (int i=0; i< idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	private void tableSetWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i=0; i< width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}
}






