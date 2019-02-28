package com.cihan.sp.ui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.cihan.sp.dao.UserDAO;
import com.cihan.sp.model.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;


public class GirisFrame extends JFrame{
	private JTextField txtkadi;
	private JTextField txtsifre;
	public GirisFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("Kullanıcı giriŞ Ekranı");
		setBounds(100, 100, 300, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		txtkadi = new JTextField();
		txtkadi.setText("");
		txtkadi.setBounds(142, 48, 123, 20);
		getContentPane().add(txtkadi);
		txtkadi.setColumns(10);
		
		txtsifre = new JTextField();
		txtsifre.setBounds(142, 90, 123, 20);
		getContentPane().add(txtsifre);
		txtsifre.setColumns(10);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setBounds(22, 51, 94, 14);
		getContentPane().add(lblKullancAd);
		
		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setBounds(22, 96, 94, 14);
		getContentPane().add(lblifre);
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserDAO dao = new UserDAO();
					User usr = dao.getUserForName(txtkadi.getText());					
					if (usr !=null) {
						if(txtsifre.getText().equals(usr.getPassword())) {
							// yeni ekran açtır
							MainFrame mainf= new MainFrame();
							mainf.setVisible(true);
							GirisFrame.this.setVisible(false);
						}
						else 
							JOptionPane.showMessageDialog(GirisFrame.this, "Şifre Hatalı...!");
						
					}
					else 
						JOptionPane.showMessageDialog(GirisFrame.this, "Kullanıcı Adı Hatalı...!");

				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(GirisFrame.this, "SQL çalıŞtırılırken bir hata oldu...!!!");
				}
			}
		});
		btnGiris.setBounds(174, 147, 91, 23);
		getContentPane().add(btnGiris);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(42, 147, 91, 23);
		getContentPane().add(btnIptal);
		
	}
}