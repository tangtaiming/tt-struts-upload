package com.ttm.application.util;

/**
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-07-16</p>
 * <p>@Version 1.0</p>
 **/
public class Filename {

    private String fullPath;
    private char pathSeparator;
    private char extensionSeparator;

    public Filename(String str) {
        this.fullPath = str;
        this.pathSeparator = 47;
        this.extensionSeparator = 46;
    }

    /**
     * 后缀
     * @return
     */
    public String extension() {
        int dot = this.fullPath.lastIndexOf(this.extensionSeparator);
        return this.fullPath.substring(dot + 1);
    }

    /**
     * 文件名称
     * @return
     */
    public String filename() {
        int dot = this.fullPath.lastIndexOf(this.extensionSeparator);
        int sep = this.fullPath.lastIndexOf(this.pathSeparator);
        return this.fullPath.substring(sep + 1, dot);
    }

    /**
     * 路径
     * @return
     */
    public String path() {
        int sep = this.fullPath.lastIndexOf(this.pathSeparator);
        return this.fullPath.substring(0, sep);
    }

}
