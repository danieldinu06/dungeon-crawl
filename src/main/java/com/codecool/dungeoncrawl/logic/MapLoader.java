package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map3.txt");
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
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.SKELETON);
                            break;
                        case 'd':
                            cell.setType(CellType.DOOR);
                            break;
                        case 'k':
                            cell.setType(CellType.KEY);
                            break;
                        case 'b':
                            cell.setType(CellType.BAT);
                            break;
                        case '/':
                            cell.setType(CellType.SWORD);
                            break;
                        case 'w':
                            cell.setType(CellType.WATER);
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
                            break;
                        case 'u':
                            cell.setType(CellType.BUSH);
                            break;
                        case 'n':
                            cell.setType(CellType.KNIGHT);
                            break;
                        case '%':
                            cell.setType(CellType.TELEPORT);
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
