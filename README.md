
# 💣 Bomberman (Java)

A classic Bomberman-style game implemented in Java, showcasing object-oriented programming principles and the Model-View-Controller (MVC) architectural pattern.
This project features player movement, bombs, destructible bricks, monsters, and flame explosions.

![image](https://user-images.githubusercontent.com/22189126/179818952-2ee8f97f-6d76-4fab-bdab-594fe4d15af6.png)

## 🎮 Overview

This project recreates the timeless Bomberman gameplay, where players navigate a grid-based map, strategically place bombs to eliminate obstacles and opponents, and aim to be the last player standing. Developed using Java's Swing/AWT libraries, it offers an engaging experience that mirrors the original game's mechanics.

## 🏗️ Architecture

### Model-View-Controller (MVC) Pattern

- **Model**: Manages the game's core logic and data structures, including player states, bomb mechanics, and the game map.
- **View**: Handles all graphical representations, rendering the game state to the user using Java's GUI components.
- **Controller**: Processes user inputs, translating them into actions within the game, and updates the model accordingly.

This design follows MVC architecture with clear separation between data (Model), user interface (View), and application logic (Controller).
## Simplified UML Overview
```
+--------------------+       +--------------------+       +--------------------+
|   MainApplication  |       |   GameController   |       |    MainView        |
|--------------------|       |--------------------|       |--------------------|
| +main(args: String[])|-->  | - model             |       | - entityManager     |
|                    |       | - view              |       | - gameController    |
+--------------------+       | +startGame()        |       +--------------------+
                             +--------------------+

        |                             |                             |
        v                             v                             v
+--------------------+       +--------------------+       +--------------------+
|      Player        |       |       Bomb         |       |     Brick          |
|--------------------|       |--------------------|       |--------------------|
| - position          |       | - timer            |       | - destructible     |
| - lives             |       | - owner            |       |                    |
+--------------------+       +--------------------+       +--------------------+

+--------------------+       +--------------------+       +--------------------+
|      Wall          |       |     Monster        |       |    EntityManager   |
|--------------------|       |--------------------|       |--------------------|
| - indestructible    |       | - AI behavior      |       | - manage entities  |
+--------------------+       +--------------------+       +--------------------+

+--------------------+       +--------------------+
|    Flame           |       |   MoveableObject   |
|--------------------|       |--------------------|
| - explosion effect  |       | - movement logic   |
+--------------------+       +--------------------+
```

This design follows MVC architecture with clear separation between data (Model), user interface (View), and application logic (Controller).


## 🧩 Core Components

This Bomberman project is organized mainly into three packages:

### Model Package

Contains the core game logic and entities:

- `Entity.java` — Base class for all game objects.
- `Player.java` — The player character logic.
- `Bomb.java` — Bomb behavior and explosion handling.
- `Brick.java` — Destructible obstacles.
- `Wall.java` — Indestructible obstacles.
- `Monster.java` — Enemy AI entities.
- `Flame.java` — Bomb explosion flames.
- `EntityManager.java` — Manages and updates all entities.
- `MoveableObject.java` — Base class for all movable entities.
- `Position.java` — Utility class for coordinates.
- `Direction.java` — Defines movement directions.

### Controller Package

- `GameController.java` — Main controller coordinating game logic, handling user input, and managing game state.

### View Package

- `MainView.java` — Main GUI window, rendering the game and forwarding user inputs to the controller.

## 🕹️ Controls

- **Arrow Keys** – Move player
- **Spacebar** – Drop bomb

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) installed
- An IDE like Eclipse or IntelliJ IDEA

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yanivlav/Bomberman.git
   cd Bomberman
   ```

2. **Open the project in your IDE:**

   - For Eclipse: Import as an existing project.
   - For IntelliJ IDEA: Open the `Bomberman` directory.

3. **Build and run the project:**

   - Run ```/src/run/MainApplication.java```.

## 🧪 Testing

Basic unit tests are available under the `test/model/` directory to validate core functionalities of the game's model components.

## 📁 Project Structure

```
Bomberman/
├── src/             # Java source files
├── bin/             # Compiled class files
├── image/           # Game assets (sprites, textures)
├── test/            # Unit tests
├── .classpath       # Eclipse configuration
├── .project         # Eclipse configuration
├── README.md        # Project documentation
```

## 📜 License

MIT License.

