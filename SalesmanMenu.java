import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Home
 */
public class SalesmanMenu extends javax.swing.JFrame {

	/**
	 * Creates new form SalesmanMenu
	 */
	public SalesmanMenu() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton3 = new javax.swing.JRadioButton();
		jLabel4 = new javax.swing.JLabel();
		jRadioButton4 = new javax.swing.JRadioButton();
		jRadioButton6 = new javax.swing.JRadioButton();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(0, 102, 102));

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
		jRadioButton1.setForeground(new java.awt.Color(0, 102, 102));
		jRadioButton1.setText("Εγγραφή νέου πελάτη");
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});

		jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup1.add(jRadioButton3);
		jRadioButton3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
		jRadioButton3.setForeground(new java.awt.Color(0, 102, 102));
		jRadioButton3.setText("Πελατολόγιο");
		jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton3ActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(0, 102, 102));
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("Μενού Πωλητή");
		jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addGap(0, 90, Short.MAX_VALUE)
								.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 377,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(69, 69, 69))
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(162, 162, 162)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jRadioButton3).addComponent(jRadioButton1).addComponent(jLabel3))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(23, 23, 23).addComponent(jLabel4)
						.addGap(77, 77, 77).addComponent(jRadioButton1).addGap(127, 127, 127)
						.addComponent(jRadioButton3).addGap(316, 316, 316).addComponent(jLabel3)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jRadioButton4.setBackground(new java.awt.Color(0, 102, 102));
		buttonGroup1.add(jRadioButton4);
		jRadioButton4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
		jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
		jRadioButton4.setText("Μισθός και Μπόνους");
		jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton4ActionPerformed(evt);
			}
		});

		jRadioButton6.setBackground(new java.awt.Color(0, 102, 102));
		buttonGroup1.add(jRadioButton6);
		jRadioButton6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
		jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
		jRadioButton6.setText("Προσωπική Aπόδοση");
		jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton6ActionPerformed(evt);
			}
		});

		jButton1.setForeground(new java.awt.Color(0, 102, 102));
		jButton1.setText("Αποσύνδεση");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(84, 84, 84)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														jPanel1Layout.createSequentialGroup()
																.addComponent(jRadioButton6).addGap(163, 163, 163))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jRadioButton4).addContainerGap())))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(353, 353, 353).addComponent(
										jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
										javax.swing.GroupLayout.PREFERRED_SIZE)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(141, 141, 141).addComponent(jRadioButton4)
						.addGap(125, 125, 125).addComponent(jRadioButton6)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(203, 203, 203)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		RegisterCustomer rc = new RegisterCustomer();
		rc.setVisible(true);
	}

	private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		Salesman.Salesman_Clients();
	}

	private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905;";
		Connection dbcon;
		Statement stmt1;
		ResultSet rs1;

		try {
			float salary = 0;
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("SELECT * FROM Salesman");
			while (rs1.next()) {
				String username = rs1.getString("Username");
				if (username.equals(LogIn.usernameS)) {
					salary = rs1.getFloat("salary");
					SalesmanSalary ss = new SalesmanSalary();
					ss.jLabel4.setText(String.valueOf(salary) + "€");
					ss.jLabel5.setText(
							String.valueOf(Salesman.Salesman_ExtraSalary(LogIn.usernameS, Manager.getBudget())) + "€");
					ss.setVisible(true);
				}
			}
			dbcon.close();
			stmt1.close();

		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}
	}

	private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		float ef = Salesman.Salesman_Efficiency(LogIn.usernameS);
		Efficiency e = new Efficiency();
		e.jLabel4.setText(String.valueOf(ef) + "%");
		e.setVisible(true);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		Welcome wl = new Welcome();
		setVisible(false);
		wl.setVisible(true);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SalesmanMenu.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SalesmanMenu.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SalesmanMenu.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SalesmanMenu.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SalesmanMenu().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JRadioButton jRadioButton6;
	// End of variables declaration
}