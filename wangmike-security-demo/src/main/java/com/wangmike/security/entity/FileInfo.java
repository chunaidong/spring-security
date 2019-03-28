package com.wangmike.security.entity;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/28 14:14
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
public class FileInfo {


    public FileInfo(String filePath) {
        this.filePath = filePath;
    }

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
