import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;
import javax.swing.JPanel;
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class DataEntry {

	private JFrame frmResultsDataEntry;
	private JTextField pol_code;
	private JTextField cppinput;
	private JTextField ndpinput;
	private JTextField ndcinput;
	private JTextField pppinput;
	private JTextField nppinput;
	private JTextField pncinput;
	private JTextField indinput;
	private JTextField rejected_votes_input;
	
	Integer cpp, ndp, ndc, ppp, npp, pnc, ind, totalvotes, validvotes, rejectedvotes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataEntry window = new DataEntry();
					window.frmResultsDataEntry.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public DataEntry() {
		initialize();
	}
	
	 
	int index = 0;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResultsDataEntry = new JFrame();
		frmResultsDataEntry.setTitle("Results Data Entry Center");
		frmResultsDataEntry.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		frmResultsDataEntry.setBounds(100, 100, 1100, 648);
		frmResultsDataEntry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResultsDataEntry.getContentPane().setLayout(null);
		
		JLabel lblCode = new JLabel("CODE:");
		lblCode.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCode.setBounds(28, 37, 56, 16);
		frmResultsDataEntry.getContentPane().add(lblCode);
		
		pol_code = new JTextField();
		pol_code.setBackground(new Color(245, 245, 245));
		pol_code.setBounds(120, 34, 116, 22);
		frmResultsDataEntry.getContentPane().add(pol_code);
		pol_code.setColumns(10);
		
		JLabel lblCpp = new JLabel("CPP");
		lblCpp.setEnabled(true);
		lblCpp.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCpp.setBounds(28, 89, 56, 16);
		frmResultsDataEntry.getContentPane().add(lblCpp);
		
		cppinput = new JTextField();
		cppinput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cppinput.setBounds(120, 86, 116, 22);
		frmResultsDataEntry.getContentPane().add(cppinput);
		cppinput.setColumns(10);
		
		JLabel lblNdp = new JLabel("NDP");
		lblNdp.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNdp.setBounds(28, 138, 56, 16);
		frmResultsDataEntry.getContentPane().add(lblNdp);
		
		ndpinput = new JTextField();
		ndpinput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ndpinput.setBounds(120, 135, 116, 22);
		frmResultsDataEntry.getContentPane().add(ndpinput);
		ndpinput.setColumns(10);
		
		JLabel lblNdc = new JLabel("NDC");
		lblNdc.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNdc.setBounds(28, 188, 56, 16);
		frmResultsDataEntry.getContentPane().add(lblNdc);
		
		ndcinput = new JTextField();
		ndcinput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ndcinput.setBounds(120, 185, 116, 22);
		frmResultsDataEntry.getContentPane().add(ndcinput);
		ndcinput.setColumns(10);
		
		JLabel lblPpp = new JLabel("PPP");
		lblPpp.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPpp.setBounds(28, 240, 56, 16);
		frmResultsDataEntry.getContentPane().add(lblPpp);
		
		pppinput = new JTextField();
		pppinput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pppinput.setBounds(120, 237, 116, 22);
		frmResultsDataEntry.getContentPane().add(pppinput);
		pppinput.setColumns(10);
		
		JLabel lblNpp = new JLabel("NPP");
		lblNpp.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNpp.setBounds(28, 294, 56, 16);
		frmResultsDataEntry.getContentPane().add(lblNpp);
		
		nppinput = new JTextField();
		nppinput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nppinput.setBounds(120, 291, 116, 22);
		frmResultsDataEntry.getContentPane().add(nppinput);
		nppinput.setColumns(10);
		
		JLabel lblPnc = new JLabel("PNC");
		lblPnc.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPnc.setBounds(28, 355, 56, 16);
		frmResultsDataEntry.getContentPane().add(lblPnc);
		
		pncinput = new JTextField();
		pncinput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pncinput.setBounds(120, 352, 116, 22);
		frmResultsDataEntry.getContentPane().add(pncinput);
		pncinput.setColumns(10);
		
		JLabel lblInd = new JLabel("IND");
		lblInd.setFont(new Font("Arial", Font.PLAIN, 13));
		lblInd.setBounds(28, 410, 56, 16);
		frmResultsDataEntry.getContentPane().add(lblInd);
		
		indinput = new JTextField();
		indinput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		indinput.setBounds(120, 407, 116, 22);
		frmResultsDataEntry.getContentPane().add(indinput);
		indinput.setColumns(10);
		
		JLabel lblRejectedVotes = new JLabel("Rejected Votes");
		lblRejectedVotes.setFont(new Font("Arial", Font.PLAIN, 13));
		lblRejectedVotes.setBounds(12, 461, 94, 28);
		frmResultsDataEntry.getContentPane().add(lblRejectedVotes);
		
		rejected_votes_input = new JTextField();
		rejected_votes_input.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rejected_votes_input.setBounds(120, 464, 116, 22);
		frmResultsDataEntry.getContentPane().add(rejected_votes_input);
		rejected_votes_input.setColumns(10);
		
		JLabel lblValidVotes = new JLabel("Valid Votes");
		lblValidVotes.setFont(new Font("Arial", Font.BOLD, 13));
		lblValidVotes.setBounds(332, 37, 83, 33);
		frmResultsDataEntry.getContentPane().add(lblValidVotes);
		
		JLabel lblV_votes = new JLabel("");
		lblV_votes.setFont(new Font("Arial", Font.BOLD, 14));
		lblV_votes.setHorizontalAlignment(SwingConstants.CENTER);
		lblV_votes.setBounds(455, 37, 114, 33);
		frmResultsDataEntry.getContentPane().add(lblV_votes);
		
		JLabel lblTotalVotes = new JLabel("Total Votes");
		lblTotalVotes.setFont(new Font("Arial", Font.BOLD, 13));
		lblTotalVotes.setBounds(332, 118, 83, 42);
		frmResultsDataEntry.getContentPane().add(lblTotalVotes);
		
		JLabel lblT_votes = new JLabel("");
		lblT_votes.setBackground(new Color(255, 255, 255));
		lblT_votes.setFont(new Font("Arial", Font.BOLD, 14));
		lblT_votes.setHorizontalAlignment(SwingConstants.CENTER);
		lblT_votes.setBounds(455, 118, 114, 36);
		frmResultsDataEntry.getContentPane().add(lblT_votes);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBackground(new Color(230, 230, 250));
		lblImage.setForeground(new Color(220, 220, 220));
		lblImage.setBounds(581, 13, 474, 493);
		frmResultsDataEntry.getContentPane().add(lblImage);
		
		File path = new File("C:/Users/JARVIS/Documents/abbyy/images/");
		File[] files = path.listFiles();
		
		JButton btnNewButton_1 = new JButton("Fetch Image");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        for(index = 0; index < files.length; index++) {
		        ImageIcon[] imagelist = new ImageIcon[files.length];
				//Image image = imagelist[index].getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
				 lblImage.setIcon(imagelist[index]);
		        }
			}
		});
		btnNewButton_1.setBounds(758, 519, 116, 42);
		frmResultsDataEntry.getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Pol_code = pol_code.getText();
				
				cpp = Integer.parseInt(cppinput.getText());
				ndp = Integer.parseInt(ndpinput.getText());
				ndc = Integer.parseInt(ndcinput.getText());
				ppp = Integer.parseInt(pppinput.getText());
				npp = Integer.parseInt(nppinput.getText());
				pnc = Integer.parseInt(pncinput.getText());
				ind = Integer.parseInt(indinput.getText());
				rejectedvotes = Integer.parseInt(rejected_votes_input.getText());
				
				validvotes = cpp + ndp + ndc + ppp + npp + pnc + ind;
				totalvotes = rejectedvotes + validvotes;
				
								
				//Database connection intialization
				Connection connect = null;
				
				try {
					String dbURL = "jdbc:postgresql://104.196.171.159/icrapp";
					String user = "postgres";
					String pass = "testing";

					connect = DriverManager.getConnection(dbURL, user, pass);
					if (connect != null) {
						System.out.println("Connected to database");
					}
					
					PreparedStatement prepstatement = connect.prepareStatement(
							"UPDATE votes SET \"NPP\" = ?, \"NDC\" = ?,\"CPP\" = ?, \"PPP\" = ?,\"NDP\" = ?,\"PNC\" = ?,\"IND\" = ?,\"Rejected_Votes\" = ?, \"Total_Valid_Votes\" = ?, \"Total_Votes\" = ? WHERE \"Pol_Code\" = ?");
					
					prepstatement.setInt(1, npp);
					prepstatement.setInt(2, ndc);
					prepstatement.setInt(3, cpp);
					prepstatement.setInt(4, ppp);
					prepstatement.setInt(5, ndp);
					prepstatement.setInt(6, pnc);
					prepstatement.setInt(7, ind);
					prepstatement.setInt(8, rejectedvotes);
					prepstatement.setInt(9, validvotes);
					prepstatement.setInt(10, totalvotes);
					
					prepstatement.setString(11, Pol_code);

					prepstatement.executeUpdate();
					
					String v_votes = Integer.toString(validvotes);
					String t_votes = Integer.toString(totalvotes);
					lblV_votes.setText(v_votes);
					lblT_votes.setText(t_votes);
					System.out.println("Database updated");
					connect.close();
				}catch (Exception e) {
					System.err.println("Got an exception");
					System.err.println(e.getMessage());
				}
					
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\JARVIS\\Documents\\abbyy\\sign-check-icon.png"));
		btnNewButton.setBounds(299, 519, 116, 42);
		frmResultsDataEntry.getContentPane().add(btnNewButton);
		
	}
}
