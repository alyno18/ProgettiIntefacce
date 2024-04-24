import javax.swing.JOptionPane;

public class TestMatrix {

    private static int insertIntegerDialog(String message) {
        int value = Integer.MAX_VALUE;
        Object[] options = {"OK", "Annulla"};
        String s = (String)JOptionPane.showInputDialog(null,(Object)message,"Input",JOptionPane.QUESTION_MESSAGE,null,null,(Object)"0");
        try {
            value = Integer.valueOf(s);
        }
        catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null,"Soltanto valori interi possono essere inseriti.", "Input Error",JOptionPane.ERROR_MESSAGE);
        }
        return value;
    }

    public static int readInt(String message) {
        int value = Integer.MAX_VALUE;
        boolean rightInsert = false;
        while (!rightInsert) {
            value = insertIntegerDialog(message);
            if (value != Integer.MAX_VALUE)
                rightInsert = true;
        }
        return value;
    }

    public static void main(String[] args) {

        int rows = readInt("Inserire il numero di righe");
        int columns = readInt("Inserire il numero di colonne");

        IntegerMatrix matrix = new IntegerMatrix(rows, columns);

        int ijVal = -1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                ijVal = readInt("Inserire il valore di matrix[" + i + "][" + j + "]");
                matrix.setValue(i, j, ijVal);
            }

        boolean quit = false;
        String str = null;
        int i = -1;
        int j = -1;
        while (!quit) {
            int confirm = JOptionPane.showConfirmDialog(null, "Desideri proseguire?", "Visualizzazione interattiva", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.NO_OPTION)
                quit = true;
            else {
                i = readInt("Inserire indice di riga i");
                j = readInt("Inserire indice di colonna j");

                try {
                    JOptionPane.showMessageDialog(null,"matrix[" + i + "][" + j + "] = " + matrix.getValue(i, j),"IntegerMatrix info",JOptionPane.INFORMATION_MESSAGE);
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null,"La riga i o la colonna j specificati sono errati.","Errore di inserimento",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}