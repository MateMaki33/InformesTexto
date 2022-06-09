package gui;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import negocio.AccesoInformesImp;
import negocio.IAccesoInformes;
import pacientes.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class VentanaInformes extends JFrame {

	JCheckBox gidko = new JCheckBox("GID elevada");
	JCheckBox gidok = new JCheckBox("GID controlada");
	JCheckBox establecheck = new JCheckBox("Estable");
	JCheckBox hipoGlucemiacheck = new JCheckBox("Hipoglucemia");
	JCheckBox hipoTAcheck = new JCheckBox("HipoTA");
	JCheckBox hemostasiacheck = new JCheckBox("Hemostasia");

	public JPanel panelPrincipal;
	public JTextField nombretxt;
	public JTextField flujotxt;
	public JTextField pvtext;
	public JTextField patxt;
	private int flujoint;
	private int paint;
	private int pvint;
	public static boolean peso;
	public static boolean pacienteEstable;
	public static boolean hipoGlucemia;
	public static boolean hemostasiaACV;


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

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(387, 347, 364, 21);
		panelPrincipal.add(separator_3);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(387, 376, 364, -22);
		panelPrincipal.add(separator_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(388, 111, 363, 4);
		panelPrincipal.add(separator_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(388, 210, 364, 7);
		panelPrincipal.add(separator);


		hemostasiacheck.setBounds(630, 298, 93, 21);
		panelPrincipal.add(hemostasiacheck);


		hipoTAcheck.setBounds(413, 298, 93, 21);
		panelPrincipal.add(hipoTAcheck);


		hipoGlucemiacheck.setBounds(523, 298, 93, 21);
		panelPrincipal.add(hipoGlucemiacheck);


		establecheck.setBounds(520, 243, 93, 21);
		panelPrincipal.add(establecheck);


		gidko.setBounds(605, 164, 93, 21);
		panelPrincipal.add(gidko);

		gidok.setBounds(438, 164, 93, 21);
		panelPrincipal.add(gidok);
		JCheckBox cvccheck = new JCheckBox("CVC");
		cvccheck.setBounds(605, 121, 93, 21);
		panelPrincipal.add(cvccheck);

		JCheckBox fistulacheck = new JCheckBox("Fistula");
		fistulacheck.setBounds(438, 121, 93, 21);
		panelPrincipal.add(fistulacheck);

		JButton botonGenerar = new JButton("Generar");
		botonGenerar.addActionListener(e -> {
			IAccesoInformes informe = new AccesoInformesImp();
			Paciente paciente;
			setFlujoint(flujotxt);
			setPaint(patxt);
			setPvint(pvtext);
			String nombre = nombretxt.getText();
			int paint = getPaint();
			int pvint = getPvint();
			int flujoint = getFlujoint();
			try {
				peso=controlPeso(gidok,gidko);
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
			try {
				pacienteEstable=estabilidad();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());

			}
			hipoGlucemia=glucemia();
			hemostasiaACV=hemostasia();


			if (fistulacheck.isSelected() && cvccheck.isSelected()) {
				JOptionPane.showMessageDialog(botonGenerar, "Solo puedes marcar un acceso vascular");
			} else if (fistulacheck.isSelected()) {
				informe.iniciarInforme();
				paciente = informe.crearPacienteFav(nombre, flujoint, pvint, paint);
				informe.agregarPaciente(IAccesoInformes.NOMBRE_RECURSO, paciente);
				JOptionPane.showMessageDialog(botonGenerar, "Se ha creado el archivo con la informacion");

			} else if (cvccheck.isSelected()) {
				informe.iniciarInforme();
				paciente = informe.crearPacienteCvc(nombre, flujoint, pvint, paint);
				informe.agregarPaciente(IAccesoInformes.NOMBRE_RECURSO, paciente);
				JOptionPane.showMessageDialog(botonGenerar, "Se ha creado el archivo con la informacion");

			} else {
				JOptionPane.showMessageDialog(botonGenerar, "Marca un acceso vascular");
			}


		});

		botonGenerar.setBackground(Color.WHITE);
		botonGenerar.setFont(new Font("Tahoma", Font.BOLD, 18));
		botonGenerar.setForeground(Color.MAGENTA);
		botonGenerar.setBounds(30, 105, 132, 47);
		panelPrincipal.add(botonGenerar);

		patxt = new JTextField();
		patxt.setBounds(627, 423, 96, 19);
		panelPrincipal.add(patxt);
		patxt.setColumns(10);

		JLabel lblpa = new JLabel("PA");
		lblpa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpa.setForeground(Color.WHITE);
		lblpa.setBounds(572, 417, 62, 26);
		panelPrincipal.add(lblpa);

		pvtext = new JTextField();
		pvtext.setBounds(435, 423, 96, 19);
		panelPrincipal.add(pvtext);
		pvtext.setColumns(10);

		JLabel lblpv = new JLabel("PV");
		lblpv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpv.setForeground(Color.WHITE);
		lblpv.setBounds(378, 420, 47, 21);
		panelPrincipal.add(lblpv);

		flujotxt = new JTextField();
		flujotxt.setBounds(252, 423, 96, 19);
		panelPrincipal.add(flujotxt);
		flujotxt.setColumns(10);

		JLabel lblFlujo = new JLabel("Flujo");
		lblFlujo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFlujo.setForeground(Color.WHITE);
		lblFlujo.setBounds(187, 420, 55, 21);
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
		lblFondo.setBounds(-202, -17, 1433, 1065);
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
		this.flujoint = Integer.parseInt(flujo.getText());
	}

	public int getPaint() {
		return paint;
	}

	public void setPaint(JTextField pa) {
		this.paint = Integer.parseInt(pa.getText());
	}

	public int getPvint() {
		return pvint;
	}

	public void setPvint(JTextField pv) {
		this.pvint = Integer.parseInt(pv.getText());
	}

	 public boolean controlPeso(JCheckBox gidok,JCheckBox gidko ) throws Exception{
		boolean peso=false;
		if (gidok.isSelected() && gidko.isSelected()) {
			JOptionPane.showMessageDialog(null, "Solo una opcion de control de peso");
			gidok.setSelected(false);
			gidko.setSelected(false);
			throw new Exception("Solo una casilla GID");
		}
		else if(gidok.isSelected()) {peso=true;}
		else if (gidko.isSelected()) {peso=false;}
		return peso;

	}

	 public boolean estabilidad() throws Exception {
		boolean estable = false;
		if (establecheck.isSelected() && hipoTAcheck.isSelected()) {
			JOptionPane.showMessageDialog(null, "Estable no es compatible con HipoTA ");
			establecheck.setSelected(false);
			hipoTAcheck.setSelected(false);
			throw new Exception("Casillas Estable e HipoTA incompatibles");
		}
			if (establecheck.isSelected()) {
				estable = true;
			} else if (hipoTAcheck.isSelected()) {
				estable = false;
			}

		return estable;
	}

	public boolean glucemia() {
		return hipoGlucemiacheck.isSelected();
	}
	public boolean hemostasia() {
		return hemostasiacheck.isSelected();
	}


}	
