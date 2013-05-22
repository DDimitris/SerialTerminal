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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;


public class PropertiesMenu extends JFrame {

	public JPanel contentPane;
	public Communicator communicator;
	
    public int baud1=4800;
    public int baud2=9600;
    public int baud3=14400;
    public int baud4=19200;
    public int baud5=28800;
    public int baud6=38400;
    public int baud7=57600;
    public int baud8=115200;
    public int dataBits_5 = 5;
    public int dataBits_6 = 6;
    public int dataBits_7 = 7;
    public int dataBits_8 = 8;
    public int stopBits1 = 1;
    public int stopBits2 = 2;
    public int stopBits1_5 = 3;
    public javax.swing.JComboBox baud_rate;
	public javax.swing.JComboBox dataBits;
	public javax.swing.JComboBox stopBits;
	public javax.swing.JButton btnOk;

	
	public void SettingsMenu() {
	
				try {
					PropertiesMenu frame = new PropertiesMenu();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	public PropertiesMenu(Communicator communicator) {
		this.communicator = communicator;
	}
	
	public PropertiesMenu() {

		
		 	baud_rate = new javax.swing.JComboBox();
		 	dataBits = new javax.swing.JComboBox();
		 	stopBits = new javax.swing.JComboBox();
	 		btnOk = new javax.swing.JButton();
	 		btnOk.setText("OK");
	 		baud_rate.addItem(baud1);
			baud_rate.addItem(baud2);
			baud_rate.addItem(baud3);
			baud_rate.addItem(baud4);
			baud_rate.addItem(baud5);
			baud_rate.addItem(baud6);
			baud_rate.addItem(baud7);
			baud_rate.addItem(baud8);
			dataBits.addItem(dataBits_5);
			dataBits.addItem(dataBits_6);
			dataBits.addItem(dataBits_7);
			dataBits.addItem(dataBits_8);
			stopBits.addItem(new ComBoItem("1",stopBits1));
			stopBits.addItem(new ComBoItem("1,5",stopBits1_5));
			stopBits.addItem(new ComBoItem("2",stopBits2));
			dataBits.setSelectedItem(dataBits_8);
			baud_rate.setSelectedItem(baud2);
			setTitle("Settings");
		
			setBounds(100, 100, 373, 329);
		
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
		
		
			JLabel lblSelectBaudRate = new JLabel("Baud Rate:");
		
			JLabel lblSelectDataBits = new JLabel("Data Bits:");
		
			JLabel lblSelectStopBits = new JLabel("Stop Bits:");
		
		
		btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnOkActionPerormed(evt);
			}
		});
		
		JLabel lblSerialTerminalSettings = new JLabel();
		lblSerialTerminalSettings.setText("Serial Terminal Settings");
		lblSerialTerminalSettings.setFont(new Font("Harrington", Font.BOLD, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSerialTerminalSettings, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectDataBits, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSelectBaudRate)
								.addComponent(lblSelectStopBits))
							.addGap(111)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dataBits, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(baud_rate, 0, 116, Short.MAX_VALUE)
								.addComponent(stopBits, 0, 126, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSerialTerminalSettings, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectBaudRate)
						.addComponent(baud_rate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectDataBits)
						.addComponent(dataBits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectStopBits)
						.addComponent(stopBits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(btnOk)
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	
	
	public void btnOkActionPerormed(java.awt.event.ActionEvent evt)
{	
		communicator.setSettings((int) baud_rate.getSelectedItem(), (int) dataBits.getSelectedItem(), (int) ((ComBoItem)stopBits.getSelectedItem()).getValue());
		//communicator.setSettings(9600, 8, 1);
		//communicator.writeData(5);
		
		dispose();
}
}
