package org.geyser.extension.exampleid;

import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.lifecycle.GeyserDefineResourcePacksEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPreInitializeEvent;
import org.geysermc.geyser.api.extension.Extension;

import java.nio.file.Path;

/**
 * The main class of your extension - must implement extension, and be in the extension.yml file.
 * See {@link Extension} for available methods - for example to get the path to the configuration folder.
 */
public class ExtensionMain implements Extension {

    /*
     * Registering custom items/blocks, or adding resource packs (and basically all other events that are fired before Geyser initializes fully)
     * are done in their respective events. See below for an example:
     */
    @Subscribe
    public void onGeyserLoadResourcePacksEvent(GeyserDefineResourcePacksEvent event) {
        logger().info("Loading: " + event.resourcePacks().size() + " resource packs.");
    }

    @Subscribe
    public void onGeyserPreInitializeEvent(GeyserDefineCustomItemsEvent event) {
        CustomItemData andesite_alloy = CustomItemData.builder()
                .name("andesite_alloy")
                .customItemOptions(CustomItemOptions.builder().customModelData(1).build())
                .textureSize(16)
                .creativeCategory(CreativeCategory.ITEMS.id())
                .build();
        event.register("create:andesite_alloy", andesite_alloy);

    }
    /*
     * You can use the GeyserPostInitializeEvent to run anything after Geyser fully initialized and is ready to accept bedrock player connections.
     */
    @Subscribe
    public void onPostInitialize(GeyserPostInitializeEvent event) {
        this.logger().info("Loading %s...".formatted(this.description().name()));

        //example: accessing extension data folder
        Path exampleDataFolder = this.dataFolder();
        this.logger().info(exampleDataFolder.toString());
    }

    /**
     * You can reload your extension - for example, reload the extension config - by listening to Geyser's
     * {@link org.geysermc.geyser.api.event.lifecycle.GeyserPreReloadEvent}
     */
        @Subscribe
    public void onPreInitialize(GeyserPreInitializeEvent event) {
        this.logger().info("");
        this.logger().info("----------------------------------------------");
        this.logger().info("Create: Geyser");
        this.logger().info("By: Turkey");
        this.logger().info("----------------------------------------------");
        this.logger().info("");
    }@Subscribe
    public void onGeyserReload(GeyserPreInitializeEvent event) {
        this.logger().info("Reloading %s!".formatted(this.description().name()));
    }

}
