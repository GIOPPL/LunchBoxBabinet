package com.gioppl.lunchboxcabinet.bean;

import java.util.List;

public class DistributionBoxBean {

    /**
     * name_line : [{"name_line":"002"}]
     * order_id : 20200513025111416267
     * member_id : 1
     */

    private String order_id;
    private int member_id;
    private List<NameLineBean> name_line;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public List<NameLineBean> getName_line() {
        return name_line;
    }

    public void setName_line(List<NameLineBean> name_line) {
        this.name_line = name_line;
    }

    public static class NameLineBean {
        /**
         * name_line : 002
         */

        private String name_line;

        public String getName_line() {
            return name_line;
        }

        public void setName_line(String name_line) {
            this.name_line = name_line;
        }
    }
}
