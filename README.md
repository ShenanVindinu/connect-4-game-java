# <img src="src/main/resources/asset/connect-four.png" alt="drawing" width="50"/> The Connect-4 Game

## Overview
This project is a Java-based implementation of the Connect 4 game. It includes the core game logic, player interactions, and a simple interface to play the game. The AI component (Monte Carlo Tree Search) is not included in this version.

## Features 💖
- Two-player mode (human vs. human)
- Console-based game interface
- Board validation and win-checking logic
- Error handling for invalid moves

## Installation 🥬🧦
1. Clone the repository:
   ```sh
   git clone https://github.com/ShenanVindinu/connect-4-game-java.git
   ```
2. Navigate to the project directory:
   ```sh
   cd connect4-game-java
   ```
3. Compile the Java files:
   ```sh
   javac Main.java
   ```
4. Run the game:
   ```sh
   java Main
   ```

## Game Rules ⚖️
- The game is played on a 7x6 grid.
- Players take turns dropping pieces into a column.
- The first player to connect four of their pieces in a row (horizontally, vertically, or diagonally) wins.
- If the board is full without a winner, the game ends in a draw.

## How to Play 🏆
1. The game prompts Player 1 and Player 2 to enter a column number (0-6) to drop their piece.
2. The board updates after each move and is displayed on the console.
3. The game announces the winner or a draw when the game ends.

## File Structure
```
connect4-game/
│-- src/
│   │-- Main.java
│   │-- Game.java
│   │-- Board.java
│   │-- Player.java
│-- README.md
│-- .gitignore
```
