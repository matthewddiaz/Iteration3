package com.wrathOfLoD.Views.CameraView;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Observers.ViewObjectObservers.MovableVOObserver;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ViewObjects.ModelViewObject;

/**
 * Created by luluding on 4/17/16.
 */
public class CameraCenter implements MovableVOObserver{

    private Position cameraCenter;

    public CameraCenter(){
        this.cameraCenter = Avatar.getInstance().getPosition();
    }

    private void setCameraCenter(Position pos){
        this.cameraCenter = pos;
    }

    @Override
    public void notifyOnMove(ModelViewObject mvo, Position src, Position dest, Direction dir, int ticks) {
        setCameraCenter(dest);
    }
}
