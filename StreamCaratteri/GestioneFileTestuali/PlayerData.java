package StreamCaratteri.GestioneFileTestuali;

import java.util.LinkedList;

public class PlayerData {
    
    private LinkedList<Player> playerLst;

    public PlayerData() {
        this.playerLst = new LinkedList<Player>();
    }

    public void add(Player player) {
        this.playerLst.add(player);
    }

    public LinkedList<Player> getListOfPlayers() {
        return this.playerLst;
    }

    public LinkedList<String[]> asListOfStringArray() {
        LinkedList<String[]> lstSA = null;

        lstSA = new LinkedList<String[]>();
        String[] sArr = null;
        for (Player p : this.playerLst) {
            sArr = new String[3];
            sArr[0] = p.getName();
            sArr[1] = p.getSurname();
            sArr[2] = String.valueOf(p.getScore());
            lstSA.add(sArr);
        }

        return lstSA;
    }
}
