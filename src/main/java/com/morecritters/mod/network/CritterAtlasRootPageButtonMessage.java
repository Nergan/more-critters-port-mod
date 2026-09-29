package com.morecritters.mod.network;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.procedures.PageFlipAvoiderProcedure;
import com.morecritters.mod.procedures.PageFlipBalloonRatProcedure;
import com.morecritters.mod.procedures.PageFlipBlubberfishProcedure;
import com.morecritters.mod.procedures.PageFlipBombJellyProcedure;
import com.morecritters.mod.procedures.PageFlipBouncelizardProcedure;
import com.morecritters.mod.procedures.PageFlipBunbugProcedure;
import com.morecritters.mod.procedures.PageFlipCreeblossomProcedure;
import com.morecritters.mod.procedures.PageFlipCritterlingProcedure;
import com.morecritters.mod.procedures.PageFlipIropodProcedure;
import com.morecritters.mod.procedures.PageFlipKelpireProcedure;
import com.morecritters.mod.procedures.PageFlipMightshroomProcedure;
import com.morecritters.mod.procedures.PageFlipNauticrawlProcedure;
import com.morecritters.mod.procedures.PageFlipRoot2Procedure;
import com.morecritters.mod.procedures.PageFlipShimmerwingProcedure;
import com.morecritters.mod.procedures.PageFlipShriekbatProcedure;
import com.morecritters.mod.procedures.PageFlipSnowflakeSpiderProcedure;
import com.morecritters.mod.procedures.PageFlipStincarpProcedure;
import com.morecritters.mod.procedures.PageFlipWarptrapProcedure;
import com.morecritters.mod.procedures.PartyhatclickProcedure;
import com.morecritters.mod.world.inventory.CritterAtlasRootPageMenu;
import java.util.HashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record CritterAtlasRootPageButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
    public static final Type<CritterAtlasRootPageButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, "critter_atlas_root_page_button_message"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CritterAtlasRootPageButtonMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }, buffer -> new CritterAtlasRootPageButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

    @Override
    public Type<CritterAtlasRootPageButtonMessage> type() {
        return TYPE;
    }

    public static void handleData(CritterAtlasRootPageButtonMessage message, IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = CritterAtlasRootPageMenu.guistate;
        if (world.hasChunkAt(new BlockPos(x, y, z))) {
            if (buttonID == 0) {
                PageFlipBunbugProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 1) {
                PageFlipSnowflakeSpiderProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 2) {
                PageFlipShriekbatProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 3) {
                PageFlipCreeblossomProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 4) {
                PageFlipBouncelizardProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 5) {
                PageFlipStincarpProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 6) {
                PageFlipBalloonRatProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 7) {
                PageFlipWarptrapProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 8) {
                PageFlipShimmerwingProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 9) {
                PageFlipMightshroomProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 10) {
                PageFlipBombJellyProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 11) {
                PageFlipAvoiderProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 12) {
                PageFlipIropodProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 13) {
                PageFlipBlubberfishProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 14) {
                PageFlipKelpireProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 15) {
                PageFlipNauticrawlProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 16) {
                PageFlipRoot2Procedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 17) {
                PageFlipCritterlingProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 18) {
                PartyhatclickProcedure.execute(world, x, y, z);
            }
        }
    }

    @SubscribeEvent
    public static void registerMessage(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToServer(TYPE, STREAM_CODEC, CritterAtlasRootPageButtonMessage::handleData);
    }
}
