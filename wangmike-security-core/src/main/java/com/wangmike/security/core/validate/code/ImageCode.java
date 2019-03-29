package com.wangmike.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 22:41
 *    desc    : 图形验证码
 *    version : v1.0
 * </pre>
 */
public class ImageCode {


    /**
     * 验证码图像
     */
    private BufferedImage image;
    /**
     * 验证码内容
     */
    private String code;
    /**
     * 验证码超时时间
     */
    private LocalDateTime expireTime;


    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
