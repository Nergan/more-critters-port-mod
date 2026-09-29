package com.morecritters.mod.network;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.procedures.PageFlipMightshroom3Procedure;
import com.morecritters.mod.procedures.PageFlipMightshroomProcedure;
import com.morecritters.mod.world.inventory.CritterAtlasMightshroom2Menu;
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
public record CritterAtlasMightshroom2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
    public static final Type<CritterAtlasMightshroom2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, "critter_atlas_mightshroom2_button_message"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CritterAtlasMightshroom2ButtonMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }, buffer -> new CritterAtlasMightshroom2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

    @Override
    public Type<CritterAtlasMightshroom2ButtonMessage> type() {
        return TYPE;
    }

    public static void handleData(CritterAtlasMightshroom2ButtonMessage message, IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = CritterAtlasMightshroom2Menu.guistate;
        if (world.hasChunkAt(new BlockPos(x, y, z))) {
            if (buttonID == 0) {
                PageFlipMightshroomProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 1) {
                PageFlipMightshroom3Procedure.execute(world, x, y, z, entity);
            }
        }
    }

    @SubscribeEvent
    public static void registerMessage(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToServer(TYPE, STREAM_CODEC, CritterAtlasMightshroom2ButtonMessage::handleData);
    }
}
