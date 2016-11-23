package com.jcg.rca.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;


public class MainWindow {

	private JFrame frmDataEntry;
	private JTextField CPP;
	private JTextField NDP;
	private JTextField NDC;
	Integer nppinput;
	Integer ndcinput;
	Integer cppinput;
	Integer pppinput;
	Integer ndpinput;
	Integer indinput;
	Integer pncinput;
	Integer rejected_votes_input;
	Integer valid_votes_input;
	Integer totalvotes;
	private JTextField PPP;
	private JTextField NPP;
	private JTextField REJECTED_VOTES;
	private JTextField VALID_VOTES;
	private JTextField PNC;
	private JLabel lblInd_2;
	private JTextField IND;
	private JLabel lblTotalvotes;
	private JLabel lblX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmDataEntry.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDataEntry = new JFrame();
		frmDataEntry.setTitle("Data Entry");
		frmDataEntry.setBounds(100, 100, 1109, 554);
		frmDataEntry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("CPP");
		
		JLabel lblNewLabel_1 = new JLabel("NDP");
		
		JLabel lblNewLabel_2 = new JLabel("NDC");
		
		JLabel lblPpp = new JLabel("PPP");
		
		JLabel lblInd = new JLabel("NPP");
		
		JLabel lblRejectedVotes = new JLabel("REJECTED VOTES");
		lblRejectedVotes.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblValidVotes = new JLabel("VALID VOTES");
		lblValidVotes.setHorizontalAlignment(SwingConstants.CENTER);
		
		CPP = new JTextField();
		
		NDP = new JTextField();
		
		NDC = new JTextField();
		
		PPP = new JTextField();
		
		NPP = new JTextField();
		
		REJECTED_VOTES = new JTextField();
		
		VALID_VOTES = new JTextField();
		VALID_VOTES.setEditable(false);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cppinput = Integer.parseInt(CPP.getText());
				ndpinput = Integer.parseInt(NDP.getText());
				ndcinput = Integer.parseInt(NDC.getText());
				pppinput = Integer.parseInt(PPP.getText());
				nppinput = Integer.parseInt(NPP.getText());
				pncinput = Integer.parseInt(PNC.getText());
				indinput = Integer.parseInt(IND.getText());
				rejected_votes_input = Integer.parseInt(REJECTED_VOTES.getText());
				valid_votes_input = Integer.parseInt(VALID_VOTES.getText());
				
				
				totalvotes = rejected_votes_input + valid_votes_input;
				
				//Database connection initialized
				Connection connect = null;
				try {
					String dbURL = "jdbc:postgresql://localhost/icrnewdb";
					String user = "postgres";
					String pass = "postgres";

					connect = DriverManager.getConnection(dbURL, user, pass);
					if (connect != null) {
						System.out.println("Connected to database");
					}
					
					PreparedStatement prepstatement = connect.prepareStatement("INSERT INTO \"NEW_AKRADE\"(\"NPP\", \"NDC\",\"CPP\", \"PPP\",\"NDP\",\"PNC\",\"IND\",rejectedvotes, validvotes, totalvotes) VALUES(?,?,?,?,?,?,?,?,?,?)");
					
					prepstatement.setInt(1, nppinput);
					prepstatement.setInt(2, ndcinput);
					prepstatement.setInt(3, cppinput);
					prepstatement.setInt(4, pppinput);
					prepstatement.setInt(5, ndpinput);
					prepstatement.setInt(6, pncinput);
					prepstatement.setInt(7, indinput);
					prepstatement.setInt(8, totalvotes);
					prepstatement.setInt(9, rejected_votes_input);
					prepstatement.setInt(10, valid_votes_input);
					
					prepstatement.executeUpdate();
					System.out.println("Database Updated");
					connect.close();
				} catch (Exception e) {
					System.err.println("Got an exception");
					System.err.println(e.getMessage());
				}
				}
		});
		
		JLabel lblInd_1 = new JLabel("PNC");
		
		PNC = new JTextField();
		
		lblInd_2 = new JLabel("IND");
		
		IND = new JTextField();
		
		lblTotalvotes = new JLabel("TOTAL VOTES");
		
		lblX = new JLabel("");
		
		JPanel panel = new JPanel();
		
		JButton btnFetchImage = new JButton("Fetch Image");
		
		
	
		GroupLayout groupLayout = new GroupLayout(frmDataEntry.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblPpp, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
									.addComponent(lblInd, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
								.addComponent(lblInd_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInd_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGap(26))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblRejectedVotes, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(NDC, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(IND, 47, 47, 47)
									.addComponent(PNC, Alignment.TRAILING, 47, 47, 47)
									.addComponent(NDP, 47, 47, 47)
									.addComponent(PPP, 47, 47, 47)
									.addComponent(NPP, 47, 47, 47)
									.addComponent(CPP, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(79)
										.addComponent(lblValidVotes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblTotalvotes, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(VALID_VOTES, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFetchImage))
							.addGap(80))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(REJECTED_VOTES, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(131)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblValidVotes)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(11)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(NDC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel_1)
												.addComponent(CPP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(26)
											.addComponent(lblTotalvotes, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
								.addComponent(VALID_VOTES, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(38)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(NPP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(34)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPpp)
										.addComponent(PPP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(36)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblInd)
										.addComponent(NDP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(37)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblInd_1)
										.addComponent(PNC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblInd_2)
										.addComponent(IND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(50)
									.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(5)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnFetchImage, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRejectedVotes, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(REJECTED_VOTES, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		frmDataEntry.getContentPane().setLayout(groupLayout);
	}
}
