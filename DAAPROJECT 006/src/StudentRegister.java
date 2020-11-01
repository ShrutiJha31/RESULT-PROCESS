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
import java.util.UUID;

import javax.swing.*;
import java.awt.SystemColor;
public class StudentRegister {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	String str;
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
					StudentRegister window = new StudentRegister();
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
	public StudentRegister() {
		initialize();
		conn = SqliteConnection2.ConnectDb();
		Object col[]= {"StudentID", "Name", "PhoneNO", "email", "Address","Category"};
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
		panel.setBorder(new LineBorder(null, 8));
		panel.setBounds(492, 147, 689, 520);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(270, 43, 201, 49);
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("NAME\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(64, 129, 216, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("PHONE NUMBER");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(64, 190, 216, 28);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("EMAIL");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(64, 259, 216, 28);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("ADDRESS");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(64, 324, 216, 28);
		panel.add(lblNewLabel_2_1_1_1);
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("CATEGORY");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1.setBounds(64, 400, 216, 28);
		panel.add(lblNewLabel_2_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(315, 129, 317, 28);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(315, 190, 317, 28);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(315, 259, 317, 28);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(315, 324, 317, 28);
		panel.add(textField_4);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"GEN", "OBC", "SC","ST", "EWS"}));
		comboBox.setBounds(317, 400, 315, 27);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("REGISTER \r\n");
		btnNewButton.setForeground(UIManager.getColor("Button.light"));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double R[] = new double[14];
				
				
				
				String sql1="SELECT count(*) from `Student`";
				try
				{
					pst=conn.prepareStatement(sql1);
					 if(conn!=null)
				       {
				        rs=pst.executeQuery();
			            int x=0;
			          
			            while(rs.next()) {                    
			                x=Integer.parseInt(rs.getString(1))+1;
			            }
			            str="0"+String.valueOf(x);
				       }
				}
			    catch(Exception ev1)
			    {
			    	JOptionPane.showMessageDialog(null,ev1);
			    }
			    
			    String sql= "INSERT INTO Student(Name,PhoneNO,Email,Address,Category,StudentID)"+ "VALUES(?,?,?,?,?,?)";
				
			    try 
			    {
			    	pst=conn.prepareStatement(sql);
			      
			    	pst.setString(1, textField_1.getText());
			    	pst.setString(2, textField_2.getText());
			    	pst.setString(3, textField_3.getText());
			    	pst.setString(4, textField_4.getText());
			    	pst.setString(5,(String) comboBox.getSelectedItem());
		            pst.setString(6,(String) comboBox.getSelectedItem()+str );
			    	pst.execute();
			    	
		           
		            pst.execute();
			    	
			    	pst.close();
			    	JOptionPane.showMessageDialog(null,"Registered! Your Application ID is = "+(String) comboBox.getSelectedItem() + str);
			    	
			    }
			    
			    catch(Exception ev)
			    {
			    	JOptionPane.showMessageDialog(null,ev);
			    }
			    
			    
			} 
			
			
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(492, 689, 679, 64);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
 