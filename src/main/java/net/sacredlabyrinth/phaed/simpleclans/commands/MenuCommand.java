package net.sacredlabyrinth.phaed.simpleclans.commands;

import net.sacredlabyrinth.phaed.simpleclans.*;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * @author phaed
 */
public class MenuCommand
{
    private List<String> menuItems = new LinkedList<String>();

    public MenuCommand()
    {
    }

    /**
     * Execute the command
     *
     * @param player
     */
    public void execute(Player player)
    {
        SimpleClans plugin = SimpleClans.getInstance();

        String headColor = plugin.getSettingsManager().getPageHeadingsColor();
        String subColor = plugin.getSettingsManager().getPageSubTitleColor();

        ClanPlayer cp = plugin.getClanManager().getClanPlayer(player);
        Clan clan = cp == null ? null : cp.getClan();

        boolean isLeader = cp != null && cp.isLeader();
        boolean isTrusted = cp != null && cp.isTrusted();
        boolean isVerified = clan != null && clan.isVerified();
        boolean isNonVerified = clan != null && !clan.isVerified();

        String clanCommand = plugin.getSettingsManager().getCommandClan();

        ChatBlock chatBlock = new ChatBlock();

        if (clan == null && plugin.getPermissionsManager().has(player, "simpleclans.leader.create"))
        {
            if (plugin.getSettingsManager().isePurchaseCreation())
            {
                chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.create.tag.name.1.purchase.a.new.clan"), clanCommand, ChatColor.WHITE));
            }
            else
            {
                chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.create.tag.name.1.create.a.new.clan"), clanCommand, ChatColor.WHITE));
            }
        }
        if (isNonVerified && plugin.getSettingsManager().isRequireVerification() && plugin.getSettingsManager().isePurchaseVerification())
        {
            chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.verify.1.purchase.verification.of.your.clan"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.anyone.list"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.list.1.lists.all.clans"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && plugin.getPermissionsManager().has(player, "simpleclans.member.profile"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.profile.1.view.your.clan.s.profile"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.anyone.profile"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.profile.tag.1.view.a.clan.s.profile"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.member.lookup"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.lookup.1.lookup.your.info"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.anyone.lookup"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.lookup.player.1.lookup.a.player.s.info"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.anyone.leaderboard"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.leaderboard.1.view.leaderboard"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.anyone.alliances"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.alliances.1.view.all.clan.alliances"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.anyone.rivalries"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.rivalries.1.view.all.clan.rivalries"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && plugin.getPermissionsManager().has(player, "simpleclans.member.roster"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.roster.1.view.your.clan.s.member.list"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.anyone.roster"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.roster.tag.1.view.a.clan.s.member.list"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isTrusted && plugin.getPermissionsManager().has(player, "simpleclans.member.vitals"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.vitals.1.view.your.clan.member.s.vitals"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isTrusted && plugin.getPermissionsManager().has(player, "simpleclans.member.coords"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.coords.1.view.your.clan.member.s.coordinates"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isTrusted && plugin.getPermissionsManager().has(player, "simpleclans.member.stats"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.stats.1.view.your.clan.member.s.stats"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isTrusted && plugin.getPermissionsManager().has(player, "simpleclans.member.kills"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.kills"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isTrusted && plugin.getPermissionsManager().has(player, "simpleclans.member.kills"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.killsplayer"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.ally"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.ally.add.remove.tag.1.add.remove.an.ally.clan"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.rival"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.rival.add.remove.tag.1.add.remove.a.rival.clan"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && plugin.getPermissionsManager().has(player, "simpleclans.member.home"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("home-menu"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.home-set"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("home-set-menu"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.home-set"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("home-clear-menu"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.war"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.war"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && plugin.getPermissionsManager().has(player, "simpleclans.member.bb"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.bb.1.display.bulletin.board"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isTrusted && plugin.getPermissionsManager().has(player, "simpleclans.member.bb-add"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.bb.msg.1.add.a.message.to.the.bulletin.board"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.modtag"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.modtag.tag.1.modify.the.clan.s.tag"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getSpoutPluginManager().isHasSpout() && plugin.getSettingsManager().isClanCapes() && plugin.getPermissionsManager().has(player, "simpleclans.leader.cape"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.cape.url.1.change.your.clan.s.cape"), clanCommand, ChatColor.WHITE));
        }

        String toggles = "";

        if (isVerified && plugin.getSpoutPluginManager().isHasSpout() && plugin.getSettingsManager().isClanCapes() && plugin.getPermissionsManager().has(player, " simpleclans.member.cape-toggle"))
        {
            toggles += "cape/";
        }

        if (isVerified && isTrusted && plugin.getPermissionsManager().has(player, "simpleclans.member.bb-toggle"))
        {
            toggles += "bb/";
        }

        if (isVerified && isTrusted && plugin.getPermissionsManager().has(player, "simpleclans.member.tag-toggle"))
        {
            toggles += "tag/";
        }

        if (!toggles.isEmpty())
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.toggle.command"), clanCommand, ChatColor.WHITE, Helper.stripTrailing(toggles, "/")));
        }

        if (isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.invite"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.invite.player.1.invite.a.player"), clanCommand, ChatColor.WHITE));
        }
        if (isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.kick"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.kick.player.1.kick.a.player.from.the.clan"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.setrank"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.trust.setrank"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.settrust"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.trust.untrust.player.1.set.trust.level1"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.settrust"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.trust.untrust.player.1.set.trust.level2"), clanCommand, ChatColor.WHITE));
        }
        if (isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.promote"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.promote.member.1.promote.a.member.to.leader"), clanCommand, ChatColor.WHITE));
        }
        if (isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.demote"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.demote.leader.1.demote.a.leader.to.member"), clanCommand, ChatColor.WHITE));
        }
        if (isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.ff"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.clanff.allow.block.1.toggle.clan.s.friendly.fire"), clanCommand, ChatColor.WHITE));
        }
        if (isLeader && plugin.getPermissionsManager().has(player, "simpleclans.leader.disband"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.disband.1.disband.your.clan"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.member.ff"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.ff.allow.auto.1.toggle.personal.friendly.fire"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.member.resign"))
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + MessageFormat.format(plugin.getLang("0.resign.1.resign.from.the.clan"), clanCommand, ChatColor.WHITE));
        }

        for (String item : menuItems)
        {
            chatBlock.addRow(ChatColor.AQUA + "  " + item);
        }

        if (plugin.getPermissionsManager().has(player, "simpleclans.mod.verify") && plugin.getSettingsManager().isRequireVerification())
        {
            chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.verify.tag.1.verify.an.unverified.clan"), clanCommand, ChatColor.WHITE));
        }
        if (isVerified && isTrusted && plugin.getPermissionsManager().has(player, "simpleclans.mod.mostkilled"))
        {
            chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.mostkilled"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.mod.disband"))
        {
            chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.disband.tag.1.disband.a.clan"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.mod.ban"))
        {
            chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.ban.unban.player.1.ban.unban.a.player"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.mod.hometp"))
        {
            chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.hometp.clan.1.tp.home.a.clan"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.mod.globalff"))
        {
            chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.globalff.allow.auto.1.set.global.friendly.fire"), clanCommand, ChatColor.WHITE));
        }
        if (plugin.getPermissionsManager().has(player, "simpleclans.admin.reload"))
        {
            chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.reload.1.reload.configuration"), clanCommand, ChatColor.WHITE));
        }
        if (chatBlock.isEmpty())
        {
            ChatBlock.sendMessage(player, ChatColor.RED + plugin.getLang("insufficient.permissions"));
            return;
        }

        ChatBlock.sendBlank(player);
        ChatBlock.saySingle(player, plugin.getSettingsManager().getServerName() + subColor + " " + plugin.getLang("clan.commands") + " " + headColor + Helper.generatePageSeparator(plugin.getSettingsManager().getPageSep()));
        ChatBlock.sendBlank(player);

        boolean more = chatBlock.sendBlock(player, plugin.getSettingsManager().getPageSize());

        if (more)
        {
            plugin.getStorageManager().addChatBlock(player, chatBlock);
            ChatBlock.sendBlank(player);
            ChatBlock.sendMessage(player, headColor + MessageFormat.format(plugin.getLang("view.next.page"), plugin.getSettingsManager().getCommandMore()));
        }

        ChatBlock.sendBlank(player);
    }

    /**
     * Execute the command
     *
     * @param sender
     */
    public void executeSender(CommandSender sender)
    {
        SimpleClans plugin = SimpleClans.getInstance();

        String headColor = plugin.getSettingsManager().getPageHeadingsColor();
        String subColor = plugin.getSettingsManager().getPageSubTitleColor();

        String clanCommand = plugin.getSettingsManager().getCommandClan();

        ChatBlock chatBlock = new ChatBlock();

        chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.verify.tag.1.verify.an.unverified.clan"), clanCommand, ChatColor.WHITE));
        chatBlock.addRow(ChatColor.DARK_RED + "  " + MessageFormat.format(plugin.getLang("0.reload.1.reload.configuration"), clanCommand, ChatColor.WHITE));

        ChatBlock.sendBlank(sender);
        ChatBlock.saySingle(sender, plugin.getSettingsManager().getServerName() + subColor + " " + plugin.getLang("clan.commands") + " " + headColor + Helper.generatePageSeparator(plugin.getSettingsManager().getPageSep()));
        ChatBlock.sendBlank(sender);
        chatBlock.sendBlock(sender, plugin.getSettingsManager().getPageSize());
        ChatBlock.sendBlank(sender);
    }

    /**
     * Adds a menu item to the /clan menu
     *
     * @param syntax
     * @param description
     */
    public void addMenuItem(String syntax, String description)
    {
        addMenuItem(syntax, description, ChatColor.AQUA);
    }

    /**
     * Adds a menu item to the /clan menu, specifying syntax color
     * [color] /[syntax] - [description]
     *
     * @param syntax
     * @param description
     * @param color
     */
    public void addMenuItem(String syntax, String description, ChatColor color)
    {
        menuItems.add(color + "/" + syntax + ChatColor.WHITE + " - " + description);
    }
}
