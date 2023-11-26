package dev.lambdaurora.spruceui.forge;

import dev.lambdaurora.spruceui.SpruceUI;
import dev.lambdaurora.spruceui.forge.event.ForgeClientEventsHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SpruceUI.MODID)
public class SpruceUIForge {
    public static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
    public SpruceUIForge() {
        MinecraftForge.EVENT_BUS.register(ForgeClientEventsHandler.class);
    }
}
