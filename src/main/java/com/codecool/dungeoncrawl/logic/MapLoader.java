package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.enemies.Enemy;
import com.codecool.dungeoncrawl.logic.actors.Player;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap(String mapName) {
        InputStream is = MapLoader.class.getResourceAsStream(mapName);
        Scanner scanner = new Scanner(is);

        int width = scanner.nextInt();
        int height = scanner.nextInt();


        scanner.nextLine(); // empty line



        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            map.addWall(cell);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.SKELETON);
                            map.addSkeleton(cell, 5, 2);
                            break;
                        case 'd':
                            cell.setType(CellType.DOOR);
                            break;
                        case 'k':
                            cell.setType(CellType.KEY);
                            map.addKey(cell);
                            break;
                        case 'b':
                            cell.setType(CellType.BAT);
                            map.addBat(cell, 3, 1);
                            break;
                        case '/':
                            cell.setType(CellType.SWORD);
                            map.addSword(cell);
                            break;
                        case 'w':
                            cell.setType(CellType.WATER);
                            map.addWater(cell);
                            break;
                        case '$':
                            cell.setType(CellType.BRIDGE);
                            break;
                        case 't':
                            cell.setType(CellType.TREE);
                            break;
                        case 'h':
                            cell.setType(CellType.HOUSE);
                            break;
                        case '>':
                            cell.setType(CellType.BEAR);
                            break;
                        case 'f':
                            cell.setType(CellType.FENCE);
                            map.addFence(cell);
                            break;
                        case 'u':
                            cell.setType(CellType.BUSH);
                            break;
                        case 'n':
                            cell.setType(CellType.KNIGHT);
                            map.addKnight(cell, 20, 10);
                            break;
                        case 'T':
                            cell.setType(CellType.TELEPORT);
                            break;
                        case 'a':
                            cell.setType(CellType.AXE);
                            map.addAxe(cell);
                            break;
                        case 'p':
                            cell.setType(CellType.PEASANT);
                            break;
                        case 'e':
                            cell.setType(CellType.END);
                            break;
                        case '!':
                            cell.setType(CellType.PEAK);
                            break;
                        case 'l':
                            cell.setType(CellType.HIGHLAND);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }
}
