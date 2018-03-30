package cn.edu.imut.bean.model;

/**
 * Created by di_dong on 2017/5/27.
 */
public class VerificationCodeModel {
    private String imgWithBase64;

    private String imgWithMd5;


    public String getImgWithBase64() {
        return imgWithBase64;
    }

    public void setImgWithBase64(String imgWithBase64) {
        this.imgWithBase64 = imgWithBase64;
    }

    public String getImgWithMd5() {
        return imgWithMd5;
    }

    public void setImgWithMd5(String imgWithMd5) {
        this.imgWithMd5 = imgWithMd5;
    }

    @Override
    public String toString() {
        return "VerificationCodeModel{" +
                "imgWithBase64='" + imgWithBase64 + '\'' +
                ", imgWithMd5='" + imgWithMd5 + '\'' +
                '}';
    }
}
