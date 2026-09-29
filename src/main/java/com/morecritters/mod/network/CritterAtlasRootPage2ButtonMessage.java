package com.morecritters.mod.network;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.procedures.PageFlipArmossilloProcedure;
import com.morecritters.mod.procedures.PageFlipCorpseCrewProcedure;
import com.morecritters.mod.procedures.PageFlipCustodianProcedure;
import com.morecritters.mod.procedures.PageFlipDripperProcedure;
import com.morecritters.mod.procedures.PageFlipGravediggerProcedure;
import com.morecritters.mod.procedures.PageFlipNervoidProcedure;
import com.morecritters.mod.procedures.PageFlipRamchuProcedure;
import com.morecritters.mod.procedures.PageFlipRootProcedure;
import com.morecritters.mod.procedures.PageFlipShadeletProcedure;
import com.morecritters.mod.procedures.PageFlipTreepletProcedure;
import com.morecritters.mod.world.inventory.CritterAtlasRootPage2Menu;
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
public record CritterAtlasRootPage2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
    public static final Type<CritterAtlasRootPage2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, "critter_atlas_root_page2_button_message"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CritterAtlasRootPage2ButtonMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }, buffer -> new CritterAtlasRootPage2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

    @Override
    public Type<CritterAtlasRootPage2ButtonMessage> type() {
        return TYPE;
    }

    public static void handleData(CritterAtlasRootPage2ButtonMessage message, IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = CritterAtlasRootPage2Menu.guistate;
        if (world.hasChunkAt(new BlockPos(x, y, z))) {
            if (buttonID == 0) {
                PageFlipShadeletProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 1) {
                PageFlipTreepletProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 2) {
                PageFlipNervoidProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 3) {
                PageFlipCorpseCrewProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 4) {
                PageFlipRootProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 5) {
                PageFlipGravediggerProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 6) {
                PageFlipArmossilloProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 7) {
                PageFlipRamchuProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 8) {
                PageFlipDripperProcedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 9) {
                PageFlipCustodianProcedure.execute(world, x, y, z, entity);
            }
        }
    }

    @SubscribeEvent
    public static void registerMessage(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToServer(TYPE, STREAM_CODEC, CritterAtlasRootPage2ButtonMessage::handleData);
    }
}
