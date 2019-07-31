package diffTriageFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

public class WaitFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaitFrame frame = new WaitFrame();
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
	public WaitFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPleaseWaitFor = new JLabel("Please Wait for 10 Seconds ");
		lblPleaseWaitFor.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblWhileYourData = new JLabel("While Your Data is Being Processed");
		lblWhileYourData.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(93, Short.MAX_VALUE)
					.addComponent(lblPleaseWaitFor)
					.addGap(84))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(lblWhileYourData)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(lblPleaseWaitFor)
					.addGap(18)
					.addComponent(lblWhileYourData)
					.addContainerGap(117, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
