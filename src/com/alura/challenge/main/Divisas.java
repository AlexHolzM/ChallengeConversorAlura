package com.alura.challenge.main;

import java.awt.*;
import java.awt.event.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.*;

public class Divisas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Menu_Divisas;
	private JComboBox<Moneda> lista;
	private JLabel resultado;
	private JLabel titulo;
	private JLabel header;
	private JLabel divisas_ico;
	private JLabel alura_ico;
	private JLabel alura_txt;

	/*
	 * Enums tipos de divisas utilizadas pesos mexicanos
	 */
	public enum Moneda {

		PesosMXN_DolarUSD, PesosMXN_DolarCAD, PesosMXN_EuroEU, PesosMXN_LibraGBP, PesosMXN_YenJPY, PesosMXN_FrancoCHF,
		DolarUSD_PesosMXN, DolarCAD_PesosMXN, EuroEU_PesosMXN, LibraGBP_PesosMXN, YenJPY_PesosMXN, FrancoCHF_PesosMXN,
	}

	/*
	 * Valores de moneda a pesos Mexicanos Julio 2023
	 */

	public double DolarUSD = 0.059;
	public double DolarCAD = 0.078;
	public double EuroEU = 0.054;
	public double LibraGBP = 0.046;
	public double YenJPY = 8.33;
	public double FrancoCHF = 0.051;

	public double valorInput = 0.00;
	private JTextField txt_input;
	private JButton btn_convertir;
	private JButton btn_back;

	/**
	 * Inicia la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Divisas frame = new Divisas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Jframe Divisas.
	 */
	public Divisas() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setType(Type.UTILITY);
		setTitle("Conversor Divisas");
		setBounds(100, 100, 497, 313);

		Menu_Divisas = new JPanel();
		Menu_Divisas.setForeground(new Color(63, 63, 63));
		Menu_Divisas.setBackground(new Color(63, 63, 63));

		setContentPane(Menu_Divisas);
		Menu_Divisas.setLayout(null);

		/*
		 * Titulo CONVERSOR DE DIVISAS//
		 */

		titulo = new JLabel("CONVERSOR DE DIVISAS");
		titulo.setForeground(new Color(0, 74, 149));
		titulo.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
		titulo.setBounds(45, 1, 240, 20);
		Menu_Divisas.add(titulo);

		/*
		 * Header//Contenido Central de aplicacion y elementos de diseno
		 */
		header = new JLabel("CONVERSOR DE DIVISAS");
		header.setHorizontalAlignment(SwingConstants.LEFT);
		header.setForeground(new Color(20, 254, 184));
		header.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
		header.setBackground(Color.WHITE);
		header.setBounds(43, 2, 240, 20);
		Menu_Divisas.add(header);

		/*
		 * logo alaura "a"
		 */
		alura_ico = new JLabel("");
		alura_ico.setBounds(2, 2, 30, 30);
		ImageIcon alura = new ImageIcon(this.getClass().getResource("/a.png"));
		Image imgalura = alura.getImage().getScaledInstance(alura_ico.getWidth(), alura_ico.getHeight(),
				Image.SCALE_DEFAULT);
		alura_ico.setIcon(new ImageIcon(imgalura));
		Menu_Divisas.add(alura_ico);

		/*
		 * alura by oracle
		 */
		alura_txt = new JLabel("Alura by Oracle");
		alura_txt.setBackground(new Color(255, 255, 255));
		alura_txt.setForeground(new Color(168, 81, 255));
		alura_txt.setFont(new Font("Cascadia Code", Font.BOLD, 8));
		alura_txt.setBackground(Color.WHITE);
		alura_txt.setBounds(20, 15, 80, 20);
		Menu_Divisas.add(alura_txt);

		/*
		 * Botones y componentes
		 */

		/* * Cuadro de texto "TXT" */
		txt_input = new JTextField();
		txt_input.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		txt_input.setHorizontalAlignment(SwingConstants.CENTER);
		txt_input.setBounds(45, 136, 190, 30);
		Menu_Divisas.add(txt_input);
		txt_input.setColumns(10);

		/* Combobox LISTA desplegable */
		lista = new JComboBox<Moneda>();
		lista.setToolTipText("Seleccion de divisas");
		lista.setFont(new Font("Cascadia Code", Font.BOLD, 14));
		lista.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		lista.setBounds(45, 57, 170, 30);
		Menu_Divisas.add(lista);

		/*
		 * Boton Convertir - manda llamar a las operaciones y muestra resultado
		 */
		btn_convertir = new JButton("");
		btn_convertir.setToolTipText("Convertir");
		btn_convertir.setBounds(175, 92, 40, 40);
		ImageIcon convert = new ImageIcon(this.getClass().getResource("/convertir.png"));
		btn_convertir.setIcon(convert);
		Menu_Divisas.add(btn_convertir);
		btn_convertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});

		/*
		 * Texto resultado de conversion - muestra resultado
		 */

		resultado = new JLabel("$00.00");
		resultado.setForeground(new Color(255, 255, 255));
		resultado.setBackground(new Color(255, 255, 255));
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		resultado.setBounds(45, 170, 190, 30);
		Menu_Divisas.add(resultado);

		/*
		 * Boton Borrar - restablece valores a 0
		 */

		JButton btn_borrar = new JButton("BORRAR");
		btn_borrar.setToolTipText("Borrar");
		btn_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_input.setText("");
				resultado.setText(" 00.00");
			}
		});
		btn_borrar.setFont(new Font("Cascadia Code", Font.BOLD, 15));
		btn_borrar.setBounds(45, 98, 90, 30);
		Menu_Divisas.add(btn_borrar);
		ImageIcon back = new ImageIcon(this.getClass().getResource("/back.png"));

		/*
		 * Imagenes y texto necesarios para diseno
		 */

		/*
		 * logo divisas
		 */
		divisas_ico = new JLabel("");
		divisas_ico.setForeground(new Color(63, 63, 63));
		divisas_ico.setBackground(new Color(63, 63, 63));
		divisas_ico.setBounds(240, 16, 231, 248);
		ImageIcon divisas = new ImageIcon(this.getClass().getResource("/divisas.png"));
		Image imgD = divisas.getImage().getScaledInstance(divisas_ico.getWidth(), divisas_ico.getHeight(),
				Image.SCALE_DEFAULT);
		divisas_ico.setIcon(new ImageIcon(imgD));
		Menu_Divisas.add(divisas_ico);

		/*
		 * Boton Back - regresa al menu principal - no funciona de momento
		 */

		btn_back = new JButton("");
		btn_back.setToolTipText("Volver");
		btn_back.setBounds(0, 230, 48, 45);
		btn_back.setIcon(back);
		Menu_Divisas.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	/*
	 * Funciones matematicas
	 */

	/*
	 * Convertir
	 */

	public void Convertir() {
		if (Validar(txt_input.getText())) {
			Moneda moneda = (Moneda) lista.getSelectedItem();

			switch (moneda) {

			case PesosMXN_DolarUSD:
				PesosAMoneda(DolarUSD);
				break;
			case PesosMXN_DolarCAD:
				PesosAMoneda(DolarCAD);
				break;
			case PesosMXN_EuroEU:
				PesosAMoneda(EuroEU);
				break;
			case PesosMXN_LibraGBP:
				PesosAMoneda(LibraGBP);
				break;
			case PesosMXN_YenJPY:
				PesosAMoneda(YenJPY);
				break;
			case PesosMXN_FrancoCHF:
				PesosAMoneda(FrancoCHF);
				break;
			case DolarUSD_PesosMXN:
				MonedaAPesos(DolarUSD);
				break;
			case DolarCAD_PesosMXN:
				MonedaAPesos(DolarCAD);
				break;
			case EuroEU_PesosMXN:
				MonedaAPesos(EuroEU);
				break;
			case LibraGBP_PesosMXN:
				MonedaAPesos(LibraGBP);
				break;
			case YenJPY_PesosMXN:
				MonedaAPesos(YenJPY);
				break;
			case FrancoCHF_PesosMXN:
				MonedaAPesos(FrancoCHF);
				break;
			default:
				throw new IllegalArgumentException("Valor Invalido +" + moneda);
			}
		}
	}

	/*
	 * Operaciones numericas
	 */
	public void PesosAMoneda(double moneda) {
		double result = valorInput * moneda;
		resultado.setText(Redondear(result));

	}

	public void MonedaAPesos(double moneda) {
		double result = valorInput / moneda;
		resultado.setText(Redondear(result));
	}

	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("$0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}

	/*
	 * validacion de input y error
	 */
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if (x > 0)
				;
			valorInput = x;
			return true;
		} catch (NumberFormatException e) {
			resultado.setText("Solo Numeros!!");
			return false;
		}
	}
}
