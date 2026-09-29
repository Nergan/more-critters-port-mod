package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.CobbleEntity;
import com.morecritters.mod.entity.CritterEaterEntity;
import com.morecritters.mod.entity.CubefrogEntity;
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
import com.morecritters.mod.entity.ScowlEntity;
import com.morecritters.mod.entity.SnekEntity;
import com.morecritters.mod.entity.StalkEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class CritterlingSackRightclickMobProcedure {
    @SubscribeEvent
    public static void onRightClickEntity(EntityInteract event) {
        if (event.getHand() == event.getEntity().getUsedItemHand()) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                == MoreCrittersModItems.CRITTERLING_SACK.get()) {
                if (entity instanceof CubefrogEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof CubefrogEntity _datEntI ? _datEntI.getEntityData().get(CubefrogEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof CubefrogEntity _datEntI ? _datEntI.getEntityData().get(CubefrogEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof CubefrogEntity _datEntI ? _datEntI.getEntityData().get(CubefrogEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof DungerEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof DungerEntity _datEntI ? _datEntI.getEntityData().get(DungerEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DUNGER.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof DungerEntity _datEntI ? _datEntI.getEntityData().get(DungerEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DUNGER_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof DungerEntity _datEntI ? _datEntI.getEntityData().get(DungerEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DUNGER_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof PlainswyrmEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof PlainswyrmEntity _datEntI ? _datEntI.getEntityData().get(PlainswyrmEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof PlainswyrmEntity _datEntI ? _datEntI.getEntityData().get(PlainswyrmEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof PlainswyrmEntity _datEntI ? _datEntI.getEntityData().get(PlainswyrmEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof RollballEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof ScowlEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof ScowlEntity _datEntI ? _datEntI.getEntityData().get(ScowlEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SCOWL.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof ScowlEntity _datEntI ? _datEntI.getEntityData().get(ScowlEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SCOWL_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof ScowlEntity _datEntI ? _datEntI.getEntityData().get(ScowlEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SCOWL_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof ExpyEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof ExpyEntity _datEntI ? _datEntI.getEntityData().get(ExpyEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_EXPY.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof ExpyEntity _datEntI ? _datEntI.getEntityData().get(ExpyEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_EXPY_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof ExpyEntity _datEntI ? _datEntI.getEntityData().get(ExpyEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_EXPY_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof SnekEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof SnekEntity _datEntI ? _datEntI.getEntityData().get(SnekEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SNEK.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof SnekEntity _datEntI ? _datEntI.getEntityData().get(SnekEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SNEK_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof SnekEntity _datEntI ? _datEntI.getEntityData().get(SnekEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SNEK_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof OpalcrabEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof MothkidEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MOTHKID.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MOTHKID_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MOTHKID_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof GillmunchEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof GillmunchEntity _datEntI ? _datEntI.getEntityData().get(GillmunchEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof GillmunchEntity _datEntI ? _datEntI.getEntityData().get(GillmunchEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof GillmunchEntity _datEntI ? _datEntI.getEntityData().get(GillmunchEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof StalkEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof StalkEntity _datEntI ? _datEntI.getEntityData().get(StalkEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_STALK.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof StalkEntity _datEntI ? _datEntI.getEntityData().get(StalkEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_STALK_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof StalkEntity _datEntI ? _datEntI.getEntityData().get(StalkEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_STALK_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof DominicEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof DominicEntity _datEntI ? _datEntI.getEntityData().get(DominicEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DOMINIC.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof DominicEntity _datEntI ? _datEntI.getEntityData().get(DominicEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DOMINIC_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof DominicEntity _datEntI ? _datEntI.getEntityData().get(DominicEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DOMINIC_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof OlmerEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof OlmerEntity _datEntI ? _datEntI.getEntityData().get(OlmerEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OLMER.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof OlmerEntity _datEntI ? _datEntI.getEntityData().get(OlmerEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OLMER_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof OlmerEntity _datEntI ? _datEntI.getEntityData().get(OlmerEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OLMER_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof FlargEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof FlargEntity _datEntI ? _datEntI.getEntityData().get(FlargEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FLARG.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof FlargEntity _datEntI ? _datEntI.getEntityData().get(FlargEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FLARG_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof FlargEntity _datEntI ? _datEntI.getEntityData().get(FlargEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FLARG_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof PiranheedEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof PiranheedEntity _datEntI ? _datEntI.getEntityData().get(PiranheedEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof PiranheedEntity _datEntI ? _datEntI.getEntityData().get(PiranheedEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof PiranheedEntity _datEntI ? _datEntI.getEntityData().get(PiranheedEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof MangotriceEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof MangotriceEntity _datEntI ? _datEntI.getEntityData().get(MangotriceEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof MangotriceEntity _datEntI ? _datEntI.getEntityData().get(MangotriceEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof MangotriceEntity _datEntI ? _datEntI.getEntityData().get(MangotriceEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof FresnoidEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FRESNOID.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FRESNOID_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FRESNOID_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof CobbleEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof CobbleEntity _datEntI ? _datEntI.getEntityData().get(CobbleEntity.DATA_variant) : 0) == 0) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_COBBLE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof CobbleEntity _datEntI ? _datEntI.getEntityData().get(CobbleEntity.DATA_variant) : 0) == 1) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_COBBLE_RARE.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if ((entity instanceof CobbleEntity _datEntI ? _datEntI.getEntityData().get(CobbleEntity.DATA_variant) : 0) == 2
                        && sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_COBBLE_EPIC.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (entity instanceof CritterEaterEntity) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.pick_up")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_CRITTER_EATER.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                }
            }
        }
    }
}
