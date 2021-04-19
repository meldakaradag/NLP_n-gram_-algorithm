import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Test {

	private static JFrame frame;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {


					JScrollPane scrolltxt;
					frame = new JFrame();


					frame.setBounds(100, 100, 700, 532);
					frame.setBackground(Color.red);

					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);
					JFileChooser fileChooser = new JFileChooser();
					frame.getContentPane().add(fileChooser);

					JTextArea textArea = new JTextArea();
					textArea.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
					textArea.setToolTipText("");
					textArea.setForeground(Color.WHITE);
					textArea.setBackground(new Color(173, 216, 230));
					textArea.setBounds(1, 72, 598, 247);
					frame.getContentPane().add(textArea);
					scrolltxt=new JScrollPane(textArea);
					scrolltxt.setBounds(35,88,600,320);

					frame.getContentPane().add(scrolltxt);

					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 11));
					scrollPane.setBorder(new LineBorder(new Color(32, 178, 170)));
					scrollPane.setBackground(new Color(74, 112, 139));
					scrollPane.setBounds(803, 75, 264, 161);
					frame.getContentPane().add(scrollPane);

					FileFilter filter = new FileNameExtensionFilter("txt files", "txt");
					fileChooser.addChoosableFileFilter(filter);




					JButton uniButton = new JButton("UNIGRAM");
					uniButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
					uniButton.setForeground(Color.WHITE);
					uniButton.setToolTipText("");
					uniButton.setBackground(new Color(135, 206, 250));
					uniButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Ngram unigram=new Ngram();

							try {
								unigram.uniGram();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							textArea.setText(unigram.result.toString());
						}
					});
					uniButton.setBounds(120, 51, 120, 23);
					frame.getContentPane().add(uniButton);






					JButton biButton = new JButton("BIGRAM");
					biButton.setForeground(new Color(0, 0, 255));
					biButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
					biButton.setBackground(new Color(135, 206, 250));

					biButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Ngram bigram =new Ngram();

							try {
								bigram.biGram();
							} 
							catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							textArea.setText(bigram.result.toString());
						}
					});


					biButton.setBounds(270, 51, 120, 23);
					frame.getContentPane().add(biButton);






					JButton triButton = new JButton("TRIGRAM");
					triButton.setToolTipText("");
					triButton.setBackground(new Color(135, 206, 250));
					triButton.setForeground(new Color(0, 0, 205));
					triButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
					triButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {


							Ngram trigram =new Ngram();
							try {
								trigram.triGram();
							} catch (Exception e1) {

								e1.printStackTrace();
							}
							textArea.setText(trigram.result.toString());
						}
					});
					triButton.setBounds(420, 51, 120, 23);
					frame.getContentPane().add(triButton);


					frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
