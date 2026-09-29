package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.AncientCustodianEntity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class AncientCustodianRightClickedOnEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.ECHO_SHARD) {
                if ((entity instanceof AncientCustodianEntity _datEntI ? _datEntI.getEntityData().get(AncientCustodianEntity.DATA_fed) : 0) <= 3) {
                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.spin")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.spin")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                }

                if ((entity instanceof AncientCustodianEntity _datEntI ? _datEntI.getEntityData().get(AncientCustodianEntity.DATA_fed) : 0) <= 2
                    && entity instanceof AncientCustodianEntity _datEntSetI) {
                    _datEntSetI.getEntityData()
                        .set(
                            AncientCustodianEntity.DATA_fed,
                            (entity instanceof AncientCustodianEntity _datEntI ? _datEntI.getEntityData().get(AncientCustodianEntity.DATA_fed) : 0) + 1
                        );
                }

                if ((entity instanceof AncientCustodianEntity _datEntI ? _datEntI.getEntityData().get(AncientCustodianEntity.DATA_fed) : 0) == 3
                    && sourceentity instanceof ServerPlayer _player) {
                    AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:awaken_custodian"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                            _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
            }
        }
    }
}
