import java.io.File;
import java.net.URI;
import java.nio.file.Paths;
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
        ComponentUpdater updater = new ComponentUpdater();
        ScriptUpdater scriptUpdater = new ScriptUpdater();
        FixedUpdater fixedUpdater = new FixedUpdater();
        Thread renderThread = new Thread(renderer, "Render Thread");
        Thread cUpdateThread = new Thread(updater, "Component Update Thread");
        Thread sUpdateThread = new Thread(scriptUpdater, "Script Update Thread");
        
        if(args.length == 0) throw new IllegalArgumentException("No window configuration file path provided");
        if(args.length == 1) throw new IllegalArgumentException("No initial scene index provided");
        File configFile = Paths.get(new URI(args[0])).toFile();
        if(!configFile.exists()) throw new IllegalArgumentException("Window configuration file does not exist");
        if(!configFile.isFile()) throw new IllegalArgumentException("Window configuration file is not a file");
        if(!configFile.canRead()) throw new IllegalArgumentException("Window configuration file is not readable");

        configureWindow(args[0]); // don't mess with this method or window.config file, working on building this system

        try { Integer.parseInt(args[1]); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("Initial scene index is not a number"); }
        
        loadGameScene(args[1]); // loads the initial scene from the command line arg[1]

        ScheduledExecutorService fixedUpdateExecutor = Executors.newSingleThreadScheduledExecutor();
        renderThread.start();
        fixedUpdateExecutor.scheduleAtFixedRate(fixedUpdater, 0, 20, TimeUnit.MILLISECONDS);
        cUpdateThread.start();
        sUpdateThread.start();

        
        
    }
}