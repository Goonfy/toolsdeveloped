package org.academiadecodigo.bootcamp.controller;


import org.academiadecodigo.bootcamp.manager.ConnectionManager;

public class MainController extends AbstractController {

    private Controller userListController;
    private Controller userDetailsController;
    private ConnectionManager connectionManager;

    public void onMenuSelection(int answerIndex) {

        switch (answerIndex) {
            case 1:
                userListController.init();
                init();
                break;
            case 2:
                userDetailsController.init();
                init();
                break;
            case 3:
                connectionManager.close();
                break;
        }
    }


    public void setUserListController(Controller userListController) {
        this.userListController = userListController;
    }

    public void setUserDetailsController(Controller userDetailsController) {
        this.userDetailsController = userDetailsController;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
}
