import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    // use this to initialize the rendering system,
    // add all the threads,
    // add all the GameObjects,
    // and their components, scripts, tags, and children
    // and start the game loop from the initial scene defined in the config file

    // render thread, update thread, fixed update executor

    // render -> Thread
    // update -> Thread
    // fixed update -> ScheduledExecutorService

    public static void main(String [] args){ // [window config file path, initial scene index]
        Renderer renderer = new Renderer();
        Updater updater = new Updater();
        Thread renderThread = new Thread(renderer, "Render Thread");
        Thread updateThread = new Thread(updater, "Update Thread");
        ScheduledExecutorService fixedUpdateExecutor = Executors.newScheduledThreadPool(5);

        configureWindow(args[0]);
    }
}