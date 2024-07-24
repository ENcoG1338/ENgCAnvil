package spigot.encog.canvil.engcanvil;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

public class ENgEvent implements Listener {

    private FileConfiguration config;

    public ENgEvent(JavaPlugin plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onAnvil(PrepareAnvilEvent event) {
        try {
            ItemStack item1 = event.getInventory().getItem(0);
            ItemStack item2 = event.getInventory().getItem(1);
            ItemStack item3 = event.getInventory().getItem(2);
            if (item1 != null && item2 != null) {
                int EnchantLevel1 = item1.getEnchantmentLevel(Enchantment.DIG_SPEED);
                int EnchantLevel2 = item2.getEnchantmentLevel(Enchantment.DIG_SPEED);
                int maxDigSpeedLevel = config.getInt("enchantments.DIG_SPEED.max_level");

                if (EnchantLevel1 == EnchantLevel2 && item1.getType() == item2.getType() && EnchantLevel1 < maxDigSpeedLevel) {
                    item3.addUnsafeEnchantment(Enchantment.DIG_SPEED, EnchantLevel1 + 1);
                    event.setResult(item3);
                }

                int Enchant1 = item1.getEnchantmentLevel(Enchantment.DURABILITY);
                int Enchant2 = item2.getEnchantmentLevel(Enchantment.DURABILITY);
                int maxDurabilityLevel = config.getInt("enchantments.DURABILITY.max_level");

                if (Enchant1 == Enchant2 && item1.getType() == item2.getType() && Enchant1 < maxDurabilityLevel) {
                    item3.addUnsafeEnchantment(Enchantment.DURABILITY, Enchant1 + 1);
                    event.setResult(item3);
                }

                if (EnchantLevel1 != EnchantLevel2 && item1.getType() == item2.getType()) {
                    if (EnchantLevel1 > EnchantLevel2) {
                        item3.addUnsafeEnchantment(Enchantment.DIG_SPEED, EnchantLevel1);
                        event.setResult(item3);
                    } else if (EnchantLevel1 < EnchantLevel2) {
                        item3.addUnsafeEnchantment(Enchantment.DIG_SPEED, EnchantLevel2);
                        event.setResult(item3);
                    }
                }

                if (Enchant1 != Enchant2 && item1.getType() == item2.getType()) {
                    if (Enchant1 > Enchant2) {
                        item3.addUnsafeEnchantment(Enchantment.DURABILITY, Enchant1);
                        event.setResult(item3);
                    } else if (Enchant1 < Enchant2) {
                        item3.addUnsafeEnchantment(Enchantment.DURABILITY, Enchant2);
                        event.setResult(item3);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}