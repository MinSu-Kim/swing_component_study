package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class JSliderChangeEventEx extends JFrame implements ActionListener, ChangeListener {

	private JPanel contentPane;
	private JButton btnOk;
	private JSlider slider;
	private JLabel lblValue;
	private JSlider slider_R;
	private JLabel lblColor;
	private JSlider slider_G;
	private JSlider slider_B;
	private JPanel pSpinner;
	private JSpinner spList;
	private JSpinner spNumber;
	private JSpinner spDate;
	private JButton btnSpinnerOk;
	private JPanel panel;

	public JSliderChangeEventEx() {
		initComponents();
	}

	private void initComponents() {
		setTitle("JSliderChangeEventEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));

		JPanel pBasicSlider = new JPanel();
		pBasicSlider.setBorder(new TitledBorder(null, "\uC2AC\uB77C\uC774\uB354 \uCEF4\uD3EC\uB10C\uD2B8",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pBasicSlider);

		slider = new JSlider();
		slider.addChangeListener(this);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		pBasicSlider.add(slider);

		btnOk = new JButton("슬라이더 값 확인");
		btnOk.addActionListener(this);
		pBasicSlider.add(btnOk);

		lblValue = new JLabel("");
		pBasicSlider.add(lblValue);

		JPanel pAdvanceSlider = new JPanel();
		pAdvanceSlider.setBorder(
				new TitledBorder(null, "\uC774\uBCA4\uD2B8\uB97C \uC801\uC6A9\uD55C \uC2AC\uB77C\uC774\uB354",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pAdvanceSlider);
		pAdvanceSlider.setLayout(new GridLayout(0, 1, 10, 10));

		slider_R = new JSlider();
		slider_R.setValue(128);
		slider_R.setForeground(Color.RED);
		slider_R.setMaximum(255);
		slider_R.setMinorTickSpacing(10);
		slider_R.setMajorTickSpacing(50);
		slider_R.setPaintTicks(true);
		slider_R.setPaintLabels(true);
		pAdvanceSlider.add(slider_R);

		slider_G = new JSlider();
		slider_G.setValue(128);
		slider_G.setPaintTicks(true);
		slider_G.setPaintLabels(true);
		slider_G.setMinorTickSpacing(10);
		slider_G.setMaximum(255);
		slider_G.setMajorTickSpacing(50);
		slider_G.setForeground(Color.GREEN);
		pAdvanceSlider.add(slider_G);

		slider_B = new JSlider();
		slider_B.setValue(128);
		slider_B.setPaintTicks(true);
		slider_B.setPaintLabels(true);
		slider_B.setMinorTickSpacing(10);
		slider_B.setMaximum(255);
		slider_B.setMajorTickSpacing(50);
		slider_B.setForeground(Color.BLUE);
		pAdvanceSlider.add(slider_B);

		lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBackground(new Color(slider_R.getValue(), slider_G.getValue(), slider_B.getValue()));
		pAdvanceSlider.add(lblColor);
		
		slider_R.addChangeListener(this);
		slider_G.addChangeListener(this);
		slider_B.addChangeListener(this);
		
		pSpinner = new JPanel();
		contentPane.add(pSpinner);
		pSpinner.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel = new JPanel();
		pSpinner.add(panel);
		
		spList = new JSpinner();
		spList.setModel(new SpinnerListModel(new String[] {"\uC18C\uC124", "\uC7A1\uC9C0", "\uC804\uACF5\uC11C\uC801", "\uCDE8\uBBF8"}));
		panel.add(spList);
		
		spNumber = new JSpinner();
		spNumber.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		panel.add(spNumber);
		
		spDate = new JSpinner();
		Calendar cal = Calendar.getInstance();
		Date value = cal.getTime();
		
		cal.add(Calendar.YEAR, -50);
		Date start = cal.getTime();
		
		cal.add(Calendar.YEAR, 100);
		Date end = cal.getTime();
		
		spDate.setModel(new SpinnerDateModel(value, start, end, Calendar.YEAR));
		spDate.setEditor(new JSpinner.DateEditor(spDate, "yyyy/MM/dd"));
		
		panel.add(spDate);
		
		btnSpinnerOk = new JButton("스피너 값 확인");
		btnSpinnerOk.addActionListener(this);
		pSpinner.add(btnSpinnerOk);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSpinnerOk) {
			do_btnSpinnerOk_actionPerformed(e);
		}else {
			int value = slider.getValue();
			JOptionPane.showMessageDialog(null, "슬라이더의 값은 " + value);
		}
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider_R || e.getSource() == slider_B || e.getSource() == slider_G) {
			Color color = new Color(slider_R.getValue(), slider_G.getValue(), slider_B.getValue());
			lblColor.setBackground(color);
			lblColor.setText(color.toString());
			lblColor.setForeground(new Color(255-slider_R.getValue(), 255-slider_G.getValue(), 255-slider_B.getValue()));
		}

		if (e.getSource() == slider) {
			int value = slider.getValue();
			lblValue.setText(value + "");
		}
	}

	protected void do_btnSpinnerOk_actionPerformed(ActionEvent e) {
		String strVal = (String) spList.getValue();
		int intVal = (int) spNumber.getValue();
		Date dateVal = (Date) spDate.getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		JOptionPane.showMessageDialog(null, strVal + "\n" + intVal + "\n" + sdf.format(dateVal));
	}
}
