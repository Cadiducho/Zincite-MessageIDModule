package com.cadiducho.zincite.modules.messageid;

import com.cadiducho.zincite.ZinciteBot;
import com.cadiducho.zincite.api.command.CommandManager;
import com.cadiducho.zincite.api.module.ModuleInfo;
import com.cadiducho.zincite.api.module.ZinciteModule;
import lombok.extern.java.Log;

@Log
@ModuleInfo(name = MessageIdModule.MODULE_NAME, description = "Utilidad para obtener las ids de mensajes recibidos")
public class MessageIdModule implements ZinciteModule {

    public static final String MODULE_NAME = "MessageIdModule";
    private CommandManager commandManager;

    @Override
    public void onLoad() {
        this.commandManager = ZinciteBot.getInstance().getCommandManager();

        commandManager.register(new MessageIdCommand());
        log.info("Zincite Message id module loaded");
    }
}
