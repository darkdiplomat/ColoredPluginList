import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;

public class ColoredPluginList extends Plugin {
    public static final Logger log = Logger.getLogger("Minecraft");
    public final String name = "ColoredPluginList";
    private final String version = "1.2";
    protected String currver = version;
	
    public void enable(){
        log.info(name+" v"+version+" by DarkDiplomat enabled!");
        if(!isLatest()){
            log.info(name+": There is an update available!");
        }
    }
	
    public void disable(){
        log.info(name+" v"+version+" by DarkDiplomat disabled!");
    }
	
    public void initialize(){
        CPLListener l = new CPLListener();
        etc.getLoader().addListener(PluginLoader.Hook.COMMAND, l, this, PluginListener.Priority.MEDIUM);
    }
	
    public boolean isLatest(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(new URL("http://visualillusionsent.net/cmod_plugins/versions.php?plugin="+name).openStream()));
            String inputLine;
            if ((inputLine = in.readLine()) != null) {
                currver = inputLine;
            }
            in.close();
            return Float.valueOf(version.replace("_", "")) >= Float.valueOf(currver.replace("_", ""));
        } 
        catch (Exception E) {
        }
        return true;
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
