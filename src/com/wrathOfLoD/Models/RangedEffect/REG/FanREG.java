package com.wrathOfLoD.Models.RangedEffect.REG;

import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories.HitBoxFactory;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

import java.util.List;

/**
 * Created by luluding on 4/9/16.
 */
public class FanREG extends RangedEffectGenerator {
    private Direction facingDirection;

    public FanREG(int totalDistance, Position entityLocation, int damage, int travelTime, HitBoxFactory hitBoxFactory, Direction facingDirection){
        super(totalDistance, entityLocation, damage, travelTime, hitBoxFactory);
        this.facingDirection = facingDirection;

        List<Position> pos = Position.drawWave(entityLocation, facingDirection, 3);

        for(Position p : pos){
            System.out.println("HB POS: " + p.getQ() + " " + p.getR() + " " + p.getH());
        }
    }

    @Override
    public List<Position> getEffectiveLocations(int radius, Position orignalPos) {
        return Position.drawWave(orignalPos, facingDirection, radius);
    }
}
