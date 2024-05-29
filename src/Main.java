
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException var2) {
            throw new RuntimeException(var2);
        } catch (InstantiationException var3) {
            throw new RuntimeException(var3);
        } catch (IllegalAccessException var4) {
            throw new RuntimeException(var4);
        } catch (UnsupportedLookAndFeelException var5) {
            throw new RuntimeException(var5);
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calculator f = new Calculator();
                f.setVisible(true);
            }
        });
    }
}