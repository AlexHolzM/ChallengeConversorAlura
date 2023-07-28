package com.alura.challenge.main;

import java.awt.*;
import java.awt.event.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.*;

public class Temperatura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Menu_Temperatura;
	private JComboBox<Temperaturas> lista;
	private JLabel resultado;
	private JLabel titulo;
	private JLabel header;
	private JLabel temperatura_ico;
	private JLabel alura_ico;
	private JLabel alura_txt;

	/*
	 * Enums tipos de temperatura utilizadas
	 */
	public enum Temperaturas {
		celsius_fahrenheit, celsius_kelvin, fahrenheit_celsius, fahrenheit_kelvin, kelvin_celsius, kelvin_fahrenheit,
	}

	private JTextField txt_input;
	private JButton btn_convertir;
	private JButton btn_back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura frame = new Temperatura();
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
	public Temperatura() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setType(Type.UTILITY);
		setTitle("Conversor Temperatura");
		setBounds(100, 100, 497, 313);

		Menu_Temperatura = new JPanel();
		Menu_Temperatura.setForeground(new Color(63, 63, 63));
		Menu_Temperatura.setBackground(new Color(63, 63, 63));

		setContentPane(Menu_Temperatura);
		Menu_Temperatura.setLayout(null);

		/*
		 * Titulo CONVERSOR DE TEMPERATURA//
		 */

		titulo = new JLabel("CONVERSOR DE TEMPERATURA");
		titulo.setForeground(new Color(0, 74, 149));
		titulo.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
		titulo.setBounds(45, 1, 290, 20);
		Menu_Temperatura.add(titulo);

		/*
		 * Header//Contenido Central de aplicacion
		 */
		header = new JLabel("CONVERSOR DE TEMPERATURA");
		header.setHorizontalAlignment(SwingConstants.LEFT);
		header.setForeground(new Color(20, 254, 184));
		header.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
		header.setBackground(Color.WHITE);
		header.setBounds(43, 2, 290, 20);
		Menu_Temperatura.add(header);

		/*
		 * logo alaura "a"
		 */
		alura_ico = new JLabel("");
		alura_ico.setBounds(2, 2, 30, 30);
		ImageIcon alura = new ImageIcon(this.getClass().getResource("/a.png"));
		Image imgalura = alura.getImage().getScaledInstance(alura_ico.getWidth(), alura_ico.getHeight(),
				Image.SCALE_DEFAULT);
		alura_ico.setIcon(new ImageIcon(imgalura));
		Menu_Temperatura.add(alura_ico);

		// alura by oracle
		alura_txt = new JLabel("Alura by Oracle");
		alura_txt.setBackground(new Color(255, 255, 255));
		alura_txt.setForeground(new Color(168, 81, 255));
		alura_txt.setFont(new Font("Cascadia Code", Font.BOLD, 8));
		alura_txt.setBackground(Color.WHITE);
		alura_txt.setBounds(20, 15, 80, 20);
		Menu_Temperatura.add(alura_txt);

		/*
		 * Botones y componentes
		 */

		// Cuadro de texto "TXT"
		txt_input = new JTextField();
		txt_input.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		txt_input.setHorizontalAlignment(SwingConstants.CENTER);
		txt_input.setBounds(20, 148, 190, 30);
		Menu_Temperatura.add(txt_input);
		txt_input.setColumns(10);

		// Combobox LISTA desplegable
		lista = new JComboBox<Temperaturas>();
		lista.setFont(new Font("Cascadia Code", Font.BOLD, 14));
		lista.setModel(new DefaultComboBoxModel<>(Temperaturas.values()));
		lista.setBounds(20, 69, 180, 30);
		Menu_Temperatura.add(lista);

		// Boton Convertir
		btn_convertir = new JButton("");
		ImageIcon imgswitch = new ImageIcon(this.getClass().getResource("/switch.png"));
		btn_convertir.setBounds(150, 104, 40, 40);
		Menu_Temperatura.add(btn_convertir);
		btn_convertir.setIcon(imgswitch);
		btn_convertir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Convertir();
			}
		});

		/*
		 * Texto resultado de conversion
		 */
		resultado = new JLabel(" 00.00");
		resultado.setForeground(new Color(255, 255, 255));
		resultado.setBackground(new Color(255, 255, 255));
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		resultado.setBounds(20, 182, 190, 30);
		Menu_Temperatura.add(resultado);

		/*
		 *  Borrar Button Click Listener
		 */
		JButton btn_borrar = new JButton("BORRAR");
		btn_borrar.setHorizontalAlignment(SwingConstants.LEFT);
		btn_borrar.setFont(new Font("Cascadia Code", Font.BOLD, 13));
		btn_borrar.setBounds(20, 110, 90, 30);
		Menu_Temperatura.add(btn_borrar);
		btn_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_input.setText("");
				resultado.setText(" 00.00");
			}
		});

		/*
		 *  Boton Back - regresa al menu principal - no funciona de momento
		 */

		btn_back = new JButton("");
		btn_back.setToolTipText("Volver");
		btn_back.setBounds(0, 230, 48, 45);
		Menu_Temperatura.add(btn_back);
		ImageIcon back = new ImageIcon(this.getClass().getResource("/back.png"));
		btn_back.setIcon(back);
		Menu_Temperatura.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		/*
		 *  Imagenes y texto
		 */

		// logo temperatura
		temperatura_ico = new JLabel("");
		temperatura_ico.setForeground(new Color(63, 63, 63));
		temperatura_ico.setBackground(new Color(63, 63, 63));
		temperatura_ico.setBounds(244, 28, 231, 231);
		ImageIcon temperatura = new ImageIcon(this.getClass().getResource("/temp.png"));
		Image imgtemp = temperatura.getImage().getScaledInstance(temperatura_ico.getWidth(),
				temperatura_ico.getHeight(), Image.SCALE_DEFAULT);
		temperatura_ico.setIcon(new ImageIcon(imgtemp));
		Menu_Temperatura.add(temperatura_ico);
	}

	/*
	 * Operaciones Convertir
	 * metodos matematicos de conversion
	 */
	public void Convertir() {
		if (Validar(txt_input.getText())) {
			Temperaturas temperaturas = (Temperaturas) lista.getSelectedItem();
			double valorInput = Double.parseDouble(txt_input.getText());
			double resultado = 0.0;

			switch (temperaturas) {
			case celsius_fahrenheit:
				resultado = (valorInput * 9 / 5) + 32;
				break;
			case celsius_kelvin:
				resultado = valorInput + 273.15;
				break;
			case fahrenheit_celsius:
				resultado = (valorInput - 32) * 5 / 9;
				break;
			case fahrenheit_kelvin:
				resultado = (valorInput - 32) * 5 / 9 + 273.15;
				break;
			case kelvin_celsius:
				resultado = valorInput - 273.15;
				break;
			case kelvin_fahrenheit:
				resultado = (valorInput - 273.15) * 9 / 5 + 32;
				break;
			default:
				throw new IllegalArgumentException("Valor no válido: " + temperaturas);
			}
			this.resultado.setText(Redondear(resultado));
		}
	}

	/*
	 * Metodo Redondeas
	 * redondea decimales
	 */
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}

	/*
	 *  validacion de input y error
	 */
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if (x > 0)
				return true;
			else {
				resultado.setText("Ingrese un valor positivo");
				return false;
			}
		} catch (NumberFormatException e) {
			resultado.setText("Solo números");
			return false;
		}
	}
}
