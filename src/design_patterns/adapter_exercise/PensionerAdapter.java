package design_patterns.adapter_exercise;

public class PensionerAdapter {
    private Pensioner pensioner;

    public PensionerAdapter(Pensioner pensioner) {
        this.pensioner = pensioner;
    }

    @Override
    public String toString() {
        return pensioner.getInfo();
    }
}
