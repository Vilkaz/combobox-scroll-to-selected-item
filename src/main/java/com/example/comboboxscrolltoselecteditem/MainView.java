package com.example.comboboxscrolltoselecteditem;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@SpringUI
public class MainView extends UI {
    @Override
    protected void init(VaadinRequest request) {
        List<Item> items = new ArrayList<>();

        LongStream.range(1,100)
                .forEach(l -> items.add(new Item(l, "item:"+l)));
        Item selectedItem = new Item(50l, "SHOW ME");
        items.set(50, selectedItem);

        ComboBox<Item> box = new ComboBox<>("items", items);
        box.setItemCaptionGenerator(Item::getName);
        box.setScrollToSelectedItem(true);
        box.setValue(selectedItem);

        Label instruction = new Label("1:Click on the arrow down, to show the suggestions. DO NOT CLICK ON ANY OF SUGGESTIONS!" +
                "\nas you see, on the top of suggestions is item:1, you do not see the item which is set as value" +
                "\n2: Click away, make the Combobox lose focus by mouse click" +
                "\nThe combobox Text has to lose the Selection in browser" +
                "\n3: Click again on the drop down arrow" +
                "\nNow you see the 'SHOW ME' item, which is the selected value of the ComboBox",
                ContentMode.PREFORMATTED);


        setContent(new HorizontalLayout(box, instruction));
    }
}
