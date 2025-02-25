import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
        Renderer renderer = new Renderer(); // implements Runnable
        Updater updater = new Updater(); // implements Runnable
        FixedUpdate fixedUpdater = new FixedUpdater(); // implements Runnable
        Thread renderThread = new Thread(renderer, "Render Thread");
        Thread updateThread = new Thread(updater, "Update Thread");
        
        ScheduledExecutorService fixedUpdateExecutor = Executors.newSingleThreadScheduledExecutor();
        renderThread.start();
        fixedUpdateExecutor.scheduleAtFixedRate(fixedUpdater, 0, 20, TimeUnit.MILLISECONDS);
        updateThread.start();

        configureWindow(args[0]);
    }
}