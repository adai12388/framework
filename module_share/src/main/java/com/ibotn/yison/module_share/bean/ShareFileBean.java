package com.ibotn.yison.module_share.bean;

public class ShareFileBean {
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private String filePath;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件类型icon id，视频，音频，图片，其他{R.mipmap.ic_vedio,R.mipmap.ic_audio,R.mipmap.ic_picture,R.mipmap.ic_file}
     */
    private int FleTyeIconId;
    /**
     * 字节为单位，文件大小
     */
    private long FileLength;

    public ShareFileBean(){}

    public ShareFileBean(String filePath, String fileName, int fleTyeIconId, int fileLength) {
        this.filePath = filePath;
        this.fileName = fileName;
        FleTyeIconId = fleTyeIconId;
        FileLength = fileLength;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFleTyeIconId() {
        return FleTyeIconId;
    }

    public void setFleTyeIconId(int fleTyeIconId) {
        FleTyeIconId = fleTyeIconId;
    }

    public long getFileLength() {
        return FileLength;
    }

    public void setFileLength(long fileLength) {
        FileLength = fileLength;
    }

    @Override
    public String toString() {
        return "ShareFileBean{" +
                "filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", FleTyeIconId=" + FleTyeIconId +
                ", FileLength=" + FileLength +
                '}';
    }
}
