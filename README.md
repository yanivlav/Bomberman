
# 💣 Bomberman (Java)

A classic Bomberman-style game implemented in Java, showcasing object-oriented programming principles and the Model-View-Controller (MVC) architectural pattern.

![image](https://user-images.githubusercontent.com/22189126/179818952-2ee8f97f-6d76-4fab-bdab-594fe4d15af6.png)

## 🎮 Overview

This project recreates the timeless Bomberman gameplay, where players navigate a grid-based map, strategically place bombs to eliminate obstacles and opponents, and aim to be the last player standing. Developed using Java's Swing/AWT libraries, it offers an engaging experience that mirrors the original game's mechanics.

## 🏗️ Architecture

### Model-View-Controller (MVC) Pattern

- **Model**: Manages the game's core logic and data structures, including player states, bomb mechanics, and the game map.
- **View**: Handles all graphical representations, rendering the game state to the user using Java's GUI components.
- **Controller**: Processes user inputs, translating them into actions within the game, and updates the model accordingly.

## 🧩 Core Components

### Model

- `Player`: Represents the player's state, including position, movement, and bomb placement capabilities.
- `Bomb`: Manages bomb placement, countdown timers, explosion effects, and interactions with the environment.
- `GameMap`: Defines the 2D grid layout, including walls, destructible blocks, and power-ups.
- `Explosion`: Handles the logic for bomb explosions, affecting nearby tiles and entities.

### View

- `GamePanel`: Extends Java's `JPanel` to render the game scene, including the map, players, bombs, and explosions.
- `ImageLoader`: Utility class for loading and managing game assets like sprites and textures.

### Controller

- `Game`: Contains the main game loop, orchestrating updates and rendering cycles.
- `KeyHandler`: Captures and processes keyboard inputs, facilitating player interactions.

## 🕹️ Controls

- **Arrow Keys / WASD** – Move player
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

Specify the license here (e.g., MIT License).

