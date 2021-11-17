package app;

public class MusicFacade {
    private TheaterLights lights;
    private Amplifier amplifier;
    private CdPlayer cdPlayer;

    public MusicFacade(TheaterLights lights, Amplifier amplifier, CdPlayer cdPlayer){
        this.lights = lights;
        this.amplifier = amplifier;
        this.cdPlayer = cdPlayer;
    }

    public void startMusic(){
        this.lights.on();
        this.amplifier.on();
        this.amplifier.setVolume(5);
        this.amplifier.setCd(this.cdPlayer);
        this.amplifier.setStereoSound();
        this.cdPlayer.on();
        this.cdPlayer.play("Walking the Cow - Daniel Johnston");
    }
    public void afterMusic(){
        this.amplifier.off();
        this.amplifier.setCd(this.cdPlayer);
        this.cdPlayer.eject();
        this.cdPlayer.off();
    }
}
