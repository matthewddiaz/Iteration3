package com.wrathOfLoD.Models.Occupation;

import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FanBlastAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FireballAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.RadialBombBlastAbility;
import com.wrathOfLoD.Models.Ability.Abilities.PickPocketAbility;
import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.SmasherWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons.SneakWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.StaffWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.SummonerWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Skill.SummonerSkillManager;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by zach on 4/7/16.
 */

public class Summoner extends Occupation {

    public Summoner() {
        StatsModifiable statsModifiable = StatsModifiable.createGenericStatsModifiable(1,1,5,1,0);
        setStatsModifiable(statsModifiable);
    }

    public void levelUp(Stats stats) {}

    @Override
    public  boolean canEquip(SmasherWeapon weapon){
        return false;
    }

    @Override
    public  boolean canEquip(SneakWeapon weapon){
        return false;
    }

    @Override
    public  boolean canEquip(SummonerWeapon weapon){
        return true;
    }


    @Override
    public SkillManager createSkillManager() {
        return new SummonerSkillManager();
    }

    @Override
    public Weapon createWeapon(){
        return new StaffWeapon();
    }

    public void addAbilities(AbilityManager abilityManager){
        super.addAbilities(abilityManager);
        Character character = abilityManager.getCharacter();

        abilityManager.addAbilities(new FireballAbility(character, 5, 10, 5, 10));
        abilityManager.addAbilities(new FanBlastAbility(3, character, 5, 10, 5, 10));
        abilityManager.addAbilities(new RadialBombBlastAbility(5, character, 5, 10,5, 10));
    }
}