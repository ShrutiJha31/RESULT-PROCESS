import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MainPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(30, 144, 255));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Click here For Office Entry");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StudentResult ob=new StudentResult();
					
					ob.frame.setVisible(true);
			}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"NOT HAPPENING");
				}
		}});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnNewButton_1.setBackground(UIManager.getColor("CheckBox.background"));
		frame.getContentPane().add(btnNewButton_1, BorderLayout.WEST);
		
		JButton btnNewButton_2 = new JButton("Click To View Result");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StudentResultView ob=new StudentResultView();
		
					ob.frame.setVisible(true);
			}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"NOT HAPPENING");
				}
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frame.getContentPane().add(btnNewButton_2, BorderLayout.EAST);
		
		JButton btnNewButton_3 = new JButton("Click to Register");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StudentRegister ob=new StudentRegister();
					
					ob.frame.setVisible(true);
			}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"NOT HAPPENING");
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 35));
		frame.getContentPane().add(btnNewButton_3, BorderLayout.CENTER);
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
