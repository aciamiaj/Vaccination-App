package Assignment1.src.presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

import Assignment1.src.data.FileIO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Display by vaccine name
public class DisplayVaccineofVaccine extends JFrame {
	
public static ArrayList<String> getDetails(){
		
		//ArrayList of string  to read the data from FileIO
		ArrayList<String> data;
		try {
			data = FileIO.readData();
			return data;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Read Data", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public DisplayVaccineofVaccine() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(156, 10, 93, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblChoose = new JLabel("Choose Vaccine");
		lblChoose.setBounds(100, 42, 100, 25);
		getContentPane().add(lblChoose);
		
		//ComboBox for the vaccine names
		JComboBox comboBoxVaccine = new JComboBox();
		comboBoxVaccine.setModel(new DefaultComboBoxModel(new String[] {"Pfizer", "Moderna", "AstraZeneca"}));
		comboBoxVaccine.setBounds(210, 42, 107, 25);
		getContentPane().add(comboBoxVaccine);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(40, 110, 400, 110);
		getContentPane().add(textArea);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Selected vaccine will display the total number of vaccine doses  in textarea
				String input = (String) comboBoxVaccine.getSelectedItem();
				ArrayList<String> data = getDetails();
				int sum = 0;
				switch (input) {
				  case "Pfizer":
					textArea.setText("");
				    for(String record : data) {
				    	String[] fields = record.split(",");
				    	sum = sum + Integer.parseInt(fields[2]);
				    }
				    textArea.append("Total Pfizer : " + sum);
				    textArea.append("\n");
				    break;
				  case "Moderna":
					  textArea.setText("");
				    for(String record : data) {
				    	String[] fields = record.split(",");
				    	sum = sum + Integer.parseInt(fields[3]);
				    }
				    textArea.append("Total Moderna : " + sum);
				    textArea.append("\n");
				    break;
				  case "AstraZeneca":
					  textArea.setText("");
				    for(String record : data) {
				    	String[] fields = record.split(",");
				    	sum = sum + Integer.parseInt(fields[4]);
				    }
				    textArea.append("Total AstraZeneca : " + sum);
				    textArea.append("\n");
				    break;
				}
				
			}
		});
		btnSearch.setBounds(330, 42, 85, 25);
		getContentPane().add(btnSearch);
	}
}
