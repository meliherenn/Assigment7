import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Calculator extends JFrame {
    private JPanel panel1;
    private JTextArea TextArea;
    private JRadioButton multiplesOf3AndRadioButton;
    private JRadioButton primeNumbersRadioButton;
    private JButton SHOWButton;

    public Calculator() {
        add(panel1);
        setSize(800, 600);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonGroup group = new ButtonGroup();
        group.add(multiplesOf3AndRadioButton);
        group.add(primeNumbersRadioButton);
        try {
            BufferedImage originalImage = ImageIO.read(getClass().getResource("/flower.png"));
            Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);
            SHOWButton.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SHOWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (multiplesOf3AndRadioButton.isSelected()) {
                    TextArea.setText(divisibleBy3and5());
                } else if (primeNumbersRadioButton.isSelected()) {
                    TextArea.setText(findPrimes());
                }
            }
        });
    }

    public String divisibleBy3and5() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.append(i).append("\n");
            }
        }
        return result.toString();
    }

    private String findPrimes() {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j <i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result.append(i).append("\n");
            }
        }
        return result.toString();
    }
}
