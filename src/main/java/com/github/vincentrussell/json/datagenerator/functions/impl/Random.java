package com.github.vincentrussell.json.datagenerator.functions.impl;

import com.github.vincentrussell.json.datagenerator.functions.Function;
import com.github.vincentrussell.json.datagenerator.functions.FunctionInvocation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * random item from list
 */
@Function(name = "random")
public class Random {

    /**
     * random item from list:
     * @param strings options to choose from
     * @return the result
     */
    @FunctionInvocation
    public String random(final String... strings) {
        if (strings.length == 1) {
            //Probable json string array
            try {
                JsonArray jsonArray = new Gson().fromJson(strings[0], JsonArray.class);
                int randomNum = (int) (Math.random() * jsonArray.size()) % jsonArray.size();
                return jsonArray.get(randomNum).getAsString();
            } catch (Exception e) {
            }
        }
        int randomNum = (int) (Math.random() * strings.length);
        return strings[randomNum];
    }

}
