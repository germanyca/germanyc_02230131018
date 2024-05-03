import static org.junit.Assert.*;
import javax.swing.JTextField;
import org.junit.Test;

public class CalculadoraVisualTest {
    
    @Test
    public void testIniciar() {
        // Probando el método iniciar de la clase CalculadoraVisual
        CalculadoraVisual calc = new CalculadoraVisual();
        calc.iniciar();
        // Verificar que la interfaz gráfica se haya inicializado correctamente
        assertNotNull(calc.getPantalla());
    }

    @Test
    public void testRealizarOperacion() {
        // Probando el método realizarOperacion de la clase CalculadoraVisual
        CalculadoraVisual calc = new CalculadoraVisual();
        double resultado = calc.realizarOperacion(10, 5, "+");
        assertEquals(15, resultado, 0.001); // Verificar suma
        resultado = calc.realizarOperacion(10, 5, "-");
        assertEquals(5, resultado, 0.001); // Verificar resta
        resultado = calc.realizarOperacion(10, 5, "*");
        assertEquals(50, resultado, 0.001); // Verificar multiplicación
        resultado = calc.realizarOperacion(10, 5, "/");
        assertEquals(2, resultado, 0.001); // Verificar división
    }
}