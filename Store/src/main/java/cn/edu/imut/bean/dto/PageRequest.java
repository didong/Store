package cn.edu.imut.bean.dto;

/**
 * Created by di_dong on 2017/6/14.
 */
public class PageRequest {
    private String pageNumber;//页码
    private String type;//商品类型

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
