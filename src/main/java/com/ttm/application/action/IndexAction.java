package com.ttm.application.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ttm.application.action.vo.ServiceResponse;
import com.ttm.application.util.Filename;
import com.ttm.application.util.Md5;
import com.ttm.application.util.ServiceResponseUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

/**
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-07-15</p>
 * <p>@Version 1.0</p>
 **/
public class IndexAction extends ActionSupport {

    private File fileUpload;
    private String fileUploadFileName;
    private String fileUploadContentType;
    private String fileNameSku;
    private String responseJson;

    public String execute() {
        return SUCCESS;
    }

    public String doUpload() throws IOException {
//        System.out.println("File = " + fileUpload.toString() + " fileUploadFileName = " + fileUploadFileName + " fileUploadContentType = " + fileUploadContentType);
//        ActionContext ac = ActionContext.getContext();
//        ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
        String appPath = ServletActionContext.getServletContext().getRealPath(File.separator);
//        System.out.println("appPath = " + appPath);
        String path = makeRelativePath(fileNameSku, "images");
        String newPathsss = appPath + File.separator + path;
//        System.out.println("make relative path = " + newPathsss);
        String fileNameNews = fileNameSku + "-" + RandomStringUtils.randomNumeric(4) + "-" + RandomStringUtils.randomAlphabetic(4) + "." + new Filename(fileUploadFileName.toString()).extension();
//        System.out.println("fileNameNews = " + newPathsss + fileNameNews);
        File newFile = new File(newPathsss + fileNameNews);
        FileUtils.copyFile(fileUpload, newFile);
        if (newFile.exists()) {
            String newShowPath = path + fileNameNews;
            System.out.println("path = " + StringUtils.replace(newShowPath, "\\", "/"));
            setResponseJson(ServiceResponseUtils.success(StringUtils.replace(newShowPath, "\\", "/")));
        }
        return SUCCESS;
    }

    /*
     * 获取扩展名以外的其余部分
     */
    public static String getPicPrefix(String imgPath, String sign) {
        if (imgPath == null || imgPath.indexOf(sign) == -1) {
            return ""; //如果图片地址为null或者地址中没有"."就返回""
        }
        return imgPath.substring(0, imgPath.lastIndexOf(sign)).
                trim();
    }


    public String makeRelativePath(String sku, String type) {
        String path = type + File.separator + sku.substring(0, 1) + File.separator + sku.substring(sku.length() - 1) + File.separator + sku + File.separator;

        return path;
    }

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getFileNameSku() {
        return fileNameSku;
    }

    public void setFileNameSku(String fileNameSku) {
        this.fileNameSku = fileNameSku;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }
}
