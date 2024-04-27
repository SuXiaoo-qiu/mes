package com.worlds.mes.commons;

import lombok.Data;

import java.io.Serializable;

@Data
public class SimplePageInfo implements Serializable {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Boolean isCount;
    public SimplePageInfo() {
        this.isCount = Boolean.TRUE;
    }
    public Boolean getCount() {
        return this.isCount;
    }

    public void setCount(Boolean count) {
        this.isCount = count;
    }
}
