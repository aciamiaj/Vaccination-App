package Assignment1.src.presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Welcome Page with group names contains menu bar for adding and displaying the vaccine information
public class MainMenu extends JFrame {
	public MainMenu() {
		
		setTitle("Vaccine Information");
		getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Canada's COVID Vaccination Portal");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblWelcome.setBounds(65, 64, 389, 33);
		getContentPane().add(lblWelcome);
		
		JLabel lblGroupBy= new JLabel("Group Assigment By:");
		lblGroupBy.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblGroupBy.setBounds(164, 121, 306, 21);
		getContentPane().add(lblGroupBy);
		
		JLabel lblG1 = new JLabel("Jaspreet Singh");
		lblG1.setFont(new Font("Calibiri", Font.BOLD | Font.ITALIC, 17));
		lblG1.setBounds(165, 160, 306, 21);
		getContentPane().add(lblG1);
		
		JLabel lblG2 = new JLabel("Jaimaica Daisy");
		lblG2.setFont(new Font("Calibiri", Font.BOLD | Font.ITALIC, 17));
		lblG2.setBounds(165, 190, 306, 21);
		getContentPane().add(lblG2);
		
		JLabel lblG3 = new JLabel("Anna Salas");
		lblG3.setFont(new Font("Calibiri", Font.BOLD | Font.ITALIC, 17));
		lblG3.setBounds(165, 220, 306, 21);
		getContentPane().add(lblG3);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 490, 30);
		getContentPane().add(menuBar);
		
		//To add details
		JMenu mnAdd = new JMenu("Add Details");
		mnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnAdd);
		
		//Add information about vaccine
		JMenuItem mntmNewMenuItem = new JMenuItem("Add");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDetails g1 = new AddDetails();
				g1.setSize(500,600);
				g1.setVisible(true);
			}
		});
		mnAdd.add(mntmNewMenuItem);
		
		//View details about the vaccine by date, city, vaccine name, and total number of vaccine 
		JMenu mnView= new JMenu("View Details");
		mnView.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnView);
		
		//Search by date
		JMenuItem mntmSearchWDate = new JMenuItem("Search by Date");
		mntmSearchWDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayWithDate d1 = new DisplayWithDate();
				d1.setSize(500,600);
				d1.setVisible(true);
			}
		});
		mnView.add(mntmSearchWDate);
		
		//Search by city
		JMenuItem mntmSearchWCity = new JMenuItem("Seach by City");
		mntmSearchWCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayWithCity d2 = new DisplayWithCity();
				d2.setSize(500,600);
				d2.setVisible(true);
			}
		});
		mnView.add(mntmSearchWCity);
		
		//Search by vaccine name
		JMenuItem mntmmntmSearchWVaccine = new JMenuItem("Search by Vaccine Name");
		mntmmntmSearchWVaccine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayVaccineofVaccine d3 = new DisplayVaccineofVaccine();
				d3.setSize(500,600);
				d3.setVisible(true);
			}
		});
		mnView.add(mntmmntmSearchWVaccine);
		
		//Search by city with total numbers of vaccine
		JMenuItem mntmSearchVaccineCity = new JMenuItem("Search Vaccine of City");
		mntmSearchVaccineCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayVaccineOfCity d4 = new DisplayVaccineOfCity();
				d4.setSize(500,600);
				d4.setVisible(true);
			}
		});
		mnView.add(mntmSearchVaccineCity);
		
		//Display total numbers of vaccine
		JMenuItem mntmSearchTotal = new JMenuItem("Search Total Vaccine by Date");
		mntmSearchTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayVaccineOfDate d5 = new DisplayVaccineOfDate();
				d5.setSize(500,600);
				d5.setVisible(true);
			}
		});
		mnView.add(mntmSearchTotal);
		
		
	}
}
