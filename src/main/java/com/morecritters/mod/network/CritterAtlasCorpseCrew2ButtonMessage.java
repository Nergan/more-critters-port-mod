package com.morecritters.mod.network;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.procedures.PageFlipCorpseCrew3Procedure;
import com.morecritters.mod.procedures.PageFlipCorpseCrewProcedure;
import com.morecritters.mod.world.inventory.CritterAtlasCorpseCrew2Menu;
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
public record CritterAtlasCorpseCrew2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
    public static final Type<CritterAtlasCorpseCrew2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, "critter_atlas_corpse_crew2_button_message"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CritterAtlasCorpseCrew2ButtonMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }, buffer -> new CritterAtlasCorpseCrew2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

    @Override
    public Type<CritterAtlasCorpseCrew2ButtonMessage> type() {
        return TYPE;
    }

    public static void handleData(CritterAtlasCorpseCrew2ButtonMessage message, IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = CritterAtlasCorpseCrew2Menu.guistate;
        if (world.hasChunkAt(new BlockPos(x, y, z))) {
            if (buttonID == 0) {
                PageFlipCorpseCrewProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 1) {
                PageFlipCorpseCrew3Procedure.execute(world, x, y, z, entity);
            }
        }
    }

    @SubscribeEvent
    public static void registerMessage(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToServer(TYPE, STREAM_CODEC, CritterAtlasCorpseCrew2ButtonMessage::handleData);
    }
}
