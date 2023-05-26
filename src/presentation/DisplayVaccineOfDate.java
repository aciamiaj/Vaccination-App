package Assignment1.src.presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Assignment1.src.data.FileIO;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Display total number of vaccine by date 
public class DisplayVaccineOfDate extends JFrame {
	
public static ArrayList<String> getDetails(){
		
	//arraylist of string to read the FileIO 
		ArrayList<String> data;
		try {
			data = FileIO.readData();
			return data;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Read Data", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	private JTextField txtDate;
	public DisplayVaccineOfDate() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(131, 10, 122, 31);
		getContentPane().add(lblNewLabel);
		
		txtDate = new JTextField();
		txtDate.setBounds(180, 42, 96, 21);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnSearch= new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Check if the date is empty else will display the data in textarea
				if( !txtDate.getText().isEmpty() ) {
					ArrayList<String> data = getDetails();
					String input = txtDate.getText();
					if(!data.isEmpty()) { 
						int sum = 0;
						int sum2 = 0;
						int sum3 = 0;
						textArea.setText("");	
						for(String record : data) {
								
								String[] fields = record.split(",");
								if(input.toString().equals(fields[0].toString())) {
									sum = sum + Integer.parseInt(fields[2]);
							    	sum2 =sum2 + Integer.parseInt(fields[3]);
							    	sum3 =sum3 + Integer.parseInt(fields[4]);}
									
							}
					
					textArea.append("Total Pfizer : " + sum + "  Moderna : " + sum2 +  " AstraZeneca :  " + sum3);
				    textArea.append("\n");
					}
				}
					
							
				else {
					JOptionPane.showMessageDialog(null, "Date is Empty", "Get Data", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			
				
			}
		});
		btnSearch.setBounds(280, 42, 96, 21);
		getContentPane().add(btnSearch);
		
		JLabel lblDate= new JLabel("Enter Date ");
		lblDate.setBounds(110, 42, 96, 21);
		getContentPane().add(lblDate);
		
		textArea.setBounds(40, 132, 400, 110);
		getContentPane().add(textArea);
	}
	
	

}
