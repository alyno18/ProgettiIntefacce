package GestioneFileConfigurazione.myapp.bin;

public class TestConfig {
    public static void main(String[] args) {
        outLn("backgroundColor: " + Config.getInstance().getBackgroundColor());
        outLn("lineColor: " + Config.getInstance().getLineColor());
        outLn("padColor: " + Config.getInstance().getPadColor());
        outLn("starColor: " + Config.getInstance().getStarColor());
        outLn("level: " +Config.getInstance().getLevel());
    }

    public static void outLn(Object obj){
        System.out.println(obj);
    }
}
