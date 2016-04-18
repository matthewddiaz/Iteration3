package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Controllers.InputStates.AvatarState;
import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Controllers.InputStates.InventoryState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.GameLaunching.Vendors.EntityVendor;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FanBlastAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FireballAbility;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.ModelEngine;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.AvatarIESView.AvatarIESView;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.ListStructure;
import com.wrathOfLoD.Views.ItemDisplayView.EquipmentView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.StatsView.StatsView;
import com.wrathOfLoD.Views.ViewEngine;
import com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory.ViewObjectFactory;
import com.wrathOfLoD.Views.ViewManager.ViewManager;
import sun.security.x509.AVA;

import java.io.IOException;

/**
 * Created by luluding on 4/15/16.
 */
public class GameLauncher {
    private GameLaunchHelper gameLaunchHelper;

    public GameLauncher(GameLaunchHelper gameLaunchHelper){
        this.gameLaunchHelper = gameLaunchHelper;
    }


    public void launchGame() throws InterruptedException, IOException{
        gameLaunchHelper.createMap();
        gameLaunchHelper.populateMap();

        EntityVendor.createNewSummonerPlayer("Dave",Map.getInstance().getMapAreas()[0].getSpawnPoint(), Map.getInstance().getMapAreas()[0]);
        //TODO: test can remove
        //Avatar.getInstance().getAbilityManager().addAbilities(new FireballAbility(Avatar.getInstance(),5,10,3,5));
        Avatar.getInstance().equipAbility1(new FireballAbility(Avatar.getInstance(),5,10,3,20));
        Avatar.getInstance().equipAbility2(new FanBlastAbility(Avatar.getInstance(),5,10,3,5));
        gameLaunchHelper.setActiveCameraView(Map.getInstance().getActiveMapArea());

        ViewObjectFactory.getInstance().initVOFactory(gameLaunchHelper.getAreaView());
        ViewObjectFactory.getInstance().createAvatarViewObject(Map.getInstance().getActiveMapArea().getSpawnPoint(), Avatar.getInstance());

        ViewEngine viewEngine = ViewEngine.getInstance();
        viewEngine.registerView(gameLaunchHelper.getAreaView());
        ListStructure listStructure = new ListStructure(7,2, 15, 0);
        StatsView statsView = new StatsView(Avatar.getInstance().getStats(),listStructure);
        Inventory inventory = Avatar.getInstance().getInventory();
        InventoryView inventoryView = new InventoryView(inventory, new GridStructure(6,4));
        EquipmentView equipmentView = new EquipmentView(Avatar.getInstance().getEquipment());
        AvatarIESView avatarIESView = new AvatarIESView(inventoryView, statsView, equipmentView);
        ViewManager vm = new ViewManager(gameLaunchHelper.getAreaView(), avatarIESView);
        viewEngine.registerView(vm);
        vm.addView(gameLaunchHelper.getAreaView());
        ModelEngine.getInstance().start();
        MainController mainController = MainController.getInstance();

        InputState avatarState = new AvatarState();


        // TODO: 4/17/16 Do same for Equipment 
        inventory.addToActionSet(ActionVendor.createSelectUpAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectRightAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectLeftAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectDownAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectItemAction(inventoryView));



        InputState inventoryState = new InventoryState(inventory);
        mainController.setActiveState(avatarState);

        Thread.sleep(2000);
        System.out.println("Setting active state");

    }
}
