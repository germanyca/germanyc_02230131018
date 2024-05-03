import static org.junit.Assert.*;
import javax.swing.JTextField;
import org.junit.Test;

public class BotonTest {
    
    @Test
    public void testActionPerformed() {
        // Probando el método actionPerformed de la clase Boton
        CalculadoraVisual calc = new CalculadoraVisual();
        JTextField pantalla = calc.getPantalla();
        pantalla.setText("10");
        Boton boton = new Boton("+", calc);
        boton.getActionListeners()[0].actionPerformed(null); // Simular clic en el botón
        assertEquals("10+", pantalla.getText()); // Verificar que el operador se agregó a la pantalla
    }
}