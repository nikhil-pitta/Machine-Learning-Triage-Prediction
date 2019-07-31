package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import diffTriageFrames.Triage1;
import diffTriageFrames.Triage2;
import diffTriageFrames.Triage3;
import diffTriageFrames.Triage4;
import diffTriageFrames.Triage5;
import diffTriageFrames.WaitFrame;

import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class NurseGui extends JFrame{
	
	//////////////////////////////////
	private Triage triage;
	private MouseColor mouse;
	//////////////////////////////////

	private JPanel contentPane;
	private JLabel tempLabel;
	private JLabel heartLabel;
	private JLabel respLabel;
	private JLabel bpLabel;
	private JTextField tempText;
	private JTextField bpText;
	private JTextField nameText;
	private JTextField spText;
	private JLabel spLabel;
	private JLabel nameLabel;
	private JLabel Title;
	private JTextField heartText;
	private JTextField respText;
	private JButton submit;
	private JLabel pieChart;
	private JLabel symptomLabel;
	private JTextField symptomText;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseGui frame = new NurseGui();
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
	public NurseGui() {
		
		createComponents();
		handleEvents();
	}
	
	private void createComponents() {
		
		try {
			triage = new Triage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Title = new JLabel("Enter Details Of Person");
		Title.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		nameLabel = new JLabel("Name:");
		
		spLabel = new JLabel("Sp02 Level:");
		
		tempLabel = new JLabel("Temperature");
		
		heartLabel = new JLabel("Heart Rate");
		
		respLabel = new JLabel("Respiratory Rate");
		
		bpLabel = new JLabel("Blood Pressure");
		
		nameText = new JTextField();
		nameText.setColumns(10);
		
		spText = new JTextField();
		spText.setColumns(10);
		
		tempText = new JTextField();
		tempText.setColumns(10);
		
		heartText = new JTextField();
		heartText.setColumns(10);
		
		respText = new JTextField();
		respText.setColumns(10);
		
		bpText = new JTextField();
		bpText.setColumns(10);
		
		submit = new JButton("Submit");
		
		pieChart = new JLabel("");
	
		
		mouse = new MouseColor();
		
		generateImage();
		
		symptomLabel = new JLabel("Symptoms");
		
		symptomText = new JTextField();
		symptomText.setColumns(10);

		//pieChart.setIcon(new ImageIcon("/Users/nikhil/Desktop/Synopsys Project/yeet.png"));
		
	//	BufferedImage image;
		
//		try {
//			image = ImageIO.read(new File("/Users/nikhil/Desktop/Synopsys Project/yeet.png"));
//			Image dimg = image.getScaledInstance(pieChart.getWidth(), pieChart.getHeight(), Image.SCALE_SMOOTH);
//			pieChart.setIcon(new ImageIcon(dimg));
//
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(heartLabel)
								.addComponent(respLabel)
								.addComponent(tempLabel)
								.addComponent(spLabel)
								.addComponent(nameLabel)
								.addComponent(bpLabel)
								.addComponent(symptomLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tempText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(heartText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(respText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(symptomText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(bpText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(pieChart, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(237)
							.addComponent(submit)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(231, Short.MAX_VALUE)
					.addComponent(Title)
					.addGap(179))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(Title)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(spText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spLabel))
							.addGap(17)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tempText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tempLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(heartText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(heartLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(respText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(respLabel))
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(bpText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bpLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(symptomLabel)
								.addComponent(symptomText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(62))
						.addComponent(pieChart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(submit)
					.addGap(98))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void handleEvents(){
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Writer writer = new Writer();
					
					String name = nameText.getText();
					String sp = spText.getText();
					String temp = tempText.getText();
					String heart = heartText.getText();
					String resp = respText.getText();
					String bp = bpText.getText();
					
					int n = bp.indexOf("/");
					double firstNum = Integer.parseInt(bp.substring(0, n));
					double secondNum = Integer.parseInt(bp.substring(n+1));
					double realBp = firstNum/secondNum;
				
					bp = String.valueOf(realBp);
					
					String sy = symptomText.getText();

					writer.write(name, sp, temp, heart, resp, bp, sy);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}

				nameText.setText("");
				spText.setText("");
				tempText.setText("");
				heartText.setText("");
				respText.setText("");
				bpText.setText("");
				symptomText.setText("");
								


				try {
					Thread.sleep(10000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				//////// START MAKING TRAIGE SYSTEM
				
				generateImage();
				
			}
		});
		
		
		pieChart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(mouse.currentColor[0]==255)
				{
					dispose();
					Triage1 tri = new Triage1();
					tri.setVisible(true);
				}
				
				else if(mouse.currentColor[1]==116)
				{
					dispose();
					Triage2 tri = new Triage2();
					tri.setVisible(true);
				}
				else if(mouse.currentColor[2]==255)
				{
					dispose();
					Triage3 tri = new Triage3();
					tri.setVisible(true);
				}
				else if(mouse.currentColor[2]==179)
				{
					dispose();
					Triage4 tri = new Triage4();
					tri.setVisible(true);
				}
				else if(mouse.currentColor[1]==182)
				{
					dispose();
					Triage5 tri = new Triage5();
					tri.setVisible(true);
				}
			}
		});
		
	}
	
	private void generateImage()
	{
		int size = 400;
		pieChart.setIcon(new ImageIcon(new ImageIcon("/Users/nikhil/Desktop/Synopsys Project/TriageChart.png").getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH)));

	}
	
}
