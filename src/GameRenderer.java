public class GameRenderer implements Runnable {

    //? needs to have a registry of all the game objects
    //? needs to keep track of game object layering
    //? needs to be an infinite loop that renders the game objects
    //? needs to be able to render the game objects in the correct order and only if they have a sprite component
    //? possibly implement some sort of batch rendering system? (Renderer1 does game objects 1 - n, Renderer2 does game objects n+1 - m, etc)
        
    //! might need to only repaint() since javafx might handle the layering and rendering

    @Override
    public void run() {
        // implement render code
    }
}
