package app;

public class HomeCinemaFacade {
    private PopcornPopper popcornPopper;
    private TheaterLights lights;
    private Screen screen;
    private Projector projector;
    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private CdPlayer cdPlayer;
    private Tuner tuner;

    public HomeCinemaFacade(PopcornPopper popcornPopper, TheaterLights lights, Screen screen, Projector projector, Amplifier amplifier, DvdPlayer dvdPlayer, CdPlayer cdPlayer, Tuner tuner){
        this.popcornPopper = popcornPopper;
        this.lights = lights;
        this.screen = screen;
        this.projector = projector;
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
        this.tuner = tuner;
    }

    public void startMovie(){
        this.popcornPopper.on();
        this.popcornPopper.pop();
        this.lights.dim(10);
        this.screen.down();
        this.projector.on();
        this.projector.wideScreenMode();
        this.amplifier.on();
        this.amplifier.setDvd(this.dvdPlayer);
        this.amplifier.setSurroundSound();
        this.amplifier.setVolume(5);
        this.dvdPlayer.on();
        this.dvdPlayer.play("Captain America: The First Avenger");
    }

    public void afterMovie(){
        this.popcornPopper.off();
        this.lights.on();
        this.screen.up();
        this.projector.off();
        this.amplifier.off();
        this.dvdPlayer.stop();
        this.dvdPlayer.eject();
        this.dvdPlayer.off();
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
