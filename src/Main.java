import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    // use this to initialize the rendering system,
    // add all the threads,

    // Game {
    //  Window(s)
    //  GameScripts
    //  GameScenes {
    //    SceneScripts
    //    GameObjects {
    //      Components
    //      Scripts
    //      Children
    //    }
    //  }
    // }


    // add all the GameObjects,
    // and their components, scripts, tags, and children
    // and start the game loop from the initial scene defined in the config file

    // render thread, update thread, fixed update executor

    // render -> Thread
    // update -> Thread
    // fixed update -> ScheduledExecutorService

    public static void main(String [] args){ // [window config file path, initial scene index]
        
        GameRenderer renderer = new GameRenderer(); 

        ComponentUpdater componentUpdater = new ComponentUpdater();
        ScriptUpdater scriptUpdater = new ScriptUpdater();
        FixedUpdater fixedUpdater = new FixedUpdater();
        
        if(args.length == 0) throw new IllegalArgumentException("No window configuration file path provided");
        if(args.length == 1) throw new IllegalArgumentException("No initial scene index provided");
        File configFile;
        try {
            configFile = Paths.get(new URI(args[0])).toFile();
            if(!configFile.exists()) throw new IllegalArgumentException("Window configuration file does not exist");
            if(!configFile.isFile()) throw new IllegalArgumentException("Window configuration file is not a file");
            if(!configFile.canRead()) throw new IllegalArgumentException("Window configuration file is not readable");
        } catch (URISyntaxException e) { e.printStackTrace(); }
        
        configureWindow(args[0]); // don't mess with this method or window.config file, working on building this system

        try { Integer.parseInt(args[1]); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("Initial scene index is not a number"); }
        
        loadGameScene(args[1]); // loads the initial scene from the command line arg[1]

        ScheduledExecutorService renderExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService cUpdateExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService sUpdateExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService fixedUpdateExecutor = Executors.newSingleThreadScheduledExecutor();

        renderExecutorService.scheduleAtFixedRate(renderer, (long) 0, (long) 17, TimeUnit.MILLISECONDS);
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