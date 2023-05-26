package Assignment1.src.presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Assignment1.src.business.DateNotValid;
import Assignment1.src.business.ValidateDate;
import Assignment1.src.data.FileIO;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Display by date
public class DisplayWithDate extends JFrame {
	
	private JTextField txtDate;
	public DisplayWithDate() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Display All Records");
		getContentPane().setLayout(null);
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInfo.setBounds(137, 10, 120, 42);
		getContentPane().add(lblInfo);
		
		JLabel lblDate = new JLabel("Enter Date");
		lblDate.setBounds(40, 42, 96, 19);
		getContentPane().add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(120, 42, 96, 19);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(15, 100, 450, 139);
		getContentPane().add(txtArea);
		
		//Label for date format
		JLabel lblDateFormat = new JLabel("(mm/dd/yyyy)");
		lblDateFormat.setBounds(226, 42, 96, 13);
		getContentPane().add(lblDateFormat);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If date is empty it will prompt an error message, else it will display or append vaccine details in textarea
				if(!txtDate.getText().isEmpty() ) {
					ArrayList<String> data = getDetails();
					String input = txtDate.getText();
					if(!data.isEmpty()) {
							for(String record : data) {
								String[] fields = record.split(",");
								if(input.equals(fields[0])) {	
									String output ="Date : " + fields[0] + ", City : " + fields[1] + ", Pfizer : " + fields[2] + ", Moderna :  " + fields[3] + ", AstraZeneca:  " + fields[4];
									txtArea.append(output);
									txtArea.append("\n");									
								}
							}
					}						
				else {
					//It will display an error message is date is empty
					JOptionPane.showMessageDialog(null, "Date is Empty", "Get Data", JOptionPane.ERROR_MESSAGE);
					return;
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Date is Empty", "Get Data", JOptionPane.ERROR_MESSAGE);
					return;
					}				
			}	
		});
		
		btnSearch.setBounds(330, 42, 85, 21);
		getContentPane().add(btnSearch);
	}
	
	//ArrayList of String for reading the data and return the data
	public static ArrayList<String> getDetails(){
		ArrayList<String> data;
		try {
			data = FileIO.readData();
			return data;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Read Data", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}

