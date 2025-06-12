# ⚔️ Undertale Undyne Fight Recreation

1. [Desc](#desc)  
2. [Project Structure](#project-structure)
3. [How to Run](#how-to-run)  
4. [Upcoming Updates](#upcoming-updates)

---

## Desc

This project is a Java-based recreation of the **Undyne battle** from the hit indie game **Undertale**, originally developed by Toby Fox. The game mimics the iconic fight mechanics, focusing on dodging projectiles and blocking attacks with directional shields — staying true to the fast-paced bullet-hell style gameplay.

Built with **Java Swing**, this version features real-time movement, basic collision detection, and dynamic projectile spawning.

## Project Structure

```
project-root/
├── game/
│   └── Game.java
├── logic/
│   ├── CollisionDetector.java
│   ├── Coordinates.java
│   ├── Direction.java
│   ├── InputHandler.java
│   ├── Projectile.java
│   └── ProjectileHandler.java
├── logos/
│   ├── blockerHorz.png
│   ├── blockerVert.png
│   ├── logo.png
│   └── projectile.png
├── UI/
│   ├── myPanel.java
│   └── Renderer.java
├── Main.java
└── README.md
```

## How to Run

From the root directory of the project, use the following commands:

```bash
javac -d Out -cp .\Main.java .\game\* .\logic\* .\UI\*
java -cp Out Main
```
## Upcoming updates

1. Future optimizations to code
2. Add score manager system
3. Add life system