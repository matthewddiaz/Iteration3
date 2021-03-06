package com.wrathOfLoD.Models.Commands.SelectableActionCommands;

import com.wrathOfLoD.Views.Selectable;

/**
 * Created by zach on 4/9/16.
 */
public class SelectLeftCommand extends SelectCommand {

    public SelectLeftCommand(Selectable selectable) {
        super(selectable);
    }

    @Override
    public void execute(){
        this.getSelectable().selectPrevItem();
    }
}
