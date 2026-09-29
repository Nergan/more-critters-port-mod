package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.DominicEntity;
import com.morecritters.mod.entity.DungerEntity;
import com.morecritters.mod.entity.ExpyEntity;
import com.morecritters.mod.entity.FlargEntity;
import com.morecritters.mod.entity.FresnoidEntity;
import com.morecritters.mod.entity.GillmunchEntity;
import com.morecritters.mod.entity.MangotriceEntity;
import com.morecritters.mod.entity.MothkidEntity;
import com.morecritters.mod.entity.OlmerEntity;
import com.morecritters.mod.entity.OpalcrabEntity;
import com.morecritters.mod.entity.PiranheedEntity;
import com.morecritters.mod.entity.PlainswyrmEntity;
import com.morecritters.mod.entity.RollballEntity;
import com.morecritters.mod.entity.SnekEntity;
import com.morecritters.mod.entity.StalkEntity;
import net.minecraft.world.entity.Entity;

public class DanceTickProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null) {
            return false;
        } else if (entity instanceof PlainswyrmEntity
            && !((PlainswyrmEntity)entity).animationprocedure.equals("dance")
            && !((PlainswyrmEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof DungerEntity
            && !((DungerEntity)entity).animationprocedure.equals("dance")
            && !((DungerEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof RollballEntity
            && !((RollballEntity)entity).animationprocedure.equals("dance")
            && !((RollballEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof SnekEntity
            && !((SnekEntity)entity).animationprocedure.equals("dance")
            && !((SnekEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof ExpyEntity
            && !((ExpyEntity)entity).animationprocedure.equals("dance")
            && !((ExpyEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof OpalcrabEntity
            && !((OpalcrabEntity)entity).animationprocedure.equals("dance")
            && !((OpalcrabEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof GillmunchEntity
            && !((GillmunchEntity)entity).animationprocedure.equals("dance")
            && !((GillmunchEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof MothkidEntity
            && !((MothkidEntity)entity).animationprocedure.equals("dance")
            && !((MothkidEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof StalkEntity
            && !((StalkEntity)entity).animationprocedure.equals("dance")
            && !((StalkEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof DominicEntity
            && !((DominicEntity)entity).animationprocedure.equals("dance")
            && !((DominicEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof OlmerEntity
            && !((OlmerEntity)entity).animationprocedure.equals("dance")
            && !((OlmerEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof FlargEntity
            && !((FlargEntity)entity).animationprocedure.equals("dance")
            && !((FlargEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else if (entity instanceof PiranheedEntity
            && !((PiranheedEntity)entity).animationprocedure.equals("dance")
            && !((PiranheedEntity)entity).animationprocedure.equals("dance_epic")) {
            return true;
        } else {
            return entity instanceof MangotriceEntity
                    && !((MangotriceEntity)entity).animationprocedure.equals("dance")
                    && !((MangotriceEntity)entity).animationprocedure.equals("dance_epic")
                ? true
                : entity instanceof FresnoidEntity
                    && !((FresnoidEntity)entity).animationprocedure.equals("dance")
                    && !((FresnoidEntity)entity).animationprocedure.equals("dance_epic");
        }
    }
}
