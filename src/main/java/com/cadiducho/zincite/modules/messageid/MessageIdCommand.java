package com.cadiducho.zincite.modules.messageid;

import com.cadiducho.telegrambotapi.Chat;
import com.cadiducho.telegrambotapi.Message;
import com.cadiducho.telegrambotapi.User;
import com.cadiducho.telegrambotapi.exception.TelegramException;
import com.cadiducho.zincite.api.command.BotCommand;
import com.cadiducho.zincite.api.command.CommandContext;
import com.cadiducho.zincite.api.command.CommandInfo;
import com.cadiducho.zincite.api.module.ZinciteModule;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Log
@CommandInfo(module = MessageIdModule.class, aliases = {"/messageid"}, hidden=true)
public class MessageIdCommand implements BotCommand {

    @Override
    public void execute(final Chat chat, final User from, final CommandContext context, final Integer messageId, final Message replyingTo, Instant instant) throws TelegramException {
        if (replyingTo == null) {
            getBot().sendMessage(chat.getId(), "No estás responiendo a ningún mensaje, no puedo adivinar su id");
            return;
        }

        StringBuilder info = new StringBuilder();
        info.append("Message id: " + replyingTo.getMessageId().toString());
        info.append('\n');

        if (replyingTo.getVideo() != null) {
            info.append("Video file id: " + replyingTo.getVideo().getFileId());
        }
        if (replyingTo.getAudio() != null) {
            info.append("Audio file id: " + replyingTo.getAudio().getFileId());
        }
        if (replyingTo.getVoice() != null) {
            info.append("Voice file id: " + replyingTo.getVoice().getFileId());
        }
        if (replyingTo.getVideoNote() != null) {
            info.append("Video note file id: " + replyingTo.getVideoNote().getFileId());
        }
        if (replyingTo.getAnimation() != null) {
            info.append("Animation file id: " + replyingTo.getAnimation().getFileId());
        }
        if (replyingTo.getPhoto() != null) {
            info.append("Photo file id: " + replyingTo.getPhoto().get(0).getFileId());
        }
        if (replyingTo.getSticker() != null) {
            info.append("Sticker file id: " + replyingTo.getSticker().getFileId());
        }

        getBot().sendMessage(chat.getId(), info.toString());
    }
}