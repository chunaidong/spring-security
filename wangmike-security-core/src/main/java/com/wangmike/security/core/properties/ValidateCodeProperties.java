package com.wangmike.security.core.properties;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 23:39
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
public class ValidateCodeProperties {


    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
