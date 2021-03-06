
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ezisouli
 */
public class InsuranceChoice extends javax.swing.JFrame {

	/**
	 * Creates new form InsuranceChoice
	 */
	public InsuranceChoice() {
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
		buttonGroup2 = new javax.swing.ButtonGroup();
		buttonGroup3 = new javax.swing.ButtonGroup();
		buttonGroup4 = new javax.swing.ButtonGroup();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox2 = new javax.swing.JCheckBox();
		jCheckBox3 = new javax.swing.JCheckBox();
		jCheckBox4 = new javax.swing.JCheckBox();
		jButton1 = new javax.swing.JButton();
		jCheckBox5 = new javax.swing.JCheckBox();
		jCheckBox6 = new javax.swing.JCheckBox();
		jCheckBox7 = new javax.swing.JCheckBox();
		jCheckBox8 = new javax.swing.JCheckBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(0, 102, 102));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Επιλογή Ασφαλειών");
		jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

		jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup1.add(jCheckBox1);
		jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jCheckBox1.setForeground(new java.awt.Color(0, 102, 102));
		jCheckBox1.setText("Αυτοκινήτου-6 μήνες");
		jCheckBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

		jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup3.add(jCheckBox2);
		jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jCheckBox2.setForeground(new java.awt.Color(0, 102, 102));
		jCheckBox2.setText("Κλοπής-6 μήνες");
		jCheckBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

		jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup2.add(jCheckBox3);
		jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jCheckBox3.setForeground(new java.awt.Color(0, 102, 102));
		jCheckBox3.setText("Πυρός-6 μήνες");
		jCheckBox3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

		jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup4.add(jCheckBox4);
		jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jCheckBox4.setForeground(new java.awt.Color(0, 102, 102));
		jCheckBox4.setText("Ζωής-6 μήνες");
		jCheckBox4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setForeground(new java.awt.Color(0, 102, 102));
		jButton1.setText("OK");
		jButton1.setBorder(null);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup1.add(jCheckBox5);
		jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jCheckBox5.setForeground(new java.awt.Color(0, 102, 102));
		jCheckBox5.setText("Αυτοκινήτου-12 μήνες");
		jCheckBox5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
		jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox5ActionPerformed(evt);
			}
		});

		jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup2.add(jCheckBox6);
		jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jCheckBox6.setForeground(new java.awt.Color(0, 102, 102));
		jCheckBox6.setText("Πυρός-12 μήνες");
		jCheckBox6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
		jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox6ActionPerformed(evt);
			}
		});

		jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup3.add(jCheckBox7);
		jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jCheckBox7.setForeground(new java.awt.Color(0, 102, 102));
		jCheckBox7.setText("Κλοπής-12 μήνες");
		jCheckBox7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

		jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroup4.add(jCheckBox8);
		jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jCheckBox8.setForeground(new java.awt.Color(0, 102, 102));
		jCheckBox8.setText("Ζωής-12 μήνες");
		jCheckBox8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(26, 26, 26))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(57, 57, 57).addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jCheckBox7).addGap(0, 0,
								Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jCheckBox5)
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(
										jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jCheckBox1).addComponent(jCheckBox2))
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addGap(99, 99, 99)
																.addGroup(jPanel1Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jCheckBox8)
																		.addComponent(jCheckBox4)))
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout.createSequentialGroup().addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jCheckBox3)))
												.addGroup(jPanel1Layout.createSequentialGroup().addGap(99, 99, 99)
														.addComponent(jCheckBox6))))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(44, 44, 44).addComponent(jLabel1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 261,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(39, Short.MAX_VALUE)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(47, 47, 47)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jCheckBox1).addComponent(jCheckBox3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jCheckBox5).addComponent(jCheckBox6))
						.addGap(33, 33, 33)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jCheckBox2).addComponent(jCheckBox4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jCheckBox7).addComponent(jCheckBox8))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		int i1 = 0;
		Connection connection;
		PreparedStatement ps;
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905;";
		try {
			connection = DriverManager.getConnection(url);
			if (jCheckBox1.isSelected()) {
				i1++;
				ps = connection.prepareStatement("INSERT INTO Client_Insurances VALUES ( ?,?, ? , ?)");
				ps.setString(1, RegisterCustomer.lname);
				ps.setString(2, "Autokinitou");
				ps.setInt(3, 6);
				ps.setFloat(4, 0);
				ps.executeUpdate();
				Client.Client_bill(RegisterCustomer.lname);

			} else if (jCheckBox5.isSelected()) {
				i1++;
				ps = connection.prepareStatement("INSERT INTO Client_Insurances VALUES ( ?,?, ? , ?)");
				ps.setString(1, RegisterCustomer.lname);
				ps.setString(2, "Autokinitou");
				ps.setInt(3, 12);
				ps.setFloat(4, 0);
				ps.executeUpdate();
				Client.Client_bill(RegisterCustomer.lname);

			}
			if (jCheckBox2.isSelected()) {
				i1++;
				ps = connection.prepareStatement("INSERT INTO Client_Insurances VALUES ( ?,?, ? , ?)");
				ps.setString(1, RegisterCustomer.lname);
				ps.setString(2, "Klopis");
				ps.setInt(3, 6);
				ps.setFloat(4, 0);
				ps.executeUpdate();
				Client.Client_bill(RegisterCustomer.lname);

			} else if (jCheckBox7.isSelected()) {
				i1++;
				ps = connection.prepareStatement("INSERT INTO Client_Insurances VALUES ( ?,?, ? , ?)");
				ps.setString(1, RegisterCustomer.lname);
				ps.setString(2, "Klopis");
				ps.setInt(3, 12);
				ps.setFloat(4, 0);
				ps.executeUpdate();
				Client.Client_bill(RegisterCustomer.lname);

			}
			if (jCheckBox3.isSelected()) {
				i1++;
				ps = connection.prepareStatement("INSERT INTO Client_Insurances VALUES ( ?,?, ? , ?)");
				ps.setString(1, RegisterCustomer.lname);
				ps.setString(2, "Pyros");
				ps.setInt(3, 6);
				ps.setFloat(4, 0);
				ps.executeUpdate();
				Client.Client_bill(RegisterCustomer.lname);

			} else if (jCheckBox6.isSelected()) {
				i1++;
				ps = connection.prepareStatement("INSERT INTO Client_Insurances VALUES ( ?,?, ? , ?)");
				ps.setString(1, RegisterCustomer.lname);
				ps.setString(2, "Pyros");
				ps.setInt(3, 12);
				ps.setFloat(4, 0);
				ps.executeUpdate();
				Client.Client_bill(RegisterCustomer.lname);

			}
			if (jCheckBox4.isSelected()) {
				i1++;
				ps = connection.prepareStatement("INSERT INTO Client_Insurances VALUES ( ?,?, ? , ?)");
				ps.setString(1, RegisterCustomer.lname);
				ps.setString(2, "Zwis");
				ps.setInt(3, 6);
				ps.setFloat(4, 0);
				ps.executeUpdate();
				Client.Client_bill(RegisterCustomer.lname);

			} else if (jCheckBox8.isSelected()) {
				i1++;
				ps = connection.prepareStatement("INSERT INTO Client_Insurances VALUES ( ?,?, ? , ?)");
				ps.setString(1, RegisterCustomer.lname);
				ps.setString(2, "Zwis");
				ps.setInt(3, 12);
				ps.setFloat(4, 0);
				ps.executeUpdate();
				Client.Client_bill(RegisterCustomer.lname);

			}
			if (i1 == 0) {
				JOptionPane.showMessageDialog(null, "Παρακαλώ επιλέξτε κάποια ασφάλεια");
			} else {
				JOptionPane.showMessageDialog(null, "Επιτυχής αποθήκευση ασφαλειών");
				setVisible(false);
			}
		} catch (SQLException w) {
			System.out.print("SQLException: ");
			System.out.println(w.getMessage());
		}
	}

	private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
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
			java.util.logging.Logger.getLogger(InsuranceChoice.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(InsuranceChoice.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(InsuranceChoice.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(InsuranceChoice.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InsuranceChoice().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private javax.swing.ButtonGroup buttonGroup3;
	private javax.swing.ButtonGroup buttonGroup4;
	private javax.swing.JButton jButton1;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JCheckBox jCheckBox3;
	private javax.swing.JCheckBox jCheckBox4;
	private javax.swing.JCheckBox jCheckBox5;
	private javax.swing.JCheckBox jCheckBox6;
	private javax.swing.JCheckBox jCheckBox7;
	private javax.swing.JCheckBox jCheckBox8;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration
}
