package com.alura.challenge.main;

import javax.swing.*;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index_menu {

	private JFrame Index_menu;

	/**
	 * @author AlexHolz
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index_menu window = new Index_menu();
					window.Index_menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Index_menu() {
		initialize();
	}

	/**
	 * JFrame Index Menu.
	 */
	private void initialize() {
		Index_menu = new JFrame();
		ImageIcon imgframeicon = new ImageIcon(this.getClass().getResource("/logoA2.png"));
		Index_menu.setBackground(new Color(63, 63, 63));
		Index_menu.getContentPane().setForeground(new Color(63, 63, 63));
		Index_menu.getContentPane().setBackground(new Color(63, 63, 63));
		Index_menu.setTitle("Challenge Conversor Alura");
		Index_menu.setResizable(false);
		Index_menu.setBounds(100, 100, 385, 300);
		Image frameIconImage = imgframeicon.getImage();
		Index_menu.setIconImage(frameIconImage);
		Index_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * Barra de Menu
		 */

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		Index_menu.setJMenuBar(menuBar);

		/*
		 * Contenido de Barra de menu_cambio//botones//action listeners
		 */

		/*
		 * Menu Cambio
		 */
		JMenu menu_cambio = new JMenu("| MENU-CAMBIO |");
		menu_cambio.setForeground(new Color(0, 0, 0));
		menu_cambio.setFont(new Font("Cascadia Mono", Font.BOLD, 13));
		menu_cambio.setMnemonic('E');
		menu_cambio.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(menu_cambio);

		/*
		 * Boton Divisas- desplega pagina de cambio de divisas
		 */
		JMenuItem btn_divisas = new JMenuItem("DIVISAS");
		btn_divisas.setFont(new Font("Cascadia Code SemiBold", Font.PLAIN, 12));
		btn_divisas.setHorizontalAlignment(SwingConstants.LEFT);
		menu_cambio.add(btn_divisas);
		btn_divisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Divisas.main(null);
				// Index_menu.setVisible(false);
			}
		});

		/*
		 * Boton Distancia desplega pagina de cambio de distancias
		 */

		JMenuItem btn_distancia = new JMenuItem("DISTANCIA");
		btn_distancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Distancia.main(null);
//				Index_menu.setVisible(false);
			}
		});

		btn_distancia.setFont(new Font("Cascadia Code SemiBold", Font.PLAIN, 12));
		btn_distancia.setHorizontalAlignment(SwingConstants.LEFT);
		menu_cambio.add(btn_distancia);

		/*
		 * Boton Temperatura- desplega pagina de cambio de temperatura
		 */

		JMenuItem btn_temperatura = new JMenuItem("TEMPERATURA");
		btn_temperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temperatura.main(null);
//				Index_menu.setVisible(false);
			}
		});
		btn_temperatura.setFont(new Font("Cascadia Code SemiBold", Font.PLAIN, 12));
		btn_temperatura.setHorizontalAlignment(SwingConstants.LEFT);
		menu_cambio.add(btn_temperatura);

		/*
		 * Boton IMC- desplega pagina de calculo de Indice de Masa Corporal
		 */

		JMenuItem btn_imc = new JMenuItem("PESO IMC");
		btn_imc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IMC.main(null);
//				Index_menu.setVisible(false);
			}
		});
		btn_imc.setHorizontalAlignment(SwingConstants.LEFT);
		btn_imc.setFont(new Font("Cascadia Code SemiBold", Font.PLAIN, 12));
		menu_cambio.add(btn_imc);

		/*
		 * Menu Imstrucciones //
		 */

		JMenu menu_instrucciones = new JMenu("| INSTRUCCIONES |");
		menu_instrucciones.setForeground(new Color(0, 0, 0));
		menu_instrucciones.setFont(new Font("Cascadia Mono", Font.BOLD, 13));
		menu_instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		menu_instrucciones.setMnemonic('I');
		menuBar.add(menu_instrucciones);

		/*
		 * INSTRUCCIONES USO//
		 */

		JLabel Opcn1 = new JLabel("1) Elija Opcion de lista");
		Opcn1.setForeground(new Color(0, 0, 0));
		Opcn1.setHorizontalAlignment(SwingConstants.LEFT);
		Opcn1.setFont(new Font("Cascadia Code SemiBold", Font.PLAIN, 11));
		Opcn1.setBackground(Color.WHITE);
		menu_instrucciones.add(Opcn1);

		JLabel Opcn2 = new JLabel("2) Ingrese una Cantidad");
		Opcn2.setHorizontalAlignment(SwingConstants.LEFT);
		Opcn2.setForeground(new Color(0, 0, 0));
		Opcn2.setFont(new Font("Cascadia Code SemiBold", Font.PLAIN, 11));
		Opcn2.setBackground(Color.WHITE);
		menu_instrucciones.add(Opcn2);

		JLabel Opcn3 = new JLabel("3) Click Convertir");
		Opcn3.setForeground(new Color(0, 0, 0));
		Opcn3.setHorizontalAlignment(SwingConstants.LEFT);
		Opcn3.setFont(new Font("Cascadia Code SemiBold", Font.PLAIN, 11));
		Opcn3.setBackground(Color.WHITE);
		menu_instrucciones.add(Opcn3);

		JLabel Opcn4 = new JLabel("4) Invertir Valores");
		Opcn4.setForeground(new Color(0, 0, 0));
		Opcn4.setHorizontalAlignment(SwingConstants.LEFT);
		Opcn4.setFont(new Font("Cascadia Code SemiBold", Font.PLAIN, 11));
		Opcn4.setBackground(Color.WHITE);
		menu_instrucciones.add(Opcn4);

		/*
		 * Menu Opciones // botones
		 */

		JMenu menu_opciones = new JMenu("| OPCIONES |");
		menu_opciones.setForeground(new Color(0, 0, 0));
		menu_opciones.setFont(new Font("Cascadia Mono", Font.BOLD, 13));
		menu_opciones.setHorizontalAlignment(SwingConstants.CENTER);
		menu_opciones.setMnemonic('O');
		menuBar.add(menu_opciones);

		/*
		 * boton salir//
		 */

		JMenuItem btn_salir = new JMenuItem("SALIR");
		btn_salir.setHorizontalAlignment(SwingConstants.CENTER);
		menu_opciones.add(btn_salir);
		Index_menu.getContentPane().setLayout(null);
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		/*
		 * Titulo CHALLENGE MULTI CONVERSOR//
		 */

		JLabel titulo = DefaultComponentFactory.getInstance().createTitle("CHALLENGE MULTI CONVERSOR");
		titulo.setForeground(new Color(0, 74, 149));
		titulo.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
		titulo.setBounds(44, 2, 300, 20);
		Index_menu.getContentPane().add(titulo);

		/*
		 * Header//Contenido Central de aplicacion
		 */
		JLabel header = new JLabel("CHALLENGE MULTI CONVERSOR");
		header.setBackground(new Color(255, 255, 255));
		header.setHorizontalAlignment(SwingConstants.LEFT);
		header.setForeground(new Color(20, 254, 184));
		header.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
		header.setBounds(45, 1, 300, 25);
		Index_menu.getContentPane().add(header);

		/*
		 * Imagenes y texto
		 */
		/*
		 * logo divisas
		 */
		JLabel divisas_ico = new JLabel("");
		divisas_ico.setBounds(5, 45, 90, 90);
		ImageIcon divisas = new ImageIcon(this.getClass().getResource("/divisas.png"));
		Image imgD = divisas.getImage().getScaledInstance(divisas_ico.getWidth(), divisas_ico.getHeight(),
				Image.SCALE_DEFAULT);
		divisas_ico.setIcon(new ImageIcon(imgD));
		Index_menu.getContentPane().add(divisas_ico);

		/*
		 * logo distancia
		 */
		JLabel dist_ico = new JLabel("distancia");
		dist_ico.setBounds(90, 115, 90, 90);
		ImageIcon distancia = new ImageIcon(this.getClass().getResource("/distancia.png"));
		Image imgdist = distancia.getImage().getScaledInstance(dist_ico.getWidth(), dist_ico.getHeight(),
				Image.SCALE_DEFAULT);
		dist_ico.setIcon(new ImageIcon(imgdist));
		Index_menu.getContentPane().add(dist_ico);

		/*
		 * logo temperatura
		 */
		JLabel temp_ico = new JLabel("temperatura");
		temp_ico.setBounds(180, 45, 90, 90);
		ImageIcon temperatura = new ImageIcon(this.getClass().getResource("/temp.png"));
		Image imgtemp = temperatura.getImage().getScaledInstance(temp_ico.getWidth(), temp_ico.getHeight(),
				Image.SCALE_DEFAULT);
		temp_ico.setIcon(new ImageIcon(imgtemp));
		Index_menu.getContentPane().add(temp_ico);

		/*
		 * logo IMC
		 */
		JLabel imc_ico = new JLabel("IMC");
		imc_ico.setBounds(270, 140, 90, 90);
		ImageIcon imc = new ImageIcon(this.getClass().getResource("/imc.png"));
		Image imgimc = imc.getImage().getScaledInstance(imc_ico.getWidth(), imc_ico.getHeight(), Image.SCALE_DEFAULT);
		imc_ico.setIcon(new ImageIcon(imgimc));
		Index_menu.getContentPane().add(imc_ico);

		/*
		 * logo ico
		 */
		JLabel firma_ico = new JLabel("");
		firma_ico.setBounds(2, 200, 40, 40);
		ImageIcon temp = new ImageIcon(this.getClass().getResource("/logoA.png"));
		Image imgT = temp.getImage().getScaledInstance(firma_ico.getWidth(), firma_ico.getHeight(),
				Image.SCALE_DEFAULT);
		firma_ico.setIcon(new ImageIcon(imgT));
		Index_menu.getContentPane().add(firma_ico);

		/*
		 *  firma By Alejandro Holz
		 */
		JLabel firma_txt = new JLabel("lejandro Holz");
		firma_txt.setFont(new Font("Cascadia Code PL Light", Font.BOLD, 14));
		firma_txt.setForeground(new Color(141, 28, 255));
		firma_txt.setBounds(37, 216, 114, 20);
		Index_menu.getContentPane().add(firma_txt);

		// By
		JLabel firma_by = new JLabel("By");
		firma_by.setForeground(new Color(213, 213, 255));
		firma_by.setFont(new Font("Cascadia Code PL Light", Font.BOLD, 14));
		firma_by.setBounds(30, 196, 20, 20);
		Index_menu.getContentPane().add(firma_by);

		// alura by oracle
		JLabel alura_txt = new JLabel("Alura by Oracle");
		alura_txt.setBackground(new Color(255, 255, 255));
		alura_txt.setForeground(new Color(168, 81, 255));
		alura_txt.setFont(new Font("Cascadia Code", Font.BOLD, 8));
		alura_txt.setBounds(20, 15, 80, 20);
		Index_menu.getContentPane().add(alura_txt);

		// logo alaura "a"
		JLabel alura_ico = new JLabel("");
		alura_ico.setBounds(2, 2, 30, 30);
		ImageIcon alura = new ImageIcon(this.getClass().getResource("/a.png"));
		Image imgalura = alura.getImage().getScaledInstance(alura_ico.getWidth(), alura_ico.getHeight(),
				Image.SCALE_DEFAULT);
		alura_ico.setIcon(new ImageIcon(imgalura));
		Index_menu.getContentPane().add(alura_ico);

	}
}
