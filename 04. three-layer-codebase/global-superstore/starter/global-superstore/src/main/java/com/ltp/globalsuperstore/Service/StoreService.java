package com.ltp.globalsuperstore.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Date;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.Repository.StoreRepository;

public class StoreService {
    StoreRepository storeRepository = new StoreRepository();

    public Item getItem(int index){
        return storeRepository.getItem(index);
    }

    public void addItem(Item item){
        storeRepository.addItem(item);
    }
    
    public void updateItem(Item item, int index){
        storeRepository.updateItem(item, index);
    }

    public List<Item> getItems(){
        return storeRepository.getItems();
    }

    public int getItemIndex(String id) {
        for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public Item getItemById(String id){
        int index = getItemIndex(id);
        return index == Constants.NOT_FOUND ? new Item() : getItem(index);
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

    public String submitItem(Item item){
        int index = getItemIndex(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if (index == Constants.NOT_FOUND) {
            getItems().add(item);
        } else if (within5Days(item.getDate(), getItems().get(index).getDate())) {
            getItems().set(index, item);
        } else {
            status = Constants.FAILED_STATUS;
        }
        return status;
    }
}
