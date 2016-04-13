package com.wrathOfLoD.Models.RangedEffect.REG;

import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactory;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

import java.util.List;

/**
 * Created by luluding on 4/9/16.
 */
public class ConicalREG extends RangedEffectGenerator {

    public ConicalREG(int totalDistance, Position entityLocation, int damage, int travelTime, HitBoxFactory hitBoxFactory){
        super(totalDistance, entityLocation, damage, travelTime, hitBoxFactory);
    }


    @Override
    public List<Position> getEffectiveLocations(int radius, Position orignalPos) {
        return null;
    }
}
