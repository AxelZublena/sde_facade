package app;

public class RadioFacade {
    private Amplifier amplifier;
    private Tuner tuner;

    public RadioFacade(Amplifier amplifier, Tuner tuner){
        this.amplifier = amplifier;
        this.tuner = tuner;
    }

    public void startRadio(double frequency){
        this.tuner.on();
        this.tuner.setFrequency(frequency);
        this.amplifier.on();
        this.amplifier.setVolume(5);
        this.amplifier.setTuner(this.tuner);
    }
    public void afterRadio(){
        this.tuner.off();
        this.amplifier.off();
    }
}