package com.amalthea.amalthea.amalthea18;

import java.util.ArrayList;

public class Sponsobj {
    private String mName;
    private ArrayList<String> mUrls;

    public ArrayList<String> getUrls() {
        return mUrls;
    }

    public void setUrls(ArrayList<String> urls) {
        mUrls = urls;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Sponsobj(String name, ArrayList<String> urls) {
        mName = name;
        mUrls = urls;
    }
}
