import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.sql.*;

import javax.swing.*;
import java.awt.SystemColor;
 public class StudentResult {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();
	
	

	/**
	 * Launch the application.
	 */
	public void updateTable()
	{
		conn=SqliteConnection2.ConnectDb();
		/*if(conn != null)
		{
			String sql="Select StudentID, Mathematics, Physics, Chemistry, Total ";
			try {
				pst = conn.prepareStatement(sql);
				rs=pst.executeQuery();
				Object[] columnData = new Object[13];
				while(rs.next())
				{
					columnData[0]=rs.getString("Application ID");
					columnData[1]=rs.getString("MATHEMATICS");
					columnData[2]=rs.getString("PHYSICS");
					columnData[3]=rs.getString("CHEMISTRY");
					columnData[4]=rs.getString("TOTAL");
					model.addRow(columnData);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e);
				
			}
		}*/
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentResult window = new StudentResult();
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
	public StudentResult() {
		initialize();
		conn = SqliteConnection2.ConnectDb();
		Object col[]= {"StudentID", "Mathematics", "Physics", "Chemistry", "Total"};
		model.setColumnIdentifiers(col);
	
		updateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */ 
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.PINK);
		panel.setBorder(new LineBorder(null, 8));
		panel.setBounds(482, 137, 689, 520);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER DETAILS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(233, 45, 201, 49);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Application ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(64, 135, 216, 28);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(315, 135, 317, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PHYSICS\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(64, 203, 216, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("CHEMISTRY");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(64, 273, 216, 28);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("MATHEMATICS");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(64, 348, 216, 28);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("TOTAL\r\n");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(64, 414, 216, 28);
		panel.add(lblNewLabel_2_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(315, 203, 317, 28);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(315, 273, 317, 28);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(315, 348, 317, 28);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(315, 414, 317, 28);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("SUBMIT\r\n");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double R[] = new double[14];
				
				R[1]=Double.parseDouble(textField_1.getText());
				R[2]=Double.parseDouble(textField_2.getText());
		        R[3]=Double.parseDouble(textField_3.getText());		
				R[4]=(R[1]+R[2]+R[3]);
				
				String Total = String.format("%.0f", R[4]);
			    textField_4.setText(Total);
			    
			    String sql= "INSERT INTO StudentResult(StudentID,Mathematics,Physics,Chemistry,Total)"+ "VALUES(?,?,?,?,?)";
				
			    try 
			    {
			    	pst=conn.prepareStatement(sql);
			    	pst.setString(1, textField.getText());
			    	pst.setString(2, textField_1.getText());
			    	pst.setString(3, textField_2.getText());
			    	pst.setString(4, textField_3.getText());
			    	pst.setString(5, textField_4.getText());
			    	
			    	pst.execute();
			    	//rs.close();
			    	pst.close();
			    	conn.close();
			    	JOptionPane.showMessageDialog(null,"Record Saved");
			    	
			    }
			    
			    catch(Exception ev)
			    {
			    	JOptionPane.showMessageDialog(null,ev);
			    }
			}
			
			
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(492, 689, 154, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL\r\n\r\n");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(749, 689, 154, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnReset = new JButton("RESET\r\n");
		btnReset.addActionListener((ActionListener) new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		});
		btnReset.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(1005, 689, 154, 42);
		frame.getContentPane().add(btnReset);
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		StudentResult obj=new StudentResult();
				obj.setVisible(true);
		
	}
}
