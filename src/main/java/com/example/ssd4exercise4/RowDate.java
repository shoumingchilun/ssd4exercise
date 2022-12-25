package com.example.ssd4exercise4;

/**
 * @auther 齿轮
 * @create 2022-12-24-15:35
 */
public class RowDate {
    String SUN;
    String MON;
    String TUE;
    String WED;
    String THU;
    String FRI;
    String SAT;
    String[] data = new String[7];

    public RowDate() {
        for (String string : data) {
            string = new String("");
        }
    }

    public void update() {
        SUN = data[0];
        MON = data[1];
        TUE = data[2];
        WED = data[3];
        THU = data[4];
        FRI = data[5];
        SAT = data[6];
    }

    public String getSUN() {
        return SUN;
    }

    public void setSUN(String SUN) {
        this.SUN = SUN;
    }

    public String getMON() {
        return MON;
    }

    public void setMON(String MON) {
        this.MON = MON;
    }

    public String getTUE() {
        return TUE;
    }

    public void setTUE(String TUE) {
        this.TUE = TUE;
    }

    public String getWED() {
        return WED;
    }

    public void setWED(String WED) {
        this.WED = WED;
    }

    public String getTHU() {
        return THU;
    }

    public void setTHU(String THU) {
        this.THU = THU;
    }

    public String getFRI() {
        return FRI;
    }

    public void setFRI(String FRI) {
        this.FRI = FRI;
    }

    public String getSAT() {
        return SAT;
    }

    public void setSAT(String SAT) {
        this.SAT = SAT;
    }
}
