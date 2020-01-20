package com.example.callbacks;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;

import java.util.ArrayList;

public class PopupMenuView extends PopupMenu {
    private ArrayList<String> menuList;

    public void setMenuList(ArrayList<String> menuList) {
        this.menuList = menuList;
    }

    public void setViewPopupMenu() {
        for (int i = 0; i < menuList.size(); i++) {
            this.getMenu().add(i, Menu.FIRST, i, menuList.get(i));
        }
    }

    public void setShow() {
        this.show();
    }


    public PopupMenuView(Context context, View anchor) {
        super(context, anchor);
    }


   public static class Builder implements IBuilder<PopupMenuView> {

        //@Required
        private Context context;
        private View view;
        //@Required
        private ArrayList<String> items;

        public static PopupMenuView.Builder initialize(@NonNull Context context, View view) {
            return new PopupMenuView.Builder(context, view);
        }

        public Builder(Context context, View view) {
            this.context = context;
            this.view = view;
        }

        public PopupMenuView.Builder addListItems(@NonNull ArrayList<String> items) {
            this.items = items;
            return this;
        }


        @Override
        public PopupMenuView build() {
            PopupMenuView popupMenu = new PopupMenuView(this.context,this.view);
            popupMenu.setMenuList(this.items);
            popupMenu.setViewPopupMenu();
            popupMenu.setShow();
            popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(context,item.getTitle(),Toast.LENGTH_SHORT).show();
                    return true;
                }
            });

           /* try {
                if (!Validator.validateForNull(this))
                    return null;
            } catch (ClassNotFoundException | IllegalAccessException | RequiredFieldException e) {
                e.printStackTrace();
            }*/
            return popupMenu;
        }
    }
}
