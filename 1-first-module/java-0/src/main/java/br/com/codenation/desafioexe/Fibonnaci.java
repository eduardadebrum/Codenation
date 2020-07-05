package br.com.codenation.desafioexe;

/**
 * @author Eduarda de Brum Lucena
 */
public class Fibonnaci {

    private Integer previous;
    private Integer current;
    private Integer result;

    public Fibonnaci(Integer previous, Integer current, Integer result) {
        this.previous = previous;
        this.current = current;
        this.result = result;
    }

    public Integer getPrevious() {
        return previous;
    }

    public void setPrevious(Integer previous) {
        this.previous = previous;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
