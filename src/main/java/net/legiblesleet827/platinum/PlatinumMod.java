package net.legiblesleet827.platinum;

import net.legiblesleet827.platinum.setup.Registration;
import net.legiblesleet827.platinum.world.OreGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PlatinumMod.MOD_ID)
public class PlatinumMod {
    public static final String MOD_ID = "platinum";
    private static final Logger LOGGER = LogManager.getLogger();

    public PlatinumMod() {
        Registration.register();

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        MinecraftForge.EVENT_BUS.register(this);
    }
}