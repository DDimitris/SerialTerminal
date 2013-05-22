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
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;


public class About extends JFrame {

	private JPanel contentPane;
public void licence(){
					About frame = new About();
					frame.setVisible(true);
}

	
	public About() {
		
		JTextArea txtrSerialTerminalFor = new JTextArea();
		txtrSerialTerminalFor.setRows(10);
		
		
		setBounds(100, 100, 589, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtrSerialTerminalFor.setEditable(false);
		txtrSerialTerminalFor.setFont(new Font("Courier", Font.PLAIN, 17));
		txtrSerialTerminalFor.setText("Serial terminal for communicating with Cisco / 3COM and other devices\r\nCopyright (C) 2013  Dimitris Dedousis\r\n\r\nThis program is free software: you can redistribute it and/or modify\r\nit under the terms of the GNU General Public License as published by\r\nthe Free Software Foundation, either version 3 of the License, or\r\n(at your option) any later version.\r\n\r\nThis program is distributed in the hope that it will be useful,\r\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\r\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\r\nGNU General Public License for more details.\r\n\r\nYou should have received a copy of the GNU General Public License\r\nalong with this program.  If not, see <http://www.gnu.org/licenses/>.");
		contentPane.add(txtrSerialTerminalFor, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("                                    About Serial Terminal");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Harrington", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}

}
