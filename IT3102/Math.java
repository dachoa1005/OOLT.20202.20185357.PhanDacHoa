import javax.swing.JOptionPane;
public class Math {
    public static void main(String[] args){
    String strNum1, strNum2;
    String strNotification = "You've just entered: ";

    strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
    strNotification += strNum1 + " and ";
    double num1 = Double.parseDouble(strNum1);
    strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
    strNotification += strNum2;
    JOptionPane.showMessageDialog(null, strNotification, "Show two number", JOptionPane.INFORMATION_MESSAGE);
    double num2 = Double.parseDouble(strNum2);
    JOptionPane.showMessageDialog(null, strNum1, "so thu nhat", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
    }
}
