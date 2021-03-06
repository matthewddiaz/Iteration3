package com.wrathOfLoD.Views.SpriteMap;

import java.io.IOException;
import java.util.HashMap;


/**
 * Created by matthewdiaz on 4/16/16.
 */
public class SpriteTestOutPut {
    public static void main(String args[]) throws IOException {
        SpriteMap sm = new SpriteMap();
        sm.generateEntityMap();
        HashMap<SpriteMap.AvatarKey, ImageAnimation> h = sm.getAvatarMapMap();
        for(SpriteMap.AvatarKey str: h.keySet()){
            System.out.println(h.get(str));
            System.out.println("------------------------");
            System.out.println("The key is " + str.toString());
            System.out.println("---------------------");
            System.out.println("");
        }
    }
}
