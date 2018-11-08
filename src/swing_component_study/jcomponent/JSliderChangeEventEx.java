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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class JSliderChangeEventEx extends JFrame implements ActionListener, ChangeListener {

	private JPanel contentPane;
	private JButton btnOk;
	private JSlider slider;
	private JLabel lblValue;
	private JSlider slider_R;
	private JLabel lblColor;
	private JSlider slider_G;
	private JSlider slider_B;

	public JSliderChangeEventEx() {
		initComponents();
	}

	private void initComponents() {
		setTitle("JSliderChangeEventEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 0));

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
	}

	public void actionPerformed(ActionEvent e) {
		int value = slider.getValue();
		JOptionPane.showMessageDialog(null, "슬라이더의 값은 " + value);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider_R || e.getSource() == slider_B || e.getSource() == slider_G) {
			Color color = new Color(slider_R.getValue(), slider_G.getValue(), slider_B.getValue());
			lblColor.setBackground(color);
		}

		if (e.getSource() == slider) {
			int value = slider.getValue();
			lblValue.setText(value + "");
		}
	}

}
