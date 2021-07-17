package server_gradle.mining;

class Interval {

    private float inf;
    private float sup;

    Interval(float inf, float sup) {

        this.inf = inf;
        this.sup = sup;
    }

    float getInf() {
        return inf;
    }

    void setInf(float inf) {
        this.inf = inf;
    }

    float getSup() {
        return sup;
    }

    void setSup(float sup) {
        this.sup = sup;
    }

    boolean checkValueInclusion(float value) {

        return value >= inf && value <= sup;
    }

    public String toString() {
        
        return "[" + inf + "," + sup + "[";
    }

}