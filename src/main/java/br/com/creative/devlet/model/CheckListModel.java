package br.com.creative.devlet.model;


import java.util.List;
public class CheckListModel {
    private List<CheckList> checkLists;

    public List<CheckList> getCheckLists() {
        return checkLists;
    }

    public void setCheckLists(List<CheckList> checkLists) {
        this.checkLists = checkLists;
    }

    public static class CheckList {
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
            private String description;

            public Boolean getChecked() {
                return checked;
            }

            public void setChecked(Boolean checked) {
                this.checked = checked;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String descrition) {
                this.description = descrition;
            }
        }
    }
}
