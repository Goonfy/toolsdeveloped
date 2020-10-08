package org.academiadecodigo.sniperelite.objects;

import org.academiadecodigo.sniperelite.enemies.ArmouredEnemy;
import org.academiadecodigo.sniperelite.enemies.SoldierEnemy;
import org.academiadecodigo.sniperelite.environment.Barrel;
import org.academiadecodigo.sniperelite.environment.Tree;
import org.academiadecodigo.sniperelite.types.BarrelType;
import org.academiadecodigo.sniperelite.types.ObjectType;

public class GameObjectFactory {
    public static GameObject generateGameObject() {
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
                gameObject = new Barrel(BarrelType.values()[(int) (Math.random() * BarrelType.values().length)]);
                break;
            default:
                gameObject = null;
        }

        return gameObject;
    }
}
