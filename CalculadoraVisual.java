
import javax.swing.*;
import java.awt.*;

public class CalculadoraVisual extends JFrame {
    private JTextField pantalla;
    private Boton[] botones;
    private String[] etiquetas = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+", "CLR"
    };
    private double numero1, numero2;
    private String operador;

    public CalculadoraVisual() {
        setTitle("Germany Carreño");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
    }

    public void iniciar() {
        pantalla = new JTextField();
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setBackground(new Color(255, 255, 255));
        pantalla.setFont(new Font("Arial", Font.PLAIN, 24));
        add(pantalla, BorderLayout.NORTH);
    
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 5, 5));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelBotones.setBackground(new Color(255, 255, 255));
        botones = new Boton[17];
        for (int i = 0; i < 17; i++) {
            botones[i] = new Boton(etiquetas[i], this);
            panelBotones.add(botones[i]);
        }
        add(panelBotones, BorderLayout.CENTER);
    
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    

    public double realizarOperacion(double numero1, double numero2, String operador) {
        switch (operador) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "*":
                return numero1 * numero2;
            case "/":
                if (numero2 != 0) {
                    return numero1 / numero2;
                } else {
                    JOptionPane.showMessageDialog(this, "Error: División por cero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                return 0;
        }
    }

    public JTextField getPantalla() {
        return pantalla;
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}

