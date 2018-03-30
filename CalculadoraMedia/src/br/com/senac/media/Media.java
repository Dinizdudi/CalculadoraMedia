package br.com.senac.media;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Media extends JFrame {

	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtMedia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Media frame = new Media();
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
	public Media() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Media.class.getResource("/br/com/senac/media/icones/igual.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNota = new JLabel("Nota 1");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNota.setBounds(10, 38, 65, 33);
		contentPane.add(lblNota);
		
		JLabel lblNota_1 = new JLabel("Nota 2");
		lblNota_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNota_1.setBounds(10, 94, 65, 33);
		contentPane.add(lblNota_1);
		
		txtNota1 = new JTextField();
		txtNota1.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNota1.setBounds(81, 38, 311, 33);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNota2.setColumns(10);
		txtNota2.setBounds(81, 97, 311, 33);
		contentPane.add(txtNota2);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(Media.class.getResource("/br/com/senac/media/icones/if_package-purge_24217.png")));
		btnLimpar.setBounds(262, 145, 130, 130);
		contentPane.add(btnLimpar);
		
		JButton btnCalc = new JButton("");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnCalc.setToolTipText("Calcular");
		btnCalc.setIcon(new ImageIcon(Media.class.getResource("/br/com/senac/media/icones/igual.png")));
		btnCalc.setBounds(81, 145, 137, 130);
		contentPane.add(btnCalc);
		
		JLabel lblMdia = new JLabel("M\u00E9dia");
		lblMdia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMdia.setBounds(10, 301, 65, 33);
		contentPane.add(lblMdia);
		
		txtMedia = new JTextField();
		txtMedia.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtMedia.setEditable(false);
		txtMedia.setBounds(81, 306, 311, 29);
		contentPane.add(txtMedia);
		txtMedia.setColumns(10);
	}
	
	/* método calcular média */
	
	private void calcular() {
		DecimalFormat formatador = new DecimalFormat("#0.00");
		float nota1, nota2, media;
		//a linha abaixo captura o conteúdo da caixa de texto, converte para float
		nota1 = Float.parseFloat(txtNota1.getText().replace(",", "."));
		nota2 = Float.parseFloat(txtNota2.getText().replace(",", "."));
		media = (nota1 + nota2)/2;
		txtMedia.setText("" + formatador.format(media));
		if(media < 5) {
			JOptionPane.showMessageDialog(null, "Reprovado", "Status", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Aprovado", "Status", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void limpar() {
		txtMedia.setText(null);
		txtNota1.setText(null);
		txtNota2.setText(null);
	}
}
