package org.academiadecodigo.sniperelite;

import org.academiadecodigo.sniperelite.objects.*;
import org.academiadecodigo.sniperelite.weapons.SniperRifle;

public class Game {
    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private int shotsFired;

    public Game(int numberOfObjects) {
        sniperRifle = new SniperRifle(10);

        gameObjects = createObjects(numberOfObjects);
    }

    public void start() {
        for (GameObject gameObject : gameObjects) {
            System.out.println(gameObject.getMessage());

            if (!(gameObject instanceof Destroyable)) {
                continue;
            }

            Destroyable destroyable = (Destroyable) gameObject;

            while (!destroyable.isDestroyed()) {
                sniperRifle.shoot((Destroyable) gameObject);
                shotsFired++;
            }
        }

        System.out.println("Shots Fired: " + shotsFired);
    }

    private GameObject[] createObjects(int numberOfObjects) {
        GameObject[] gameObjects = new GameObject[numberOfObjects];

        for (int i = 0; i < gameObjects.length; i++) {
            int random = (int) (Math.random() * ObjectType.values().length);
            ObjectType objectType = ObjectType.values()[random];

            GameObject gameObject;

            switch (objectType) {
                case TREE:
                    gameObject = new Tree();
                    break;
                case ARMOUREDENEMY:
                    gameObject = new ArmouredEnemy(100, 100);
                    break;
                case SOLDIERENEMY:
                    gameObject = new SoldierEnemy(100);
                    break;
                case BARREL:
                    gameObject = new Barrel();
                    break;
                default:
                    gameObject = null;
            }

            gameObjects[i] = gameObject;
        }

        return gameObjects;
    }
}
