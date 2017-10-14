package idv.kiwi.app.win;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import idv.kiwi.app.service.LogonService;
import idv.kiwi.app.vo.UserVO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TglApp extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserId;
	private JPasswordField txtUserPwd;
	private JTextPane txtPaneInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TglApp frame = new TglApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TglApp() {
		setResizable(false);
		setTitle("TglApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("帳號");
		
		JLabel label_1 = new JLabel("密碼");
		
		txtUserId = new JTextField();
		txtUserId.setColumns(10);
		
		
		
		txtUserPwd = new JPasswordField();
		
		txtPaneInfo = new JTextPane();
		
		JButton btnOK = new JButton("確認");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogonService logonService = new LogonService();
				
				UserVO userVO = logonService.logon(txtUserId.getText(), new String(txtUserPwd.getPassword()));
				
				StringBuffer sbInfo = new StringBuffer();
				
				if(userVO == null) {
					sbInfo.append("帳號或密碼錯誤\n");
				} else {
					sbInfo.append("userType: ").append(userVO.getUserType()).append("\n");
					sbInfo.append(userVO.getMemo());
				}
				
				txtPaneInfo.setText(sbInfo.toString());
			}
		});
		
		JButton btnClear = new JButton("清除");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserId.setText("");
				txtUserPwd.setText("");
				txtPaneInfo.setText("");
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtPaneInfo))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(label)
									.addGap(15)
									.addComponent(txtUserId))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(txtUserPwd, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOK)
								.addComponent(btnClear))))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtUserId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOK))
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtUserPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(btnClear))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPaneInfo, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
