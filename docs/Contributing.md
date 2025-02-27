# Guidelines:


# Todo:
- Hello Window!
  - [ ] Windowing config
  - Multi-window Support (?)
  - Game Scripts (?)
    - Scripts global to the entire game
    - Contain both fixed update and update
- Scenes
  - What do we want in scenes?
  - Scene Scripts (?)
    - Scripts global to the entire scene
    - Contain both fixed update and update
- Objects
  - [X] Tags
  - [X] Child Objects
  - [X] Transform
    - [X] Position
    - [X] Rotation
    - [X] Scale
  - [ ] Scripts
  - [ ] Components
    - Sprite
      - Animator
    - Colliders
      - Collider groups
    - Physics Body
      - Gravity
      - Fixed Update
  - [X] Layering (Z position)
- Input System
  - Actions
    - Keybinds
    - Key Events
  - Mouse Listener
    - Mouse Capture


# Notes:

```java
static {
  // this could be used as a replacement for awake()
  // this runs only once, and runs before a constructor
}

class Foo {

  {
    // this could be used as a replacement for start()
    // this runs BEFORE a constructor
  }

  public Foo(){
    // this could also be used as a replacement for start()
  }
}
```