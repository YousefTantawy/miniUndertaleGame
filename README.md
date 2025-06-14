# ⚔️ Undertale Undyne Fight Recreation

1. [Description](#description)  
2. [Project Structure](#project-structure)
3. [How to Run](#how-to-run)  
4. [Upcoming Updates](#upcoming-updates)

---

## Description

This project is a Java-based recreation of the **Undyne battle** from the indie game **Undertale** (by Toby Fox).  
It mimics the iconic fight mechanics: dodging projectiles and blocking attacks with directional shields, in a fast-paced bullet-hell style.

**Features:**
- Dynamic projectile spawning
- Directional shield blocking
- **Background music** (Undyne's theme)
- Simple one-click build & run with `run.bat`

Built with **Java Swing**.

---

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
├── music/
│   ├── MusicPlayer.java
│   └── undyneOST.wav
├── UI/
│   ├── myPanel.java
│   └── Renderer.java
├── Main.java
├── run.bat
└── README.md
```

---

## How to Run

**No need to use terminal commands!**

Just double-click `run.bat` (or run it from the terminal) in the project root folder.  
This will:
- Clean previous builds
- Compile all Java files
- Copy all resources (music, images)
- Launch the game

**Requirements:**  
- Java 8 or higher installed

---

## Upcoming Updates

1. Future code optimizations
2. Add score manager system
3. Add life system

---

*Inspired by Undertale, by Toby Fox.*