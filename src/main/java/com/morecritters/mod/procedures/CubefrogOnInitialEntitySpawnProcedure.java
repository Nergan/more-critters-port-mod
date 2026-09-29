package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CubefrogEntity;
import com.morecritters.mod.entity.DominicEntity;
import com.morecritters.mod.entity.DungerEntity;
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
import com.morecritters.mod.entity.ScowlEntity;
import com.morecritters.mod.entity.SnekEntity;
import com.morecritters.mod.entity.StalkEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class CubefrogOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof CubefrogEntity) {
                if (entity instanceof CubefrogEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(CubefrogEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }

                if (entity instanceof CubefrogEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(CubefrogEntity.DATA_jump, Mth.nextInt(RandomSource.create(), 60, 200));
                }
            } else if (entity instanceof PlainswyrmEntity) {
                if (entity instanceof PlainswyrmEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(PlainswyrmEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof DungerEntity) {
                if (entity instanceof DungerEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(DungerEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof SnekEntity) {
                if (entity instanceof SnekEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(SnekEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof ScowlEntity) {
                if (entity instanceof ScowlEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(ScowlEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }

                if (entity instanceof ScowlEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(ScowlEntity.DATA_jump, Mth.nextInt(RandomSource.create(), 60, 200));
                }
            } else if (entity instanceof RollballEntity) {
                if (entity instanceof RollballEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(RollballEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }

                if (entity instanceof RollballEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(RollballEntity.DATA_roll, Mth.nextInt(RandomSource.create(), 60, 200));
                }
            } else if (entity instanceof OpalcrabEntity) {
                if (entity instanceof OpalcrabEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(OpalcrabEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof MothkidEntity) {
                if (entity instanceof MothkidEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(MothkidEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }

                if (entity instanceof MothkidEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(MothkidEntity.DATA_jump, Mth.nextInt(RandomSource.create(), 60, 200));
                }
            } else if (entity instanceof GillmunchEntity) {
                if (entity instanceof GillmunchEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(GillmunchEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof StalkEntity) {
                if (entity instanceof StalkEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(StalkEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof DominicEntity) {
                if (entity instanceof DominicEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(DominicEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof OlmerEntity) {
                if (entity instanceof OlmerEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(OlmerEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof FlargEntity) {
                if (entity instanceof FlargEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(FlargEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof PiranheedEntity) {
                if (entity instanceof PiranheedEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(PiranheedEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof MangotriceEntity) {
                if (entity instanceof MangotriceEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(MangotriceEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }
            } else if (entity instanceof FresnoidEntity && entity instanceof FresnoidEntity _datEntSetI) {
                _datEntSetI.getEntityData().set(FresnoidEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
            }
        }
    }
}
