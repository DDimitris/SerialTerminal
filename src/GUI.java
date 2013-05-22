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

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
public class GUI extends javax.swing.JFrame implements KeyListener {
    /**
	 * 
	 */
	
	//private static final long serialVersionUID = 1L;
	//Communicator object
    Communicator communicator = null;
    PropertiesMenu properties = null;
    FontsMenu FontsMenu = null;
    About licence = null;
    int test;
   // Runnable time = new StopWatch();
   // Thread timeThreaded = new Thread(time);
   // InputType Type = null;
    public boolean Device;
   // List<String> CommandList = new ArrayList<String>();
    public int key;
  public static String Fonts = "Courier";
     public static int Size = 17;
    public static int Style = 0;
    public static int device;
    
    /** Creates new form GUI */
    public GUI() {
        initComponents();
        createObjects();
        communicator.searchForPorts();
        communicator.toggleControls();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getClassLoader().getResource("utilities_terminal.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        super.setIconImage(image);
        
    }
    
public void setFontMine(String fonts, int style, int size){
	Fonts = fonts;
	Style = style;
	Size = size;
	
}
public String getFonts(){
	return Fonts;
}
public int getStyle(){
	return Style;
}
public int getSizes(){
	return Size;
}
    private void createObjects()
    {
        communicator = new Communicator(this);
        FontsMenu = new FontsMenu();
        licence = new About();
        //Type = new InputType();
    }
   


    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void initComponents() {
    	
    	ConnectionStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cboxPorts = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btnConnect = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        btnDisconnect.setEnabled(false);
        mail_label = new javax.swing.JLabel();
        clear_log = new javax.swing.JButton();
        clear_log.setEnabled(false);
       // jLabel17 = new javax.swing.JLabel();
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Serial Terminal");

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 24));
        jLabel1.setText("Serial Terminal");

        cboxPorts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxPortsActionPerformed(evt);
            }
        });

        jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel5.setText("Select Port and Connect");

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnDisconnect.setText("Disconnect");
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        mail_label.setFont(new java.awt.Font("Tahoma", 0, 10));

        clear_log.setText("Clear All");
        clear_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_log_ActionPerformed(evt);
            }
        });
               
       
        text_command = new JTextField();
        text_command.setColumns(10);
        scrollPane = new JScrollPane();
        
        lblSendCommand = new JLabel();
        lblSendCommand.setText("Send Command");
        lblSendCommand.setFont(new Font("Tahoma", Font.PLAIN, 11));
        String COPYRIGHT = "\u00a9";
        
        autoScrollCheck = new JCheckBox("Enable Auto Scroll");
        autoScrollCheck.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		 DefaultCaret caret = (DefaultCaret)txtLog.getCaret();
        		if (autoScrollCheck.isSelected()){    
        			int len = txtLog.getDocument().getLength();
        			txtLog.setCaretPosition(len);
        	        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        		}else{
        			caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        		}
        	}
        });
        
        
        
        
        
        
        
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(27)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(ConnectionStatus, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
        				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        					.addComponent(lblSendCommand, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(text_command, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        						.addComponent(clear_log)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(scrollPane)
        							.addPreferredGap(ComponentPlacement.RELATED)))
        					.addGap(54))
        				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabel5)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(btnConnect, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnDisconnect, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(autoScrollCheck, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
        						.addComponent(cboxPorts, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
        					.addGap(560))))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(16)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel5)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(cboxPorts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnDisconnect)
        					.addComponent(autoScrollCheck))
        				.addComponent(btnConnect))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblSendCommand)
        				.addComponent(clear_log))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(text_command, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(ConnectionStatus)
        			.addContainerGap())
        );
        
        
         txtLog = new JTextArea();
         scrollPane.setViewportView(txtLog);
         txtLog.setEditable(false);
         txtLog.setFocusable(true);
         txtLog.setWrapStyleWord(true);
         txtLog.setLineWrap(true);
         //txtLog.setEditable(false);
         ConnectionStatus.setFont(new Font("Courier", Font.PLAIN, 10));
         ConnectionStatus.setText("Disconnected");
        getContentPane().setLayout(groupLayout);

        pack();
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mnTools = new JMenu("File");
        menuBar.add(mnTools);
        
        mntmSettings = new JMenuItem("Settings");
        mntmSettings.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                     	new PropertiesMenu().SettingsMenu();	
            //new Menu().setVisible(true);         
        	}
        });
        mnTools.add(mntmSettings);
        
        mnFonts = new JMenu("Fonts");
        menuBar.add(mnFonts);
        
        mntmSetFonts = new JMenuItem("Set Fonts");
        mntmSetFonts.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new FontsMenu().FontsSettings();
        	}
        });
        mnFonts.add(mntmSetFonts);
        
        mnDevices = new JMenu("Devices");
        menuBar.add(mnDevices);
        
        CiscoDevice = new JCheckBoxMenuItem("On key typed: Cisco/3com Device");
        CiscoDevice.setSelected(true);
        buttonGroup.add(CiscoDevice);
        mnDevices.add(CiscoDevice);
        
        OtherDevice = new JCheckBoxMenuItem("On Enter pressed: Other Device");
        buttonGroup.add(OtherDevice);
        mnDevices.add(OtherDevice);
        
        mnAbout = new JMenu("About");
        menuBar.add(mnAbout);
        
        mntmGplLicenceOf = new JMenuItem("GPL Licence");
        mntmGplLicenceOf.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new About().licence();
        	}
        });
        mnAbout.add(mntmGplLicenceOf);
    }

//<----------------------------------CONNECTION BUTTON--------------------------------------------------------------------->
    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) { 
    	txtLog.setFont(new Font(getFonts(), getStyle(), getSizes()));
    	if(CiscoDevice.isSelected())
		{
		InputType(1);
		ConnectionStatus.setText("Connected to Cisco/3COM device");
		}
	else if(OtherDevice.isSelected())
		{
		InputType(0);
		ConnectionStatus.setText("Connected to Other device");
		}
        communicator.connect();
        
       // timeThreaded.start();
        if (communicator.getConnected() == true)
        {
            if (communicator.initIOStream() == true)
            {
                communicator.initListener();
            }
        }
    }                                          

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {                                              
        communicator.disconnect();
        ConnectionStatus.setText("Disconnected");
        text_command.setText("");
      //  timeThreaded.stop();
    }                                             

    private void clear_log_ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        txtLog.setText("");
    }                                          

    private void cboxPortsActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    public javax.swing.JButton btnConnect;
    public javax.swing.JButton btnDisconnect;
    @SuppressWarnings("rawtypes")
	public javax.swing.JComboBox cboxPorts;
    public javax.swing.JButton clear_log;
    private javax.swing.JLabel jLabel1;
  //  private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel mail_label;
    public javax.swing.JTextArea txtLog;
    public JTextField text_command;
    public JScrollPane scrollPane;
    private JLabel lblSendCommand;
    private JCheckBox autoScrollCheck;
    private JMenuBar menuBar;
    public JMenu mnTools;
  //  private JMenuItem mntmProperties;
    private JMenuItem mntmSettings;
    public JMenu mnFonts;
    private JMenuItem mntmSetFonts;
    public JMenu mnDevices;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JCheckBoxMenuItem CiscoDevice;
    private JCheckBoxMenuItem OtherDevice;
    public javax.swing.JLabel ConnectionStatus;
    private JMenu mnAbout;
    private JMenuItem mntmGplLicenceOf;
    
 
    
    public void InputType(int type){
    	if(type == 0)
    {
    Other(0);
    }
    	else if (type == 1)
    {
    Cisco(1);
    }
    	else 
    {
    	JOptionPane.showMessageDialog(null, "SomeThing went wrong");
    }
    }
//<--------------------------KEY LISTENERS!!!!!!--------------------------------------------------------------------------------->
//<--------------------------------------------Other Device------------------------------------------------------------------>
    public void Other(int type){ 
    	Device = true;
    	text_command.removeKeyListener(this);
    	text_command.addKeyListener(this);
    	}
//<-------------------------------------------------------------------------------------------------------------------------->
//<-----------------------------------------------Cisco Device--------------------------------------------------------------->
    public void Cisco(int type){
    	Device = false;
    	text_command.removeKeyListener(this);
    	text_command.addKeyListener(this);
    }
//<---------------------------------------------------------------------------------------------------------------------------->

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		key = e.getKeyChar();
		if (Device == true){
		//key = e.getKeyChar();
  		System.out.println("Other Device: "+key);
  		if (key == KeyEvent.VK_ENTER){
     	   Communicator.writeData2(text_command.getText());
     	  text_command.setText("");
  		}
  		}
		else if (Device == false)
		{
  	 		//key = e.getKeyChar();
     		System.out.println("Cisco Device: "+key);
     		if (key == KeyEvent.VK_ENTER){
        	   Communicator.writeData(13);
        	   text_command.setText("");
            }else if (key == 63){
            	Communicator.writeData(key);
            	text_command.setText("");
            }else{
            	Communicator.writeData(key);
            }
     		
     	}		
		/*CommandList.add(e.getKeyChar()+"");
		
		if (key == KeyEvent.VK_BACK_SPACE){
			//kati sto textArea
			CommandList.
		}*/
  		}
	}
//<---------------------------------------------------------------------------------------------------------------------------------------->   
    
    

