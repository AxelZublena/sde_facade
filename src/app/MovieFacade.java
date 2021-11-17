package app;

public class MovieFacade {
    private PopcornPopper popcornPopper;
    private TheaterLights lights;
    private Screen screen;
    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private Projector projector;

    public MovieFacade(PopcornPopper popcornPopper, TheaterLights lights, Screen screen, Amplifier amplifier, DvdPlayer dvdPlayer, Projector projector){
        this.popcornPopper = popcornPopper;
        this.lights = lights;
        this.screen = screen;
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
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
}
