 package Assignment1.src.presentation;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import Assignment1.src.data.FileIO;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Display vaccine by city
public class DisplayVaccineOfCity extends JFrame {
	
public static ArrayList<String> getDetails(){
		
	//create arraylist of string to read data from FileIO
		ArrayList<String> data;
		try {
			data = FileIO.readData();
			return data;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Read Data", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	//Display vaccine by city
	public DisplayVaccineOfCity() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		JComboBox comboBox = new JComboBox();
		
		//combobox for city
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Toronto", "Calgary", "Vancouver"}));
		comboBox.setBounds(190, 79, 106, 21);
		getContentPane().add(comboBox);
		
		JLabel lblInfo = new JLabel("SELECT CITY");
		//lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfo.setBounds(100, 79, 96, 21);
		getContentPane().add(lblInfo);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//selected item will display the vaccine details for the city and display in textarea
				String input = (String) comboBox.getSelectedItem();
				ArrayList<String> data = getDetails();
				//compute the total number of vaccine doses
				int sum = 0;
				int sum2 = 0;
				int sum3 = 0;
				switch (input) {
				  case "Toronto":
					textArea.setText("");
					
				    for(String record : data) {
				    	
				    	String[] fields = record.split(",");
				    	//compute the total number of vaccine doses
				    	if(input.toString().equals(fields[1].toString())) {
				    	sum = sum + Integer.parseInt(fields[2]);
				    	sum2 =sum2 + Integer.parseInt(fields[3]);
				    	sum3 =sum3 + Integer.parseInt(fields[4]);}
				    	
				    }
				    textArea.append("Total Pfizer : " + sum + "  Moderna : " + sum2 +  " AstraZeneca :  " + sum3);
				    textArea.append("\n");
				    break;
				  case "Calgary":
					  textArea.setText("");
				    for(String record : data) {
				    	String[] fields = record.split(",");
				    	//compute the total number of vaccine doses
				    	if(input.toString().equals(fields[1].toString())) { 
				    	sum = sum + Integer.parseInt(fields[2]);
				    	sum2 =sum2 + Integer.parseInt(fields[3]);
				    	sum3 =sum3 + Integer.parseInt(fields[4]);}
				    }
				    textArea.append("Total Pfizer : " + sum + "  Moderna : " + sum2 +  " AstraZeneca :  " + sum3);
				    textArea.append("\n");
				    break;
				  case "Vancouver":
					  textArea.setText("");
				    for(String record : data) {
				    	String[] fields = record.split(",");
				    	//compute the total number of vaccine doses
				    	if(input.toString().equals(fields[1].toString())) {
				    	sum = sum + Integer.parseInt(fields[2]);
				    	sum2 =sum2 + Integer.parseInt(fields[3]);
				    	sum3 =sum3 + Integer.parseInt(fields[4]);}
				    }
				    textArea.append("Total Pfizer : " + sum + "  Moderna : " + sum2 +  " AstraZeneca :  " + sum3);
				    textArea.append("\n");
				    break;
				}
			}
		});
		btnSearch.setBounds(300, 79, 85, 21);
		getContentPane().add(btnSearch);
		
		
		textArea.setBounds(40, 132, 400, 110);
		getContentPane().add(textArea);
	}

}
