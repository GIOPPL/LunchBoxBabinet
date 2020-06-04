package com.gioppl.lunchboxcabinet.bean;

import java.util.List;

public class BoxBean {

    private List<BoxListBean> box_list;
    private List<BoxTypeBean> box_type;

    public List<BoxListBean> getBox_list() {
        return box_list;
    }

    public void setBox_list(List<BoxListBean> box_list) {
        this.box_list = box_list;
    }

    public List<BoxTypeBean> getBox_type() {
        return box_type;
    }

    public void setBox_type(List<BoxTypeBean> box_type) {
        this.box_type = box_type;
    }

    public static class BoxListBean {
        /**
         * id : 66
         * name : 1
         * name_line : 001
         * is_used : 1
         * box_id : 2
         * type_id : 1
         */

        private int id;
        private String name;
        private String name_line;
        private int is_used;
        private int box_id;
        private int type_id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_line() {
            return name_line;
        }

        public void setName_line(String name_line) {
            this.name_line = name_line;
        }

        public int getIs_used() {
            return is_used;
        }

        public void setIs_used(int is_used) {
            this.is_used = is_used;
        }

        public int getBox_id() {
            return box_id;
        }

        public void setBox_id(int box_id) {
            this.box_id = box_id;
        }

        public int getType_id() {
            return type_id;
        }

        public void setType_id(int type_id) {
            this.type_id = type_id;
        }
    }

    public static class BoxTypeBean {
        /**
         * id : 1
         * name : 轻食。简餐
         * number : 52
         */

        private int id;
        private String name;
        private int number;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
