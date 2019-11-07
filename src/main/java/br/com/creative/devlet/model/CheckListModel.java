package br.com.creative.devlet.model;

import java.util.List;

public class CheckListModel {
    private String title;
    private List<Item> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {
        private Boolean checked;
        private String descrition;

        public Boolean getChecked() {
            return checked;
        }

        public void setChecked(Boolean checked) {
            this.checked = checked;
        }

        public String getDescrition() {
            return descrition;
        }

        public void setDescrition(String descrition) {
            this.descrition = descrition;
        }
    }
}
