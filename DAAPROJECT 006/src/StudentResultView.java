import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.sql.*;

import javax.swing.*;
import java.awt.SystemColor;
public class StudentResultView {

	JFrame frame;
	private JTextField textField;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();
	int phy,chem,maths,total;
	String Category;
	String str;
    String str1;int rank;
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
					StudentResultView window = new StudentResultView();
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
	public StudentResultView() {
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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBorder(new LineBorder(null, 8));
		panel.setBounds(464, 127, 689, 235);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER APPLICATION ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(32, 69, 272, 91);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBounds(329, 69, 306, 79);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("VIEW RESULT\r\n");
		btnNewButton.setForeground(UIManager.getColor("CheckBox.focus"));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double R[] = new double[14];
				str1=textField.getText();
				
				
				String sql1="SELECT Physics,Mathematics,Chemistry,Total," +"RANK () OVER ( \r\n"
						+ "		ORDER BY Total DESC"
						+ "	)  FROM StudentResult Where StudentID=? COLLATE NOCASE";
				try
				{
					pst=conn.prepareStatement(sql1);
					 if(conn!=null)
				       {
							pst.setString(1, textField.getText());
				        rs=pst.executeQuery();
			            int x=0;
			            while(rs.next()) {                    
			                phy=rs.getInt(1);
			                maths=rs.getInt(2);
			                chem=rs.getInt(3);
			                total=rs.getInt(4);
			                rank=rs.getInt(5);
			            }
			            
			            
			           
			            
				       }
					 JOptionPane.showMessageDialog(null,"Your Result\nMathematics = "+maths+"\nPhysics =  "+phy+"\nChemistry = "+chem+"\nTotal = "+total+"\nRank = "+rank);
                     phy=maths=chem=total=rank=0;				
				}
			    catch(Exception ev1)
			    {
			    	JOptionPane.showMessageDialog(null,ev1);
			    }
				
			
		}});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(690, 406, 221, 92);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		StudentResultView obj=new StudentResultView();
				obj.frame.setVisible(true);
		
	}
}
