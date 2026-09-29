package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.network.MoreCrittersModVariables;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CritterlingSackCubefrogItemInInventoryTickProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadCubefrog = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadPlainswyrm = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DUNGER.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DUNGER_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DUNGER_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadDunger = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SNEK.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SNEK_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SNEK_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadSnek = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_EXPY.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_EXPY_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_EXPY_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadExpy = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SCOWL.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SCOWL_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SCOWL_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadScowl = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadRollball = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadOpalcrab = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MOTHKID.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MOTHKID_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MOTHKID_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadMothkid = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadGillmunch = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_STALK.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_STALK_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_STALK_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadStalk = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DOMINIC.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DOMINIC_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DOMINIC_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadDominc = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OLMER.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OLMER_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OLMER_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadOlmer = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FLARG.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FLARG_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FLARG_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadFlarg = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadPiranheed = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadMangotrice = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FRESNOID.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FRESNOID_RARE.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FRESNOID_EPIC.get())) : false)) {
                boolean _setval = true;
                {
    MoreCrittersModVariables.PlayerVariables capability = entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES);
                    capability.HadFresnoid = _setval;
                    capability.syncPlayerVariables(entity);
                }
            }

            if (entity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:obtain_critterling"));
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
