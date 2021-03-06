package com.wrathOfLoD.Models.Commands.FogOfWarActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.TilePillar;
import com.wrathOfLoD.Utility.ModelConfig;
import com.wrathOfLoD.Utility.Position;

import java.util.List;

/**
 * Created by Mitchell on 4/17/2016.
 */
public class InvisibleTilesCommand extends ActionCommand{

	List<Position> positions;

	public InvisibleTilesCommand(Position origin){
		this.positions = Position.drawCircle(origin, ModelConfig.getAvatarVisibleRadius(), true);
	}

	@Override
	public void execute(){
		for(Position pos: positions){
			TilePillar pillar = Map.getInstance().getTilePillar(pos);
			if(pillar != null){
				pillar.setVisible(false);
			}
		}
	}
}
