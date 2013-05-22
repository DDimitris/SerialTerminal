/*  Serial terminal for communicating with Cisco / 3COM and other devices
    Copyright (C) 2013  Dimitris Dedousis
	
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FontsMenu extends JFrame {

	private JPanel contentPane;
	
	public static GUI GUI = new GUI();
	public javax.swing.JComboBox FontscomboBox;
	public javax.swing.JComboBox SizecomboBox;
	public javax.swing.JComboBox StylecomboBox;
    
	public void FontsSettings() {
		
				try {
					FontsMenu frame = new FontsMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	
	}		
	
	
	
	public FontsMenu() {
		FontscomboBox = new javax.swing.JComboBox();
		SizecomboBox = new javax.swing.JComboBox();
		StylecomboBox = new javax.swing.JComboBox();
		FontscomboBox.addItem("Harrington");
		FontscomboBox.addItem("Courier");
		FontscomboBox.addItem("Tahoma");
		SizecomboBox.addItem(8);
		SizecomboBox.addItem(9);
		SizecomboBox.addItem(10);
		SizecomboBox.addItem(11);
		SizecomboBox.addItem(12);
		SizecomboBox.addItem(13);
		SizecomboBox.addItem(14);
		SizecomboBox.addItem(15);
		SizecomboBox.addItem(16);
		SizecomboBox.addItem(17);
		SizecomboBox.addItem(18);
		SizecomboBox.addItem(19);
		SizecomboBox.addItem(20);
		SizecomboBox.addItem(21);
		SizecomboBox.addItem(22);
		SizecomboBox.addItem(23);
		SizecomboBox.addItem(24);
		StylecomboBox.addItem(new ComBoItem("PLAIN",0));
		StylecomboBox.addItem(new ComBoItem("BOLD",1));
		StylecomboBox.addItem(new ComBoItem("ITALIC",2));
		SizecomboBox.setSelectedItem(17);
		FontscomboBox.setSelectedItem("Courier");
		setBounds(100, 100, 400, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblSerialTerminalFonts = new JLabel();
		lblSerialTerminalFonts.setText("Serial Terminal Fonts");
		lblSerialTerminalFonts.setFont(new Font("Harrington", Font.BOLD, 24));	
		JLabel lblSelectFont = new JLabel("Select Font:");
		JLabel lblSelectSize = new JLabel("Select Size:");
		JLabel lblSelectStyle = new JLabel("Select Style:");
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		 
				GUI.setFontMine((String)FontscomboBox.getSelectedItem(), (int) ((ComBoItem)StylecomboBox.getSelectedItem()).getValue(), (int) SizecomboBox.getSelectedItem());
			
			dispose();
		}});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSerialTerminalFonts, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSelectFont)
										.addComponent(lblSelectSize))
									.addGap(53))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSelectStyle)
									.addGap(51)))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(SizecomboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(StylecomboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(FontscomboBox, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblSerialTerminalFonts)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectFont)
						.addComponent(FontscomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectSize)
						.addComponent(SizecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectStyle)
						.addComponent(StylecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addComponent(btnOk)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
