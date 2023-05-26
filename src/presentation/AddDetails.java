package Assignment1.src.presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;

import Assignment1.src.business.DateNotValid;
import Assignment1.src.business.ValidateDate;

import Assignment1.src.data.FileIO;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class AddDetails extends JFrame {
	private JTextField txtDate;
	private JTextField txtPfizer;
	private JTextField txtModerna;
	private JTextField txtAstra;
	
	//Add details about the vaccine
	public AddDetails() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		setTitle("Insert Details");
		getContentPane().setLayout(null);	
		
		JLabel lblenterDetails = new JLabel("Enter below information:");
		lblenterDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblenterDetails.setBounds(143, 10, 180, 40);
		getContentPane().add(lblenterDetails);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(50, 55, 45, 13);
		getContentPane().add(lblDate);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCity.setBounds(50, 92, 45, 13);
		getContentPane().add(lblCity);
		
		JLabel lblPfizer = new JLabel("Pfizer");
		lblPfizer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPfizer.setBounds(50, 129, 45, 13);
		getContentPane().add(lblPfizer);
		
		JLabel lblModerna = new JLabel("Moderna");
		lblModerna.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModerna.setBounds(50, 164, 59, 13);
		getContentPane().add(lblModerna);
		
		JLabel lblAstra = new JLabel("AstraZenca");
		lblAstra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAstra.setBounds(50, 197, 78, 13);
		getContentPane().add(lblAstra);
		
		txtDate = new JTextField();
		txtDate.setBounds(182, 54, 96, 19);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtPfizer = new JTextField();
		txtPfizer.setBounds(182, 128, 96, 19);
		getContentPane().add(txtPfizer);
		txtPfizer.setColumns(10);
		
		txtModerna = new JTextField();
		txtModerna.setBounds(182, 163, 96, 19);
		getContentPane().add(txtModerna);
		txtModerna.setColumns(10);
		
		txtAstra = new JTextField();
		txtAstra.setBounds(182, 196, 96, 19);
		getContentPane().add(txtAstra);
		txtAstra.setColumns(10);
		
		//ComboBox for City
		JComboBox comboBox = new JComboBox();
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Check if date is empty and will display an error message
				if( !txtDate.getText().isEmpty() ) {
					String date = txtDate.getText();
					try { 
						ValidateDate dateCheck = new ValidateDate();
						dateCheck.validateDate(date);
					}
					catch(DateNotValid ed){
						JOptionPane.showMessageDialog(null, "Date is not valid \n \nFor Example - 01/02/2021 (mm/dd/yyyy)", "Save Data", JOptionPane.ERROR_MESSAGE);
						return;
					}
					//initialize the vaccine values to 0
					String city = String.valueOf(comboBox.getSelectedItem());
					int pfizer = 0;
					int moderna = 0;
					int asta = 0;
					//condition to check if textfield is empty will display an error, else will display the data
					if( !txtPfizer.getText().isEmpty() ) {
						try 
				        {
							pfizer = Integer.parseInt(txtPfizer.getText());
				        } 
				        catch (NumberFormatException e1) 
				        {
				        	JOptionPane.showMessageDialog(null, "Value is not integer", "Save Data", JOptionPane.ERROR_MESSAGE);
				        	return;
				        }	
					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter number of Pfizer", "Save Data", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if( !txtModerna.getText().isEmpty() ) {
						try 
				        {
							moderna = Integer.parseInt(txtModerna.getText());
				        } 
				        catch (NumberFormatException e2) 
				        {
				        	JOptionPane.showMessageDialog(null, "Value is not integer", "Save Data", JOptionPane.ERROR_MESSAGE);
				        	return;
				        }	
					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter number of Moderna", "Save Data", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if( !txtAstra.getText().isEmpty() ) {
						try 
				        {
							asta = Integer.parseInt(txtAstra.getText());
				        } 
				        catch (NumberFormatException e3) 
				        {
				        	JOptionPane.showMessageDialog(null, "Value is not integer", "Save Data", JOptionPane.ERROR_MESSAGE);
				        	return;
				        }	
					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter number of AstraZeneca", "Save Data", JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						FileIO.saveData(date, city, pfizer, moderna, asta);
						JOptionPane.showMessageDialog(null, "Data is saved to a file.", "Save Data", JOptionPane.INFORMATION_MESSAGE);
						txtPfizer.setText("");
						txtAstra.setText("");
						txtModerna.setText("");
						txtDate.setText("");
						
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error saving to file -> " + e1.getMessage(), "Save Data", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter the date", "Save Data", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnSave.setBounds(175, 240, 100, 25);
		getContentPane().add(btnSave);
		
		JLabel lbldateFormat = new JLabel("(mm/dd/yyyy)");
		lbldateFormat.setBounds(288, 57, 85, 13);
		getContentPane().add(lbldateFormat);
		
		//combobox to add city
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Toronto", "Calgary", "Vancouver"}));
		comboBox.setBounds(182, 90, 96, 21);
		getContentPane().add(comboBox);
	}
}
