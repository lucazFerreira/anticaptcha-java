package com.anti_captcha.Api;

import com.anti_captcha.AnticaptchaBase;
import com.anti_captcha.ApiResponse.TaskResultResponse;
import com.anti_captcha.Helper.DebugHelper;
import com.anti_captcha.IAnticaptchaTaskProtocol;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class HCaptchaProxyless extends AnticaptchaBase implements IAnticaptchaTaskProtocol {
    URL websiteUrl;
    String websiteKey;
    String userAgent;
    JSONObject enterprisePayload;
    Boolean isInvisible;
    Boolean isEnterprise;

    public JSONObject getPostData() {
        JSONObject postData = new JSONObject();

        try {
            postData.put("type", "HCaptchaTaskProxyless");
            postData.put("websiteURL", websiteUrl.toString());
            postData.put("websiteKey", websiteKey);
            postData.put("userAgent", userAgent);
            postData.put("isInvisible", isInvisible);
            postData.put("isEnterprise", isEnterprise);

            if (enterprisePayload != null) {
                postData.put("enterprisePayload", enterprisePayload);
            }
        } catch (JSONException e) {
            DebugHelper.out("JSON compilation error: " + e.getMessage(), DebugHelper.Type.ERROR);

            return null;
        }

        return postData;
    }

    @Override
    public TaskResultResponse.SolutionData getTaskSolution() {
        return taskInfo.getSolution();
    }

    public void setWebsiteUrl(URL websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setWebsiteKey(String websiteKey) {
        this.websiteKey = websiteKey;
    }

    public void setEnterprisePayload(JSONObject value) {
        this.enterprisePayload = value;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setIsInvisible(Boolean isInvisible) { this.isInvisible = isInvisible; }
}
