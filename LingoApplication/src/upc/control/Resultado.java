package upc.control;

/**
 *
 * @author pablo.sierralta
 */
public class Resultado {

    private String dmu;
    private Double score;

    public Resultado(String dmu, Double score) {
        this.dmu = dmu;
        this.score = score;
    }

    /**
     * @return the dmu
     */
    public String getDmu() {
        return dmu;
    }

    /**
     * @param dmu the dmu to set
     */
    public void setDmu(String dmu) {
        this.dmu = dmu;
    }

    /**
     * @return the score
     */
    public Double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Double score) {
        this.score = score;
    }
}
