import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JButton buttonSuma, buttonResta, buttonMultiplicacion, buttonDivision, buttonIgual, buttonLimpiar;

    private double num1, num2;
    private char operacion;

    public CalculadoraGUI() {
        super("Calculadora");

        textField = new JTextField(15);
        textField.setEditable(false);

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        buttonSuma = new JButton("+");
        buttonResta = new JButton("-");
        buttonMultiplicacion = new JButton("*");
        buttonDivision = new JButton("/");
        buttonIgual = new JButton("=");
        buttonLimpiar = new JButton("C");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonSuma);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonResta);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonMultiplicacion);
        panel.add(button0);
        panel.add(buttonIgual);
        panel.add(buttonLimpiar);
        panel.add(buttonDivision);

        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        button0.addActionListener(new BotonNumeroListener("0"));
        button1.addActionListener(new BotonNumeroListener("1"));
        button2.addActionListener(new BotonNumeroListener("2"));
        button3.addActionListener(new BotonNumeroListener("3"));
        button4.addActionListener(new BotonNumeroListener("4"));
        button5.addActionListener(new BotonNumeroListener("5"));
        button6.addActionListener(new BotonNumeroListener("6"));
        button7.addActionListener(new BotonNumeroListener("7"));
        button8.addActionListener(new BotonNumeroListener("8"));
        button9.addActionListener(new BotonNumeroListener("9"));

        buttonSuma.addActionListener(new BotonOperacionListener('+'));
        buttonResta.addActionListener(new BotonOperacionListener('-'));
        buttonMultiplicacion.addActionListener(new BotonOperacionListener('*'));
        buttonDivision.addActionListener(new BotonOperacionListener('/'));
        buttonIgual.addActionListener(new BotonIgualListener());
        buttonLimpiar.addActionListener(new BotonLimpiarListener());
    }

    private class BotonNumeroListener implements ActionListener {
        private String numero;

        public BotonNumeroListener(String numero) {
            this.numero = numero;
        }

        public void actionPerformed(ActionEvent event) {
            textField.setText(textField.getText() + numero);
        }
    }

    private class BotonOperacionListener implements ActionListener {
        private char operacion;

        public BotonOperacionListener(char operacion) {
            this.operacion = operacion;
        }

        public void actionPerformed(ActionEvent event) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            CalculadoraGUI.this.operacion = operacion;
        }
    }

    private class BotonIgualListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            num2 = Double.parseDouble(textField.getText());
            double resultado = 0;

            switch (operacion) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    resultado = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(resultado));
        }
    }

    private class BotonLimpiarListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operacion = '\0';
        }
    }

    public static void main(String[] args) {
        CalculadoraGUI calculadora = new CalculadoraGUI();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculadora.setSize(300, 300);
        calculadora.setVisible(true);
        calculadora.setLocationRelativeTo(null);
    }
}
