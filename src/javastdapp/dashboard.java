package javastdapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class dashboard extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	public dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(115, 210, 22));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(134, 12, 115, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course Management System");
		lblNewLabel_1.setBackground(new Color(115, 210, 22));
		lblNewLabel_1.setBounds(12, 58, 210, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(12, 102, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(12, 162, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tutors");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(12, 212, 117, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setBounds(12, 266, 117, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Mail");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setBounds(12, 317, 117, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Setting");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(0, 0, 0));
		btnNewButton_5.setBounds(12, 370, 117, 25);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("Notification");
		lblNewLabel_2.setBounds(396, 24, 117, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Activity History");
		lblNewLabel_3.setBounds(180, 145, 125, 15);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(165, 162, 257, 276);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("To Do");
		lblNewLabel_4.setBounds(443, 107, 70, 15);
		contentPane.add(lblNewLabel_4);
	}

}


