package StreamCaratteri.GestioneFileTestuali;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) throws Exception{
        String fileName = "./StreamCaratteri/GestioneFileTestuali/data.csv";
        String charset = "UTF-8";

        LinkedList<String[]> lstRows = ReadCSV.getRows(fileName, charset);

        PlayerData pData = new PlayerData();

        for (String[] sArr : lstRows)
            pData.add(new Player(sArr[0], sArr[1], Integer.valueOf(sArr[2])));

        WriteCSV.print("./StreamCaratteri/GestioneFileTestuali/data2.csv", charset, pData.asListOfStringArray());
    }
}
