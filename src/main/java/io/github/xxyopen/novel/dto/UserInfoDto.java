package io.github.xxyopen.novel.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * User Info Response DTO
 */
@Data
@Builder
public class UserInfoDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer status;

}
