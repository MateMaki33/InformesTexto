package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class VentanaInformes extends JFrame {

	private JPanel panelPrincipal;
	private JTextField nombretxt;
	private JTextField flujotxt;
	private JTextField pvtext;
	private JTextField patxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInformes frame = new VentanaInformes();
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
	public VentanaInformes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 542);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		setTitle("GENERADOR DE INFORMES");
		setResizable(false);
		setLocationRelativeTo(null);
		
		JButton botonGenerar = new JButton("Generar");
		botonGenerar.setBackground(Color.WHITE);
		botonGenerar.setFont(new Font("Tahoma", Font.BOLD, 18));
		botonGenerar.setForeground(Color.MAGENTA);
		botonGenerar.setBounds(423, 391, 163, 66);
		panelPrincipal.add(botonGenerar);
		
		JCheckBox inestablecheck = new JCheckBox("Inestable e HipoTA");
		inestablecheck.setFont(new Font("Tahoma", Font.PLAIN, 13));
		inestablecheck.setBounds(583, 323, 135, 21);
		panelPrincipal.add(inestablecheck);
		
		JCheckBox estable2check = new JCheckBox("Estable con HTA");
		estable2check.setFont(new Font("Tahoma", Font.PLAIN, 13));
		estable2check.setBounds(423, 323, 124, 21);
		panelPrincipal.add(estable2check);
		
		JCheckBox establecheck = new JCheckBox("Estable");
		establecheck.setFont(new Font("Tahoma", Font.PLAIN, 13));
		establecheck.setForeground(Color.BLACK);
		establecheck.setBounds(297, 323, 93, 21);
		panelPrincipal.add(establecheck);
		
		patxt = new JTextField();
		patxt.setBounds(480, 266, 96, 19);
		panelPrincipal.add(patxt);
		patxt.setColumns(10);
		
		JLabel lblpa = new JLabel("PA");
		lblpa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpa.setForeground(Color.WHITE);
		lblpa.setBounds(423, 260, 93, 26);
		panelPrincipal.add(lblpa);
		
		pvtext = new JTextField();
		pvtext.setBounds(480, 219, 96, 19);
		panelPrincipal.add(pvtext);
		pvtext.setColumns(10);
		
		JLabel lblpv = new JLabel("PV");
		lblpv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpv.setForeground(Color.WHITE);
		lblpv.setBounds(423, 216, 105, 21);
		panelPrincipal.add(lblpv);
		
		flujotxt = new JTextField();
		flujotxt.setBounds(480, 177, 96, 19);
		panelPrincipal.add(flujotxt);
		flujotxt.setColumns(10);
		
		JLabel lblFlujo = new JLabel("Flujo");
		lblFlujo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFlujo.setForeground(Color.WHITE);
		lblFlujo.setBounds(423, 174, 84, 21);
		panelPrincipal.add(lblFlujo);
		
		JCheckBox cvccheck = new JCheckBox("Cateter");
		cvccheck.setBounds(597, 119, 93, 21);
		panelPrincipal.add(cvccheck);
		
		JCheckBox favCheck = new JCheckBox("Fistula");
		favCheck.setBounds(435, 119, 93, 21);
		panelPrincipal.add(favCheck);
		
		nombretxt = new JTextField();
		nombretxt.setForeground(Color.BLACK);
		nombretxt.setBounds(435, 69, 263, 26);
		panelPrincipal.add(nombretxt);
		nombretxt.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre Paciente");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(480, 28, 210, 39);
		panelPrincipal.add(lblNombre);
		
		JLabel lblTitulo = new JLabel("Generador de Informes");
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setBounds(20, 10, 358, 118);
		panelPrincipal.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setBackground(Color.DARK_GRAY);
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblFondo.setIcon(new ImageIcon("C:\\Users\\matem\\Desktop\\Desarrollo WEB\\Ejercicios java\\Eclipse\\Informes\\Dise\u00F1o sin t\u00EDtulo.png"));
		lblFondo.setBounds(-180, -61, 1433, 1065);
		panelPrincipal.add(lblFondo);
	}
}
