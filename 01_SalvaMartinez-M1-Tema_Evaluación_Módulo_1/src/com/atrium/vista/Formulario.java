package com.atrium.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import com.atrium.modelo.Fachada_Formulario;
import com.atrium.modelo.Fachada_Properties;
import com.atrium.modelo.IFachada_Formulario;
import com.atrium.modelo.IFachada_Properties;
import com.atrium.modelo.Datos_DTO_Formulario;
import com.atrium.modelo.Datos_DTO_Properties;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;

public class Formulario extends JFrame implements IFormulario, ActionListener, MouseListener, KeyListener, FocusListener {

	private Boolean objetoGuardado;

	private IFachada_Properties fachadaProperties;
	private IFachada_Formulario fachadaFormulario;

	private Datos_DTO_Formulario datos_DTO_Formulario;
	private Datos_DTO_Properties datos_DTO_Properties;

	private ResourceBundle resourceBundle;

	private JPanel panelDatos;
	private JPanel panelBotones;

	private JMenuBar barraMenu;

	private JMenu opcion1;

	private JMenuItem opcion10;
	private JMenuItem opcion11;
	private JMenuItem opcion12;
	private JMenuItem opcion13;
	private JMenuItem opcion14;
	private JMenuItem opcion15;

	private JLabel etiNombre;
	private JLabel etiPassword;
	private JLabel etiCodigoRol;
	private JLabel etiFechaAlta;
	private JLabel etiFechaBaja;
	private JLabel etiCarpetaDocumentacion;
	private JLabel etiIdioma;

	private JTextField nombre;
	private JPasswordField password;
	private JTextField fechaAlta;
	private JTextField fechaBaja;
	private JTextField carpetaDocumentacion;

	private JComboBox codigoRol;

	private JRadioButton idiomaEs;
	private JRadioButton idiomaIn;
	private JRadioButton idiomaFr;
	private JRadioButton idiomaAl;
	private String idiomaSeleccionado;

	private JButton botonAlta;
	private JButton botonBaja;
	private JButton botonModificacion;
	private JButton botonConsulta;
	private JButton botonSalir;

	// GESTORES DE FORMATOS
	private NumberFormat formato_numerico;
	private DateFormat formato_fecha;
	private SimpleDateFormat formato_fechacompleto_fechaAlta;
	private SimpleDateFormat formato_fechacompleto_fechaBaja;
	private MaskFormatter mascara_personalizada_fechaAlta;
	private MaskFormatter mascara_personalizada_fechaBaja;

	// COMPONENTE DE SWING QUE PERMITE LA GESTION DE FORMATO
	private JFormattedTextField campo_textoconformato;

	public Formulario() {

		inicializar();
		crearElementosVentanaPrincipal();
		darVisibilidadVentanaPrincipal();
	}

	private void inicializar() {

		// DEFINIR COMPORTAMIENTO DE LA VENTANA PRINCIPAL
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 953, 611);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// INSTANCIAR A LAS FACHADAS
		fachadaProperties = new Fachada_Properties();
		fachadaFormulario = new Fachada_Formulario();

		// CARGAR DATOS DEL FICHERO PROPERTIES
		cargarDatosProperties();

		// INICIALIZAR FORMATO DE FECHAS
		String pattern = "dd/MM/yyyy";
		formato_fechacompleto_fechaAlta = new SimpleDateFormat(pattern);
		formato_fechacompleto_fechaBaja = new SimpleDateFormat(pattern);
		try {
			mascara_personalizada_fechaAlta = new MaskFormatter("##/##/####");
			mascara_personalizada_fechaBaja = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// AL INICIO NO HAY NINGÚN OBJETO DEL FORMULARIO GUARDADO
		objetoGuardado = false;
	}

	private void crearElementosVentanaPrincipal() {

		panelDatos = new JPanel();
		panelDatos.setToolTipText("Formulario");
		panelDatos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos usuario",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatos.setLayout(null);
		panelDatos.setBounds(0, 0, 935, 466);
		this.getContentPane().add(panelDatos);

		barraMenu = new JMenuBar();
		this.setJMenuBar(barraMenu);

		opcion1 = new JMenu("Opciones");
		barraMenu.add(opcion1);

		opcion10 = new JMenuItem("Cargar Formulario");
		opcion1.add(opcion10);
		opcion11 = new JMenuItem("Alta");
		opcion1.add(opcion11);
		opcion11.setVisible(false);
		opcion12 = new JMenuItem("Baja");
		opcion1.add(opcion12);
		opcion12.setVisible(false);
		opcion13 = new JMenuItem("Modificación");
		opcion1.add(opcion13);
		opcion13.setVisible(false);
		opcion14 = new JMenuItem("Consulta");
		opcion1.add(opcion14);
		opcion14.setVisible(false);
		opcion15 = new JMenuItem("Salir");
		opcion1.add(opcion15);

		etiNombre = new JLabel("Nombre usuario");
		etiNombre.setBounds(330, 73, 91, 24);
		panelDatos.add(etiNombre);

		etiPassword = new JLabel("Password");
		etiPassword.setBounds(366, 111, 55, 24);
		panelDatos.add(etiPassword);

		etiCodigoRol = new JLabel("Código rol");
		etiCodigoRol.setBounds(362, 148, 59, 24);
		panelDatos.add(etiCodigoRol);

		etiFechaAlta = new JLabel("Fecha alta");
		etiFechaAlta.setBounds(362, 183, 59, 24);
		panelDatos.add(etiFechaAlta);

		etiFechaBaja = new JLabel("Fecha baja");
		etiFechaBaja.setBounds(358, 220, 63, 24);
		panelDatos.add(etiFechaBaja);

		etiCarpetaDocumentacion = new JLabel("Carpeta documentación");
		etiCarpetaDocumentacion.setBounds(286, 257, 135, 24);
		panelDatos.add(etiCarpetaDocumentacion);

		etiIdioma = new JLabel("Idioma");
		etiIdioma.setBounds(382, 290, 39, 24);
		panelDatos.add(etiIdioma);

		nombre = new JTextField();
		nombre.setColumns(20);
		nombre.setBounds(426, 74, 173, 22);
		panelDatos.add(nombre);

		password = new JPasswordField(10);
		password.setColumns(10);
		password.setBounds(426, 112, 173, 22);
		panelDatos.add(password);

		fechaAlta = new JFormattedTextField(mascara_personalizada_fechaAlta);
		fechaAlta.setColumns(10);
		fechaAlta.setBounds(426, 184, 173, 22);
		panelDatos.add(fechaAlta);

		fechaBaja = new JFormattedTextField(mascara_personalizada_fechaBaja);
		fechaBaja.setToolTipText("");
		fechaBaja.setColumns(10);
		fechaBaja.setBounds(426, 220, 173, 22);
		panelDatos.add(fechaBaja);

		carpetaDocumentacion = new JTextField();
		carpetaDocumentacion.setColumns(10);
		carpetaDocumentacion.setBounds(426, 257, 467, 22);
		panelDatos.add(carpetaDocumentacion);

		codigoRol = new JComboBox<String>();
		codigoRol.setBounds(426, 149, 173, 22);
		panelDatos.add(codigoRol);
		cargarComboCodigoRol();

		idiomaEs = new JRadioButton("Español");
		idiomaEs.setBounds(426, 290, 127, 25);
		panelDatos.add(idiomaEs);

		idiomaIn = new JRadioButton("Inglés");
		idiomaIn.setBounds(426, 312, 127, 25);
		panelDatos.add(idiomaIn);

		idiomaFr = new JRadioButton("Francés");
		idiomaFr.setBounds(426, 336, 127, 25);
		panelDatos.add(idiomaFr);

		idiomaAl = new JRadioButton("Alemán");
		idiomaAl.setBounds(426, 360, 127, 25);
		panelDatos.add(idiomaAl);

		panelBotones = new JPanel();
		panelBotones.setBounds(0, 470, 935, 68);
		getContentPane().add(panelBotones);
		panelBotones.setLayout(null);

		botonAlta = new JButton("Alta");
		botonAlta.setBounds(32, 30, 97, 25);
		panelBotones.add(botonAlta);

		botonBaja = new JButton("Baja");
		botonBaja.setBounds(149, 30, 97, 25);
		panelBotones.add(botonBaja);

		botonModificacion = new JButton("Modificación");
		botonModificacion.setBounds(266, 30, 115, 25);
		panelBotones.add(botonModificacion);

		botonConsulta = new JButton("Consulta");
		botonConsulta.setBounds(398, 30, 115, 25);
		panelBotones.add(botonConsulta);

		botonSalir = new JButton("Salir");
		botonSalir.setBounds(808, 30, 115, 25);
		panelBotones.add(botonSalir);

		// DAMOS VALOR A LA PROPIEDAD NAME PARA IDENTIFICAR LOS OBJETOS EN EL EVENTO
		opcion10.setName("cargarFormulario");
		opcion11.setName("menuAlta");
		opcion12.setName("menuBaja");
		opcion13.setName("menuModificacion");
		opcion14.setName("menuConsulta");
		opcion15.setName("menuSalir");

		// AÑADIMOS A LA OPCION SALIR UN ACELERADOR DE TECLADO
		opcion15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK + InputEvent.ALT_MASK));

		nombre.setName("nombre");
		password.setName("password");
		carpetaDocumentacion.setName("carpetaDocumentacion");

		fechaAlta.setName("fechaAlta");
		fechaBaja.setName("fechaBaja");

		idiomaEs.setName("idiomaEs");
		idiomaIn.setName("idiomaIn");
		idiomaFr.setName("idiomaFr");
		idiomaAl.setName("idiomaAl");

		botonAlta.setName("botonAlta");
		botonBaja.setName("botonBaja");
		botonModificacion.setName("botonModificacion");
		botonConsulta.setName("botonConsulta");
		botonSalir.setName("botonSalir");

		// ASOCIAMOS EL ESCUCHADOR DE EVENTOS CON EL COMPONENTE
		opcion10.addActionListener(this);
		opcion11.addActionListener(this);
		opcion12.addActionListener(this);
		opcion13.addActionListener(this);
		opcion14.addActionListener(this);
		opcion15.addActionListener(this);

		nombre.addKeyListener(this);
		password.addKeyListener(this);
		carpetaDocumentacion.addKeyListener(this);

		fechaAlta.addFocusListener(this);
		fechaBaja.addFocusListener(this);

		idiomaEs.addMouseListener(this);
		idiomaIn.addMouseListener(this);
		idiomaFr.addMouseListener(this);
		idiomaAl.addMouseListener(this);

		botonAlta.addActionListener(this);
		botonBaja.addActionListener(this);
		botonModificacion.addActionListener(this);
		botonConsulta.addActionListener(this);
		botonSalir.addActionListener(this);
	}

	private void darVisibilidadVentanaPrincipal() {
		panelDatos.setVisible(false);
		panelBotones.setVisible(false);
		this.setVisible(true);
	}

	private void cargarDatosProperties() {

		// COMPONENTE QUE TE PERMITE LEER DE UN FICHERO PROPERTIES
		resourceBundle = ResourceBundle.getBundle("configuracion");

		List<String> valores = new ArrayList<String>();
		datos_DTO_Properties = new Datos_DTO_Properties();

		Integer i = new Integer(0);
		for (;; i++) {
			try {
				valores.add(resourceBundle.getString(PREFIJO_CODIGO_ROL_PROPERTIES + i));
			} catch (Exception e) {
				break;
			}
		}

		datos_DTO_Properties.setList(valores);
		fachadaProperties.escribir_Datos_DTO_Properties(datos_DTO_Properties);
	}

	private void cargarComboCodigoRol() {
		List<String> valores = new ArrayList<String>();
		valores = fachadaProperties.leer_Datos_DTO_Properties().getList();

		for (String codigoRol : valores) {
			this.codigoRol.addItem(codigoRol);
		}
	}

	private void tratarAlta() {

		if (validarDatos()) {
			cargarDatosFormulario();
			fachadaFormulario.escribir_Datos_DTO_Formulario(datos_DTO_Formulario);
			JOptionPane.showMessageDialog(rootPane, "Alta realizada");
			objetoGuardado = true;
		} else {
			JOptionPane.showMessageDialog(rootPane, "Es obligatorio completar todos los campos");
		}
	}

	private void tratarBaja() {

		if (objetoGuardado) {
			this.nombre.setText(null);
			this.password.setText(null);
			this.codigoRol.setSelectedIndex(0);
			this.fechaAlta.setText(null);
			this.fechaBaja.setText(null);
			this.carpetaDocumentacion.setText(null);
			idiomaEs.setSelected(false);
			idiomaIn.setSelected(false);
			idiomaFr.setSelected(false);
			idiomaAl.setSelected(false);
			objetoGuardado = false;
		} else {
			JOptionPane.showMessageDialog(rootPane, "No hay ningún objeto guardado en el DTO del Formulario");
		}
	}

	private void tratarModificacion() {
		if (objetoGuardado) {
			if (validarDatos()) {
				cargarDatosFormulario();
				fachadaFormulario.escribir_Datos_DTO_Formulario(datos_DTO_Formulario);
				JOptionPane.showMessageDialog(rootPane, "Modificación realizada");
			} else {
				JOptionPane.showMessageDialog(rootPane, "Es obligatorio completar todos los campos");
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "No hay ningún objeto guardado en el DTO del Formulario");
		}
	}

	private void tratarConsulta() {
		if (objetoGuardado) {
			this.nombre.setText(fachadaFormulario.leer_Datos_DTO_Formulario().getNombre());
			this.password.setText(fachadaFormulario.leer_Datos_DTO_Formulario().getPassword());
			this.codigoRol.setSelectedIndex(
					Integer.parseInt(fachadaFormulario.leer_Datos_DTO_Formulario().getCodigoRol().substring(0, 2)));
			this.fechaAlta.setText(fachadaFormulario.leer_Datos_DTO_Formulario().getFechaAlta());
			this.fechaBaja.setText(fachadaFormulario.leer_Datos_DTO_Formulario().getFechaBaja());
			this.carpetaDocumentacion.setText(fachadaFormulario.leer_Datos_DTO_Formulario().getCarpetaDocumentacion());

			switch (fachadaFormulario.leer_Datos_DTO_Formulario().getIdioma()) {
			case "Español":
				idiomaEs.setSelected(true);
				idiomaIn.setSelected(false);
				idiomaFr.setSelected(false);
				idiomaAl.setSelected(false);
				break;
			case "Inglés":
				idiomaEs.setSelected(false);
				idiomaIn.setSelected(true);
				idiomaFr.setSelected(false);
				idiomaAl.setSelected(false);
				break;
			case "Francés":
				idiomaEs.setSelected(false);
				idiomaIn.setSelected(false);
				idiomaFr.setSelected(true);
				idiomaAl.setSelected(false);
				break;
			case "Alemán":
				idiomaEs.setSelected(false);
				idiomaIn.setSelected(false);
				idiomaFr.setSelected(false);
				idiomaAl.setSelected(true);
				break;
			default:
				break;
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "No hay ningún objeto guardado en el DTO del Formulario");
		}
	}

	private boolean validarDatos() {

		if (this.nombre.getText().isEmpty()) {
			return false;
		}
		if (this.password.getPassword().length == 0) {
			return false;
		}
		if (((String) this.codigoRol.getSelectedItem()).isEmpty()) {
			return false;
		}
		if (!validarFecha(this.fechaAlta.getText())) {
			return false;
		}
		if (!validarFecha(this.fechaBaja.getText())) {
			return false;
		}
		if (this.carpetaDocumentacion.getText().isEmpty()) {
			return false;
		}
		if (!this.idiomaEs.isSelected() && !this.idiomaIn.isSelected() && !this.idiomaFr.isSelected()
				&& !this.idiomaAl.isSelected()) {
			return false;
		}
		return true;
	}

	private void cargarDatosFormulario() {
		datos_DTO_Formulario = new Datos_DTO_Formulario();

		datos_DTO_Formulario.setNombre(this.nombre.getText());
		datos_DTO_Formulario.setPassword(String.valueOf(password.getPassword()));
		datos_DTO_Formulario.setCodigoRol(this.codigoRol.getSelectedItem().toString());
		datos_DTO_Formulario.setFechaAlta(this.fechaAlta.getText());
		datos_DTO_Formulario.setFechaBaja(this.fechaBaja.getText());
		datos_DTO_Formulario.setCarpetaDocumentacion(this.carpetaDocumentacion.getText());
		datos_DTO_Formulario.setIdioma(this.idiomaSeleccionado);
	}

	public static boolean validarFecha(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false);
			formatoFecha.parse(fecha);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public void actionPerformed(ActionEvent evento) {

		// OBTENEMOS EL VALOR DE LA PROPIEDAD NAME PARA ESTABLECER LA LOGICA DE
		// TRATAMIENTO
		String componenteSeleccionado = ((JComponent) evento.getSource()).getName();

		switch (componenteSeleccionado) {
		case "cargarFormulario":
			opcion10.setVisible(false);
			opcion11.setVisible(true);
			opcion12.setVisible(true);
			opcion13.setVisible(true);
			opcion14.setVisible(true);
			panelDatos.setVisible(true);
			panelBotones.setVisible(true);
			break;
		case "menuAlta":
			tratarAlta();
			break;
		case "botonAlta":
			tratarAlta();
			break;
		case "menuBaja":
			tratarBaja();
			break;
		case "botonBaja":
			tratarBaja();
			break;
		case "menuModificacion":
			tratarModificacion();
			break;
		case "botonModificacion":
			tratarModificacion();
			break;
		case "menuConsulta":
			tratarConsulta();
			break;
		case "botonConsulta":
			tratarConsulta();
			break;
		case "menuSalir":
			System.exit(0);
			break;
		case "botonSalir":
			System.exit(0);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent evento) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent evento) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent evento) {

		// OBTENEMOS EL VALOR DE LA PROPIEDAD NAME PARA ESTABLECER LA LOGICA DE
		// TRATAMIENTO
		String componenteSeleccionado = ((JComponent) evento.getSource()).getName();

		switch (componenteSeleccionado) {
		case "nombre":
			if (nombre.getText().length() >= NUMERO_CARACTERES_NOMBRE) {
				// ... no lo escribe
				evento.consume();
				JOptionPane.showMessageDialog(rootPane, "Sólo se admiten 20 carácteres como máximo");
			}
			break;
		case "password":
			if ((password.getPassword()).length >= NUMERO_CARACTERES_PASSWORD) {
				// ... no lo escribe
				evento.consume();
				JOptionPane.showMessageDialog(rootPane, "Sólo se admiten 10 carácteres como máximo");
			}
			break;
		case "carpetaDocumentacion":
			if (carpetaDocumentacion.getText().length() >= NUMERO_CARACTERES_CARPETA_DOCUMENTACION) {
				// ... no lo escribe
				evento.consume();
				JOptionPane.showMessageDialog(rootPane, "Sólo se admiten 250 carácteres como máximo");
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent evento) {
		// OBTENEMOS EL VALOR DE LA PROPIEDAD NAME PARA ESTABLECER LA LOGICA DE
		// TRATAMIENTO
		String componenteSeleccionado = ((JComponent) evento.getSource()).getName();

		switch (componenteSeleccionado) {
		case "idiomaEs":
			idiomaSeleccionado = "Español";
			idiomaEs.setSelected(true);
			idiomaIn.setSelected(false);
			idiomaFr.setSelected(false);
			idiomaAl.setSelected(false);
			break;
		case "idiomaIn":
			idiomaSeleccionado = "Inglés";
			idiomaEs.setSelected(false);
			idiomaIn.setSelected(true);
			idiomaFr.setSelected(false);
			idiomaAl.setSelected(false);
			break;
		case "idiomaFr":
			idiomaSeleccionado = "Francés";
			idiomaEs.setSelected(false);
			idiomaIn.setSelected(false);
			idiomaFr.setSelected(true);
			idiomaAl.setSelected(false);
			break;
		case "idiomaAl":
			idiomaSeleccionado = "Alemán";
			idiomaEs.setSelected(false);
			idiomaIn.setSelected(false);
			idiomaFr.setSelected(false);
			idiomaAl.setSelected(true);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent evento) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent evento) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent evento) {
		// OBTENEMOS EL VALOR DE LA PROPIEDAD NAME PARA ESTABLECER LA LOGICA DE
		// TRATAMIENTO
		String componenteSeleccionado = ((JComponent) evento.getSource()).getName();

		switch (componenteSeleccionado) {
		case "fechaAlta":
			break;
		case "fechaBaja":
			break;
		default:
			break;
		}
	}
}
