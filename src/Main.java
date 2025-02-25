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
        //? implements Runnable
        //? needs to have a registry of all the game objects
        //? needs to keep track of game object layering
        //? needs to be an infinite loop that renders the game objects
        //? needs to be able to render the game objects in the correct order and only if they have a sprite component
        //? possibly implement some sort of batch rendering system? (Renderer1 does game objects 1 - n, Renderer2 does game objects n+1 - m, etc)
        Renderer renderer = new Renderer(); //! might need to only repaint() since javafx might handle the layering and rendering

        ComponentUpdater componentUpdater = new ComponentUpdater();
        ScriptUpdater scriptUpdater = new ScriptUpdater();
        FixedUpdater fixedUpdater = new FixedUpdater();
        
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

        ScheduledExecutorService renderExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService cUpdateExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService sUpdateExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService fixedUpdateExecutor = Executors.newSingleThreadScheduledExecutor();

        renderExecutorService.schedule(renderer, 0, TimeUnit.MILLISECONDS);
        fixedUpdateExecutor.scheduleAtFixedRate(fixedUpdater, 0, 20, TimeUnit.MILLISECONDS);
        cUpdateExecutorService.schedule(componentUpdater, 0, TimeUnit.MILLISECONDS);
        sUpdateExecutorService.schedule(scriptUpdater, 0, TimeUnit.MILLISECONDS);

    }

    private static void configureWindow(String configFilePath){
        // lex, parse, and then interpret the window.config file
        // set the window title, width, height, and other properties
    }

    private static void loadGameScene(String sceneIndex){
        int index = Integer.parseInt(sceneIndex);
        // load the game scene from the scene index
        // get the Scene object from the scene index
        // iterate through every top level game object and register them
    }
}