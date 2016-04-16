package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Models.ActionsHolder;
import com.wrathOfLoD.Views.StaticView;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by zach on 4/16/16.
 */
public abstract class Menu extends StaticView implements ActionsHolder {
    private int currentIndex = 0;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private Set<Action> actionSet;

    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    /**
     * desc: Increment to next row
     */
    public void safeDecrementUp() {
        int prevIndex = this.currentIndex;
        this.currentIndex--;

        if (this.currentIndex < 0)
            this.currentIndex = prevIndex;
    }

    /**
     * desc: Increment to next row
     */
    public void safeIncrementDown() {
        int prevIndex = this.currentIndex;
        this.currentIndex++;

        if (this.currentIndex >= this.getMenuItems().size())
            this.currentIndex = prevIndex;
    }

    public void selectPrevItem() {
        this.safeDecrementUp();
    }

    public void selectNextItem() {
        this.safeIncrementDown();
    }

    /**
     * desc: Return the currently selected item
     */
    public void useSelectedItem() {
        System.out.println(this.getMenuItems().get(currentIndex));

//        return this.getItemViewObject(currentIndex).getItem();
    }

    @Override
    public Set<Action> getActionSet() {
        return this.actionSet;
    }

    @Override
    public void initializeActionSet() {

    }

    @Override
    public void setActionSet(Set<Action> actionSet) {

    }

    @Override
    public void addToActionSet(Action action) {

    }
}
