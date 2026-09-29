package com.morecritters.mod.network;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.procedures.NumButtonClick1Procedure;
import com.morecritters.mod.procedures.NumButtonClick2Procedure;
import com.morecritters.mod.procedures.NumButtonClick3Procedure;
import com.morecritters.mod.procedures.NumButtonClick4Procedure;
import com.morecritters.mod.procedures.NumButtonClick5Procedure;
import com.morecritters.mod.procedures.NumButtonClick6Procedure;
import com.morecritters.mod.procedures.PageFlipCorpseCrew2Procedure;
import com.morecritters.mod.procedures.PageFlipRoot2Procedure;
import com.morecritters.mod.world.inventory.CritterAtlasCorpseCrewMenu;
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
public record CritterAtlasCorpseCrewButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
    public static final Type<CritterAtlasCorpseCrewButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, "critter_atlas_corpse_crew_button_message"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CritterAtlasCorpseCrewButtonMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }, buffer -> new CritterAtlasCorpseCrewButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

    @Override
    public Type<CritterAtlasCorpseCrewButtonMessage> type() {
        return TYPE;
    }

    public static void handleData(CritterAtlasCorpseCrewButtonMessage message, IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = CritterAtlasCorpseCrewMenu.guistate;
        if (world.hasChunkAt(new BlockPos(x, y, z))) {
            if (buttonID == 0) {
                PageFlipRoot2Procedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 1) {
                PageFlipCorpseCrew2Procedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 2) {
                NumButtonClick1Procedure.execute(entity);
            }

            if (buttonID == 3) {
                NumButtonClick2Procedure.execute(entity);
            }

            if (buttonID == 4) {
                NumButtonClick3Procedure.execute(entity);
            }

            if (buttonID == 5) {
                NumButtonClick4Procedure.execute(entity);
            }

            if (buttonID == 6) {
                NumButtonClick5Procedure.execute(entity);
            }

            if (buttonID == 7) {
                NumButtonClick6Procedure.execute(entity);
            }
        }
    }

    @SubscribeEvent
    public static void registerMessage(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToServer(TYPE, STREAM_CODEC, CritterAtlasCorpseCrewButtonMessage::handleData);
    }
}
