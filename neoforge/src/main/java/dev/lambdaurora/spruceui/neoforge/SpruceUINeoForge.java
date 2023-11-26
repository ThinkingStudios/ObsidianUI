package dev.lambdaurora.spruceui.neoforge;

import dev.lambdaurora.spruceui.SpruceUI;
import dev.lambdaurora.spruceui.neoforge.event.ForgeClientEventsHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.network.NetworkConstants;

@Mod(SpruceUI.MODID)
public class SpruceUINeoForge {
    public static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    public SpruceUINeoForge() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        if (FMLLoader.getDist().isClient()) {
            ForgeClientEventsHandler.initialize();
        }
    }
}
