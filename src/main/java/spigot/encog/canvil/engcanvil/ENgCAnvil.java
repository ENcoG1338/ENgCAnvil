package spigot.encog.canvil.engcanvil;

import org.bukkit.plugin.java.JavaPlugin;

public final class ENgCAnvil extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("§aвключён. §fby ENcoG");
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new ENgEvent(this), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        getLogger().info("§cотключён. §fby ENcoG");
        // Plugin shutdown logic
    }

}
