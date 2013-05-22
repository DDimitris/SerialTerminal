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

import gnu.io.*;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.swing.text.Element;
public class Communicator implements SerialPortEventListener {

    public static  int baudRate;
    public static int stopBits;
    public static int dataBits;
    public static int baud;
    public static int data;
    public static int stop;
	public Enumeration ports = null;
	public HashMap portMap = new HashMap(); // map the port names to CommPortIdentifiers
	public CommPortIdentifier selectedPortIdentifier = null; // this is the object that contains the opened port
	public SerialPort serialPort = null;
	public InputStream input = null;
	public static OutputStream output = null;
	public boolean bConnected = false;
	final static int TIMEOUT = 2000;
	static String logText = null;
	public GUI GUI = null;
	//ReadingLine ReadingLine = new ReadingLine();
	//public int count = 0;
	public PropertiesMenu PropertiesMenu;
	public Communicator(GUI window) {
		this.GUI = window;
	}
	public Communicator(PropertiesMenu settings) {
		this.PropertiesMenu = settings;
	}
//<----------------------------------------------Searching for ports-------------------------------------------------------------->
	@SuppressWarnings("unchecked")
	public void searchForPorts() {
		ports = CommPortIdentifier.getPortIdentifiers();
		while (ports.hasMoreElements()) {
			CommPortIdentifier curPort = (CommPortIdentifier) ports
					.nextElement();

			if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				GUI.cboxPorts.addItem(curPort.getName());
				portMap.put(curPort.getName(), curPort);
			}
		}
	}
//<-------------------------------------------------------------------------------------------------------------------------------->
//<------------------------------------Setters and Getters------------------------------------------------------------------------->
	public static void setSettings(int baud, int data , int stop)
	{
		baudRate=baud;
		stopBits=stop;
		dataBits=data;	
	}
	public static int getBaud(){
		return baudRate;
	}
	public static int getStopBits(){
		return stopBits;
	}
	public static int getDataBits(){
		return dataBits;
	}
//<---------------------------------------------------------------------------------------------------------------------------->
	
//<-------------------------------------------------Connection----------------------------------------------------------------->
	public void connect() {
		String selectedPort = (String) GUI.cboxPorts.getSelectedItem();
		selectedPortIdentifier = (CommPortIdentifier) portMap.get(selectedPort);

		CommPort commPort = null;

		try {

			commPort = selectedPortIdentifier.open("SerialTerminal", TIMEOUT);
			serialPort = (SerialPort) commPort;
			/*System.out.println(getBaud());
			System.out.println(getDataBits());
			System.out.println(getStopBits());*/
			serialPort.setSerialPortParams(getBaud(), getDataBits(), getStopBits(), SerialPort.FLOWCONTROL_NONE);
			setConnected(true);
			JOptionPane.showMessageDialog(null, selectedPort + " opened successfully.");
			
			GUI.communicator.toggleControls();
		} catch (PortInUseException e) {
			logText = selectedPort + " is in use. (" + e.toString() + ")";
			JOptionPane.showMessageDialog(null, logText);
		} catch (Exception e) {
			logText = "Failed to open " + selectedPort + "(" + e.toString()
					+ ")\n\t Please check your parameters from File >> Settings";
			serialPort.close();
			JOptionPane.showMessageDialog(null, logText);
		}
	}
	
//<------------------------------------------------------------------------------------------------------------------------------>
//<------------------------------------------initialize input/output streams----------------------------------------------------->
	public boolean initIOStream() {
		boolean successful = false;
		try {
			
			input = serialPort.getInputStream();
			output = serialPort.getOutputStream();
			successful = true;
			return successful;
		} catch (IOException e) {
			logText = "I/O Streams failed to open. (" + e.toString() + ")";
			JOptionPane.showMessageDialog(null, logText);
			return successful;
		}
	}
//<------------------------------------------------------------------------------------------------------------------------------->
	
//<----------------------------------------------initialize event listener on a port---------------------------------------------->	
	public void initListener() {
		try {
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (TooManyListenersException e) {
			logText = "Too many listeners. (" + e.toString() + ")";
			JOptionPane.showMessageDialog(null, logText);
		}
	}
	
//<------------------------------------------------------------------------------------------------------------------------------->
//<--------------------------------------------------------disconnect------------------------------------------------------------->
	public void disconnect() {
		try {

			serialPort.removeEventListener();
			serialPort.close();
			input.close();
			output.close();
			setConnected(false);
			GUI.communicator.toggleControls();
			logText = "Disconnected";
			JOptionPane.showMessageDialog(null, logText);
		} catch (Exception e) {
			logText = "Failed to close " + serialPort.getName() + "("
					+ e.toString() + ")";
			JOptionPane.showMessageDialog(null, logText);
		}
	}
//<-------------------------------------------------------------------------------------------------------------------------------->
	final public boolean getConnected() {
		return bConnected;
	}
	public void setConnected(boolean bConnected) {
		this.bConnected = bConnected;
	}
	
//<-----------------------------------------------Read from comm port--------------------------------------------------------------->
	public void serialEvent(SerialPortEvent evt) {
		if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			
			try {
				byte singleData = (byte) input.read();
				
				logText = new String(new byte[] { singleData });
				//GUI.txtLog.append(logText);
				//count++;
				if (singleData == 7 || singleData == 8)
				{
					
				}else{
					GUI.txtLog.append(logText);
					//ReadingLine.Read();
				}
			}
			catch (Exception e) {
				logText = "Failed to read data from serial port. (" + e.toString()
						+ ")";
				JOptionPane.showMessageDialog(null, logText);
			}
		}	
	}
//<--------------------------------------------------------------------------------------------------------------------------------->
//<-------------------------------------------------------write data to comm port for cisco----------------------------------------->	
	public static void writeData(int write) {
		try {
				output.write(write);
				output.flush();
		} catch (Exception e) {
			logText = "Failed to write data. (" + e.toString() + ")";
			JOptionPane.showMessageDialog(null, logText);
		}
		
	}
//<--------------------------------------------------------------------------------------------------------------------------------->
//<----------------------------------write data to comm port for cisco for arduino--------------------------------------------------->
	
	public static void writeData2(String write) {
		try {
				output.write(write.getBytes());
				output.flush();
		} catch (Exception e) {
			logText = "Failed to write data. (" + e.toString() + ")";
			JOptionPane.showMessageDialog(null, logText);
		}
		
	}
	
//<---------------------------------------------------toggle controls---------------------------------------------------------------->
	public void toggleControls() {
		if (GUI.communicator.getConnected() == true) {
			GUI.btnDisconnect.setEnabled(true);
			GUI.btnConnect.setEnabled(false);
			GUI.cboxPorts.setEnabled(false);
			GUI.clear_log.setEnabled(true);
			GUI.mnTools.setEnabled(false);
	        GUI.mnFonts.setEnabled(false);
	        GUI.mnDevices.setEnabled(false);
	        GUI.text_command.setEnabled(true);
		} else {
			GUI.mnFonts.setEnabled(true);
			GUI.mnTools.setEnabled(true);
			GUI.mnDevices.setEnabled(true);
			GUI.btnDisconnect.setEnabled(false);
			GUI.btnConnect.setEnabled(true);
			GUI.cboxPorts.setEnabled(true);
			GUI.text_command.setEnabled(false);
		}
	}

}
//<------------------------------------------------------------------------------------------------------------------------------------>