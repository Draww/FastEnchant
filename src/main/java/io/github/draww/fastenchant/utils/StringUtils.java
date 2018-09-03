package io.github.draww.fastenchant.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static String cc(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String allowColor(String text) {
        return text.replace("&", "§");
    }

    public static String denyColor(String text) {
        return text.replace("§", "&");
    }

    public static String removeColor(String text) {
        return ChatColor.stripColor(text);
    }

    public static String removeWhiteSpace(String text) {
        return text.replace(" ", "");
    }

    public static ArrayList<String> fromArrayToArrayList(String[] array) {
        return new ArrayList<String>(Arrays.asList(array));
    }

    public static String[] fromArrayListToArray(ArrayList<String> list) {
        return list.toArray(new String[0]);
    }

    public static boolean isUpperCase(String string) {
        return string.toUpperCase() == string;
    }

    public static String firstUpperCase(String string, boolean multiple) {
        String result = "";
        int c = 0;
        String[] split;
        for (int length = (split = string.split(" ")).length, j = 0; j < length; ++j) {
            String s = split[j];
            if (!result.equals("")) {
                result = String.valueOf(result) + " ";
            }
            if (c > 0 && !multiple) {
                result = String.valueOf(result) + s.split("")[0];
            } else {
                result = String.valueOf(result) + s.split("")[0].toUpperCase();
            }
            for (int i = 1; i < s.split("").length; ++i) {
                result = String.valueOf(result) + s.split("")[i];
            }
            ++c;
        }
        return result;
    }

    public static String setColour(String paramString) {
        if ((paramString == null) || (paramString.isEmpty())) {
            return null;
        }
        paramString = ChatColor.translateAlternateColorCodes('�', paramString);
        paramString = ChatColor.translateAlternateColorCodes('&', paramString);

        return paramString;
    }

    public static List<String> setColourList(List<String> oldlist) {
        List<String> newlist = new ArrayList<String>();
        for (String string : oldlist) {
            newlist.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        return newlist;
    }

}
