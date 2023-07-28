package com.alura.challenge.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.*;

public class IMC extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel Menu_IMC;
    private JTextField txt_altura;
    private JTextField txt_peso;
    private JLabel resultado;
    private JLabel titulo;
    private JLabel header;
    private JLabel imc_ico;
    private JLabel alura_ico;
    private JLabel alura_txt;
    private JButton btn_convertir;
    private JLabel lbl_peso;
    private JLabel lbl_altura;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IMC frame = new IMC();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public IMC() {
        setResizable(false);
        setBackground(new Color(63, 63, 63));
        setType(Type.UTILITY);
        setTitle("Conversor IMC");
        setBounds(100, 100, 497, 313);

        /*
         * JFrame IMC
         */
        
        Menu_IMC = new JPanel();
        Menu_IMC.setForeground(new Color(63, 63, 63));
        Menu_IMC.setBackground(new Color(63, 63, 63));
        setContentPane(Menu_IMC);
        Menu_IMC.setLayout(null);

        titulo = new JLabel("CONVERSOR DE IMC");
        titulo.setForeground(new Color(0, 74, 149));
        titulo.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
        titulo.setBounds(45, 1, 270, 20);
        Menu_IMC.add(titulo);

        header = new JLabel("CONVERSOR DE IMC");
        header.setHorizontalAlignment(SwingConstants.LEFT);
        header.setForeground(new Color(20, 254, 184));
        header.setFont(new Font("Cascadia Mono", Font.BOLD, 20));
        header.setBackground(Color.WHITE);
        header.setBounds(44, 2, 270, 20);
        Menu_IMC.add(header);

        alura_ico = new JLabel("");
        alura_ico.setBounds(2, 2, 30, 30);
        ImageIcon alura = new ImageIcon(IMC.class.getResource("/a.png"));
        Image imgalura = alura.getImage().getScaledInstance(alura_ico.getWidth(), alura_ico.getHeight(),
                Image.SCALE_DEFAULT);
        alura_ico.setIcon(new ImageIcon(imgalura));
        Menu_IMC.add(alura_ico);

        alura_txt = new JLabel("Alura by Oracle");
        alura_txt.setBackground(new Color(255, 255, 255));
        alura_txt.setForeground(new Color(168, 81, 255));
        alura_txt.setFont(new Font("Cascadia Code", Font.BOLD, 8));
        alura_txt.setBackground(Color.WHITE);
        alura_txt.setBounds(20, 15, 80, 20);
        Menu_IMC.add(alura_txt);

        /*
         *  Contenido Principal botones, caja texto etc.
         */
        
        txt_altura = new JTextField();
        txt_altura.setHorizontalAlignment(SwingConstants.CENTER);
        txt_altura.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        txt_altura.setBounds(45, 175, 170, 30);
        Menu_IMC.add(txt_altura);

        txt_peso = new JTextField();
        txt_peso.setHorizontalAlignment(SwingConstants.CENTER);
        txt_peso.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        txt_peso.setBounds(45, 75, 170, 30);
        Menu_IMC.add(txt_peso);

        /*
         * Boton Convertir
         */
        btn_convertir = new JButton("");
        btn_convertir.setIcon(new ImageIcon(IMC.class.getResource("/switch.png")));
        btn_convertir.setBounds(175, 110, 40, 40);
        Menu_IMC.add(btn_convertir);
        btn_convertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Convertir();
            }
        });

        /*
         * Muestra Resultado
         */
        resultado = new JLabel(" 00.00");
        resultado.setForeground(new Color(255, 255, 255));
        resultado.setBackground(new Color(255, 255, 255));
        resultado.setHorizontalAlignment(SwingConstants.CENTER);
        resultado.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
        resultado.setBounds(45, 210, 180, 22);
        Menu_IMC.add(resultado);

        /*
         * Boton borrar, 
         * restablece datos a 0
         */
        JButton btn_borrar = new JButton("BORRAR");
        btn_borrar.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        btn_borrar.setBounds(45, 110, 90, 30);
        Menu_IMC.add(btn_borrar);
        btn_borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	txt_altura.setText("");
            	txt_peso.setText("");
                resultado.setText("");
                resultado.setText(" 00.00");
            }
        });

        /*
         * Imagenes para diseno y lables
         */
        imc_ico = new JLabel("");
        imc_ico.setForeground(new Color(63, 63, 63));
        imc_ico.setBackground(new Color(63, 63, 63));
        imc_ico.setBounds(250, 1, 231, 231);
        ImageIcon IMC = new ImageIcon(IMC.class.getResource("/imc.png"));
        Image imgimc = IMC.getImage().getScaledInstance(imc_ico.getWidth(), imc_ico.getHeight(), Image.SCALE_DEFAULT);
        imc_ico.setIcon(new ImageIcon(imgimc));
        Menu_IMC.add(imc_ico);
        
        lbl_peso = new JLabel("Ingrese Peso en (kg)");
        lbl_peso.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_peso.setForeground(new Color(255, 255, 255));
        lbl_peso.setFont(new Font("Cascadia Mono", Font.BOLD, 14));
        lbl_peso.setBounds(45, 50, 170, 30);
        Menu_IMC.add(lbl_peso);
        
        lbl_altura = new JLabel("Ingrese Altura en (mts)");
        lbl_altura.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_altura.setForeground(Color.WHITE);
        lbl_altura.setFont(new Font("Cascadia Mono", Font.BOLD, 14));
        lbl_altura.setBounds(45, 150, 200, 30);
        Menu_IMC.add(lbl_altura);
    }

    /*
     * Operaciones matematicas
     * metodo if else
     */
    public void Convertir() {
        if (Validar(txt_peso.getText()) && Validar(txt_altura.getText())) {
            double peso = Double.parseDouble(txt_peso.getText());
            double altura = Double.parseDouble(txt_altura.getText());

            double imc = peso / (altura * altura);
            resultado.setText("IMC: " + Redondear(imc));
        } else {
            resultado.setText("Ingrese Numeros!");
        }
    }

    /*
     * Metodo para redondear decimales
     */
    public String Redondear(double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(valor);
    }

    public boolean Validar(String texto) {
        try {
            double x = Double.parseDouble(texto);
            return x > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
