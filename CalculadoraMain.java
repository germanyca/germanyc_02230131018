import javax.swing.*;


public class CalculadoraMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculadoraVisual ventana = new CalculadoraVisual();
                ventana.iniciar();
            }
        });
    }
}