package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {

    // In-memory data store
    List<Item> items = new ArrayList<>();

    // 1) Display the form to create/edit an item
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = getIndexFromId(id);

        // If no existing item found, create a new Item
        Item item = (index == Constants.NOT_FOUND) ? new Item() : items.get(index);

        // Pass item + category array to the form
        model.addAttribute("item", item);
        model.addAttribute("categories", Constants.CATEGORIES);

        // "form" is the name of the front-end template
        return "form";
    }

    // 2) Process form submissions (create or update)
    @PostMapping("/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes) {
        int index = getIndexFromId(item.getId());
        String status = Constants.SUCCESS_STATUS;

        // If new item, just add it to the list
        if (index == Constants.NOT_FOUND) {
            items.add(item);
        } else {
            // If existing item, only update if the date difference is within 5 days
            if (within5Days(item.getDate(), items.get(index).getDate())) {
                items.set(index, item);
            } else {
                status = Constants.FAILED_STATUS;
            }
        }

        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    // 3) Show the inventory page
    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    // Helper to find item index by ID
    public int getIndexFromId(String id) {
        if (id == null) return Constants.NOT_FOUND;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    // Helper to check if the new date is within 5 days of the old date
    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        long days = TimeUnit.MILLISECONDS.toDays(diff);
        return days <= 5;
    }
}
