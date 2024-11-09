package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.resp.ImgVerifyCodeRespDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Resource (Images/Videos/Documents) Related Service Interface
 */
public interface ResourceService {

    /**
     * Get the image verification code
     *
     * @throws IOException If the verification code image generation fails
     * @return Base64 encoded image
     */
    RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException;

    /**
     * Image upload
     * @param file The image to be uploaded
     * @return The access path to the image
     */
    RestResp<String> uploadImage(MultipartFile file);
}

