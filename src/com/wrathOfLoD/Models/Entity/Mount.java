package com.wrathOfLoD.Models.Entity;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.MountCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.CanMoveVisitor;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

/**
 * Created by zach on 4/7/16.
 */
public class Mount extends Entity {
    private Character rider;

    public Mount(String name, Position position, CanMoveVisitor canMoveVisitor) {
        super(name, position, canMoveVisitor);
    }

	public void mount(Character rider) {
        if (rider.equals(this.rider)) {
            this.rider = null;
        } else {
            this.rider = rider;
        }
        System.out.println("MY rider is: " + this.rider);
//        ActionCommand mountCommand = new MountCommand(this, rider);
//        mountCommand.execute();
    }

    public void accept(EntityVisitor ev){
        ev.visitMount(this);
    }

	@Override
	public void hideTiles(){
		//mixed-instance can be icky, but necessary
	}

	@Override
	public void showTiles(){
		//mixed-instance can be icky, but necessary
	}

}
