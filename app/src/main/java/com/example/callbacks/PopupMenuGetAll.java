package com.example.callbacks;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

public class PopupMenuGetAll {

    static ArrayList<String> listItems;

    public static ArrayList<String> getListItems(Context context, int listArray) {
        listItems = new ArrayList<>();
        String[] list = context.getResources().getStringArray(listArray);
        for(int i =0; i < list.length; i++){
            listItems.add(list[i]);
        }
        return listItems;
    }

    public static PopupMenuView generatePopupMenu(Context context, View view) {
        return PopupMenuView.Builder.initialize(context, view)
                .addListItems(listItems)
                .build();
    }

}
