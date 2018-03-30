package cn.edu.imut.utils;

/**
 * Created by di_dong on 2017/5/23.
 */

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

public class WebReturnUtils {

    private static final String CODE = "code";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";

    private static final String SUCCESS_CODE = "0";
    private static final String FAILURE_CODE = "1";
    private static final int DEFAULT_JSON_OBJECT_LENGTH_HAVE_DATA = 3;

    private static final String SUCCESS_MESSAGE_DEFAULT = "ok";

    /**
     * 请求成功()
     */
    public static JSONObject success() {
        return success(null, null, null);
    }

    /**
     * 请求成功(resultData)
     */
    public static JSONObject success(Object resultData) {
        return success(null, null, resultData);
    }

    /**
     * 请求成功(successMessage)
     */
    public static JSONObject success(String successMessage) {
        return success(null, successMessage, null);
    }

    /**
     * 请求成功（responseCode + successMessage）
     */
    public static JSONObject success(String responseCode, String successMessage) {
        return success(responseCode, successMessage, null);
    }

    /**
     * 请求成功(successMessage + resultData)
     */
    public static JSONObject success(String successMessage, Object resultData) {
        return success(null, successMessage, resultData);
    }

    /**
     * 请求成功返回信息封装
     *
     * @param responseCode   请求成功的返回代码，默认1
     * @param successMessage 请求成功的返回信息，默认ok
     * @param resultData     请求成功返回的数据信息
     * @return JSONObject
     */
    public static JSONObject success(String responseCode, String successMessage, Object resultData) {
        JSONObject resultJSON = new JSONObject(DEFAULT_JSON_OBJECT_LENGTH_HAVE_DATA, true);
        if (StringUtils.isBlank(responseCode)) {
            responseCode = SUCCESS_CODE;
        }
        if (StringUtils.isBlank(successMessage)) {
            successMessage = SUCCESS_MESSAGE_DEFAULT;
        }

        resultJSON.put(CODE, responseCode);
        resultJSON.put(MESSAGE, successMessage);
        if (resultData != null) {
            resultJSON.put(DATA, resultData);
        }
        return resultJSON;
    }

    /**
     * 请求失败(errorMessage)
     */
    public static JSONObject failure(String errorMessage) {
        return failure(null, errorMessage, null);
    }

    /**
     * 请求失败(errorCode，resultData)
     */
    public static JSONObject failure(String errorCode, Object resultData) {
        return failure(errorCode, null, resultData);
    }

    /**
     * 请求失败(errorCode，errorMessage)
     */
    public static JSONObject failure(String errorCode, String errorMessage) {
        return failure(errorCode, errorMessage, null);
    }

    /**
     * 请求失败(errorCode，errorMessage，resultData)
     */
    public static JSONObject failure(String errorCode, String errorMessage, Object resultData) {
        JSONObject resultJSON = new JSONObject(DEFAULT_JSON_OBJECT_LENGTH_HAVE_DATA, true);

        if (StringUtils.isEmpty(errorCode)) {
            errorCode = FAILURE_CODE;
        }
        resultJSON.put(CODE, errorCode);
        resultJSON.put(MESSAGE, errorMessage);
        if (resultData != null) {
            resultJSON.put(DATA, resultData);
        }

        return resultJSON;
    }
}
