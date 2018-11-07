package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JTextFieldOtherEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField pfPwd;
	private JPasswordField pfPwd2;
	private JButton btnOk;
	private JLabel lblConfirm;
	private JFormattedTextField ftfDate;
	private JTextArea textArea;
	private JButton btnCancel;

	public JTextFieldOtherEx() throws ParseException {
		initComponents();
	}
	private void initComponents() throws ParseException {
		setTitle("JTextField JPasswordField JFormatedTextFiled이용");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pContent = new JPanel();
		pContent.setBorder(new TitledBorder(null, "TextField \uC0AC\uC6A9\uC608", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pContent, BorderLayout.NORTH);
		pContent.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblId = new JLabel("ID:");
		pContent.add(lblId);
		
		tfId = new JTextField();
		pContent.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblPwd = new JLabel("PASSWORD:");
		pContent.add(lblPwd);
		
		pfPwd = new JPasswordField();
		pContent.add(pfPwd);
		
		JLabel lblPassword = new JLabel("PASSWORD 확인");
		pContent.add(lblPassword);
		
		pfPwd2 = new JPasswordField();
		pContent.add(pfPwd2);
		
		JPanel pBlank = new JPanel();
		pContent.add(pBlank);
		
		lblConfirm = new JLabel("");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.RED);
		pContent.add(lblConfirm);
		
		JLabel lblDate = new JLabel("DATE:");
		pContent.add(lblDate);
		
		MaskFormatter mf = new MaskFormatter("####-##-##");
		mf.setPlaceholderCharacter('_');
		ftfDate = new JFormattedTextField(mf);
		ftfDate.setValue(LocalDate.now());
		pContent.add(ftfDate);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pContent.add(btnOk);
		
		btnCancel = new JButton("초기화");
		btnCancel.addActionListener(this);
		pContent.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			do_btnOk_actionPerformed(e);
		}
	}
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		try {
			validCheck();
			
			String pwd1 = new String(pfPwd.getPassword());
			String pwd2 = new String(pfPwd2.getPassword());
			
			if (pwd1.equals(pwd2)) {
				lblConfirm.setText("일치");
			}else {
				lblConfirm.setText("불일치");
			}
			
	
			String message = String.format(
					"id = %s%n"
					+ "passwd1 = %s%n"
					+ "passwd2 = %s%n"
					+ "date = %s%n", 
					tfId.getText().trim(), pwd1, pwd2, ftfDate.getText());
	
			textArea.append(message);
			
			tfId.requestFocus();
			tfId.selectAll();
	
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		tfId.setText("");
		pfPwd.setText("");
		pfPwd2.setText("");
		ftfDate.setValue(LocalDate.now());
		tfId.requestFocus();
	}
	
	private void validCheck() throws Exception {
		if (tfId.getText().equals("")) {
			throw new Exception("ID가 비어있음");
		}
		
		String pwd1 = new String(pfPwd.getPassword());
		String pwd2 = new String(pfPwd2.getPassword());
		
		if (pwd1.equals("")) {
			throw new Exception("Password가 비어있음");
		}
		
		if (pwd2.equals("")) {
			throw new Exception("Password2가 비어있음");
		}
	}
}

























