package diffTriageFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import gui.NurseGui;
import java.awt.Font;

public class Triage3 extends JFrame {

	private JPanel contentPane;
	private JButton btnGoBack;
	private JLabel lblTriage;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Triage3 frame = new Triage3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Triage3() {
		
		createComponenets();
		handleEvents();
		
	}

	private void handleEvents() 
	{
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				NurseGui gui = new NurseGui();
				gui.setVisible(true);
			}
		});
		
	}

	private void createComponenets() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblTriage = new JLabel("Triage 3");
		lblTriage.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		btnGoBack = new JButton("Go Back");
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/nikhil/Desktop/Synopsys Project/TriageTable3.png"));


		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel)
					.addContainerGap(264, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(291, Short.MAX_VALUE)
					.addComponent(btnGoBack)
					.addGap(205))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(256)
					.addComponent(lblTriage)
					.addContainerGap(238, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblTriage, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addComponent(btnGoBack)
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	

}
