package net.taehyeon.community.service;

public interface FileUpload {

    void setAllowedExt(String[] allowedExt);

    String[] getAllowedExt();

    void setMaxSize(long maxSize);

    long getMaxSize();

    String getAbsolutePath();

    void setAbsolutePath(String path);

    String getFileExt(String filename);
}
