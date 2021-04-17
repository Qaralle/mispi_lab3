package main;

import static java.lang.Math.pow;

public class Result {

    private Double x;
    private Double y;
    private Double r;
    private boolean result;

    public Result(Double x, Double y, Double r){
        this.x=x;
        this.y=y;
        this.r=r;
    }

    public Result() {

    }

    public boolean getResult(){
        return result;
    }
    public void setX(Double x) {
        if (x!=null && x>=-2 && x<= 2) {
            this.x = x;
        }
    }

    public void setY(Double y){
        if (y!=null && y>=-3 && y<= 3) {
            this.y = y;
        }
    }

    public void setR(Double r){
        if (r!=null && r>=1 && r<= 3) {
            this.r = r;
        }
    }


    public Double getR() {
        return r;
    }
    public Double getX() {
        return x;
    }

    public void checkTheArea() {
        if (x > 0 && y < 0) {
            this.result= false;
        } else if ((x <= 0 && y <= 0) && (x >= -r) && (y >=- r/2)) {
            this.result= true;
        } else if (x >= 0 && y >= 0 && (y <= -x/2 + r/2)) {
            this.result= true;
        } else this.result=((x <= 0 && y >= 0) && (pow(x,2) + pow(y,2)<=pow(r/2,2)));
    }


}
