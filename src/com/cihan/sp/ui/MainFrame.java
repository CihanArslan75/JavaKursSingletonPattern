package com.cihan.sp.ui;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.cihan.sp.dao.UserDAO;
import com.cihan.sp.model.User;


public class MainFrame extends JFrame{
	private JTable table;
	
	public MainFrame() {
		intialize();
	}

	private void intialize() {
		setTitle("Ana  Ekran");
		setBounds(100, 100, 500, 550);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 66, 460, 337);
		getContentPane().add(scrollPane);
		UserDAO dao = new UserDAO();
		String[][] data = null;
		String[] columnNames= {"id","Kullanıcı Adı","Şifre"};
		try {
			List<User> liste = dao.getAllUsers(new User());
			data = new String[liste.size()][3];
			for (int i = 0; i < liste.size(); i++) {
				data[i][0]= ""+ liste.get(i).getId();
				data[i][1]= liste.get(i).getUsername();
				data[i][2]= liste.get(i).getPassword();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
	}
}
