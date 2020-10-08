package org.academiadecodigo.sniperelite;

import org.academiadecodigo.sniperelite.objects.GameObject;
import org.academiadecodigo.sniperelite.objects.GameObjectFactory;
import org.academiadecodigo.sniperelite.types.Destroyable;
import org.academiadecodigo.sniperelite.weapons.SniperRifle;

public class Game {
    private final GameObject[] gameObjects;
    private final SniperRifle sniperRifle;
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

            Destroyable destroyableObject = (Destroyable) gameObject;

            while (!destroyableObject.isDestroyed()) {
                sniperRifle.shoot((Destroyable) gameObject);
                shotsFired++;
            }
        }

        System.out.println("Shots Fired: " + shotsFired);
    }

    private GameObject[] createObjects(int numberOfObjects) {
        GameObject[] gameObjects = new GameObject[numberOfObjects];

        for (int i = 0; i < gameObjects.length; i++) {
            gameObjects[i] = GameObjectFactory.generateGameObject();
        }

        return gameObjects;
    }
}
