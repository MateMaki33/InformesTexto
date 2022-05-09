package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.EscrituraDatosEx;
import negocio.AccesoInformesImp;
import negocio.IAccesoInformes;
import pacientes.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInformes extends JFrame {
	AccesoInformesImp boton = new AccesoInformesImp();

	public JPanel panelPrincipal;
	public JTextField nombretxt;
	public JTextField flujotxt;
	public JTextField pvtext;
	public JTextField patxt;
	public int flujoint;
	public int paint;
	public int pvint;

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
		JCheckBox cvccheck = new JCheckBox("CVC");
		cvccheck.setBounds(605, 121, 93, 21);
		panelPrincipal.add(cvccheck);
		
		JCheckBox fistulacheck = new JCheckBox("Fistula");
		fistulacheck.setBounds(438, 121, 93, 21);
		panelPrincipal.add(fistulacheck);

		JButton botonGenerar = new JButton("Generar");
		botonGenerar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				VentanaInformes obj = new VentanaInformes();
				IAccesoInformes informe = new AccesoInformesImp();
				Paciente paciente = null;
				obj.setFlujoint(flujotxt);
				obj.setPaint(patxt);
				obj.setPvint(pvtext);
				String nombre = nombretxt.getText();
				int paint=obj.getPaint();
				int pvint=obj.getPvint();
				int flujoint=obj.getFlujoint();

				informe.iniciarInforme();
				
                if(fistulacheck.isSelected() && cvccheck.isSelected()) {
                	JOptionPane.showMessageDialog(botonGenerar, "Solo puedes marcar un acceso vascular");
                }else if (fistulacheck.isSelected()) {
				   paciente = informe.crearPacienteFav(nombre,flujoint,pvint,paint);
                }else if (cvccheck.isSelected()) {
                	paciente = informe.crearPacienteCvc(nombre,flujoint,pvint,paint);
                }else {JOptionPane.showMessageDialog(botonGenerar, "Marca un acceso vascular");}
                

				informe.agregarPaciente(IAccesoInformes.NOMBRE_RECURSO, paciente);
				JOptionPane.showMessageDialog(botonGenerar, "Se ha creado el archivo con la informacion");

			}
		});
		
		
		
		botonGenerar.setBackground(Color.WHITE);
		botonGenerar.setFont(new Font("Tahoma", Font.BOLD, 18));
		botonGenerar.setForeground(Color.MAGENTA);
		botonGenerar.setBounds(423, 391, 163, 66);
		panelPrincipal.add(botonGenerar);

		patxt = new JTextField();
		patxt.setBounds(551, 260, 96, 19);
		panelPrincipal.add(patxt);
		patxt.setColumns(10);

		JLabel lblpa = new JLabel("PA");
		lblpa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpa.setForeground(Color.WHITE);
		lblpa.setBounds(503, 254, 62, 26);
		panelPrincipal.add(lblpa);

		pvtext = new JTextField();
		pvtext.setBounds(551, 219, 96, 19);
		panelPrincipal.add(pvtext);
		pvtext.setColumns(10);

		JLabel lblpv = new JLabel("PV");
		lblpv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpv.setForeground(Color.WHITE);
		lblpv.setBounds(505, 216, 47, 21);
		panelPrincipal.add(lblpv);

		flujotxt = new JTextField();
		flujotxt.setBounds(551, 174, 96, 19);
		panelPrincipal.add(flujotxt);
		flujotxt.setColumns(10);

		JLabel lblFlujo = new JLabel("Flujo");
		lblFlujo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFlujo.setForeground(Color.WHITE);
		lblFlujo.setBounds(497, 171, 55, 21);
		panelPrincipal.add(lblFlujo);

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
		lblFondo.setIcon(new ImageIcon(
				"C:\\Users\\matem\\Desktop\\Desarrollo WEB\\Ejercicios java\\Eclipse\\Informes\\Dise\u00F1o sin t\u00EDtulo.png"));
		lblFondo.setBounds(-180, -61, 1433, 1065);
		panelPrincipal.add(lblFondo);
	}

	public String getNombretxt() {
		return this.nombretxt.getText();
	}

	public String getFlujotxt() {
		return this.flujotxt.getText();
	}

	public String getPvtxt() {
		return this.pvtext.getText();
	}

	public String getPatxt() {
		return this.patxt.getText();
	}

	public int getFlujoint() {
		return flujoint;
	}

	public void setFlujoint(JTextField flujo) {
		int flujo2 = Integer.parseInt(flujo.getText());
		this.flujoint = flujo2;
	}

	public int getPaint() {
		return paint;
	}

	public void setPaint(JTextField pa) {
		int paint2 = Integer.parseInt(pa.getText());
		this.paint = paint2;
	}

	public int getPvint() {
		return pvint;
	}

	public void setPvint(JTextField pv) {
		int pvint2 = Integer.parseInt(pv.getText());
		this.pvint = pvint2;
	}
}
