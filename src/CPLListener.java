
public class CPLListener extends PluginListener {
	public boolean onCommand(Player player, String[] cmd){
		if(cmd[0].equalsIgnoreCase("/listplugins")){
			if(player.canUseCommand("/listplugins")){
				int k = 70;
				String Plugins = etc.getLoader().getPluginList();
				String[] ed = Plugins.split("\\,");
				StringBuffer list = new StringBuffer();
				for(int i = 0; i < ed.length; i++){
					if(list.length() + ed[i].length() < k){
						if(i == 0){
							list.append("§6Plugins:");
						}
						if(ed[i].contains("(E)")){
							list.append("§2"+ed[i].replace(" (E)", "")+"§f, ");
						}
						else{
							list.append("§c"+ed[i].replace(" (D)", "")+"§f, ");
						}
					}
					else{
						k += 70;
						if(ed[i].contains("(E)")){
							list.append("@§2"+ed[i].replace(" (E)", "")+"§f, ");
						}
						else{
							list.append("@§c"+ed[i].replace(" (D)", "")+"§f, ");
						}
					}
				}
				String[] plugs = list.toString().split("@");
				for(String pl : plugs){
					player.sendMessage(pl);
				}
			}
			return true;
		}
		return false;
	}
}

/*******************************************************************************\
* ColoredPluginList v1.x                                                        *
* Copyright (C) 2012 Visual Illusions Entertainment                             *
* @author darkdiplomat <darkdiplomat@visualillusionsent.net>                    *
*                                                                               *
* This file is part of ColoredPluginList                                        *
*                                                                               *
* This program is free software: you can redistribute it and/or modify          *
* it under the terms of the GNU General Public License as published by          *
* the Free Software Foundation, either version 3 of the License, or             *
* (at your option) any later version.                                           *
*                                                                               *
* This program is distributed in the hope that it will be useful,               *
* but WITHOUT ANY WARRANTY; without even the implied warranty of                *
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                          *
* See the GNU General Public License for more details.                          *
*                                                                               *
* You should have received a copy of the GNU General Public License             *
* along with this program.  If not, see http://www.gnu.org/licenses/gpl.html    *
*                                                                               *
\*******************************************************************************/