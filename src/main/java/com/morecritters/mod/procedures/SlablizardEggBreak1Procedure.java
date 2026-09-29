package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModEnchantments;
import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class SlablizardEggBreak1Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity != null) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                if ((
                        blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip2
                            ? blockstate.getValue(_getip2)
                            : -1
                    )
                    == 2) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var22) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    int _value = 0;
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    _bso = world.getBlockState(_pos);
                    if (_bso.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, _bso.setValue(_integerProp, _value), 3);
                    }
                } else if ((
                        blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6
                            ? blockstate.getValue(_getip6)
                            : -1
                    )
                    == 3) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var21) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    int _value = 2;
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    _bso = world.getBlockState(_pos);
                    if (_bso.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, _bso.setValue(_integerProp, _value), 3);
                    }
                } else if ((
                        blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip10
                            ? blockstate.getValue(_getip10)
                            : -1
                    )
                    == 4) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var20) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    int _value = 3;
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    _bso = world.getBlockState(_pos);
                    if (_bso.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerPropx
                        && _integerPropx.getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, _bso.setValue(_integerPropx, _value), 3);
                    }
                }

                if (MoreCrittersModEnchantments.getLevel(
                            Enchantments.SILK_TOUCH, entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY
                        )
                        != 0
                    && world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModBlocks.BOUNCELIZARD_EGG.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
            }
        }
    }
}
