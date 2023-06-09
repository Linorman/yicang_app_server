package com.yicang_app.backend.constant;

/**
 * 结果集枚举
 *
 * @author linorman
 * @data 2023/03/13
 */
public enum ResultCode {
    /**
     * 默认成功值
     */
    SUCCESS(1000L, "响应成功"),
    FAIL(1001L, "响应失败"),
    UNKNOWN_ERROR(2000L, "未知错误"),
    TIMEOUT(408L, "服务器繁忙"),
    INTERNAL_SERVER_ERROR(500L, "服务器内部错误"),

    /**
     * 数据库操作
     */
    DATABASE_SUCCESS(800L, "数据库操作成功"),
    DATABASE_ERROR(801L, "数据库操作异常"),
    PARAMETER_ERROR(804L, "参数错误"),
    INVALID_PARAMETER(805L, "不合法的参数"),
    MISS_PARAMETER(806L, "缺少参数"),
    REPEAT_RECORD(807L, "重复记录"),
    RECORD_NOT_EXIST(808L, "记录不存在"),
    RECORD_EXISTS(809L, "记录已存在"),
    NOVEL_EMPTY(810L, "小说列表为空"),
    PAINTING_EMPTY(811L, "画作列表为空"),
    NOVEL_NOT_EXIST(812L, "小说不存在"),
    PAINTING_NOT_EXIST(813L, "画作不存在"),
    NOVEL_EXISTS(814L, "小说已存在"),
    PAINTING_EXISTS(815L, "画作已存在"),
    NOVEL_COLLECTION_EXISTS(816L, "小说已收藏"),
    PAINTING_COLLECTION_EXISTS(817L, "画作已收藏"),
    NOVEL_COLLECTION_NOT_EXIST(818L, "小说未收藏"),
    PAINTING_COLLECTION_NOT_EXIST(819L, "画作未收藏"),
    NOVEL_COLLECTION_EMPTY(820L, "小说收藏列表为空"),
    PAINTING_COLLECTION_EMPTY(821L, "画作收藏列表为空"),

    /**
     * 用户操作
     */
    USER_SUCCESS(3000L, "用户操作成功"),
    USER_NOT_EXIST(3001L, "用户不存在"),
    USER_EXISTS(3005L, "用户已存在"),
    USER_PASSWORD_ERROR(3002L, "密码错误"),
    USER_ACCOUNT_LOCKED(3003L, "账号已被锁定"),
    USER_PERMISSION_DENIED(3004L, "权限不足");

    private Long code;
    private String msg;

    ResultCode(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
