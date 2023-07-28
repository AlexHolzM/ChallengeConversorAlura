package com.alura.challenge.main;

import java.awt.*;
import java.awt.event.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.*;

public class Distancia extends JFrame {

	/**
	 * Creacion de Jlabels
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Menu_Distancia;
	private JComboBox<Distancias> lista;
	private JLabel resultado;
	private JLabel titulo;
	private JLabel header;
	private JLabel distancia_ico;
	private JLabel alura_ico;
	private JLabel alura_txt;

	/*
	 *  Medidas de conversion distancia
	 */
	public enum Distancias {
		centimetros_metros, centimetros_pulgadas, centimetros_yardas, centimetros_millas, metros_centimetros,
		metros_pulgadas, metros_yardas, metros_millas, pulgadas_centimetros, pulgadas_metros, pulgadas_yardas,
		pulgadas_millas, yardas_cm, yardas_metros, yardas_pulgadas, yardas_millas, millas_centimetros, millas_metros,
		millas_pulgadas, millas_yardas,
	}

	/**
	 * Valores de distancia
	 */

	private double centimetros_metros = 0.01;
	private double centimetros_pulgadas = 0.393701;
	private double centimetros_yardas = 0.0109361;
	private double centimetros_millas = 6.2137e-6;
	private double metros_centimetros = 100;
	private double metros_pulgadas = 39.3701;
	private double metros_yardas = 1.09361;
	private double metros_millas = 0.000621371;
	private double pulgadas_centimetros = 2.54;
	private double pulgadas_metros = 0.0254;
	private double pulgadas_yardas = 0.0277778;
	private double pulgadas_millas = 1.5783e-5;
	private double yardas_cm = 91.44;
	private double yardas_metros = 0.9144;
	private double yardas_pulgadas = 36;
	private double yardas_millas = 0.000568182;
	private double millas_centimetros = 160934;
	private double millas_metros = 1609.34;
	private double millas_pulgadas = 63360;
	private double millas_yardas = 1760;
	public double valorInput = 0.00;

	private JTextField txt_input;
	private JButton btn_convertir;

	/**
	 * Launch the application.
	 *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Distancia frame = new Distancia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * // Jframe Distancia
	 */
	public Distancia() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setType(Type.UTILITY);
		setTitle("Conversor Distancia");
		setBounds(100, 100, 497, 313);

		Menu_Distancia = new JPanel();
		Menu_Distancia.setForeground(new Color(63, 63, 63));
		Menu_Distancia.setBackground(new Color(63, 63, 63));

		setContentPane(Menu_Distancia);
		Menu_Distancia.setLayout(null);

		/*
		 * Titulo CONVERSOR DE DISTANCIA
		 */

		titulo = new JLabel("CONVERSOR DE DISTANCIA");
		titulo.setForeground(new Color(0, 74, 149));
		titulo.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
		titulo.setBounds(45, 1, 270, 20);
		Menu_Distancia.add(titulo);

		// ___________________________________________________________//
		// ___________________________________________________________//

		/*
		 * Header//Contenido Central de aplicacion
		 */
		header = new JLabel("CONVERSOR DE DISTANCIA");
		header.setHorizontalAlignment(SwingConstants.LEFT);
		header.setForeground(new Color(20, 254, 184));
		header.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
		header.setBackground(Color.WHITE);
		header.setBounds(43, 2, 270, 20);
		Menu_Distancia.add(header);

		/*
		 * logo alaura "a"
		 */
		alura_ico = new JLabel("");
		alura_ico.setBounds(2, 2, 30, 30);
		ImageIcon alura = new ImageIcon(this.getClass().getResource("/a.png"));
		Image imgalura = alura.getImage().getScaledInstance(alura_ico.getWidth(), alura_ico.getHeight(),
				Image.SCALE_DEFAULT);
		alura_ico.setIcon(new ImageIcon(imgalura));
		Menu_Distancia.add(alura_ico);

		/*
		 * alura by oracle
		 */
		alura_txt = new JLabel("Alura by Oracle");
		alura_txt.setBackground(new Color(255, 255, 255));
		alura_txt.setForeground(new Color(168, 81, 255));
		alura_txt.setFont(new Font("Cascadia Code", Font.BOLD, 8));
		alura_txt.setBackground(Color.WHITE);
		alura_txt.setBounds(20, 15, 80, 20);
		Menu_Distancia.add(alura_txt);

		// ___________________________________________________________//
		// ___________________________________________________________//

		/*
		 * Botones y componentes aqui ira el diseno de botones
		 */

		/*
		 * Cuadro de texto "TXT"
		 */
		txt_input = new JTextField();
		txt_input.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		txt_input.setHorizontalAlignment(SwingConstants.CENTER);
		txt_input.setBounds(45, 136, 190, 30);
		Menu_Distancia.add(txt_input);
		txt_input.setColumns(10);

		/*
		 * Combobox LISTA desplegable
		 */
		lista = new JComboBox<Distancias>();
		lista.setFont(new Font("Cascadia Code", Font.BOLD, 14));
		lista.setModel(new DefaultComboBoxModel<>(Distancias.values()));
		lista.setBounds(45, 57, 190, 30);
		Menu_Distancia.add(lista);

		/*
		 * Boton Convertir manda llamar codigo para operaciones matematicas lanza el
		 * resultado a textlabel
		 */
		btn_convertir = new JButton("");
		ImageIcon imgswitch = new ImageIcon(this.getClass().getResource("/switch.png"));
		btn_convertir.setBounds(175, 92, 40, 40);
		btn_convertir.setIcon(imgswitch);
		Menu_Distancia.add(btn_convertir);
		btn_convertir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Convertir();
			}
		});

		/*
		 * Texto resultado de conversion aqui se despliega el resultado
		 */
		resultado = new JLabel("00.00");
		resultado.setForeground(new Color(255, 255, 255));
		resultado.setBackground(new Color(255, 255, 255));
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		resultado.setBounds(45, 165, 190, 30);
		Menu_Distancia.add(resultado);

		/*
		 * Borrar Button Click Listener, restablece datos a 0
		 */
		JButton btn_borrar = new JButton("BORRAR");
		btn_borrar.setHorizontalAlignment(SwingConstants.LEFT);
		btn_borrar.setFont(new Font("Cascadia Code", Font.BOLD, 15));
		btn_borrar.setBounds(45, 98, 90, 30);
		Menu_Distancia.add(btn_borrar);
		btn_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_input.setText("");
				resultado.setText(" 00.00");
			}
		});

		/*
		 * Boton Back - regresa al menu principal - no funciona de momento
		 */

		JButton btn_back = new JButton("");
		btn_back.setToolTipText("Volver");
		btn_back.setBounds(0, 230, 48, 45);
		ImageIcon back = new ImageIcon(this.getClass().getResource("/back.png"));
		btn_back.setIcon(back);
		Menu_Distancia.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		/*
		 * Imagenes y texto necesarios para diseno
		 */

		/*
		 * logo Distancia
		 */
		distancia_ico = new JLabel("");
		distancia_ico.setForeground(new Color(63, 63, 63));
		distancia_ico.setBackground(new Color(63, 63, 63));
		distancia_ico.setBounds(240, 16, 231, 248);
		ImageIcon distancia = new ImageIcon(this.getClass().getResource("/distancia.png"));
		Image imgdist = distancia.getImage().getScaledInstance(distancia_ico.getWidth(), distancia_ico.getHeight(),
				Image.SCALE_DEFAULT);
		distancia_ico.setIcon(new ImageIcon(imgdist));
		Menu_Distancia.add(distancia_ico);
	}

	/*
	 * 
	 * Inicia codigo matematico para operaciones de conversion de Distancia
	 * 
	 */
	public void Convertir() {
		if (Validar(txt_input.getText())) {
			Distancias distancia = (Distancias) lista.getSelectedItem();
			double valorInput = Double.parseDouble(txt_input.getText());
			double resultado = 0.0;

			switch (distancia) {
			case centimetros_metros:
				resultado = valorInput * centimetros_metros;
				break;
			case centimetros_pulgadas:
				resultado = valorInput * centimetros_pulgadas;
				break;
			case centimetros_yardas:
				resultado = valorInput * centimetros_yardas;
				break;
			case centimetros_millas:
				resultado = valorInput * centimetros_millas;
				break;
			case metros_centimetros:
				resultado = valorInput * metros_centimetros;
				break;
			case metros_pulgadas:
				resultado = valorInput * metros_pulgadas;
				break;
			case metros_yardas:
				resultado = valorInput * metros_yardas;
				break;
			case metros_millas:
				resultado = valorInput * metros_millas;
				break;
			case pulgadas_centimetros:
				resultado = valorInput * pulgadas_centimetros;
				break;
			case pulgadas_metros:
				resultado = valorInput * pulgadas_metros;
				break;
			case pulgadas_yardas:
				resultado = valorInput * pulgadas_yardas;
				break;
			case pulgadas_millas:
				resultado = valorInput * pulgadas_millas;
				break;
			case yardas_cm:
				resultado = valorInput * yardas_cm;
				break;
			case yardas_metros:
				resultado = valorInput * yardas_metros;
				break;
			case yardas_pulgadas:
				resultado = valorInput * yardas_pulgadas;
				break;
			case yardas_millas:
				resultado = valorInput * yardas_millas;
				break;
			case millas_centimetros:
				resultado = valorInput * millas_centimetros;
				break;
			case millas_metros:
				resultado = valorInput * millas_metros;
				break;
			case millas_pulgadas:
				resultado = valorInput * millas_pulgadas;
				break;
			case millas_yardas:
				resultado = valorInput * millas_yardas;
				break;
			default:
				throw new IllegalArgumentException("Valor no válido: " + distancia);
			}
			this.resultado.setText(Redondear(resultado));
		}
	}

	/*
	 * Codigo para redondear resultados
	 */
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}

	/*
	 * validacion de input y error + metodo catch
	 */
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if (x > 0)
				return true;
			else {
				resultado.setText("Solo positivos!!");
				return false;
			}
		} catch (NumberFormatException e) {
			resultado.setText("Solo números!!");
			return false;
		}
	}
}
