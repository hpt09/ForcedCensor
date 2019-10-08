package sample;

import javafx.event.ActionEvent;

public class Controller {

    BashCommands bash = new BashCommands();

    public void align(ActionEvent event){

        bash.align();

        System.out.println("Hello");

    }

}
