package Assignment1.src.presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import Assignment1.src.data.FileIO;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Display by City
public class DisplayWithCity extends JFrame {
public static ArrayList<String> getDetails(){
		//Create arraylist of string to read data from a file 
		ArrayList<String> data;
		try {
			data = FileIO.readData();
			return data;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Read Data", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public DisplayWithCity() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Display Results");
		getContentPane().setLayout(null);
		JTextArea textArea = new JTextArea();
		
		
		JLabel lblCity = new JLabel("");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCity.setBounds(138, 10, 106, 28);
		getContentPane().add(lblCity);
		
		JLabel lblSelect = new JLabel("SELECT CITY");
		lblSelect.setBounds(100, 42, 96, 21);
		getContentPane().add(lblSelect);
		
		//City names in combobox using array of String
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Toronto", "Calgary", "Vancouver"}));
		comboBox.setBounds(190, 42, 106, 21);
		getContentPane().add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				
				//ArrayList to get and append vaccine details in text area
				ArrayList<String> data = getDetails();
				String input = (String) comboBox.getSelectedItem();
				if(!data.isEmpty()) {
					for(String record : data) {
						String[] fields = record.split(",");
						if(input.equals(fields[1])) {
							String output = "Date : " + fields[0] + ", City : " + fields[1] + ", Pfizer : " + fields[2] + ", Moderna :  " + fields[3] + ", AstraZeneca :  " + fields[4];
							textArea.append(output);
							textArea.append("\n");
						}
					}	
				}
				else { //Error message if no city is selected
					JOptionPane.showMessageDialog(null, "No Data in System", "Get Data", JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				
			}
		});
		btnSearch.setBounds(300, 42, 85, 21);
		getContentPane().add(btnSearch);
			
		textArea.setBounds(20, 100, 440, 110);
		getContentPane().add(textArea);
	}

}
