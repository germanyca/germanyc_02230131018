import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Boton extends JButton {
    private CalculadoraVisual ventana;

    public Boton(String etiqueta, CalculadoraVisual ventana) {
        super(etiqueta);
        this.ventana = ventana;
        setFont(new Font("Arial", Font.PLAIN, 24));
        setForeground(new Color(0, 255, 255));
        setBackground(new Color(0, 0, 0));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Espacio entre el texto y el borde del botón
        setBorder(new BordeRedondo(15)); // Borde redondeado con un radio de 15 píxeles
        addActionListener(new BotonListener());
    }

    private class BotonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            JTextField pantalla = ventana.getPantalla();
            switch(comando) {
                case "=":
                    ventana.setNumero2(Double.parseDouble(pantalla.getText()));
                    double resultado = ventana.realizarOperacion(ventana.getNumero1(), ventana.getNumero2(), ventana.getOperador());
                    pantalla.setText(String.valueOf(resultado));
                    break;
                case "CLR":
                    pantalla.setText("");
                    ventana.setNumero1(0);
                    ventana.setNumero2(0);
                    ventana.setOperador("");
                    break;
                case ".":
                    if (!pantalla.getText().contains(".")) {
                        pantalla.setText(pantalla.getText() + ".");
                    }
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    pantalla.setText(pantalla.getText() + comando);
                    if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
                        ventana.setNumero1(Double.parseDouble(pantalla.getText().substring(0, pantalla.getText().length() - 1)));
                        ventana.setOperador(comando);
                        pantalla.setText("");
                    }
                    break;
                default:
                    pantalla.setText(pantalla.getText() + comando);
                    break;
            }
        }
    }
}