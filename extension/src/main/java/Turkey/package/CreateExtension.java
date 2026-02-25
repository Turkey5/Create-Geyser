package Turkey.package;

import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.event.subscribe.Subscribe;

public final class CreateBedrockExtension implements Extension {
    @Subscribe
    public void onPostInit(GeyserPostInitializeEvent event) {
        logger.info("Create: Geyser sucessfully initialized");

        //future item regristry
    }
    
}
